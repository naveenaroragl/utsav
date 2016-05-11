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
				<div class="col-md-6 col-sm-6 col-xs-12">  <img src="/glutsavacceleratorstorefront/_ui/desktop/theme-blue/images/logo.png" class="logo" alt="Ecart" />       </div>
				<div class="col-md-6 col-sm-6 col-xs-12 text-right text-xs-left"> 
					<ul class="top-header-links">
						<li><a href="" class="icon-user" data-toggle="modal" data-target="#myModalLogin" class="login-top-link">Login</a></li>
						<li><a href="#" title="About Us">About Us</a></li>
						<li><a href="#" title="Contact Us">Contact Us</a></li>
						<li><a href="#" title="Help">Help</a></li>           
						<li><a href="#" title="Privacy Policy">Privacy Policy</a></li>
					</ul>  
				</div>
				<!--<div class="col-md-1 col-sm-1 col-xs-12 text-right"> <div class="cart "></div>   </div>-->
			</div>
			</header>