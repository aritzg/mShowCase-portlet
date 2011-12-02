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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import net.sareweb.mshowcase.model.Location;

/**
 * The persistence interface for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see LocationPersistenceImpl
 * @see LocationUtil
 * @generated
 */
public interface LocationPersistence extends BasePersistence<Location> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the location in the entity cache if it is enabled.
	*
	* @param location the location
	*/
	public void cacheResult(net.sareweb.mshowcase.model.Location location);

	/**
	* Caches the locations in the entity cache if it is enabled.
	*
	* @param locations the locations
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Location> locations);

	/**
	* Creates a new location with the primary key. Does not add the location to the database.
	*
	* @param locationId the primary key for the new location
	* @return the new location
	*/
	public net.sareweb.mshowcase.model.Location create(long locationId);

	/**
	* Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the location
	* @return the location that was removed
	* @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Location remove(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchLocationException;

	public net.sareweb.mshowcase.model.Location updateImpl(
		net.sareweb.mshowcase.model.Location location, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the location with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchLocationException} if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location
	* @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Location findByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchLocationException;

	/**
	* Returns the location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the location
	* @return the location, or <code>null</code> if a location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Location fetchByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the locations.
	*
	* @return the locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Location> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.mshowcase.model.Location> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.mshowcase.model.Location> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of locations.
	*
	* @return the number of locations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Location remove(Location location) throws SystemException;
}