<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campaign Dashboard</title>
<style type="text/css" title="currentStyle">
@import "resources/css/demo_table.css";
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- #region datatables files -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<!-- #endregion -->
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
	    $('#waiting').toggle();
	})
	$('#launcher').click(function() {
    	$('#waiting').show();
    	var spreadsheetID = ${spreadsheetID};
    });
</script>
</head>
<body>
	<div id="logo" style="display: block;">
	    <img src="resources/images/JR.png" title="JR" alt="JR" style="text-align:center;"
	    	border="0" height="100" width="100"/>
	</div>
	<div id="waiting" style="display: block;">
	    <img src="resources/images/loading.gif" title="Loader" alt="Loader" />
	</div>
	<form method="post" action="CampaignDashboard_Result.jsp">
			<lable><b>Enter your Google spreadsheet ID:</b></label>
	        <input type="text" name="spreadsheetID">
	        <input type='submit' id="launcher" value="Get Campaigns Dashboard!" />
	</form>
</body>
</html>