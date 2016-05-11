<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>


<cms:pageSlot position="Footer" var="feature" element="div" class="footer">
	<cms:component component="${feature}"/>
</cms:pageSlot>


 <footer>
        <section id="countries" class="rows">
        <ul class="span-12">            
            <li class="col span-2"><a href="#" title="India">India</a></li>
            <li class="col span-2"><a href="#" title="United States">United States</a></li>
            <li class="col span-2"><a href="#" title="France">France</a></li>
            <li class="col span-2"><a href="#" title="Germany">Germany</a></li>
            <li class="col span-2"><a href="#" title="Holland">Holland</a></li>            
        </ul>
        </section>
        <section id="socialIcons" class="rows">
        <ul class="span-12">            
            <li class="col span-2"><a href="#" title="Follow Us">Follow Us</a></li>
            <li class="col span-2"><a href="#" title="Find Us">Find Us</a></li>
            <li class="col span-2"><a href="#" title="Subscribe">Subscribe</a></li> 
        </ul>
        </section>
        <section id="bottomNav" class="rows">
        <ul class="span-12">
            <li class="col span-2"><a href="#" title="About Us">About Us</a></li>
            <li class="col span-2"><a href="#" title="Contact Us">Contact Us</a></li>
            <li class="col span-2"><a href="#" title="FAQs">FAQs</a></li>
            <li class="col span-2"><a href="#" title="Help">Help</a></li>           
            <li class="col span-2"><a href="#" title="Privacy Policy">Privacy Policy</a></li>
        </ul>
        </section>
       
        </footer>