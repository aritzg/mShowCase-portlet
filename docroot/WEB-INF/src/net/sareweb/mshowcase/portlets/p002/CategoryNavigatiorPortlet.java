package net.sareweb.mshowcase.portlets.p002;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import net.sareweb.mshowcase.model.Category;
import net.sareweb.mshowcase.portlets.GenericMSCPortlet;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;

public class CategoryNavigatiorPortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		renderRequest.setAttribute(ATTR_CATEGORIES_0,
				CategoryLocalServiceUtil.findCategoryByParentCategoryId(0));
		getSubCategories(renderRequest);
		setCurrentAndParentCategory(renderRequest);

		super.doView(renderRequest, renderResponse);
	}

	private void setCurrentAndParentCategory(RenderRequest renderRequest) {
		String catId = ParamUtil.get(renderRequest, PARAM_CATEGORY_ID, "0");
		long categoryId = Long.parseLong(catId);
		if (categoryId != 0) {
			try {
				Category cat = CategoryLocalServiceUtil.getCategory(categoryId);
				if (cat.getParentCategoryId() == 0) {
					renderRequest.setAttribute(ATTR_PARENT_CATEGORY_ID, catId);
					renderRequest.setAttribute(ATTR_CATEGORY_ID, "0");
				} else {
					renderRequest.setAttribute(ATTR_PARENT_CATEGORY_ID,
							String.valueOf(cat.getParentCategoryId()));
					renderRequest.setAttribute(ATTR_CATEGORY_ID, catId);
				}
			} catch (Exception e) {
				_log.error("Error getting category", e);
			}
			renderRequest.setAttribute(ATTR_CATEGORY_ID, catId);
		} else {
			renderRequest.setAttribute(ATTR_PARENT_CATEGORY_ID, "0");
			renderRequest.setAttribute(ATTR_CATEGORY_ID, "0");
		}
	}

	private void getSubCategories(RenderRequest renderRequest) {
		String catId = ParamUtil.get(renderRequest, PARAM_CATEGORY_ID, "0");
		long categoryId = Long.parseLong(catId);
		if (categoryId != 0) {
			try {
				Category cat = CategoryLocalServiceUtil.getCategory(categoryId);
				if (cat.getParentCategoryId() != 0) {
					categoryId = cat.getParentCategoryId();
				}
				renderRequest.setAttribute(ATTR_CATEGORIES_1,
						CategoryLocalServiceUtil
								.findCategoryByParentCategoryId(categoryId));

			} catch (Exception e) {
				_log.error("Error getting category", e);
			}
		}
	}

	public void selectCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		javax.xml.namespace.QName qName = new QName("http://mshowcase.com",
				"categoryId", "x");
		actionResponse.setEvent(qName,
				ParamUtil.get(actionRequest, PARAM_CATEGORY_ID, "0"));
	}

	@javax.portlet.ProcessEvent(qname = "{http://mshowcase.com}categoryId")
	public void handleProcessempinfoEvent(javax.portlet.EventRequest request,
			javax.portlet.EventResponse response)
			throws javax.portlet.PortletException, java.io.IOException {
		javax.portlet.Event event = request.getEvent();
		String value = (String) event.getValue();

		response.setRenderParameter(PARAM_CATEGORY_ID, value);
	}

	public static final String ATTR_PARENT_CATEGORY_ID = "parentCategoryId";
	public static final String ATTR_CATEGORY_ID = "categoryId";
	public static final String ATTR_CATEGORIES_0 = "categories0";
	public static final String ATTR_CATEGORIES_1 = "categories1";

	public static final String PARAM_CATEGORY_ID = "categoryId";
}
