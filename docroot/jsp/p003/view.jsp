<%@page import="net.sareweb.mshowcase.portlets.p003.InstanceListPortlet"%>
<%@include file="/jsp/init.jsp"%>

<%
Category category0 = (Category) request.getAttribute(InstanceListPortlet.ATTR_CATEGORY_0);
Category category1 = (Category) request.getAttribute(InstanceListPortlet.ATTR_CATEGORY_1);
%>

<ul>
        <li>
                <liferay-ui:message key="msc-p003-categories"/>
        </li>
        <c:if test="<%=category0!=null %>">
        <li>
                <%=category0.getName(locale) %>
        </li>
        <c:if test="<%=category1!=null %>">
        <li>
                <%=category1.getName(locale) %>
        </li>
        </c:if>
        </c:if>

</ul>
