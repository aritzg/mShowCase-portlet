<%@page import="net.sareweb.mshowcase.portlets.p001.InstanceAdminPortlet"%>
<%@include file="/jsp/init.jsp"%>

<aui:button-row>
	<liferay-portlet:renderURL var="viewURL">
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_RENDER%>" value="<%=InstanceAdminPortlet.PARAM_RENDER_VIEW%>"/>
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_COMPANY_ID%>" value="<%=String.valueOf(company.getCompanyId())%>"/>
	</liferay-portlet:renderURL>
	<liferay-ui:icon url="<%=viewURL%>" image="view"/>
	
	<liferay-portlet:renderURL var="editURL">
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_RENDER%>" value="<%=InstanceAdminPortlet.PARAM_RENDER_EDIT%>"/>
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_COMPANY_ID%>" value="<%=String.valueOf(company.getCompanyId())%>"/>
	</liferay-portlet:renderURL>
	<liferay-ui:icon url="<%=editURL%>" image="edit"/>
	
	<liferay-portlet:actionURL name="deleteInstance" var="deleteURL">
		<liferay-portlet:param name="<%=InstanceAdminPortlet.PARAM_COMPANY_ID%>" value="<%=String.valueOf(company.getCompanyId())%>"/>
	</liferay-portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL%>"/>
</aui:button-row>