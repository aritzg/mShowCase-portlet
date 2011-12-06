<%@page import="net.sareweb.mshowcase.portlets.p000.InstancesPortlet"%>

<%@include file="/jsp/init.jsp"%>

<%
Instance instance = (Instance)request.getAttribute(InstancesPortlet.ATTR_INSTANCE);
List<Category> categories0 = (List<Category>)request.getAttribute(InstancesPortlet.ATTR_CATEGORIES_0);
%>

<div class="content-box">
	No instance yet!!!
	<liferay-portlet:actionURL name='<%=instance!=null? "updateInstance":"createInstance"  %>' var="actionURL"/>
	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">
	
		<aui:fieldset>
			<aui:input name="<%=InstancesPortlet.PARAM_NAME%>" label="msc-p000-name" value='<%=instance!=null ? instance.getName() : ""  %>'/>
			<aui:input name="<%=InstancesPortlet.PARAM_DESCRIPTION%>" label="msc-p000-description" type="textarea" value='<%=instance!=null ? instance.getDescription() : ""  %>'/>
		</aui:fieldset>
	
		<aui:fieldset>
			<aui:input name="<%=InstancesPortlet.PARAM_PHONE%>" label="msc-p000-phone" value='<%=instance!=null ? instance.getPhoneNumber() : ""  %>'/>
			<aui:input name="<%=InstancesPortlet.PARAM_FAX%>" label="msc-p000-fax" value='<%=instance!=null ? instance.getFaxNumber() : ""  %>'/>
			<aui:input name="<%=InstancesPortlet.PARAM_EMAIL%>" label="msc-p000-email" value='<%=instance!=null ? instance.getEmail() : ""  %>'/>
			<aui:input name="<%=InstancesPortlet.PARAM_WEB%>" label="msc-p000-web" value='<%=instance!=null ? instance.getWebPage() : ""  %>'/>
		</aui:fieldset>
		
		<aui:fieldset>
			<aui:select name="<%=InstancesPortlet.PARAM_CAT_0%>" onChange="updateSubCategory(this.value)">
				<aui:option value="0"></aui:option>
				<c:forEach items="${categories0}" var="cat0">
					<aui:option value="${cat0.categoryId}">${cat0.name}</aui:option>
				</c:forEach>
			</aui:select>
			
			<aui:select name="<%=InstancesPortlet.PARAM_CAT_1%>" disabled="<%=(instance==null || instance.getCategoryLevel0()==0)? true : false %>">
				<aui:option value=""></aui:option>
				<c:forEach items="${categories1}" var="cat1">
					<aui:option value="${cat1.categoryId}">${cat1.name}</aui:option>
				</c:forEach>
			</aui:select>
			
		</aui:fieldset>
	
		<aui:button-row>
			<aui:button type="submit"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
function updateSubCategory(parentCategoryId){
	alert(parentCategoryId);
	var subCat = document.getElementById('<portlet:namespace/><%=InstancesPortlet.PARAM_CAT_1%>');
	if(parentCategoryId!=0){
		subCat.disabled=false;
	}
	else{
		subCat.disabled=true;
		subCat.options.length = 0;
	}
}
</aui:script>