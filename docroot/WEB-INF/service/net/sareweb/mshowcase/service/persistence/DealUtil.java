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

package net.sareweb.mshowcase.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.sareweb.mshowcase.model.Deal;

import java.util.List;

/**
 * The persistence utility for the deal service. This utility wraps {@link DealPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see DealPersistence
 * @see DealPersistenceImpl
 * @generated
 */
public class DealUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Deal deal) {
		getPersistence().clearCache(deal);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Deal> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Deal> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Deal> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Deal remove(Deal deal) throws SystemException {
		return getPersistence().remove(deal);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Deal update(Deal deal, boolean merge)
		throws SystemException {
		return getPersistence().update(deal, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Deal update(Deal deal, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(deal, merge, serviceContext);
	}

	/**
	* Caches the deal in the entity cache if it is enabled.
	*
	* @param deal the deal
	*/
	public static void cacheResult(net.sareweb.mshowcase.model.Deal deal) {
		getPersistence().cacheResult(deal);
	}

	/**
	* Caches the deals in the entity cache if it is enabled.
	*
	* @param deals the deals
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Deal> deals) {
		getPersistence().cacheResult(deals);
	}

	/**
	* Creates a new deal with the primary key. Does not add the deal to the database.
	*
	* @param dealId the primary key for the new deal
	* @return the new deal
	*/
	public static net.sareweb.mshowcase.model.Deal create(long dealId) {
		return getPersistence().create(dealId);
	}

	/**
	* Removes the deal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dealId the primary key of the deal
	* @return the deal that was removed
	* @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal remove(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchDealException {
		return getPersistence().remove(dealId);
	}

	public static net.sareweb.mshowcase.model.Deal updateImpl(
		net.sareweb.mshowcase.model.Deal deal, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(deal, merge);
	}

	/**
	* Returns the deal with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchDealException} if it could not be found.
	*
	* @param dealId the primary key of the deal
	* @return the deal
	* @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal findByPrimaryKey(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchDealException {
		return getPersistence().findByPrimaryKey(dealId);
	}

	/**
	* Returns the deal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dealId the primary key of the deal
	* @return the deal, or <code>null</code> if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Deal fetchByPrimaryKey(
		long dealId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dealId);
	}

	/**
	* Returns all the deals.
	*
	* @return the deals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Deal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<net.sareweb.mshowcase.model.Deal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the deals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of deals
	* @param end the upper bound of the range of deals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of deals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Deal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the deals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of deals.
	*
	* @return the number of deals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DealPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DealPersistence)PortletBeanLocatorUtil.locate(net.sareweb.mshowcase.service.ClpSerializer.getServletContextName(),
					DealPersistence.class.getName());

			ReferenceRegistry.registerReference(DealUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DealPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DealUtil.class, "_persistence");
	}

	private static DealPersistence _persistence;
}