           <%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="hideHeaderLinks" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/desktop/common/header"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
           
           <header>
           <div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">  <img src="${themeResourcePath}/images/logo.png" class="logo" alt="Ecart" />       </div>
				<div class="col-md-6 col-sm-6 col-xs-12 text-right text-xs-left"> 
					<ul class="top-header-links">
						<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
								<c:set var="maxNumberChars" value="25" />
								<c:if test="${fn:length(user.firstName) gt maxNumberChars}">
									<c:set target="${user}" property="firstName"
										value="${fn:substring(user.firstName, 0, maxNumberChars)}..." />
								</c:if>

								<li class="liOffcanvas ">
									<ycommerce:testId code="header_LoggedUser">
										<spring:theme code="header.welcome" arguments="${user.firstName},${user.lastName}" htmlEscape="true" />
									</ycommerce:testId>
								</li>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
								<li class="liOffcanvas">
									<ycommerce:testId code="header_Login_link">
										<li><a href="" class="icon-user" data-toggle="modal" data-target="#myModalLogin" class="login-top-link">Login</a></li>
									</ycommerce:testId>
								</li>
						</sec:authorize>

						<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
							<li class="liOffcanvas">
								<ycommerce:testId code="header_signOut">
									<li><a href="<c:url value='/logout'/>" class="icon-user" class="login-top-link">Logout</a></li>
								</ycommerce:testId>
							</li>
						</sec:authorize>
						
						<li><a href="#" title="About Us">About Us</a></li>
						<li><a href="#" title="Contact Us">Contact Us</a></li>
						<li><a href="#" title="Help">Help</a></li>           
						<li><a href="#" title="Privacy Policy">Privacy Policy</a></li>
					</ul>  
				</div>
				<!--<div class="col-md-1 col-sm-1 col-xs-12 text-right"> <div class="cart "></div>   </div>-->
			</div>
			</header>