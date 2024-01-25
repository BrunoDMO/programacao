import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.swing.text.html.parser.Parser;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIBored {
    private URI uri = URI.create("https://www.boredapi.com/api/activity/");
    private String contentResponse = responseFromAPI();



    public String getContentResponse() {
        return contentResponse;
    }

    private String responseFromAPI() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonElement jsonElement = JsonParser.parseString(response.body());
        return gson.toJson(jsonElement);

    }

    public void SaveFile() {
        try {
            FileWriter file = new FileWriter("Activity.txt");
            file.write(this.contentResponse);
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
