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

import net.sareweb.mshowcase.model.Instance;

import java.util.List;

/**
 * The persistence utility for the instance service. This utility wraps {@link InstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstancePersistence
 * @see InstancePersistenceImpl
 * @generated
 */
public class InstanceUtil {
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
	public static void clearCache(Instance instance) {
		getPersistence().clearCache(instance);
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
	public static List<Instance> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Instance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Instance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Instance remove(Instance instance) throws SystemException {
		return getPersistence().remove(instance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Instance update(Instance instance, boolean merge)
		throws SystemException {
		return getPersistence().update(instance, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Instance update(Instance instance, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(instance, merge, serviceContext);
	}

	/**
	* Caches the instance in the entity cache if it is enabled.
	*
	* @param instance the instance
	*/
	public static void cacheResult(
		net.sareweb.mshowcase.model.Instance instance) {
		getPersistence().cacheResult(instance);
	}

	/**
	* Caches the instances in the entity cache if it is enabled.
	*
	* @param instances the instances
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Instance> instances) {
		getPersistence().cacheResult(instances);
	}

	/**
	* Creates a new instance with the primary key. Does not add the instance to the database.
	*
	* @param InstanceId the primary key for the new instance
	* @return the new instance
	*/
	public static net.sareweb.mshowcase.model.Instance create(long InstanceId) {
		return getPersistence().create(InstanceId);
	}

	/**
	* Removes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance that was removed
	* @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance remove(long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException {
		return getPersistence().remove(InstanceId);
	}

	public static net.sareweb.mshowcase.model.Instance updateImpl(
		net.sareweb.mshowcase.model.Instance instance, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(instance, merge);
	}

	/**
	* Returns the instance with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceException} if it could not be found.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance
	* @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance findByPrimaryKey(
		long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException {
		return getPersistence().findByPrimaryKey(InstanceId);
	}

	/**
	* Returns the instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance, or <code>null</code> if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance fetchByPrimaryKey(
		long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(InstanceId);
	}

	/**
	* Returns the instance where userId = &#63; or throws a {@link net.sareweb.mshowcase.NoSuchInstanceException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching instance
	* @throws net.sareweb.mshowcase.NoSuchInstanceException if a matching instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the instance where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching instance, or <code>null</code> if a matching instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the instance where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching instance, or <code>null</code> if a matching instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Instance fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Returns all the instances.
	*
	* @return the instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Instance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<net.sareweb.mshowcase.model.Instance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<net.sareweb.mshowcase.model.Instance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the instance where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of instances where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of instances.
	*
	* @return the number of instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InstancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InstancePersistence)PortletBeanLocatorUtil.locate(net.sareweb.mshowcase.service.ClpSerializer.getServletContextName(),
					InstancePersistence.class.getName());

			ReferenceRegistry.registerReference(InstanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(InstancePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(InstanceUtil.class, "_persistence");
	}

	private static InstancePersistence _persistence;
}