<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>
<%@ attribute name="metaDescription" required="false" %>
<%@ attribute name="metaKeywords" required="false" %>
<%@ attribute name="pageCss" required="false" fragment="true" %>
<%@ attribute name="pageScripts" required="false" fragment="true" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="addonScripts" tagdir="/WEB-INF/tags/desktop/common/header" %>
<%@ taglib prefix="analytics" tagdir="/WEB-INF/tags/shared/analytics" %>
<%@ taglib prefix="debug" tagdir="/WEB-INF/tags/shared/debug" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="htmlmeta" uri="http://hybris.com/tld/htmlmeta" %>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/desktop/common/footer"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/desktop/common/header"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/desktop/user" %>



<!DOCTYPE html>
<html lang="${currentLanguage.isocode}">
<head>
	<title>
		${not empty pageTitle ? pageTitle : not empty cmsPage.title ? cmsPage.title : 'Accelerator Title'}
	</title>


	<%-- Meta Content --%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<%-- Additional meta tags --%>
	<htmlmeta:meta items="${metatags}"/>

	<%-- Favourite Icon --%>
	<spring:theme code="img.favIcon" text="/" var="favIconPath"/>
    <link rel="shortcut icon" type="image/x-icon" media="all" href="${originalContextPath}${favIconPath}" />

	<%-- CSS Files Are Loaded First as they can be downloaded in parallel --%>
	<template:styleSheets/>

	<%-- Inject any additional CSS required by the page --%>
	<jsp:invoke fragment="pageCss"/>
	<analytics:analytics/>
	
	
	<title>Ecart</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/vendors/jquery-1.11.3.min.js"></script>
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/vendors/bootstrap.min.js"></script>
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/vendors/bootstrap-select.min.js"></script>
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/custom.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.1/angular.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.1/angular-route.min.js"></script>
	
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/app.js"></script>
	<script src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/js/routes.js"></script>
	
	
</head>

<body ng-app="MainApp" class="${pageBodyCssClasses} ${cmsPageRequestContextData.liveEdit ? ' yCmsLiveEdit' : ''} language-${currentLanguage.isocode}">

	<%-- Inject the page body here --%>
	
	
	<div class="container">
	
        <header:header/>
		
		
<section class="home-search-cntr row">
	<div class="search-cntr-inner row">
		  <span class="search-label">I am looking for</span>			
		  <form class="navbar-form" role="search" method="get">
			<div class="form-group">
			  <select name="selectVal" class="selectpicker selectpicker1" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
				<optgroup label="filter1">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
				<optgroup label="filter2">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
				<optgroup label="filter3">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
			  </select>
			</div>
			<span class="search-label">In</span>
			<div class="form-group">
			  <select name="selectVal" class="selectpicker selectpicker2" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
				<optgroup label="filter1">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
				<optgroup label="filter2">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
				<optgroup label="filter3">
				  <option>option1</option>
				  <option>option2</option>
				  <option>option3</option>
				  <option>option4</option>
				</optgroup>
			  </select>
			</div>
			
			<div class="input-group">
			 

			  <div class="input-group-btn">
				<button class="btn btn-default search-btn-main" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			  </div>
			</div>
			
		  </form>
	</div> 
</section>

          <div ng-view></div>
		           
        <footer:footer/>
       
    </div>

<c:url value="/j_spring_security_check" var="loginActionUrl" />
<%-- <user:login actionNameKey="login.login" action="${loginActionUrl}"/> --%>




<!-- verticals-popup -->
<div class="modal fade verticals-popup" id="verticalsPopup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-dialog-verticals-popup" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h2>Please choose the products and services </h2>
      </div>
		  <form method="post" id="vericals-form">
			  <div class="modal-body">
				<div class="main-checkboxes-cntr">
					<div class="chkbox-label-cntr">
						<input id="catering" data="catering" type="checkbox" />
						<label for="catering" class="icon-food">Catering</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="hospitality" data="hospitality" type="checkbox" />
						<label for="hospitality" class="icon-commerical-building">Hospitality</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="fashion" data="fashion" type="checkbox" />
						<label for="fashion" class="icon-women">Fashion</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="music"  data="music" type="checkbox" />
						<label for="music" class="icon-music">Music</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="grooming" data="grooming" type="checkbox" />
						<label for="grooming" class="icon-beauty">Grooming</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="gifts"  data="gifts" type="checkbox" />
						<label for="gifts" class="icon-gift">Gifts</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="photography"  data="photography" type="checkbox" />
						<label for="photography" class="icon-camera">Photography</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="travel" data="travel" type="checkbox" />
						<label for="travel" class="icon-flight">Travel</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="jewellery" data="jewellery" type="checkbox" />
						<label for="jewellery" class="icon-luxury">Jewellery</label>
					</div>

					<div class="chkbox-label-cntr">
						<input id="customs" data="customs" type="checkbox" />
						<label for="customs" class="icon-nature-3">Customs</label>
					</div>
				</div>
			</div>
			<div class="form-footer">
					<a href="#/Products" class="btn btn-block btn-continue btn-continue-vericals-home"> Continue</a>
				
			</div>
		</form>
	</div>
	</div>
</div><!-- end of verticals-popup -->

	
	
  

	
	
	<%-- <jsp:doBody/> --%>

	

</body>

<debug:debugFooter/>

</html>
