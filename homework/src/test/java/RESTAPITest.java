import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class RESTAPITest {
    public static final String BASE_ENDPOINT = "https://jsonplaceholder.typicode.com/users";
    final OkHttpClient client = new OkHttpClient();

    @Test(testName = "REST API (Case5) test")
    public static void RestApiTest() throws IOException {
        Logger logger = LoggerFactory.getLogger(RESTAPITest.class);
//        logger.info("Hello World");
        RESTAPITest example = new RESTAPITest();
        String responseString = example.run(BASE_ENDPOINT);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User[] userArray = gson.fromJson(responseString, User[].class);

        // Java objects to File (Parse response to Json format)
        try (FileWriter writer = new FileWriter("src/test/java/savedUserData/users.json")) {
            gson.toJson(userArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //log names and emails
        for (int i = 0; i < userArray.length; i++) {
            logger.info(userArray[i].getName() + " | " + userArray[i].getEmail());
        }

        //Verify the first email address contains @
        String firstEmail = userArray[0].getEmail();
        Assert.assertTrue(firstEmail.contains("@"));
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
