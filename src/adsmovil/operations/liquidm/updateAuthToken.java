package adsmovil.operations.liquidm;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class updateAuthToken {
	
	@SuppressWarnings("unchecked")
	public static void Main(String AUTH_TOKEN, String USER_ID, String authTokenPath) throws IOException {
		JSONObject JSONResponse = new JSONObject();
		JSONResponse.put("auth_token", AUTH_TOKEN);
		JSONResponse.put("user_id", USER_ID);
		FileWriter file = new FileWriter(authTokenPath);
		file.write(JSONResponse.toJSONString());
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + JSONResponse);
		file.flush();
		file.close();
	}
}
