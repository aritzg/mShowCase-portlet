package net.sareweb.mshowcase.portlets.p002;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.mshowcase.portlets.GenericMSCPortlet;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;


public class CategoryNavigatiorPortlet extends GenericMSCPortlet {
 
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		renderRequest.setAttribute(ATTR_CATEGORIES_0, CategoryLocalServiceUtil.findCategoryByParentCategoryId(0));
		
		super.doView(renderRequest, renderResponse);
	}
	
	public static final String ATTR_CATEGORIES_0 = "categories0";
}
