
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %> --%>
<%-- <%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %> --%>

<template:page pageTitle="HOME">

	<div class="container">
		<!-- Codrops top bar -->

		<div id="container_demo">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<div id="wrapper" style="width: 80%;">
				<div id="login" class="animate form">
					<form id="category-form1" method="post" action="selectCategory">
						<label>Sell your item 1.Tell us what your selling.
							2.Create your listing. 3. Review your listing.</label> <br> <br>

						<label path="">Tell us what your are selling: select a
							category</label> <br> <label>Give us a title for your
							listing.</label> <input id="findcategory" name="findcategory"></input>
						<button id="findcat" name="findcat">Find categories</button>
					</form>
					<form id="category-form" method="post" action="selectCategory">
						<br> <br>
						<div>
							<label>Select a category</label>
						</div>
						<div>
							<table style="border-spacing: 100px;">

								<tr>
									<td style="padding: 30px;">
										<div class="selectdiv1">
											<label>Suggested categories</label> <br/>
											<select id="categorySel"
												name="categorySel" style="width: 300px;" size="10" class="categorySelect" >
												<c:forEach items="${categories}" var="category">
													<option id="${category.code}">${category.name}</option>
												</c:forEach>
											</select>
										</div>
									</td>
									
								</tr>


							</table>

						</div>
						<p class="create button"> 
                                  <input id="continueCategory" type="submit" value="Create" disabled="disabled"/> 
						</p>


					</form>

				</div>
			</div>
		</div>
	</div>
	<div class="tempdiv">
	<div class="selectdiv2"></div>
	</div>
</template:page>



