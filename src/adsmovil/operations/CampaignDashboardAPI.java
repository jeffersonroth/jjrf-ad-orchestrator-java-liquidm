package adsmovil.operations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import google.apis.services.sheets.SheetsServiceUtil;

public class CampaignDashboardAPI {
	
	private static Sheets sheetsService;
    private static String SPREADSHEET_ID = null;
    //private static String SPREADSHEET_TAB = "Cronograma campañas";
	
    //@BeforeClass
	public static void main(String[] args) throws GeneralSecurityException, IOException {
			
		try {
			SPREADSHEET_ID = args[0];
			Dashboard(SPREADSHEET_ID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static String[] Dashboard(String spreadsheetID) throws GeneralSecurityException, IOException {
		
		sheetsService = SheetsServiceUtil.getSheetsService();
		//String rngAuthorTab = "\""+SPREADSHEET_TAB+"\"" + "!A3";
		String rngAuthor = "A3";
		System.out.println(rngAuthor);
		List<String> rangesAuthor = Arrays.asList(rngAuthor);
		BatchGetValuesResponse readAuthor = sheetsService.spreadsheets().values()
		  .batchGet(spreadsheetID)
		  .setRanges(rangesAuthor)
		  .execute();
		
		ValueRange valueAuthor = readAuthor.getValueRanges().get(0);
		System.out.println("valueAuthor: " + valueAuthor.getValues().toString());
		
		String rngTotal = "H2";
		List<String> rangesTotal = Arrays.asList(rngTotal);
		BatchGetValuesResponse readTotal = sheetsService.spreadsheets().values()
		  .batchGet(spreadsheetID)
		  .setRanges(rangesTotal)
		  .execute();
		
		ValueRange valueTotal = readTotal.getValueRanges().get(0);
		String lastRow = valueTotal.getValues().get(0).get(0).toString();
		System.out.println("valueTotal: " + valueTotal.getValues().toString());
		System.out.println("lastRow: " + lastRow);
		
		String rngColumns = "A4:AA4";
		List<String> rangesColumns = Arrays.asList(rngColumns);
		BatchGetValuesResponse readColumns = sheetsService.spreadsheets().values()
		  .batchGet(spreadsheetID)
		  .setRanges(rangesColumns)
		  .execute();
		
		ValueRange valueColumns = readColumns.getValueRanges().get(0);
		System.out.println("valueColumns: " + valueColumns.getValues().toString());
		
		String rngData = "A5:AA" + lastRow;
		List<String> rangesData = Arrays.asList(rngData);
		BatchGetValuesResponse readData = sheetsService.spreadsheets().values()
		  .batchGet(spreadsheetID)
		  .setRanges(rangesData)
		  .execute();
		
		ValueRange valueData = readData.getValueRanges().get(0);
		System.out.println("valueData: " + valueData.getValues().toString());
		
		String[] dashboardResponse = new String[] {
				valueAuthor.getValues().toString(),
				valueColumns.getValues().toString(),
				valueData.getValues().toString()
			};
		
		return (dashboardResponse);
		
	}

}
