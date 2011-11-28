package net.sareweb.mshowcase.portlets.p000;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
 

}
