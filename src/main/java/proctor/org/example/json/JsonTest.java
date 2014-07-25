package proctor.org.example.json;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class JsonTest {

    public static void main(String[] args) throws IOException, JSONException {
        String jsonString = FileUtils.readFileToString(new File("Test/src/main/java/proctor/org/example/json/test.json"));
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray array = (JSONArray) ((JSONObject) jsonObject.get("Groups")).get("Test");
        System.out.println(array);
    }
}
