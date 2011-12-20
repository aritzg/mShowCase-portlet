/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.sareweb.mshowcase.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the deal local service. This utility wraps {@link net.sareweb.mshowcase.service.impl.DealLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Aritz Galdos
 * @see DealLocalService
 * @see net.sareweb.mshowcase.service.base.DealLocalServiceBaseImpl
 * @see net.sareweb.mshowcase.service.impl.DealLocalServiceImpl
 * @generated
 */
public class DealLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.sareweb.mshowcase.service.impl.DealLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the deal to the database. Also notifies the appropriate model listeners.
	*
	* @param deal the deal
	* @return the deal that was added
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal addDeal(
		net.sareweb.mshowcase.model.Deal deal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDeal(deal);
	}

	/**
	* Creates a new deal with the primary key. Does not add the deal to the database.
	*
	* @param dealId the primary key for the new deal
	* @return the new deal
	*/
	public static net.sareweb.mshowcase.model.Deal createDeal(long dealId) {
		return getService().createDeal(dealId);
	}

	/**
	* Deletes the deal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dealId the primary key of the deal
	* @throws PortalException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDeal(long dealId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDeal(dealId);
	}

	/**
	* Deletes the deal from the database. Also notifies the appropriate model listeners.
	*
	* @param deal the deal
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDeal(net.sareweb.mshowcase.model.Deal deal)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDeal(deal);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static net.sareweb.mshowcase.model.Deal fetchDeal(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDeal(dealId);
	}

	/**
	* Returns the deal with the primary key.
	*
	* @param dealId the primary key of the deal
	* @return the deal
	* @throws PortalException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal getDeal(long dealId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeal(dealId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the deals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of deals
	* @param end the upper bound of the range of deals (not inclusive)
	* @return the range of deals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Deal> getDeals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeals(start, end);
	}

	/**
	* Returns the number of deals.
	*
	* @return the number of deals
	* @throws SystemException if a system exception occurred
	*/
	public static int getDealsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDealsCount();
	}

	/**
	* Updates the deal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param deal the deal
	* @return the deal that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal updateDeal(
		net.sareweb.mshowcase.model.Deal deal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDeal(deal);
	}

	/**
	* Updates the deal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param deal the deal
	* @param merge whether to merge the deal with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the deal that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal updateDeal(
		net.sareweb.mshowcase.model.Deal deal, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDeal(deal, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<net.sareweb.mshowcase.model.Deal> getDealsByInstanceId(
		long instanceId) {
		return getService().getDealsByInstanceId(instanceId);
	}

	public static long countDealsByInstanceId(long instanceId) {
		return getService().countDealsByInstanceId(instanceId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DealLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DealLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DealLocalService.class.getName(), portletClassLoader);

			_service = new DealLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DealLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DealLocalService.class);
		}

		return _service;
	}

	public void setService(DealLocalService service) {
		MethodCache.remove(DealLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DealLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DealLocalService.class);
	}

	private static DealLocalService _service;
}