<%@page import="net.sareweb.mshowcase.portlets.p000.MyInstancePortlet"%>
<%@include file="/jsp/init.jsp"%>


<div class="content-box">
	<liferay-portlet:actionURL name="saveOffer" var="saveOfferURL">
		<liferay-portlet:param name="redirect" value="<%=PortletURLUtil.getCurrent(renderRequest, renderResponse).toString()%>"></liferay-portlet:param>
	</liferay-portlet:actionURL>
	<aui:form action="<%=saveOfferURL%>" method="post" name="fm">
	
		<aui:button-row>
			<aui:button type="submit" value="msc-p000-save"/>
			<liferay-portlet:renderURL var="viewURL">
				<liferay-portlet:param name="<%=MyInstancePortlet.PARAM_RENDER%>" value="<%=MyInstancePortlet.PARAM_RENDER_VIEW%>"></liferay-portlet:param>
			</liferay-portlet:renderURL>
			<aui:button value="msc-p000-back" onClick="<%=viewURL%>"/>
		</aui:button-row>
	</aui:form>
</div>