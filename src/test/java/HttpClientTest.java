import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class HttpClientTest {

    @Test
    public void testGetRequest() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://api.github.com/emojis");
            HttpResponse response = httpClient.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonResponse);

            assertTrue("Key 'articulated_lorry' not found in the response.", jsonNode.has("articulated_lorry"));
            System.out.println("Key 'articulated_lorry' found in the response.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
