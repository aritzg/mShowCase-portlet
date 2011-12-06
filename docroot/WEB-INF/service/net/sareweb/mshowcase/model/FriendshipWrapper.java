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

package net.sareweb.mshowcase.model;

/**
 * <p>
 * This class is a wrapper for {@link Friendship}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Friendship
 * @generated
 */
public class FriendshipWrapper implements Friendship {
	public FriendshipWrapper(Friendship friendship) {
		_friendship = friendship;
	}

	public Class<?> getModelClass() {
		return Friendship.class;
	}

	public String getModelClassName() {
		return Friendship.class.getName();
	}

	/**
	* Returns the primary key of this friendship.
	*
	* @return the primary key of this friendship
	*/
	public long getPrimaryKey() {
		return _friendship.getPrimaryKey();
	}

	/**
	* Sets the primary key of this friendship.
	*
	* @param primaryKey the primary key of this friendship
	*/
	public void setPrimaryKey(long primaryKey) {
		_friendship.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the friendship ID of this friendship.
	*
	* @return the friendship ID of this friendship
	*/
	public long getFriendshipId() {
		return _friendship.getFriendshipId();
	}

	/**
	* Sets the friendship ID of this friendship.
	*
	* @param friendshipId the friendship ID of this friendship
	*/
	public void setFriendshipId(long friendshipId) {
		_friendship.setFriendshipId(friendshipId);
	}

	/**
	* Returns the user ID of this friendship.
	*
	* @return the user ID of this friendship
	*/
	public long getUserId() {
		return _friendship.getUserId();
	}

	/**
	* Sets the user ID of this friendship.
	*
	* @param userId the user ID of this friendship
	*/
	public void setUserId(long userId) {
		_friendship.setUserId(userId);
	}

	/**
	* Returns the user uuid of this friendship.
	*
	* @return the user uuid of this friendship
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _friendship.getUserUuid();
	}

	/**
	* Sets the user uuid of this friendship.
	*
	* @param userUuid the user uuid of this friendship
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_friendship.setUserUuid(userUuid);
	}

	/**
	* Returns the user2 ID of this friendship.
	*
	* @return the user2 ID of this friendship
	*/
	public long getUser2Id() {
		return _friendship.getUser2Id();
	}

	/**
	* Sets the user2 ID of this friendship.
	*
	* @param user2Id the user2 ID of this friendship
	*/
	public void setUser2Id(long user2Id) {
		_friendship.setUser2Id(user2Id);
	}

	/**
	* Returns the accepted of this friendship.
	*
	* @return the accepted of this friendship
	*/
	public boolean getAccepted() {
		return _friendship.getAccepted();
	}

	/**
	* Returns <code>true</code> if this friendship is accepted.
	*
	* @return <code>true</code> if this friendship is accepted; <code>false</code> otherwise
	*/
	public boolean isAccepted() {
		return _friendship.isAccepted();
	}

	/**
	* Sets whether this friendship is accepted.
	*
	* @param accepted the accepted of this friendship
	*/
	public void setAccepted(boolean accepted) {
		_friendship.setAccepted(accepted);
	}

	/**
	* Returns the rejected of this friendship.
	*
	* @return the rejected of this friendship
	*/
	public boolean getRejected() {
		return _friendship.getRejected();
	}

	/**
	* Returns <code>true</code> if this friendship is rejected.
	*
	* @return <code>true</code> if this friendship is rejected; <code>false</code> otherwise
	*/
	public boolean isRejected() {
		return _friendship.isRejected();
	}

	/**
	* Sets whether this friendship is rejected.
	*
	* @param rejected the rejected of this friendship
	*/
	public void setRejected(boolean rejected) {
		_friendship.setRejected(rejected);
	}

	/**
	* Returns the company ID of this friendship.
	*
	* @return the company ID of this friendship
	*/
	public long getCompanyId() {
		return _friendship.getCompanyId();
	}

	/**
	* Sets the company ID of this friendship.
	*
	* @param companyId the company ID of this friendship
	*/
	public void setCompanyId(long companyId) {
		_friendship.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this friendship.
	*
	* @return the create date of this friendship
	*/
	public java.util.Date getCreateDate() {
		return _friendship.getCreateDate();
	}

	/**
	* Sets the create date of this friendship.
	*
	* @param createDate the create date of this friendship
	*/
	public void setCreateDate(java.util.Date createDate) {
		_friendship.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _friendship.isNew();
	}

	public void setNew(boolean n) {
		_friendship.setNew(n);
	}

	public boolean isCachedModel() {
		return _friendship.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_friendship.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _friendship.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _friendship.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_friendship.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _friendship.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_friendship.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FriendshipWrapper((Friendship)_friendship.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Friendship friendship) {
		return _friendship.compareTo(friendship);
	}

	@Override
	public int hashCode() {
		return _friendship.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Friendship> toCacheModel() {
		return _friendship.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Friendship toEscapedModel() {
		return new FriendshipWrapper(_friendship.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _friendship.toString();
	}

	public java.lang.String toXmlString() {
		return _friendship.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_friendship.persist();
	}

	public Friendship getWrappedFriendship() {
		return _friendship;
	}

	public void resetOriginalValues() {
		_friendship.resetOriginalValues();
	}

	private Friendship _friendship;
}