<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>

<c:choose>
	<c:when test="${not empty categoryData}">
		<div class="scroller">
						<c:forEach items="${categoryData}" var="category">

							<c:url value="/c/${category.code}" var="categoryUrl"/>
							<li>
								<a href="${categoryUrl}" class="popup scrollerProduct">
									<div class="thumb">
										<%-- <product:productPrimaryImage product="${product}" format="product"/> --%>
										${category.image}
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
		</div>
	</c:when>

	<c:otherwise>
		<component:emptyComponent/>
	</c:otherwise>
</c:choose>