<%@page import="net.sareweb.mshowcase.portlets.p000.InstancesPortlet"%>
<%@page import="net.sareweb.mshowcase.model.Instance"%>
<%@include file="/jsp/init.jsp"%>

<%
Instance instance = (Instance)request.getAttribute(InstancesPortlet.ATTR_INSTANCE);
%>

<div class="content-box">
	No instance yet!!!
	<liferay-portlet:actionURL name='<%=instance!=null? "updateInstance":"createInstance"  %>' var="actionURL"/>
	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">
	
	<aui:fieldset>
		<aui:input name="<%=InstancesPortlet.PARAM_NAME%>" label="msc-p000-name" value='<%=instance!=null ? instance.getName() : ""  %>'/>
		<aui:input name="<%=InstancesPortlet.PARAM_DESCRIPTION%>" label="msc-p000-description" type="textarea" value='<%=instance!=null ? instance.getDescription() : ""  %>'/>
	</aui:fieldset>

	<aui:fieldset>
		<aui:input name="<%=InstancesPortlet.PARAM_PHONE%>" label="msc-p000-phone" value='<%=instance!=null ? instance.getPhoneNumber() : ""  %>'/>
		<aui:input name="<%=InstancesPortlet.PARAM_FAX%>" label="msc-p000-fax" value='<%=instance!=null ? instance.getFaxNumber() : ""  %>'/>
		<aui:input name="<%=InstancesPortlet.PARAM_EMAIL%>" label="msc-p000-email" value='<%=instance!=null ? instance.getEmail() : ""  %>'/>
		<aui:input name="<%=InstancesPortlet.PARAM_WEB%>" label="msc-p000-web" value='<%=instance!=null ? instance.getWebPage() : ""  %>'/>
	</aui:fieldset>

	
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
	</aui:form>
</div>