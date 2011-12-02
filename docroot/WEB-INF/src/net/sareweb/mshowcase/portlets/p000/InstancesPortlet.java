package net.sareweb.mshowcase.portlets.p000;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.mshowcase.Constants;
import net.sareweb.mshowcase.portlets.GenericMSCPortlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;

/**
 * Portlet implementation class InstancesPortlet
 */
public class InstancesPortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (!hasCurrentUserAnInstance()) {
			viewJSP = "/jsp/p000/noInstance.jsp";
		}
		super.doView(renderRequest, renderResponse);
	}

	private boolean hasCurrentUserAnInstance() {
		return false;
	}

	public void createInstance(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		_log.debug("Creating new instance");
		String subdomain = ParamUtil.get(actionRequest, "subdomain", "");
		if (!existsCompany(subdomain)) {
			try {
				addCompany(subdomain);
			} catch (Exception e) {
				SessionErrors.add(actionRequest,
						"validation-instance-already-exists");
				_log.error("Error creating new instance", e);
			}
		} else {
			SessionErrors.add(actionRequest,
					"validation-instance-already-exists");
		}

	}

	private void addCompany(String hostname) throws PortalException,
			SystemException {
		CompanyLocalServiceUtil.addCompany(hostname, hostname + "."
				+ Constants.BASE_HOST_NAME, hostname + "."
				+ Constants.BASE_HOST_NAME, "default", false, 0, true);
	}

	private boolean existsCompany(String hostname) {
		try {
			CompanyLocalServiceUtil.getCompanyByWebId(hostname);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static final String RES_TYPE_PARAM = "resType";
}
