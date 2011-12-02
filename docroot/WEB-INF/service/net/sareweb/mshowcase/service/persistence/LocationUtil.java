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

import net.sareweb.mshowcase.model.Location;

import java.util.List;

/**
 * The persistence utility for the location service. This utility wraps {@link LocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see LocationPersistence
 * @see LocationPersistenceImpl
 * @generated
 */
public class LocationUtil {
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
	public static void clearCache(Location location) {
		getPersistence().clearCache(location);
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
	public static List<Location> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Location remove(Location location) throws SystemException {
		return getPersistence().remove(location);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Location update(Location location, boolean merge)
		throws SystemException {
		return getPersistence().update(location, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Location update(Location location, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(location, merge, serviceContext);
	}

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public static void cacheResult(
		net.sareweb.mshowcase.model.Location location) {
		getPersistence().cacheResult(location);
	}

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Location> locations) {
		getPersistence().cacheResult(locations);
	}

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public static net.sareweb.mshowcase.model.Location create(long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Location remove(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchLocationException {
		return getPersistence().remove(locationId);
	}

	public static net.sareweb.mshowcase.model.Location updateImpl(
		net.sareweb.mshowcase.model.Location location, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(location, merge);
	}

	/**
	* Returns the location with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchLocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Location findByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchLocationException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Location fetchByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	/**
	* Returns all the locations.
	*
	* @return the locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Location> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @return the range of locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Location> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of locations
	* @param end the upper bound of the range of locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Location> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LocationPersistence)PortletBeanLocatorUtil.locate(net.sareweb.mshowcase.service.ClpSerializer.getServletContextName(),
					LocationPersistence.class.getName());

			ReferenceRegistry.registerReference(LocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LocationPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LocationUtil.class, "_persistence");
	}

	private static LocationPersistence _persistence;
}