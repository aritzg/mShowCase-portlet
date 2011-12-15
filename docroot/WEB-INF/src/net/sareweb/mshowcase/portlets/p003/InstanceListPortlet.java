package net.sareweb.mshowcase.portlets.p003;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.mshowcase.model.Category;
import net.sareweb.mshowcase.model.Instance;
import net.sareweb.mshowcase.portlets.GenericMSCPortlet;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;
import net.sareweb.mshowcase.service.InstanceLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;

public class InstanceListPortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws java.io.IOException,
			javax.portlet.PortletException {

		prepareCategories(renderRequest, renderResponse);
		getResults(renderRequest);

		super.doView(renderRequest, renderResponse);
	}

	private void prepareCategories(RenderRequest renderRequest,
			RenderResponse renderResponse) {

		long categoryId = ParamUtil
				.getLong(renderRequest, PARAM_CATEGORY_ID, 0);

		if (categoryId != 0) {
			try {
				Category category = CategoryLocalServiceUtil
						.getCategory(categoryId);
				if (category.getParentCategoryId() == 0) {
					renderRequest.setAttribute(ATTR_CATEGORY_0, category);
				} else {
					renderRequest.setAttribute(ATTR_CATEGORY_1, category);
					Category category0 = CategoryLocalServiceUtil
							.getCategory(category.getParentCategoryId());
					renderRequest.setAttribute(ATTR_CATEGORY_0, category0);
				}
			} catch (Exception e) {
				_log.error("Error getting categories", e);
			}
		}
	}

	private void getResults(RenderRequest renderRequest) {
		long categoryId = ParamUtil
				.getLong(renderRequest, PARAM_CATEGORY_ID, 0);
		List<Instance> instances = InstanceLocalServiceUtil.getInstancesInCategory(categoryId);
		renderRequest.setAttribute(ATTR_INSTANCES, instances);
	}

	@javax.portlet.ProcessEvent(qname = "{http://mshowcase.com}categoryId")
	public void handleProcessempinfoEvent(javax.portlet.EventRequest request,
			javax.portlet.EventResponse response)
			throws javax.portlet.PortletException, java.io.IOException {
		javax.portlet.Event event = request.getEvent();
		String value = (String) event.getValue();

		response.setRenderParameter("categoryId", value);
	}

	public static final String PARAM_CATEGORY_ID = "categoryId";

	public static final String ATTR_CATEGORY_0 = "category0";
	public static final String ATTR_CATEGORY_1 = "category1";
	public static final String ATTR_INSTANCES = "instances";

}
