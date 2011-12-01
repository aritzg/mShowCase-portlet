<%@include file="/jsp/init.jsp"%>

<%@page import="net.sareweb.mshowcase.portlets.p001.InstanceAdminPortlet"%>

view


<aui:button-row>
	<liferay-portlet:renderURL var="listURL">
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_RENDER%>" value="<%=InstanceAdminPortlet.PARAM_RENDER_LIST%>"/>
	</liferay-portlet:renderURL>
	<aui:button href="<%=listURL%>" value="msc-p001-list"/>
</aui:button-row>