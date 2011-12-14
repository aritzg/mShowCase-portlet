<%@page import="net.sareweb.mshowcase.portlets.p002.CategoryNavigatorPortlet"%>
<%@include file="/jsp/init.jsp"%>
<%
	List<Category> categories0 = (List<Category>)request.getAttribute(CategoryNavigatorPortlet.ATTR_CATEGORIES_0);
%>
<ul id="categories">
	<%
		for(int i =0; i<categories0.size(); i++){
			Category cat0 = categories0.get(i);
	%>
		<liferay-portlet:actionURL name="selectCategory" var="selectCategoryURL">
			<liferay-portlet:param name="<%=CategoryNavigatorPortlet.PARAM_CATEGORY_ID %>" value="<%=String.valueOf(cat0.getCategoryId())%>"/>
		</liferay-portlet:actionURL>
		<li>
			<a href="<%=selectCategoryURL%>"><%=cat0.getName(locale) %></a>
		</li>	
	<%}%>
</ul>