<%@page import="net.sareweb.mshowcase.portlets.p002.CategoryNavigatorPortlet"%>
<%@include file="/jsp/init.jsp"%>
<%
List<Category> categories0 = (List<Category>)request.getAttribute(CategoryNavigatorPortlet.ATTR_CATEGORIES_0);
List<Category> categories1 = (List<Category>)request.getAttribute(CategoryNavigatorPortlet.ATTR_CATEGORIES_1);
String parentCategoryId = (String)request.getAttribute(CategoryNavigatorPortlet.ATTR_PARENT_CATEGORY_ID);
String categoryId = (String)request.getAttribute(CategoryNavigatorPortlet.ATTR_CATEGORY_ID);
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
                        <%if(String.valueOf(cat0.getCategoryId()).equals(categoryId) || String.valueOf(cat0.getCategoryId()).equals(parentCategoryId)){%>
                                <ul id="subCategories">
                                <%
                                for(int j =0; j<categories1.size(); j++){
                                        Category cat1 = categories1.get(j);
                                %>
                                        <liferay-portlet:actionURL name="selectCategory" var="selectCategoryURL">
                                                <liferay-portlet:param name="<%=CategoryNavigatorPortlet.PARAM_CATEGORY_ID %>" value="<%=String.valueOf(cat1.getCategoryId())%>"/>
                                        </liferay-portlet:actionURL>
                                        <li>
                                                <a href="<%=selectCategoryURL%>"><%=cat1.getName(locale) %></a>
                                        </li>
                                <%}%>
                                </ul>
                        <%} %>
                </li>   
        <%}%>
</ul>
