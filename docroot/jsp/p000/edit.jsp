<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="net.sareweb.mshowcase.portlets.p000.MyInstancePortlet"%>

<%@include file="/jsp/init.jsp"%>

<%
Instance instance = (Instance)request.getAttribute(MyInstancePortlet.ATTR_INSTANCE);
List<Category> categories0 = (List<Category>)request.getAttribute(MyInstancePortlet.ATTR_CATEGORIES_0);
List<Category> categories1 = (List<Category>)request.getAttribute(MyInstancePortlet.ATTR_CATEGORIES_1);
%>

<div class="content-box">
	No instance yet!!!
	<liferay-portlet:actionURL name='<%=instance!=null? "updateInstance":"createInstance"  %>' var="actionURL">
		<liferay-portlet:param name="redirect" value="<%=PortletURLUtil.getCurrent(renderRequest, renderResponse).toString()%>"></liferay-portlet:param>
	</liferay-portlet:actionURL>
	<aui:form action="<%=actionURL.toString()%>" method="post" name="fm">
		<aui:input name="<%=MyInstancePortlet.PARAM_INSTANCE_ID%>" type="hidden" value='<%=instance!=null ? instance.getInstanceId() : ""  %>'/>
		
		<div id="instance-data">
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
				<aui:input name="<%=MyInstancePortlet.PARAM_NAME%>" label="msc-p000-name" value='<%=instance!=null ? instance.getName() : ""  %>'/>
				<aui:input name="<%=MyInstancePortlet.PARAM_DESCRIPTION%>" label="msc-p000-description" type="textarea" value='<%=instance!=null ? instance.getDescription() : ""  %>'/>
			</aui:fieldset>
		
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
				<aui:input name="<%=MyInstancePortlet.PARAM_PHONE%>" label="msc-p000-phone" value='<%=instance!=null ? instance.getPhoneNumber() : ""  %>'/>
				<aui:input name="<%=MyInstancePortlet.PARAM_FAX%>" label="msc-p000-fax" value='<%=instance!=null ? instance.getFaxNumber() : ""  %>'/>
				<aui:input name="<%=MyInstancePortlet.PARAM_EMAIL%>" label="msc-p000-email" value='<%=instance!=null ? instance.getEmail() : ""  %>'/>
				<aui:input name="<%=MyInstancePortlet.PARAM_WEB%>" label="msc-p000-web" value='<%=instance!=null ? instance.getWebPage() : ""  %>'/>
			</aui:fieldset>
			
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
				<aui:select name="<%=MyInstancePortlet.PARAM_CAT_0%>" onChange="updateSubCategory(this.value)">
					<aui:option value="0"></aui:option>
					<%for(Category cat0 : categories0){ %>
						<aui:option value="<%=cat0.getCategoryId()%>" selected="<%=cat0.getCategoryId() == instance.getCategoryLevel0() %>"><%=cat0.getName(locale)%></aui:option>
					<%} %>
				</aui:select>
				
				<aui:select name="<%=MyInstancePortlet.PARAM_CAT_1%>" disabled="<%=(instance==null || instance.getCategoryLevel0()==0)? true : false %>">
					<aui:option value=""></aui:option>
					<%
					if(categories1!=null){
						for(Category cat1 : categories1){ %>
							<aui:option value="<%=cat1.getCategoryId()%>" selected="<%=cat1.getCategoryId() == instance.getCategoryLevel1() %>"><%=cat1.getName(locale)%></aui:option>
						<%
						} 
					}
					%>
				</aui:select>
			</aui:fieldset>
		</div>
		
		<div style="clear: both"></div>
		
		<div id="instance-images">
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
			1
			</aui:fieldset>
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
			2
			</aui:fieldset>
			<aui:fieldset column="<%= true %>" cssClass="aui-w33">
			3
			</aui:fieldset>
		</div>
			
		<aui:button-row>
			<aui:button type="submit" value="msc-p000-save"/>
			<liferay-portlet:renderURL var="viewURL">
				<liferay-portlet:param name="<%=MyInstancePortlet.PARAM_RENDER%>" value="<%=MyInstancePortlet.PARAM_RENDER_VIEW%>"></liferay-portlet:param>
			</liferay-portlet:renderURL>
			<aui:button value="msc-p000-back" onClick="<%=viewURL%>"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
function updateSubCategory(parentCategoryId){
        var subCat = document.getElementById('<portlet:namespace/><%=MyInstancePortlet.PARAM_CAT_1%>');
        if(parentCategoryId!=0){
                getSubCategories(parentCategoryId);
                subCat.disabled=false;
        }
        else{
                subCat.disabled=true;
                subCat.options.length = 0;
        }
}

<portlet:resourceURL var="serveRes" >
        <portlet:param name="resType" value="<%=MyInstancePortlet.PARAM_RES_TYPE_SUB_CATEGORIES%>"></portlet:param>
</portlet:resourceURL>
function getSubCategories(parentCategoryId){
        AUI().use('aui-io-request, aui-node', function(A){
                A.io.request('<%=serveRes.toString()%>&<%=portletDisplay.getNamespace() + MyInstancePortlet.PARAM_CATEGORY_ID%>=' + parentCategoryId , {
                        on: {
                                success: function() {
                                var items = this.get('responseData');
                                var data;
                                YUI().use("json", function (Y) {
                                                data = Y.JSON.parse(items);      
                                        });
                                var options = '<option value=""><liferay-ui:message key="msc-p000-choose-subcategory"/></option>';
                        for (var i = 0; i < data.list.length; i++) {
                                options += '<option value="' + data.list[i][0] + '">' + data.list[i][1] + '</option>';
                        }
                        A.one('#<%=portletDisplay.getNamespace() + MyInstancePortlet.PARAM_CAT_1%>').empty ( ).append(options);
                        document.getElementById('#<%=portletDisplay.getNamespace() + MyInstancePortlet.PARAM_CAT_1%>').selectedIndex = 0;
                                }
                        }
                });
        });
}
</aui:script>