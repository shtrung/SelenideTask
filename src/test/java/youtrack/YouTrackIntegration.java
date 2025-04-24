package youtrack;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;

public class YouTrackIntegration {
    private static final String YOUTRACK_URL = "https://your-youtrack-instance/api/issues";
    private static final String TOKEN = "perm:YOUR_TOKEN";

    public static void createIssue(String summary, String description, String projectId) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(YOUTRACK_URL);

        httpPost.setHeader("Authorization", "Bearer " + TOKEN);
        httpPost.setHeader("Content-Type", "application/json");

        JSONObject issue = new JSONObject();
        issue.put("project", new JSONObject().put("id", projectId));
        issue.put("summary", summary);
        issue.put("description", description);

        httpPost.setEntity(new StringEntity(issue.toString()));

        HttpResponse response = httpClient.execute(httpPost);
        System.out.println("YouTrack response: " + response.getStatusLine().getStatusCode());
    }
}