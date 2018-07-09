package adsmovil.operations.liquidm;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import common.resources.ResourceLoader;

public class getAuthToken {

	static String AUTH_TOKEN = null;
	static String USER_ID = null;
	
	//URL TOKEN_URL = null;
	
	public static String Main() throws IOException {
		
		CloseableHttpResponse response = null;
		
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost("platform.liquidm.com")
					.setPath("/api/auth")
					.setParameter("email", Credentials.LIQUIDM_EMAIL)
					.setParameter("password", Credentials.LIQUIDM_PASSWORD)
					.setParameter("api", "true")
					.build();
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(uri);
			response = httpclient.execute(httpget);
			JSONObject JSONResponse = new JSONObject(response);
			AUTH_TOKEN = JSONResponse.getString("auth_token").toString();
			USER_ID = JSONResponse.getString("user_id").toString();
			if(AUTH_TOKEN != null && AUTH_TOKEN != ""
					&& USER_ID != null && USER_ID != "") {
				ResourceLoader loader = new ResourceLoader();
				Path authTokenPath = loader.getResource("resources/authToken.txt");
				updateAuthToken.Main(AUTH_TOKEN, USER_ID, authTokenPath.toString());
			}
		} catch (URISyntaxException e) {
			//URISyntaxException
		} finally {
		    response.close();
		}
		
		return AUTH_TOKEN;
		
	}
	
}
