<%@page import="net.sareweb.mshowcase.portlets.p002.CategoryNavigatiorPortlet"%>
<%@include file="/jsp/init.jsp"%>
<%
List<Category> categories0 = (List<Category>)request.getAttribute(CategoryNavigatiorPortlet.ATTR_CATEGORIES_0);
%>
<ul id="categories">
	<%
	for(int i =0; i<categories0.size(); i++){
		Category cat0 = categories0.get(i);
	%>
		<liferay-portlet:actionURL name="selectCategory" var="selectCategoryURL">
			<liferay-portlet:param name="<%=CategoryNavigatiorPortlet.PARAM_CATEGORY_ID %>" value="<%=String.valueOf(cat0.getCategoryId())%>"/>
		</liferay-portlet:actionURL>
		<li>
			<a href="<%=selectCategoryURL%>"><%=cat0.getName(locale) %></a>
		</li>	
	<%}%>
</ul>