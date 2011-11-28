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
 * This class is a wrapper for {@link Instance}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Instance
 * @generated
 */
public class InstanceWrapper implements Instance {
	public InstanceWrapper(Instance instance) {
		_instance = instance;
	}

	public Class<?> getModelClass() {
		return Instance.class;
	}

	public String getModelClassName() {
		return Instance.class.getName();
	}

	/**
	* Returns the primary key of this instance.
	*
	* @return the primary key of this instance
	*/
	public long getPrimaryKey() {
		return _instance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this instance.
	*
	* @param primaryKey the primary key of this instance
	*/
	public void setPrimaryKey(long primaryKey) {
		_instance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the instance ID of this instance.
	*
	* @return the instance ID of this instance
	*/
	public long getInstanceId() {
		return _instance.getInstanceId();
	}

	/**
	* Sets the instance ID of this instance.
	*
	* @param InstanceId the instance ID of this instance
	*/
	public void setInstanceId(long InstanceId) {
		_instance.setInstanceId(InstanceId);
	}

	/**
	* Returns the user ID of this instance.
	*
	* @return the user ID of this instance
	*/
	public long getUserId() {
		return _instance.getUserId();
	}

	/**
	* Sets the user ID of this instance.
	*
	* @param userId the user ID of this instance
	*/
	public void setUserId(long userId) {
		_instance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this instance.
	*
	* @return the user uuid of this instance
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instance.getUserUuid();
	}

	/**
	* Sets the user uuid of this instance.
	*
	* @param userUuid the user uuid of this instance
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_instance.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this instance.
	*
	* @return the company ID of this instance
	*/
	public long getCompanyId() {
		return _instance.getCompanyId();
	}

	/**
	* Sets the company ID of this instance.
	*
	* @param companyId the company ID of this instance
	*/
	public void setCompanyId(long companyId) {
		_instance.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this instance.
	*
	* @return the create date of this instance
	*/
	public java.util.Date getCreateDate() {
		return _instance.getCreateDate();
	}

	/**
	* Sets the create date of this instance.
	*
	* @param createDate the create date of this instance
	*/
	public void setCreateDate(java.util.Date createDate) {
		_instance.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _instance.isNew();
	}

	public void setNew(boolean n) {
		_instance.setNew(n);
	}

	public boolean isCachedModel() {
		return _instance.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_instance.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _instance.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _instance.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_instance.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _instance.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_instance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstanceWrapper((Instance)_instance.clone());
	}

	public int compareTo(Instance instance) {
		return _instance.compareTo(instance);
	}

	@Override
	public int hashCode() {
		return _instance.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Instance> toCacheModel() {
		return _instance.toCacheModel();
	}

	public Instance toEscapedModel() {
		return new InstanceWrapper(_instance.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _instance.toString();
	}

	public java.lang.String toXmlString() {
		return _instance.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_instance.persist();
	}

	public Instance getWrappedInstance() {
		return _instance;
	}

	public void resetOriginalValues() {
		_instance.resetOriginalValues();
	}

	private Instance _instance;
}