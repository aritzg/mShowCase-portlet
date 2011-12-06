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

import net.sareweb.mshowcase.model.Friendship;

/**
 * The persistence interface for the friendship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipPersistenceImpl
 * @see FriendshipUtil
 * @generated
 */
public interface FriendshipPersistence extends BasePersistence<Friendship> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FriendshipUtil} to access the friendship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the friendship in the entity cache if it is enabled.
	*
	* @param friendship the friendship
	*/
	public void cacheResult(net.sareweb.mshowcase.model.Friendship friendship);

	/**
	* Caches the friendships in the entity cache if it is enabled.
	*
	* @param friendships the friendships
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Friendship> friendships);

	/**
	* Creates a new friendship with the primary key. Does not add the friendship to the database.
	*
	* @param friendshipId the primary key for the new friendship
	* @return the new friendship
	*/
	public net.sareweb.mshowcase.model.Friendship create(long friendshipId);

	/**
	* Removes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship that was removed
	* @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship remove(long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchFriendshipException;

	public net.sareweb.mshowcase.model.Friendship updateImpl(
		net.sareweb.mshowcase.model.Friendship friendship, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the friendship with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchFriendshipException} if it could not be found.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship
	* @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship findByPrimaryKey(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchFriendshipException;

	/**
	* Returns the friendship with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship, or <code>null</code> if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship fetchByPrimaryKey(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the friendships.
	*
	* @return the friendships
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Friendship> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.mshowcase.model.Friendship> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.mshowcase.model.Friendship> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the friendships from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of friendships.
	*
	* @return the number of friendships
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Friendship remove(Friendship friendship) throws SystemException;
}