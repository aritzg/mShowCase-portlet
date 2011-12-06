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
		<li><%=cat0.getName(locale) %></li>	
	<%}%>
</ul>