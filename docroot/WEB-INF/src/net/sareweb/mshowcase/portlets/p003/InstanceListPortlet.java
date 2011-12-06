package net.sareweb.mshowcase.portlets.p003;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InstanceDetailPortlet
 */
public class InstanceListPortlet extends MVCPortlet {

	@Override
	public void doView(javax.portlet.RenderRequest renderRequest,
			javax.portlet.RenderResponse renderResponse)
			throws java.io.IOException, javax.portlet.PortletException {

		String categoryId = ParamUtil.get(renderRequest, PARAM_CATEGORY_ID, "0");
		System.out.println("categoryId: " + categoryId);
		
		super.doView(renderRequest, renderResponse);
	};

	@javax.portlet.ProcessEvent(qname = "{http://mshowcase.com}categoryId")
	public void handleProcessempinfoEvent(javax.portlet.EventRequest request,
			javax.portlet.EventResponse response)
			throws javax.portlet.PortletException, java.io.IOException {
		javax.portlet.Event event = request.getEvent();
		String value = (String) event.getValue();

		response.setRenderParameter("categoryId", value);
	}
	
	public static final String PARAM_CATEGORY_ID = "categoryId";
}
