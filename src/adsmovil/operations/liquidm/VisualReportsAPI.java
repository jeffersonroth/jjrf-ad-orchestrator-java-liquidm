package adsmovil.operations.liquidm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

import common.resources.ResourceLoader;

public class VisualReportsAPI {
	
	static String AUTH_TOKEN = null;
	static String USER_ID = null;

	public static void main(String[] args) {
		
		try {
			Reporting();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String Reporting() throws IOException {

		ResourceLoader loader = new ResourceLoader();
		{
			Path authTokenPath = loader.getResource("resources/authToken.txt");
			try (Reader reader = new FileReader(authTokenPath.toString())) {
	            Gson gson = new Gson(); 
	            AuthToken[] data = gson.fromJson(reader, AuthToken[].class);
	            System.out.println("data: " + data.toString());
	            AUTH_TOKEN = data.toString();
	        	USER_ID = data.toString();
	        	if(AUTH_TOKEN != null && AUTH_TOKEN != ""
	    				&& USER_ID != null && USER_ID != "") {
	    			updateAuthToken.Main(AUTH_TOKEN, USER_ID, authTokenPath.toString());
	    		}
	        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		CloseableHttpResponse response = null;
		String JSONResponse = null;
		
		try {
			URI uri = new URIBuilder()
					.setScheme("https")
					.setHost("platform.liquidm.com")
					.setPath("/visual_reports.json")
					.setParameter("auth_token", AUTH_TOKEN)
					.setParameter("start_date", "2018-01-01")
					.setParameter("dimensions", "campaign")
					.setParameter("metrics", "ais,bids,bid_requests,clicks,ctr,downloads,downloads2,downloads3,downloads_value,e_cpc,e_cpx1,e_cpx2,e_cpx3,e_cpm,earnings,win_rate,conversion_rate,video_firstquartile,video_midpoint,video_thirdquartile,video_complete")
					.build();
			System.out.println("URI: " + uri.toString());
			response = httpClientBuild(uri, response);
			int code = response.getStatusLine().getStatusCode();
	        System.out.println("Response code of the object is: " + code);
	        if (code == 200)
	        {
	        	httpStatusOk(response);
	        } else if (code == 401) {
	        	System.out.println("Requesting new AUTH_TOKEN");
	        	String newAuthToken = getAuthToken.Main().toString();
	        	URI newUri = new URIBuilder()
						.setScheme("https")
						.setHost("platform.liquidm.com")
						.setPath("/visual_reports.json")
						.setParameter("auth_token", newAuthToken)
						.setParameter("start_date", "2018-01-01")
						.setParameter("dimensions", "campaign")
						.setParameter("metrics", "ais,bids,bid_requests,clicks,ctr,downloads,downloads2,downloads3,downloads_value,e_cpc,e_cpx1,e_cpx2,e_cpx3,e_cpm,earnings,win_rate,conversion_rate,video_firstquartile,video_midpoint,video_thirdquartile,video_complete")
						.build();
				System.out.println("new URI: " + newUri.toString());
				response = httpClientBuild(newUri, response);
				int newCode = response.getStatusLine().getStatusCode();
		        System.out.println("Response code of the object is: " + newCode);
	        }
			
		} catch (URISyntaxException e) {
			//URISyntaxException
		}
		
		return JSONResponse;
		
	}
	
	private static CloseableHttpResponse httpClientBuild(URI uri, CloseableHttpResponse response) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		response = httpclient.execute(httpget);
		return response;
	}
	
	private static void httpStatusOk(CloseableHttpResponse response) throws ParseException, IOException {
		String JSONResponse = null;
		System.out.println("OK");
        System.out.println("RESPONSE_HEADER: " + response.toString());
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("RESPONSE_BODY: " + responseString);
		JSONResponse = new JSONObject(responseString).getJSONArray("rows").toString();
		//JSONResponse = JSONResponse.substring(1, JSONResponse.length() - 1).toString();
		System.out.println("JSONArray: " + JSONResponse);
		response.close();
	}

}
