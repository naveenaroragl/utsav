<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true"
	type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/desktop/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/desktop/cart"%>

<!-- Login Modal -->
<div class="modal fade" id="myModalLogin" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-dialog-login" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<!-- Login Part -->
				<div class="login-form popup-form-cntr">
					<div class="form-header">
						<i class="icon-user"></i>
					</div>
					<form:form id="login-form" method="post" class="form-signin" role="form" action="${action}" commandName="loginForm">
						<c:if test="${not empty message}">
							<span class="errors">
								<spring:theme code="${message}"/>
							</span>
						</c:if>
						<c:if test="${loginError}">
							<div class="form_field_error">
						</c:if>
						<div class="input-group">
							<span id="basic-addon1" class="input-group-addon icon-user"></span>
							<!-- <input type="text" id="username" required placeholder="Username"
								 /> -->
							<div class="form-control">
								<formElement:formInputBox idKey="j_username" labelKey="login.email" path="j_username" inputCSS="text" mandatory="true" />
							</div>
						</div>
						<div class="input-group">
							<span id="basic-addon1" class="input-group-addon icon-lock"></span>
							<!-- <input type="password" id="password" required
								placeholder="password" /> -->
							<div class="form-control">
								<formElement:formPasswordBox idKey="j_password" labelKey="login.password" path="j_password" inputCSS="text password" mandatory="true" />
							</div>
						</div>
						<button class="btn btn-block bt-login" type="submit">
							<i class="modal-icons icon-login"></i>Sign in
						</button>
						<h4 class="text-center login-txt-center">Alternatively, you
							can log in using:</h4>
							
						<c:if test="${loginError}">
							</div>
						</c:if>
					</form:form>
					<a class="btn  facebook"
						href="<c:url value='https://www.facebook.com/dialog/oauth?client_id=1622586648064129&redirect_uri=https://localhost:9002/glutsavacceleratorstorefront/en/loginFacebook/request&scope=email'/>">
						<i class="modal-icons icon-facebook"></i> Signin with Facebook
					</a> <a class="btn  google"
						href="<c:url value='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://localhost:9002/glutsavacceleratorstorefront/en/loginGoogle/request&response_type=code&client_id=838327630667-4s7visper5eq9i1okkukcmt09518c0p5.apps.googleusercontent.com&approval_prompt=force&include_granted_scopes=true'/>">
						<i class="modal-icons icon-google"></i> Signin with Google
					</a>

					<div class="form-footer">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="" class="forgotPassword"> Forgot password? </a>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<!--<a href="#" data-dismiss="modal" data-toggle="modal" class="signupUser" data-target="#myModalSignup" > Sign Up</a>-->
								<a href="" class="signupUser"> Sign Up</a>
							</div>
						</div>
					</div>
				</div>
				<!-- end of Login Part -->
				<!-- Sign Up Part -->
				<c:url value="/login/register" var="registerActionUrl" />
				<div class="signup-form hidden popup-form-cntr">
					<div class="form-header">
						<i class="icon-edit"></i>
					</div>
					<form:form id="signup-form" method="post" class="form-signin" role="form" action="${registerActionUrl}" commandName="registerForm">
						<p class="text-secondary-color">All fields are mandatory</p>
										
						<formElement:formSelectBox idKey="register.title" labelKey="register.title" path="titleCode" mandatory="true" skipBlank="false" skipBlankMessageKey="form.select.empty" items="${titles}"/>
						<formElement:formInputBox idKey="register.firstName" labelKey="register.firstName" path="firstName" inputCSS="text" mandatory="true"/>
						<formElement:formInputBox idKey="register.lastName" labelKey="register.lastName" path="lastName" inputCSS="text" mandatory="true"/>
						<formElement:formInputBox idKey="register.email" labelKey="register.email" path="email" inputCSS="text" mandatory="true"/>
						<formElement:formPasswordBox idKey="password" labelKey="register.pwd" path="pwd" inputCSS="text password strength" mandatory="true"/>
						<formElement:formPasswordBox idKey="register.checkPwd" labelKey="register.checkPwd" path="checkPwd" inputCSS="text password" mandatory="true"/>
						
						
						<button class="btn btn-block bt-login" type="submit">
							<i class="modal-icons icon-login"></i>Sign Up
						</button>
					</form:form>
					<div class="form-footer"></div>
				</div>
				<!-- end of Sign Up Part -->
				<!-- Forgot Password Part -->
				<div class="forgot-password-form hidden popup-form-cntr">
					<div class="form-header">
						<i class="icon-at"></i>
					</div>
					<form id="forgot-password-form" method="post" class="form-signin"
						role="form" action="#">
						<p class="text-secondary-color">Enter your E-Mail address
							below to reset your password.</p>
						<input type="email" id="Email" required
							placeholder="Email Address" class="form-control" />
						<button class="btn btn-block bt-login" type="submit">
							<i class="modal-icons icon-login"></i>Send Email
						</button>
					</form>
					<div class="form-footer"></div>
				</div>
				<!-- end of Forgot Password  Part -->
			</div>
		</div>
	</div>
</div>
<!-- end of Login Modal -->

