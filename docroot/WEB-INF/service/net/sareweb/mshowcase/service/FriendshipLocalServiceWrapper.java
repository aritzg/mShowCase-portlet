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

/**
 * <p>
 * This class is a wrapper for {@link FriendshipLocalService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       FriendshipLocalService
 * @generated
 */
public class FriendshipLocalServiceWrapper implements FriendshipLocalService {
	public FriendshipLocalServiceWrapper(
		FriendshipLocalService friendshipLocalService) {
		_friendshipLocalService = friendshipLocalService;
	}

	/**
	* Adds the friendship to the database. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @return the friendship that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship addFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.addFriendship(friendship);
	}

	/**
	* Creates a new friendship with the primary key. Does not add the friendship to the database.
	*
	* @param friendshipId the primary key for the new friendship
	* @return the new friendship
	*/
	public net.sareweb.mshowcase.model.Friendship createFriendship(
		long friendshipId) {
		return _friendshipLocalService.createFriendship(friendshipId);
	}

	/**
	* Deletes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param friendshipId the primary key of the friendship
	* @throws PortalException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFriendship(long friendshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_friendshipLocalService.deleteFriendship(friendshipId);
	}

	/**
	* Deletes the friendship from the database. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		_friendshipLocalService.deleteFriendship(friendship);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the friendship with the primary key.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship
	* @throws PortalException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship getFriendship(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.getFriendship(friendshipId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<net.sareweb.mshowcase.model.Friendship> getFriendships(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.getFriendships(start, end);
	}

	/**
	* Returns the number of friendships.
	*
	* @return the number of friendships
	* @throws SystemException if a system exception occurred
	*/
	public int getFriendshipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.getFriendshipsCount();
	}

	/**
	* Updates the friendship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @return the friendship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship updateFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.updateFriendship(friendship);
	}

	/**
	* Updates the friendship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @param merge whether to merge the friendship with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the friendship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Friendship updateFriendship(
		net.sareweb.mshowcase.model.Friendship friendship, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendshipLocalService.updateFriendship(friendship, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _friendshipLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_friendshipLocalService.setBeanIdentifier(beanIdentifier);
	}

	public FriendshipLocalService getWrappedFriendshipLocalService() {
		return _friendshipLocalService;
	}

	public void setWrappedFriendshipLocalService(
		FriendshipLocalService friendshipLocalService) {
		_friendshipLocalService = friendshipLocalService;
	}

	private FriendshipLocalService _friendshipLocalService;
}