<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>
<%@ attribute name="metaDescription" required="false" %>
<%@ attribute name="metaKeywords" required="false" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="addonScripts" tagdir="/WEB-INF/tags/desktop/common/header" %>
<%@ taglib prefix="analytics" tagdir="/WEB-INF/tags/shared/analytics" %>
<%@ taglib prefix="debug" tagdir="/WEB-INF/tags/shared/debug" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/desktop/user" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>





<!DOCTYPE html>
<html lang="en">
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
  <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
  <meta name="author" content="Codrops" />
  <link rel="shortcut icon" href="../favicon.ico"> 
  <link rel="stylesheet" type="text/css" href="css/demo.css" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
  <script type="text/javascript" src="script/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="script/acc.registerProduct.js"></script>
  
  
  
	<title>
		${not empty pageTitle ? pageTitle : not empty cmsPage.title ? cmsPage.title : 'Accelerator Title'}
	</title>

	<%-- Meta Content --%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<title>Ecart</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
</head>
<body >
	<div class="container">
            <div class="row header-nav-bar" id="headerDiv">
				<div class="text-left logo">  <img src="images/logo.png" class="logo" alt="Ecart" />       </div>
				<div class="text-right"> 
					<div class="top-header-links">
								<span class="nav-element">
									<%-- 	<spring:theme code="header.welcome" arguments="${user.displayName}" htmlEscape="true" /> --%> 
								</span>

							<span class="nav-element">
								<a href="<c:url value='/logout'/>" class="icon-user" class="login-top-link">Logout</a>
							</span>
						
						<span class="nav-element"><a href="#" title="About Us">About Us</a></span>
						<span class="nav-element"><a href="#" title="Contact Us">Contact Us</a></span>
						<span class="nav-element"><a href="#" title="Help">Help</a></span>           
						<span class="nav-element"><a href="#" title="Privacy Policy">Privacy Policy</a></span>
					</div>  
				</div>
				<!--<div class="col-md-1 col-sm-1 col-xs-12 text-right"> <div class="cart "></div>   </div>-->
			</div>
          
          <jsp:doBody/>
    </div>
</body>


</html>
