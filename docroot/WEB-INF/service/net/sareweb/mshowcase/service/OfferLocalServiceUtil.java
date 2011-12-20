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
 * The utility for the offer local service. This utility wraps {@link net.sareweb.mshowcase.service.impl.OfferLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Aritz Galdos
 * @see OfferLocalService
 * @see net.sareweb.mshowcase.service.base.OfferLocalServiceBaseImpl
 * @see net.sareweb.mshowcase.service.impl.OfferLocalServiceImpl
 * @generated
 */
public class OfferLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.sareweb.mshowcase.service.impl.OfferLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the offer to the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer
	* @return the offer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Offer addOffer(
		net.sareweb.mshowcase.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOffer(offer);
	}

	/**
	* Creates a new offer with the primary key. Does not add the offer to the database.
	*
	* @param offerId the primary key for the new offer
	* @return the new offer
	*/
	public static net.sareweb.mshowcase.model.Offer createOffer(long offerId) {
		return getService().createOffer(offerId);
	}

	/**
	* Deletes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param offerId the primary key of the offer
	* @throws PortalException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteOffer(offerId);
	}

	/**
	* Deletes the offer from the database. Also notifies the appropriate model listeners.
	*
	* @param offer the offer
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteOffer(net.sareweb.mshowcase.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteOffer(offer);
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

	public static net.sareweb.mshowcase.model.Offer fetchOffer(long offerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOffer(offerId);
	}

	/**
	* Returns the offer with the primary key.
	*
	* @param offerId the primary key of the offer
	* @return the offer
	* @throws PortalException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Offer getOffer(long offerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOffer(offerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the offers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of offers
	* @param end the upper bound of the range of offers (not inclusive)
	* @return the range of offers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Offer> getOffers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOffers(start, end);
	}

	/**
	* Returns the number of offers.
	*
	* @return the number of offers
	* @throws SystemException if a system exception occurred
	*/
	public static int getOffersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOffersCount();
	}

	/**
	* Updates the offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param offer the offer
	* @return the offer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Offer updateOffer(
		net.sareweb.mshowcase.model.Offer offer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOffer(offer);
	}

	/**
	* Updates the offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param offer the offer
	* @param merge whether to merge the offer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the offer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Offer updateOffer(
		net.sareweb.mshowcase.model.Offer offer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOffer(offer, merge);
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

	public static java.util.List<net.sareweb.mshowcase.model.Offer> getOffersByInstanceId(
		long instanceId) {
		return getService().getOffersByInstanceId(instanceId);
	}

	public static long countOffersByInstanceId(long instanceId) {
		return getService().countOffersByInstanceId(instanceId);
	}

	public static void clearService() {
		_service = null;
	}

	public static OfferLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OfferLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					OfferLocalService.class.getName(), portletClassLoader);

			_service = new OfferLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(OfferLocalServiceUtil.class,
				"_service");
			MethodCache.remove(OfferLocalService.class);
		}

		return _service;
	}

	public void setService(OfferLocalService service) {
		MethodCache.remove(OfferLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(OfferLocalServiceUtil.class,
			"_service");
		MethodCache.remove(OfferLocalService.class);
	}

	private static OfferLocalService _service;
}