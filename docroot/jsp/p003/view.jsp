<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="net.sareweb.mshowcase.service.DealLocalServiceUtil"%>
<%@page import="net.sareweb.mshowcase.portlets.p003.InstanceListPortlet"%>
<%@include file="/jsp/init.jsp"%>

<%
Category category0 = (Category) request.getAttribute(InstanceListPortlet.ATTR_CATEGORY_0);
Category category1 = (Category) request.getAttribute(InstanceListPortlet.ATTR_CATEGORY_1);
List<Instance> instances = (List<Instance>) request.getAttribute(InstanceListPortlet.ATTR_INSTANCES);
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

<div class="msc-container">
	<%if(instances==null || instances.size()==0){ %>
	
	<%}else{%>
		<%for(Instance instance: instances){ %>
			<div class="msc-instance-summary">
				<div class="msc-instance-head">
					<div class="msc-instance-title">
						<%=instance.getName()%>
					</div>
					<div class="msc-instance-offers">
						<%=OfferLocalServiceUtil.countOffersByInstanceId(instance.getInstanceId()) %>
					</div>
					<div class="msc-instance-deals">
						<%=DealLocalServiceUtil.countDealsByInstanceId(instance.getInstanceId()) %>
					</div>
				</div>
				<div class="msc-instance-body">
					<div class="msc-instance-body">
						<div class="msc-instance-logo">
							<%if(instance.getLogoImageId()!=0){ %>
								<img src='<%=request.getContextPath()%>/images/defaultLogo.png'/>	
							<%}else{%>
								<img src='<%=instance.getLogoImageURL()%>'/>	
							<%} %>
						</div>
						<div class="msc-instance-data">
						
						</div>
						<div class="msc-instance-minimap">
						
						</div>
					</div>
				</div>
			</div>
			
		<%}%>
	<%}%>
</div>
