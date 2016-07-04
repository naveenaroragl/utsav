<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.error {
	color: #ff0000;
}


</style>

<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
    $(document)
            .ready(
                    function() {
                        //add more file components if Add is clicked
                        $('#addFile')
                                .click(
                                        function() {
                                            var fileIndex = $('#fileTable tr').children().length;
                                            $('#fileTable')
                                                    .append(
                                                            '<tr><td>'
                                                                    + '   <input type="file" name="files['+ fileIndex +']" />'
                                                                    + '<img class="remove_project_file" src="images/delete_icon.gif" style="cursor:pointer"/>'
                                                                    + '</td></tr>');
                                        });
 
                

                        //remove file components if Add is clicked
                      $(document).on('click','.remove_project_file', function() {
                    	  console.log("hi...");
                    	  $(this).closest("tr").remove();
                      });
                                
    }); 
    
    
    /* function makeAjaxCallAsyncFalse(requesturl, requestData, successCallBack, component, completeCallBack, method) {	
    	if(method == null){
    		method ="POST";		
    	}
    	$.blockUI(); 
    	
    	var ajax = $.ajax({
    		url : requesturl,
    		type : method,
    		async: false,
    		htmlComp : (component == null) ? "" : component,
    				data : requestData,
    				postData : requestData,
    				beforeSend : function() {
    						//showBlockUI("Please wait...");
    				},
    				success : function(responseData) {
    					try {
    						if(typeof successCallBack == 'function')
    							successCallBack.call(this, responseData);

    					} catch (e) {	
//    						showDialog(unhandledExMsg + e, false);
    					}
    				},
    				error : function(jqXHR, textStatus, errorThrown) 
    				{					
    					//handleHttpError(jqXHR, textStatus, errorThrown);
    					if (jqXHR.status == 900 || jqXHR.status == 404)
    					{
    						window.location.href='expire.jsp';
    					}
    					
    				},
    				complete : function() {
    					$.unblockUI(); 
    									
    				
    						if (initPage && typeof completeCallBack != 'function') 
    						{
    							$(document).trigger('initPage');
    							initPage = false;
    						} 
    						else if (typeof completeCallBack == 'function') 
    						{
    							try 
    							{
    								completeCallBack.call(this);
    							} 
    							catch (e) 
    							{
    								//showDialog(unhandledExMsg + e, false);
    							}
    						}
    						
    					
    				}
    	});
    	
    } */
    
    $(document).ready(function () {
        var options = {
            width: 400,
            height: 200,
            controls: "bold italic underline strikethrough subscript superscript | 
			font size " +
                    "style | color highlight removeformat | bullets numbering | 
			outdent " +
                    "indent | alignleft center alignright justify | undo redo | " +
                    "rule link image unlink | cut copy paste pastetext | print source"
        };
 
        var editor = $("#editor").cleditor(options)[0];
 
        $("#btnClear").click(function (e) {
            e.preventDefault();
            editor.focus();
            editor.clear();
        });
 
        $("#btnAddImage").click(function () {
            editor.execCommand("insertimage",
                "http://images.free-extras.com/pics/s/smile-1620.JPG", null, null);
            editor.focus();
        });
 
        $("#btnGetHtml").click(function () {
            alert($("#editor").val());
        });
 
    });
    
    
</script>

</head>
<body>
<div >
	<div class="city">
		<tr><h3>Categories where your listing will appear&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Get Help</a></h3></tr>
	</div>
</div>
<table cellpadding="0" cellspacing="0" width="100%">
                     <!--individual starts--> 
				<form:form id="form2" name="form2" method="post" action="CategoryListing" commandName="itemDetailData">
					<table width="99%" border="0" align="center" cellpadding="12" cellspacing="0">
						<tr>
							<td>Title<span class="red">*</span></td>
						</tr>
						<tr>
							<td><form:input class="input-medium" id="title" path="title" autocomplete="off" maxLength="30" /></td>
							<td >&nbsp;</td>
							<td >&nbsp;</td>
						</tr>
					
						<tr>
							<td>SubTitle<span class="red">(Rs. 0.00)</span></td>
						</tr>
						<tr>
							<td><form:input class="input-medium" id="subTitle" path="subTitle" autocomplete="off" maxLength="30" /></td>
							<td >&nbsp;</td>
							<td >&nbsp;</td>
						<tr>
					
						<tr>
							<td>Condition<br/>
							Make sure you choose the right condition-<td>
						</tr><br/>
						
							<tr>
								<td><form:input class="input-medium" id="condition" path="condition" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							<tr>
					
					
					<div>
					        <form:form method="post" name="formMultiPart" action="savefiles" modelAttribute="uploadMultipartFiles" enctype="multipart/form-data">
					 
					             <table>
					            <tr><p>Select files to upload. Press Add button to add more file
					                inputs.</p></tr>
					             	<tr>
					             		<td>
					            			<input id="addFile" type="button" value="Add File" />
					            		</td>
					             	</tr>
					             </table>   
					 
					            <table id="fileTable">
					                <tr>
					                    <td><input name="files[0]" type="file" /><img class="remove_project_file" src="images/delete_icon.gif" style="cursor:pointer" /></td>
					                </tr>
					                <tr>
					                    <td><input name="files[1]" type="file" /><img class="remove_project_file" src="images/delete_icon.gif" style="cursor:pointer" /></td>
					                </tr>
					            </table>
					            <br />
					            <input type="button" value="Upload" onclick="uploadFile()" />
					        </form:form>
 
       						 <br />
    					
					</div><br/>
						
							<tr>
							<td>Brand<span class="red">*</span></td>
							</tr>
							<tr>
								<td><form:input class="input-medium" id="brand" path="brand" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							<tr><br/>
							
							<tr>
							<td>Type<span class="red">*</span></td>
							</tr>
							<tr>
								<td><form:input class="input-medium" id="type" path="type" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							<tr><br/>
							
							<%-- <tr>
							<td>Warranty<span class="red">*</span></td>
							</tr>
							<tr>
								<td>
		               			<form:select id="waranty" path="waranty" class="select-medium" name="waranty">
									<form:option value="0">Please Select</form:option>
									<c:forEach items="${modeOfCommunication}" var="modeOfComm">
										<form:option value="${modeOfComm.commonDataId}"><c:out value="${modeOfComm.commonDataValue}" /></form:option>
									</c:forEach> 
								</form:select>
	                 			</td>
                 			</tr> --%>
							
							<tr>
							<td>Warranty Partner Name<span class="red">*</span></td>
							</tr>
							<tr>
								<td><form:input class="input-medium" id="type" path="warrantyPartnerName" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							<tr>
							
							<tr>
							<td>Warranty Details<span class="red">*</span></td>
							</tr>
							<tr>
								<td><form:input class="input-medium" id="type" path="warrantyDetails" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							<tr>
							
							<tr>
							<td>Warranty Condition<span class="red">*</span></td>
							</tr>
							<tr>
								<td><form:input class="input-medium" id="type" path="warrantyCondition" autocomplete="off" maxLength="30" /></td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
							</tr><br/>
							
							<div>
								<tr>
									<td>
										Details<span>*</span>
									</td>
								</tr>
								<div style="width: 400px">
								    <div class="normaldiv" style="float: right">
								        <a href="#" class="siteButton" id="btnClear">Clear</a>
								        <a href="#" class="siteButton" id="btnAddImage">Add an image</a>
								        <a href="#" class="siteButton" id="btnGetHtml">Get html</a>
								    </div>
								    <div>
								        <form:textarea path="" id="editor" rows="0" cols="0"/>
								    </div>
								</div>
							</div>
						
					 <div align="left" style="padding:5px; margin-top:10px;">
						 <tr>
	                    	<td><input type="submit" id="submit" value="Submit" /></td>
	                    </tr>
                   </div>
                     <!--individual ends-->
                     </table>
                  </form:form>
                  </table>

</body>
</html>