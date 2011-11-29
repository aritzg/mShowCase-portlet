package net.sareweb.mshowcase.portlets.p000;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InstancesPortlet
 */
public class InstancesPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if(!hasCurrentUserAnInstance()){
			viewJSP ="/jsp/p000/noInstance.jsp";
		}
		super.doView(renderRequest, renderResponse);
	}
	
	private boolean hasCurrentUserAnInstance(){
		return false;
	}
	
	public void createInstance(ActionRequest actionRequest,ActionResponse actionResponse){
		_log.debug("Creating new instance");
		String hostname = ParamUtil.get(actionRequest, "hostname", "");
		if(!existsVirtualHost(hostname)){
			
		}
		else{
			
		}
		
	}
	
	private boolean existsVirtualHost(String hostname){
		try {
			VirtualHostLocalServiceUtil.getVirtualHost(hostname);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(InstancesPortlet.class);
}
