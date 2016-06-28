<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %> --%>
<%-- <%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %> --%>


<template:page pageTitle="CreateProduct">

        <div class="container">
            <!-- Codrops top bar -->
           
            <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <div id="wrapper" style="width: 80%;">
                        <div id="login" class="animate form">
                           <form id="feature-form" method="post" action="createProduct" >  
                                <h1>Create Product </h1> 
                                <p> 
                                	
						          <c:forEach items="${features}" var="classification">
										</br><div class="headline"  style="font-size:17px">${classification.name}</div></br>
											<table>
												<tbody>
													<c:forEach items="${classification.allClassificationAttributeAssignments}" var="feature">
														<tr>
															<td class="attrib" style="width:30%">
															<label for="${feature.classificationAttribute.code }">${feature.classificationAttribute.name}</label></td>
															<td class="attrib" style="width:30%"><input type="text" id="${feature.classificationAttribute.code }" /></td>
															<td class="attrib" style="width:30%; padding-left:30px">${feature.unit.name}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										
									</c:forEach>                    
                               
                                
                                
                                
                                    <%-- <form:label path="category" for="baseCategory" > $</form:label>
                                    <form:input path="category" id="baseCategory" name="baseCategory" required="required" type="text" placeholder="Select Category"/> --%>
                                </p>
                                <p class="create button"> 
                                    <input type="submit" value="Create" /> 
								</p>
                                <p class="change_link" style="width: -moz-available">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            <%-- </form:form> --%>
                            </form>
                        </div>
           </div>
           </div>
	</div>
</template:page>
