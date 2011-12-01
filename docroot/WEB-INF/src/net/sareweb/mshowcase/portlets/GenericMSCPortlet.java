package net.sareweb.mshowcase.portlets;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class GenericMSCPortlet extends MVCPortlet {

	public GenericMSCPortlet(){
		super();
		_log = LogFactoryUtil.getLog(this.getClass());
	}
	
	protected void setDestinationJsp(String destination){
		viewJSP = destination;
	}
	

	
	protected static Log _log;
	
	public static final String PARAM_RENDER = "render";
	public static final String PARAM_RENDER_VIEW = "render_view";
	public static final String PARAM_RENDER_EDIT = "render_edit";
	public static final String PARAM_RENDER_LIST = "render_list";
	
}
