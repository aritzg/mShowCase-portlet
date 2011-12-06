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

import net.sareweb.mshowcase.model.Friendship;

import java.util.List;

/**
 * The persistence utility for the friendship service. This utility wraps {@link FriendshipPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipPersistence
 * @see FriendshipPersistenceImpl
 * @generated
 */
public class FriendshipUtil {
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
	public static void clearCache(Friendship friendship) {
		getPersistence().clearCache(friendship);
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
	public static List<Friendship> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Friendship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Friendship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Friendship remove(Friendship friendship)
		throws SystemException {
		return getPersistence().remove(friendship);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Friendship update(Friendship friendship, boolean merge)
		throws SystemException {
		return getPersistence().update(friendship, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Friendship update(Friendship friendship, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(friendship, merge, serviceContext);
	}

	/**
	* Caches the friendship in the entity cache if it is enabled.
	*
	* @param friendship the friendship
	*/
	public static void cacheResult(
		net.sareweb.mshowcase.model.Friendship friendship) {
		getPersistence().cacheResult(friendship);
	}

	/**
	* Caches the friendships in the entity cache if it is enabled.
	*
	* @param friendships the friendships
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Friendship> friendships) {
		getPersistence().cacheResult(friendships);
	}

	/**
	* Creates a new friendship with the primary key. Does not add the friendship to the database.
	*
	* @param friendshipId the primary key for the new friendship
	* @return the new friendship
	*/
	public static net.sareweb.mshowcase.model.Friendship create(
		long friendshipId) {
		return getPersistence().create(friendshipId);
	}

	/**
	* Removes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship that was removed
	* @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship remove(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchFriendshipException {
		return getPersistence().remove(friendshipId);
	}

	public static net.sareweb.mshowcase.model.Friendship updateImpl(
		net.sareweb.mshowcase.model.Friendship friendship, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(friendship, merge);
	}

	/**
	* Returns the friendship with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchFriendshipException} if it could not be found.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship
	* @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship findByPrimaryKey(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchFriendshipException {
		return getPersistence().findByPrimaryKey(friendshipId);
	}

	/**
	* Returns the friendship with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship, or <code>null</code> if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship fetchByPrimaryKey(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(friendshipId);
	}

	/**
	* Returns all the friendships.
	*
	* @return the friendships
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Friendship> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the friendships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of friendships
	* @param end the upper bound of the range of friendships (not inclusive)
	* @return the range of friendships
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Friendship> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the friendships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of friendships
	* @param end the upper bound of the range of friendships (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of friendships
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.Friendship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the friendships from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of friendships.
	*
	* @return the number of friendships
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FriendshipPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FriendshipPersistence)PortletBeanLocatorUtil.locate(net.sareweb.mshowcase.service.ClpSerializer.getServletContextName(),
					FriendshipPersistence.class.getName());

			ReferenceRegistry.registerReference(FriendshipUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(FriendshipPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(FriendshipUtil.class, "_persistence");
	}

	private static FriendshipPersistence _persistence;
}