<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>


		
						<c:forEach items="${categoryData}" var="category">

							<c:url value="${category.url}" var="categoryUrl"/>
							<li>
								<a href="${categoryUrl}" class="popup scrollerProduct">
									<div class="thumb">
										<%-- <product:productPrimaryImage product="${product}" format="product"/> --%>
										${category.image.url}
									</div>
									   
									<div>
									    ${category.code}
									</div>
									
									<div class="details">
											${category.description}
									</div>
								</a>
							</li>
						</c:forEach>
		
	