<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>

	<section class="packages-cntr services-cntr">
			<div class="package-heading-cntr">
				<h2>Our Services</h2>
				<div class="package-heading-divider"></div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
			</div>
		
			<div class="row packages-inner">
				<c:forEach items="${categoryData}" var="category">

							<c:url value="${category.url}" var="categoryUrl"/>

							<div class="col-xs-6 col-md-2 col-sm-4 package">
					<a href="${categoryUrl}">
					<div class="img-text-cntr">
						<img src="${themeResourcePath}/images/wedding_catering.jpg"/>
						<span>${category.name}</span>
					</div>
					</a>
				</div>
							
							<%-- 	
									<div class="thumb">
										<product:productPrimaryImage product="${product}" format="product"/>
										${category.image.url}
									</div>
									   
									<div>
									    ${category.code}
									</div>
									
									<div class="details">
											${category.description}
									</div>
								</a> --%>
							
						</c:forEach>
				
			</div>
		</section> 