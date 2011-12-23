<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@page import="net.sareweb.mshowcase.model.Category"%>
<%@page import="net.sareweb.mshowcase.model.Instance"%>
<%@page import="net.sareweb.mshowcase.model.Offer"%>

<%@page import="net.sareweb.mshowcase.service.OfferLocalServiceUtil"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences prefs = null;
if(renderRequest!=null)prefs = renderRequest.getPreferences();
%>
