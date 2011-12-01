<%@include file="/jsp/init.jsp"%>

<%@page import="com.liferay.portal.model.Company"%>
<%@page import="net.sareweb.mshowcase.portlets.p001.InstanceAdminPortlet"%>

<%
List<Company> companies = (List<Company>)request.getAttribute(InstanceAdminPortlet.ATTR_COMPANIES);
%>

<div>
	<liferay-ui:search-container>
		<liferay-ui:search-container-results
				results="<%= companies %>"
				total="<%= companies.size()%>"/>
		
			<liferay-ui:search-container-row className="com.liferay.portal.model.Company" modelVar="company">
				<liferay-ui:search-container-column-text 
					name=""
					value="<%=company.getDefaultWebId()%>" 
				/>
				<liferay-ui:search-container-column-jsp 
					path="/jsp/p001/instance_actions.jsp" name="msc-p001-actions"/>
			</liferay-ui:search-container-row>
			
		<liferay-ui:search-iterator/>			
	</liferay-ui:search-container>
	
</div>