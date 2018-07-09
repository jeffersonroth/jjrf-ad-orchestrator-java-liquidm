<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String spreadsheetID=request.getParameter("spreadsheetID"); %>
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
		var spreadsheetID = ${spreadsheetID};
    	var oTable = $('#table').dataTable({
            "processing": true,
            "ajax": {
                "url": "${pageContext.request.contextPath}/CampaignDashboardServlet",
                "dataSrc": "dashboard",
                "type": "GET"
            }
        });
	})
</script>
</head>
<body>
	<div id="logo" style="display: block;">
	    <img src="resources/images/JR.png" title="JR" alt="JR" style="text-align:center;"
	    	border="0" height="100" width="100"/>
	</div>
	<div id="dynamic">
		<table cellpadding="0" cellspacing="0" border="0" class="display"
			id="table">
			<thead>
				<tr>
					<c:forEach items="${list}" var="item">
				      <th width="10%"><c:out value="${item}" /></th>
				  	</c:forEach>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>