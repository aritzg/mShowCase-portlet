<%@page import="net.sareweb.mshowcase.portlets.p000.InstancesPortlet"%>
<%@include file="/jsp/init.jsp"%>


<div class="content-box">
	No instance yet!!!
	<liferay-portlet:actionURL name="createInstance" var="createInstanceURL"/>
	
	<aui:form action="<%=createInstanceURL.toString()%>" method="post" name="fm">
	<div>
		<aui:input name="subdomain"/><%=themeDisplay.getCompany().getVirtualHostname()%>
	</div>
	
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
	</aui:form>
</div>