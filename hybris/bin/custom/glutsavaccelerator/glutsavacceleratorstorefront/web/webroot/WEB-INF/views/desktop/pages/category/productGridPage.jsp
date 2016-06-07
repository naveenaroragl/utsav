<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/desktop/nav" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>

<template:page pageTitle="${pageTitle}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>
	
	
	<cms:pageSlot position="Section1" var="feature">
		<cms:component component="${feature}" element="div" class="span-24 section1 cms_disp-img_slot"/>
	</cms:pageSlot>
	
	<%-- <div class="span-24">
		<div class="span-6 facetNavigation">
			<cms:pageSlot position="ProductLeftRefinements" var="feature">
				<cms:component component="${feature}"/>
			</cms:pageSlot>
		</div>
		
		<div class="span-18 last">
			<cms:pageSlot position="ProductGridSlot" var="feature">
				<cms:component component="${feature}"/>
			</cms:pageSlot>
		</div>
	</div> --%>
<div id="productsServicesCntr">
	<section class="product-left-section box">
	<div class="left-sec-content-cntr">
	
		<section class="" id="Catering">

      <div class="filters-and-sort-cntr">

        <div class="showFilterBtnCntr">
          <a href=""  class="showFilterBtn" ng-click="showFilters = ! showFilters">Filters </a>
        </div>

        <div class="paginationCntr">
          Sort by: <a href="">Price: low to high</a> <a href="">Price: high to low</a> 
          <span class="pagination">Showing 1–16 of 33 results</span>
        </div>


      </div>
      <div class="filters-cntr" ng-class="{ 'hidden': ! showFilters }">
         
          <ul class="filters">
          		<li class="filter">
                <div class="filter-cntr">
                <c:forEach items="${searchPageData.facets}" var="facet">
				<c:choose>
					<c:when test="${facet.code eq 'availableInStores'}">
						<nav:facetNavRefinementFacet facetData="${facet}"/>
					</c:when>
					<c:otherwise>
						<nav:facetNavRefinementFacet facetData="${facet}"/>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				</div>
				</li>
               <li class="filter">
                <div class="filter-cntr">
                   <h3>Location</h3>
                  <ul>
                      <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                  </ul>
                </div>
              </li>
               <li class="filter">
                <div class="filter-cntr">
                   <h3>Veg/Non-Veg</h3>
                  <ul>
                      <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                  </ul>
                </div>
              </li>
               <li class="filter">
                <div class="filter-cntr">
                   <h3>Add-ons</h3>
                  <ul>
                      <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                       <li>
                        <input type="checkbox" name="abc" id="abc"/>
                        <label for="abc">Filter1</lable>
                      </li>
                  </ul>
                </div>
              </li>
          </ul>
      </div>


 <div class="packages-cntr services-cntr">
      <div class="package-heading-cntr">
        <h2>Available Options</h2>
        <div class="package-heading-divider"></div>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      </div>
    
      <div class="row packages-inner">
        <c:forEach items="${searchPageData.results}" var="product" varStatus="status">
			<product:productListerGridItem product="${product}" />
	</c:forEach>
      </div>
    </div> 

		</section>

		<section class="hidden" id="Hospitality">
			<h3>Hospitality</h3>
		</section>
		
		<section class="hidden" id="Music">
			<h3>Music</h3>
		</section>
		
		<section class="hidden" id="Grooming">
			<h3>Grooming</h3>
		</section>
		
		<section class="hidden" id="Photography">
			<h3>Photography</h3>
		</section>
		
		<section class="hidden" id="Travel">
			<h3>Travel</h3>
		</section>
		
		<section class="hidden" id="Customs">
			<h3>Customs</h3>
		</section>
		
		<section class="hidden" id="Fashion">
			<h3>Fashion</h3>
		</section>
		
		<section class="hidden" id="Gifts">
			<h3>Gifts</h3>
		</section>
		
		<section class="hidden" id="Jewellery">
			<h3>Jewellery</h3>
		</section>
		
</div>
</section>
</div> 
</template:page>