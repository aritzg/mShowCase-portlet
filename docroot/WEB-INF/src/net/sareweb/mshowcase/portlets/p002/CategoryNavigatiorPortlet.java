package net.sareweb.mshowcase.portlets.p002;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import net.sareweb.mshowcase.portlets.GenericMSCPortlet;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;

public class CategoryNavigatiorPortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		renderRequest.setAttribute(ATTR_CATEGORIES_0,
				CategoryLocalServiceUtil.findCategoryByParentCategoryId(0));

		super.doView(renderRequest, renderResponse);
	}

	public void selectCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		javax.xml.namespace.QName qName = new QName("http://mshowcase.com",
				"categoryId", "x");
		SessionMessages.clear(actionRequest);
		actionResponse.setEvent(qName,
				ParamUtil.get(actionRequest, PARAM_CATEGORY_ID, "0"));
	}

	public static final String ATTR_CATEGORIES_0 = "categories0";

	public static final String PARAM_CATEGORY_ID = "categoryId";
}
