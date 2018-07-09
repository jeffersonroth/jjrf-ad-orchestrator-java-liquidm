package adsmovil.operations.liquidm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import adsmovil.operations.liquidm.VisualReportsAPI;

/**
 * Servlet implementation class VisualReportsServlet
 */
public class VisualReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String dataSrc = "reporting";
		String report = VisualReportsAPI.Reporting().toString();
		
		JSONArray json = new JSONArray(report);
		String value = null;
		String campaignValue = null;
		String campaignCID = null;
		String ais = null;
		String bids = null;
		String bidRequests = null;
		String clicks = null;
		String ctr = null;
		String downloads = null;
		String downloads2 = null;
		String downloads3 = null;
		String downloadsValue = null;
		String eCpc = null;
		String eCpx1 = null;
		String eCpx2 = null;
		String eCpx3 = null;
		String eCpm = null;
		String earnings = null;
		String winRate = null;
		String conversionRate = null;
		String videoFirstquartile = null;
		String videoMidpoint = null;
		String videoThirdquartile = null;
		String videoComplete = null;
		String campaignInfo = null;

		for(int i=0;i<json.length();i++){ 
		    JSONObject e = json.getJSONObject(i);
		    
		    campaignValue = e.getJSONObject("campaign").optString("value");
		    campaignCID = e.getJSONObject("campaign").optString("name");
		    if(campaignCID.matches("[(]CID.*")) {
		    	campaignCID = campaignCID.substring(campaignCID.indexOf("(") + 1);
		    	campaignCID = campaignCID.substring(0, campaignCID.indexOf(")"));
		    } else {
		    	campaignCID = "";
		    }
		    ais = e.getJSONObject("ais").optString("value");
		    bids = e.getJSONObject("bids").optString("formatted_value");
		    bidRequests = e.getJSONObject("bid_requests").optString("formatted_value");
		    clicks = e.getJSONObject("clicks").optString("formatted_value");
		    ctr = e.getJSONObject("ctr").optString("formatted_value");
		    downloads = e.getJSONObject("downloads").optString("formatted_value");
			downloads2 = e.getJSONObject("downloads2").optString("formatted_value");
			downloads3 = e.getJSONObject("downloads3").optString("formatted_value");
			downloadsValue = e.getJSONObject("downloads_value").optString("formatted_value");
			eCpc = e.getJSONObject("e_cpc").optString("formatted_value");
			eCpx1 = e.getJSONObject("e_cpx1").optString("formatted_value");
			eCpx2 = e.getJSONObject("e_cpx2").optString("formatted_value");
			eCpx3 = e.getJSONObject("e_cpx3").optString("formatted_value");
			eCpm = e.getJSONObject("e_cpm").optString("formatted_value");
			earnings = e.getJSONObject("earnings").optString("formatted_value");
			winRate = e.getJSONObject("win_rate").optString("formatted_value");
			conversionRate = e.getJSONObject("conversion_rate").optString("formatted_value");
			videoFirstquartile = e.getJSONObject("video_firstquartile").optString("formatted_value");
			videoMidpoint = e.getJSONObject("video_midpoint").optString("formatted_value");
			videoThirdquartile = e.getJSONObject("ctr").optString("formatted_value");
			videoComplete = e.getJSONObject("video_complete").optString("formatted_value");
		    campaignInfo = e.getJSONObject("campaign_info").optString("value");
		    
		    String valueString = "["
		    		+"\""+campaignValue+"\"" + ","
		    		+"\""+campaignCID+"\"" + ","
		    		+"\""+ais+"\"" + ","
		    		+"\""+bids+"\"" + ","
		    		+"\""+bidRequests+"\"" + ","
		    		+"\""+clicks+"\"" + ","
		    		+"\""+ctr+"\"" + ","
		    		+"\""+downloads+"\"" + ","
		    		+"\""+downloads2+"\"" + ","
		    		+"\""+downloads3+"\"" + ","
		    		+"\""+downloadsValue+"\"" + ","
		    		+"\""+eCpc+"\"" + ","
		    		+"\""+eCpx1+"\"" + ","
		    		+"\""+eCpx2+"\"" + ","
		    		+"\""+eCpx3+"\"" + ","
		    		+"\""+eCpm+"\"" + ","
		    		+"\""+earnings+"\"" + ","
		    		+"\""+winRate+"\"" + ","
		    		+"\""+conversionRate+"\"" + ","
		    		+"\""+videoFirstquartile+"\"" + ","
		    		+"\""+videoMidpoint+"\"" + ","
		    		+"\""+videoThirdquartile+"\"" + ","
		    		+"\""+videoComplete+"\"" + ","
		    		+"\""+campaignInfo+"\""
		    		+"]";
		    
		    if (value != null) {
		    	value = value + "," + valueString;
		    } else {
		    	value = valueString;
		    }
		    
		    campaignValue = null;
		    campaignCID = null;
		    ais = null;
		    bids = null;
		    bidRequests = null;
		    clicks = null;
		    ctr = null;
		    downloads = null;
			downloads2 = null;
			downloads3 = null;
			downloadsValue = null;
			eCpc = null;
			eCpx1 = null;
			eCpx2 = null;
			eCpx3 = null;
			eCpm = null;
			earnings = null;
			winRate = null;
			conversionRate = null;
			videoFirstquartile = null;
			videoMidpoint = null;
			videoThirdquartile = null;
			videoComplete = null;
		    campaignInfo = null;
		}
	    
		//System.out.println("value: " + value);
		String valueFinal = "[" + value + "]";
		//System.out.println("valueFinal: " + valueFinal);
		
		String jsonOut = "{"
	    		+"\""+dataSrc+"\"" + ":"
	    		+valueFinal
	    		+"}";
		System.out.println("jsonOut: " + jsonOut);
		JSONObject jsonObject = new JSONObject(jsonOut);
		System.out.println("jsonObject: " + jsonObject.toString());
		out.println(jsonObject.toString());
		
	}

}
