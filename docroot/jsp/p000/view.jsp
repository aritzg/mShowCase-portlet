<%@page import="net.sareweb.mshowcase.portlets.p000.MyInstancePortlet"%>
<%@include file="/jsp/init.jsp"%>
<%
Instance instance = (Instance)request.getAttribute(MyInstancePortlet.ATTR_INSTANCE);
%>
<div id="instance-detail">
	<div id="instance-data">
		<div class="data-field">
			<div class="data-label"><liferay-ui:message key="msc-p000-name"/> </div>
			<div class="data-text"><%=instance.getName()%></div>
		</div>
	</div>
	<div id="instance-images">
	
	</div>	
	<aui:button-row>
		<liferay-portlet:renderURL var="editURL">
			<liferay-portlet:param name="<%=MyInstancePortlet.PARAM_RENDER%>" value="<%=MyInstancePortlet.PARAM_RENDER_EDIT%>"></liferay-portlet:param>
		</liferay-portlet:renderURL>
		<aui:button value="msc-p000-edit" onClick="<%=editURL%>"/>
	</aui:button-row>
</div>