package google.apis.services.sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.services.sheets.v4.Sheets;

import google.oauth.credentials.GoogleAuthorizeUtil;

public class SheetsServiceUtil {

	public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        
		return GoogleAuthorizeUtil.getSheetsService();
		
    }
	
}
