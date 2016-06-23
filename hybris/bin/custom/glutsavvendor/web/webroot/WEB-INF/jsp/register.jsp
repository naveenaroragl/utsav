<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
           
            <header>
             <div class="clr"></div>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                             <form:form id="ee" method="post" action="login" commandName="register"  autocomplete="on"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <form:label path="userData.email" for="username" class="uname" data-icon="u" > Your email or username </form:label>
                                    <form:input path="userData.email" id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                     <form:errors path="userData.email" cssClass="error" />
                                </p>
                                <p> 
                                    <form:label path="userData.password" for="password" class="youpasswd" data-icon="p"> Your password </form:label>
                                    <form:input path="userData.password" id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                    <form:errors path="userData.password" cssClass="error" />
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form:form>
                        </div>




					<div id="register" class="animate form">
						<form:form id="test" action="register" commandName="register"
							method="post">
							<h1>Sign up</h1>
							<p>
								<tr>
									<form:label path="vendorData.type" class="uname" data-icon="u">Select Category</form:label>
									<td><form:select  name="vendorData.type" path="vendorData.type"
										id="stateLst">
											<c:forEach items="${gluVendorTypes}" var="option">
												<option value="${option}">
													<c:out value="${option.code}"></c:out>
												</option>
											</c:forEach>
									</form:select> </td>
									<td><form:errors path="gluVendorTypes" cssClass="error" /></td>
								</tr>

							</p>
							<p>
								<form:label path="userData.firstName" class="uname" data-icon="u">First Name</form:label>
								<form:input id="usernamesignup" path="userData.firstName"
									required="required" placeholder="mysuperusername690" />
							</p>
							<p>
								<form:label path="userData.lastName" class="uname" data-icon="u">Last Name</form:label>
								<form:input id="usernamesignup" path="userData.lastName"
									required="required" placeholder="mysuperusername690" />
							</p>
							<p>
								<form:label path="userData.email" class="youmail" data-icon="e">Email</form:label>
								<form:input id="emailsignup" path="userData.email" required="required"
									 placeholder="mysupermail@mail.com" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.line1" class="youmail" data-icon="e">Address1</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.line1" required="required"
									 placeholder="Street abc" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.line2" class="youmail" data-icon="e">Address2</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.line2" required="required"
									 placeholder="Street abc" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.town" class="youmail" data-icon="e">City</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.town" required="required"
									 placeholder="Noida" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.country.name" class="youmail" data-icon="e">Country</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.country.name" required="required"
									 placeholder="India" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.postalCode" class="youmail" data-icon="e">Postal Code</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.postalCode" required="required"
									 placeholder="302012" />
							</p>
							<p>
								<form:label path="companyData.companyName" class="youmail" data-icon="e">Company Name</form:label>
								<form:input id="emailsignup" path="companyData.companyName" required="required"
									 placeholder="GL" />
							</p>
							<p>
								<form:label path="userData.mailingAddress.phone" class="youmail" data-icon="e">Phone</form:label>
								<form:input id="emailsignup" path="userData.mailingAddress.phone" required="required"
									 placeholder="1234567890" />
							</p>
							<p>
								<form:label path="vendorData.uridomain" class="youmail" data-icon="e">Company domain</form:label>
								<form:input id="emailsignup" path="vendorData.uridomain" required="required"
									 placeholder="www.gl.com" />
							</p>
							<p>
								<form:label path="userData.password" class="youpasswd" data-icon="p">Your password </form:label>
								<form:input id="passwordsignup" path="userData.password"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p>
								<form:label path="userData.password" class="youpasswd" data-icon="p">Please confirm your password </form:label>
								<input id="passwordsignup_confirm" path="userData.password"
									required="required" type="password" placeholder="eg. X8df!90EO" />
							</p>
							<p class="signin button">
								<input type="submit" value="Sign up" />
							</p>
							<p class="change_link">
								Already a member ? <a href="#tologin" class="to_register">
									Go and log in </a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>