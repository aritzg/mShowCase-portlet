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

import net.sareweb.mshowcase.model.Instance;

/**
 * The persistence interface for the instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstancePersistenceImpl
 * @see InstanceUtil
 * @generated
 */
public interface InstancePersistence extends BasePersistence<Instance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstanceUtil} to access the instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the instance in the entity cache if it is enabled.
	*
	* @param instance the instance
	*/
	public void cacheResult(net.sareweb.mshowcase.model.Instance instance);

	/**
	* Caches the instances in the entity cache if it is enabled.
	*
	* @param instances the instances
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Instance> instances);

	/**
	* Creates a new instance with the primary key. Does not add the instance to the database.
	*
	* @param InstanceId the primary key for the new instance
	* @return the new instance
	*/
	public net.sareweb.mshowcase.model.Instance create(long InstanceId);

	/**
	* Removes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance that was removed
	* @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance remove(long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException;

	public net.sareweb.mshowcase.model.Instance updateImpl(
		net.sareweb.mshowcase.model.Instance instance, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the instance with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceException} if it could not be found.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance
	* @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance findByPrimaryKey(
		long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException;

	/**
	* Returns the instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance, or <code>null</code> if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance fetchByPrimaryKey(
		long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the instances.
	*
	* @return the instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Instance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instances
	* @param end the upper bound of the range of instances (not inclusive)
	* @return the range of instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Instance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instances
	* @param end the upper bound of the range of instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Instance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of instances.
	*
	* @return the number of instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Instance remove(Instance instance) throws SystemException;
}