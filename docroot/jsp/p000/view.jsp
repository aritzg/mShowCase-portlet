<%@page import="net.sareweb.mshowcase.portlets.p000.MyInstancePortlet"%>
<%@include file="/jsp/init.jsp"%>
<%
Instance instance = (Instance)request.getAttribute(MyInstancePortlet.ATTR_INSTANCE);
%>
<div id="instance-detail">
	<div id="instance-data">
		<div class="data-field">
			<div class="data-label"><liferay-ui:message key="msc-p000-name"/> </div>
			<div class="data-text"><%=instance.getName()%></div>
		</div>
	</div>
	<div id="instance-images">
	
	</div>		
</div>