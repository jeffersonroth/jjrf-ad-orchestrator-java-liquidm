package adsmovil.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class CampaignDashboardServlet
 */
public class CampaignDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampaignDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String dataSrc = "dashboard";
		String spreadsheetID = request.getParameter("spreadsheetID");
		System.out.println("CampaignDashboardServlet.java request.getParameter(\"spreadsheetID\"): " + spreadsheetID);
		String[] dashboard = null;
		
		try {
			dashboard = CampaignDashboardAPI.Dashboard(spreadsheetID);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strColumns = dashboard[1];
		strColumns = strColumns.substring(1, strColumns.length()-1);
		Pattern pc = Pattern.compile("\\[(.*?)\\]");
		Matcher mc = pc.matcher(strColumns);

		while(mc.find()) {
			//strColumns = StringUtils.remove(strColumns, "[");
			strColumns = strColumns.substring(1, strColumns.length()-1);
		}
		List<String> columns = Arrays.asList(strColumns.split("\\s*,\\s*"));
		System.out.println("columns: " + columns.size() + ";" + columns.get(0));
		request.setAttribute("columns", columns);
		
		String strData = dashboard[2];
		List<String> data = new ArrayList<String>();
		strData = strData.substring(1, strData.length()-1);
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(strData);

		while(m.find()) {
			//List<String> group = Arrays.asList(m.group(1).split("\\s*,\\s*"));
			List<String> group = Arrays.asList(m.group(1));
			System.out.println("m.group(): " + group.toString());
		    data.addAll(group);
		}
		
		JSONArray json = new JSONArray(data);
		System.out.println("json: " + json.toString());
		//String value = null;
		//String campaignValue = null;
		
		/**
		for(int i=0;i<json.length();i++){ 
		    JSONObject e = json.getJSONObject(i);
		    
		    campaignValue = e.getJSONObject(dataSrc).toString();
		    
		    String valueString = "["
		    		+"\""+campaignValue+"\"" + ","
		    		+"]";
		    
		    if (value != null) {
		    	value = value + "," + valueString;
		    } else {
		    	value = valueString;
		    }
		    
		    campaignValue = null;
		}
		**/
		
		System.out.println("dashboard: " + json.toString());
		String valueFinal = "[" + json.toString() + "]";
		System.out.println("valueFinal: " + valueFinal);
		
		String jsonOut = "{"
	    		+"\""+dataSrc+"\"" + ":"
	    		+valueFinal
	    		+"}";
		System.out.println("jsonOut: " + jsonOut);
		JSONObject jsonObject = new JSONObject(jsonOut);
		System.out.println("jsonObject: " + jsonObject.toString());
		
		//response.sendRedirect("CampaignDashboard_Result.jsp");
		out.println(jsonObject.toString());
		
		String page = "";
	    try {

	    } catch (Exception e) {
	      page = "error.jsp";
	    } finally {
	      page = "CampaignDashboard_Result.jsp";
	    }

		RequestDispatcher dd = request.getRequestDispatcher(page);
		dd.forward(request, response);
	    
	}

}