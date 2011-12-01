package net.sareweb.mshowcase.portlets.p001;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.sareweb.mshowcase.portlets.GenericMSCPortlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;

public class InstanceAdminPortlet extends GenericMSCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String render = ParamUtil.get(renderRequest, PARAM_RENDER, PARAM_RENDER_LIST);
		
		if(PARAM_RENDER_LIST.equals(render)){
			doListCompany(renderRequest, renderResponse);
		}
		else if(PARAM_RENDER_VIEW.equals(render)){
			doViewCompany(renderRequest, renderResponse);
		}
		else if(PARAM_RENDER_EDIT.equals(render)){
			doEditCompany(renderRequest, renderResponse);
		}

		super.doView(renderRequest, renderResponse);
	}
	
	private void doListCompany(RenderRequest renderRequest,RenderResponse renderResponse){
		try {
			getCompanies(renderRequest);
			setDestinationJsp(PATH_LIST);
		} catch (SystemException e) {
			_log.error("Error obtaining company", e);
			setDestinationJsp(PATH_ERROR);
		}
	}
	
	private void doViewCompany(RenderRequest renderRequest,RenderResponse renderResponse){
		
		String companyId = ParamUtil.get(renderRequest, PARAM_COMPANY_ID, "");
		
		try {
			getCompany(companyId);
			setDestinationJsp(PATH_VIEW);
		} catch (Exception e) {
			_log.error("Error obtaining company", e);
			setDestinationJsp(PATH_ERROR);
		}
	}
	
	private void doEditCompany(RenderRequest renderRequest,RenderResponse renderResponse){
		doViewCompany(renderRequest, renderResponse);
	}

	private void getCompany(String companyId) throws NumberFormatException,
			PortalException, SystemException {
		CompanyLocalServiceUtil.getCompanyById(Long.parseLong(companyId));
	}

	private void getCompanies(RenderRequest renderRequest) throws SystemException {
			renderRequest.setAttribute(ATTR_COMPANIES,CompanyLocalServiceUtil.getCompanies());
	}
	


	public static final String PARAM_COMPANY_ID = "companyId";

	public static final String ATTR_COMPANIES = "companies";
	
	public static final String PATH_LIST = "/jsp/p001/view.jsp";
	public static final String PATH_VIEW = "/jsp/p001/view_company.jsp";
	public static final String PATH_EDIT = "/jsp/p001/edit_company.jsp";
	public static final String PATH_ERROR = "/jsp/error.jsp";
}
