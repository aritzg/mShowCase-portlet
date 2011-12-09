package net.sareweb.mshowcase.portlets.p000;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


import net.sareweb.mshowcase.model.Category;
import net.sareweb.mshowcase.model.Instance;
import net.sareweb.mshowcase.portlets.GenericMSCPortlet;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;
import net.sareweb.mshowcase.service.InstanceLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class InstancesPortlet
 */
public class MyInstancePortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String param_render = ParamUtil.get(renderRequest, PARAM_RENDER, "");
		if (!getThemeDisplay(renderRequest).isSignedIn()) {
			SessionErrors.add(renderRequest, "msc-error-user-not-signed-in");
			viewJSP = PATH_ERROR;
		} else if (!hasCurrentUserAnInstance(getThemeDisplay(renderRequest))
				|| PARAM_RENDER_EDIT.equals(param_render)) {
			try {
				prepareDataForEditPage(renderRequest);
				viewJSP = PATH_EDIT;
			} catch (Exception e) {
				_log.error("Error peparing data for edit page", e);
				SessionErrors.add(renderRequest,
						"msc-error-geting-instance-data");
				viewJSP = PATH_ERROR;
			}
		} else {
			viewJSP = PATH_VIEW;
		}

		super.doView(renderRequest, renderResponse);
	}

	public void createInstance(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		_log.debug("Creating new instance");
		if (hasCurrentUserAnInstance(getThemeDisplay(actionRequest))) {
			SessionErrors.add(actionRequest,
					"msc-error-user-already-has-instance");
			_log.error("Alert!! User with instance tried to create a new one.");
		} else {
			try {
				Instance instance = InstanceLocalServiceUtil
						.createInstance(CounterLocalServiceUtil.increment());
				updateFullInstanceFromRequest(instance, actionRequest);
				InstanceLocalServiceUtil.updateInstance(instance);
			} catch (SystemException e) {
				_log.error("Error creating instance.", e);
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String resType = ParamUtil.get(resourceRequest, PARAM_RES_TYPE, "");
		if(resType.equals(PARAM_RES_TYPE_SUB_CATEGORIES)){
			getSubCategories(resourceRequest, resourceResponse);
		}
	}
	
	private void getSubCategories(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException{
		long categoryId = ParamUtil.getLong(resourceRequest, PARAM_CATEGORY_ID, 0);
		List<Category> subCategories = CategoryLocalServiceUtil.findCategoryByParentCategoryId(categoryId);
		System.out.println("id" + categoryId);
		List subCategoryDescriptions= new Vector();
		for (Category cat: subCategories) {
			System.out.println("bbb");
			String[] element = {String.valueOf(cat.getCategoryId()), cat.getName(resourceRequest.getLocale())};
			subCategoryDescriptions.add(element);
		}
		resourceResponse.getWriter().write(JSONFactoryUtil.serialize(subCategories));	
	}

	private void prepareDataForEditPage(RenderRequest renderRequest)
			throws PortalException, SystemException {
		long instanceId = ParamUtil.get(renderRequest, PARAM_INSTANCE_ID, 0);
		Instance instance = null;
		if (instanceId != 0) {
			instance = InstanceLocalServiceUtil.getInstance(instanceId);
			renderRequest.setAttribute(ATTR_INSTANCE, instance);
		}
		renderRequest.setAttribute(ATTR_CATEGORIES_0,
				CategoryLocalServiceUtil.findCategoryByParentCategoryId(0));
		if (instance != null && instance.getCategoryLevel0() != 0) {
			renderRequest.setAttribute(ATTR_CATEGORIES_1,
					CategoryLocalServiceUtil
							.findCategoryByParentCategoryId(instance
									.getCategoryLevel0()));
			if (instance != null && instance.getCategoryLevel1() != 0) {
				renderRequest.setAttribute(ATTR_CATEGORIES_2,
						CategoryLocalServiceUtil
								.findCategoryByParentCategoryId(instance
										.getCategoryLevel1()));
			}
		}
	}

	private boolean hasCurrentUserAnInstance(ThemeDisplay themeDisplay) {
		if (InstanceLocalServiceUtil.getInstanceByUserId(themeDisplay
				.getUserId()) == null)
			return false;
		else
			return true;
	}

	private void updateFullInstanceFromRequest(Instance instance,
			PortletRequest request) {
		long cat0 = ParamUtil.getLong(request, PARAM_CAT_0, 0);
		instance.setCategoryLevel0(cat0);

		long cat1 = ParamUtil.getLong(request, PARAM_CAT_1, 0);
		instance.setCategoryLevel1(cat1);

		long cat2 = ParamUtil.getLong(request, PARAM_CAT_2, 0);
		instance.setCategoryLevel2(cat2);

		instance.setCompanyId(getThemeDisplay(request).getCompanyId());

		if (instance.getCreateDate() == null)
			instance.setCreateDate(new Date());

		instance.setDescription(ParamUtil.get(request, PARAM_DESCRIPTION, ""));

		instance.setEmail(ParamUtil.get(request, PARAM_EMAIL, ""));

		instance.setFaxNumber(ParamUtil.get(request, PARAM_FAX, ""));

		instance.setGroupId(0);

		instance.setName(ParamUtil.get(request, PARAM_NAME, ""));

		instance.setPhoneNumber(ParamUtil.get(request, PARAM_PHONE, ""));

		instance.setUserId(getThemeDisplay(request).getUserId());

		instance.setWebPage(ParamUtil.get(request, PARAM_WEB, ""));
	}

	public static final String PARAM_RES_TYPE = "resType";
	public static final String PARAM_RES_TYPE_SUB_CATEGORIES = "subCategories";
	public static final String PARAM_CATEGORY_ID = "categoryId";

	public static final String PARAM_INSTANCE_ID = "instanceId";
	public static final String PARAM_CAT_0 = "category0";
	public static final String PARAM_CAT_1 = "category1";
	public static final String PARAM_CAT_2 = "category2";
	public static final String PARAM_DESCRIPTION = "desription";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_FAX = "fax";
	public static final String PARAM_NAME = "name";
	public static final String PARAM_PHONE = "phone";
	public static final String PARAM_WEB = "web";

	public static final String ATTR_INSTANCE = "instance";
	public static final String ATTR_CATEGORIES_0 = "categories0";
	public static final String ATTR_CATEGORIES_1 = "categories1";
	public static final String ATTR_CATEGORIES_2 = "categories2";

	public static final String PATH_VIEW = "/jsp/p000/view.jsp";
	public static final String PATH_EDIT = "/jsp/p000/edit.jsp";
	public static final String PATH_ERROR = "/jsp/error.jsp";

}
