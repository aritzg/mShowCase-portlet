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
 * This class is a wrapper for {@link Activity}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Activity
 * @generated
 */
public class ActivityWrapper implements Activity {
	public ActivityWrapper(Activity activity) {
		_activity = activity;
	}

	public Class<?> getModelClass() {
		return Activity.class;
	}

	public String getModelClassName() {
		return Activity.class.getName();
	}

	/**
	* Returns the primary key of this activity.
	*
	* @return the primary key of this activity
	*/
	public long getPrimaryKey() {
		return _activity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this activity.
	*
	* @param primaryKey the primary key of this activity
	*/
	public void setPrimaryKey(long primaryKey) {
		_activity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the activity ID of this activity.
	*
	* @return the activity ID of this activity
	*/
	public long getActivityId() {
		return _activity.getActivityId();
	}

	/**
	* Sets the activity ID of this activity.
	*
	* @param activityId the activity ID of this activity
	*/
	public void setActivityId(long activityId) {
		_activity.setActivityId(activityId);
	}

	/**
	* Returns the type of this activity.
	*
	* @return the type of this activity
	*/
	public java.lang.String getType() {
		return _activity.getType();
	}

	/**
	* Sets the type of this activity.
	*
	* @param type the type of this activity
	*/
	public void setType(java.lang.String type) {
		_activity.setType(type);
	}

	/**
	* Returns the user ID of this activity.
	*
	* @return the user ID of this activity
	*/
	public long getUserId() {
		return _activity.getUserId();
	}

	/**
	* Sets the user ID of this activity.
	*
	* @param userId the user ID of this activity
	*/
	public void setUserId(long userId) {
		_activity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this activity.
	*
	* @return the user uuid of this activity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activity.getUserUuid();
	}

	/**
	* Sets the user uuid of this activity.
	*
	* @param userUuid the user uuid of this activity
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_activity.setUserUuid(userUuid);
	}

	/**
	* Returns the user2 ID of this activity.
	*
	* @return the user2 ID of this activity
	*/
	public long getUser2Id() {
		return _activity.getUser2Id();
	}

	/**
	* Sets the user2 ID of this activity.
	*
	* @param user2Id the user2 ID of this activity
	*/
	public void setUser2Id(long user2Id) {
		_activity.setUser2Id(user2Id);
	}

	/**
	* Returns the instance ID of this activity.
	*
	* @return the instance ID of this activity
	*/
	public long getInstanceId() {
		return _activity.getInstanceId();
	}

	/**
	* Sets the instance ID of this activity.
	*
	* @param InstanceId the instance ID of this activity
	*/
	public void setInstanceId(long InstanceId) {
		_activity.setInstanceId(InstanceId);
	}

	/**
	* Returns the offer ID of this activity.
	*
	* @return the offer ID of this activity
	*/
	public long getOfferId() {
		return _activity.getOfferId();
	}

	/**
	* Sets the offer ID of this activity.
	*
	* @param offerId the offer ID of this activity
	*/
	public void setOfferId(long offerId) {
		_activity.setOfferId(offerId);
	}

	/**
	* Returns the company ID of this activity.
	*
	* @return the company ID of this activity
	*/
	public long getCompanyId() {
		return _activity.getCompanyId();
	}

	/**
	* Sets the company ID of this activity.
	*
	* @param companyId the company ID of this activity
	*/
	public void setCompanyId(long companyId) {
		_activity.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this activity.
	*
	* @return the create date of this activity
	*/
	public java.util.Date getCreateDate() {
		return _activity.getCreateDate();
	}

	/**
	* Sets the create date of this activity.
	*
	* @param createDate the create date of this activity
	*/
	public void setCreateDate(java.util.Date createDate) {
		_activity.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _activity.isNew();
	}

	public void setNew(boolean n) {
		_activity.setNew(n);
	}

	public boolean isCachedModel() {
		return _activity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_activity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _activity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _activity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_activity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _activity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_activity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ActivityWrapper((Activity)_activity.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Activity activity) {
		return _activity.compareTo(activity);
	}

	@Override
	public int hashCode() {
		return _activity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Activity> toCacheModel() {
		return _activity.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Activity toEscapedModel() {
		return new ActivityWrapper(_activity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _activity.toString();
	}

	public java.lang.String toXmlString() {
		return _activity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_activity.persist();
	}

	public Activity getWrappedActivity() {
		return _activity;
	}

	public void resetOriginalValues() {
		_activity.resetOriginalValues();
	}

	private Activity _activity;
}