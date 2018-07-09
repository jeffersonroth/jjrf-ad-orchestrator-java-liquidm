<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>LiquidM Reporting</title>
<style type="text/css" title="currentStyle">
@import "resources/css/demo_table.css";
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- #region datatables files -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<!-- #endregion -->
<!--
<script type="text/javascript" language="javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="resources/js/jquery.dataTables.js"></script>
-->
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
	    $('#waiting').hide();
	    var oTable = $('#example').dataTable({
            "processing": true,
            "ajax": {
                "url": "${pageContext.request.contextPath}/VisualReportsServlet",
                "dataSrc": "reporting",
                "type": "GET"
            }
        });
	})
	/*
	$('#launcher').click(function() {
	    	$('#btn').hide();
	    	$('#waiting').show();
	        $.ajax({
	            url: "${pageContext.request.contextPath}/VisualReportsServlet",
	            data: {
	                dataSrc: oTable
	            },
	            dataType: "json",
	            async: false,
	            success: function(data) {
	                $('#waiting').hide();
	                $("#dynamic").html(data);
	                console.log(data)
	            }
	        });
	    });
	*/
</script>
</head>
<body id="dt_example">
<div id="logo" style="display: block;">
    <img src="resources/images/JR.png" title="JR" alt="JR" style="text-align:center;"
    	border="0" height="100" width="100"/>
</div>
<div id="btn" style="display: none;">
    <input  type="button" id="launcher" value="Get LiquidM Report" />
</div>
<div id="waiting" style="display: none;">
    <img src="resources/images/loading.gif" title="Loader" alt="Loader" />
</div>
<div id="dynamic">
		<table cellpadding="0" cellspacing="0" border="0" class="display"
			id="example">
			<thead>
				<tr>
					<th width="10%">LiquidM ID</th>
					<th width="10%">CID</th>
					<th width="10%">Ad Impressions</th>
					<th width="10%">Bids</th>
					<th width="10%">Bid Requests</th>
					<th width="10%">Clicks</th>
					<th width="10%">CTR</th>
					<th width="10%">Conversion 1 (Downloads)</th>
					<th width="10%">Conversion 2</th>
					<th width="10%">Conversion 3</th>
					<th width="10%">Conversion Value</th>
					<th width="10%">eCPC</th>
					<th width="10%">eCPX 1</th>
					<th width="10%">eCPX 2</th>
					<th width="10%">eCPX 3</th>
					<th width="10%">eCPM</th>
					<th width="10%">Cost</th>
					<th width="10%">Win Rate</th>
					<th width="10%">Conversion Rate</th>
					<th width="10%">Video 25% Viewed</th>
					<th width="10%">Video 50% Viewed</th>
					<th width="10%">Video 75% Viewed</th>
					<th width="10%">Video 100% Viewed</th>
					<th width="10%">Campaign Info</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>