<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>


<template:page pageTitle="${pageTitle}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>
	
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
	<cms:pageSlot position="CS_HomePage_Category" var="component">
		<cms:component component="${component}"/>
	</cms:pageSlot>
	
	
</template:page>
