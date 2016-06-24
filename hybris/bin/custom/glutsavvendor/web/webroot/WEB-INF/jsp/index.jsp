<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %> --%>
<%-- <%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %> --%>


<template:page pageTitle="HOME">

        <div class="container">
            <!-- Codrops top bar -->
           
            <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <div id="wrapper" style="width: 80%;">
                        <div id="login" class="animate form">
                             <form:form id="product-form" method="post" action="createProduct" commandName="productForm"  autocomplete="on"> 
                                <h1>Create Product </h1> 
                                <p> 
                                    <form:label path="category" for="baseCategory" > Select Base Category</form:label>
                                    <form:input path="category" id="baseCategory" name="baseCategory" required="required" type="text" placeholder="Select Category"/>
                                     <form:errors path="category" cssClass="error" />
                                </p>
                                <p> 
                                    <form:label path="childCategory" for="childCategory" > Select Child Category </form:label>
                                    <form:input path="childCategory" id="childCategory" name="childCategory" required="required" type="password" placeholder="Select Child Category" /> 
                                    <form:errors path="childCategory" cssClass="error" />
                                </p>
                                <p class="create button"> 
                                    <input type="submit" value="Create" /> 
								</p>
                                <p class="change_link" style="width: -moz-available">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form:form>
                        </div>
           </div>
           </div>
	</div>
</template:page>
