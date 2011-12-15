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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link InstanceImage}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       InstanceImage
 * @generated
 */
public class InstanceImageWrapper implements InstanceImage,
	ModelWrapper<InstanceImage> {
	public InstanceImageWrapper(InstanceImage instanceImage) {
		_instanceImage = instanceImage;
	}

	public Class<?> getModelClass() {
		return InstanceImage.class;
	}

	public String getModelClassName() {
		return InstanceImage.class.getName();
	}

	/**
	* Returns the primary key of this instance image.
	*
	* @return the primary key of this instance image
	*/
	public long getPrimaryKey() {
		return _instanceImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this instance image.
	*
	* @param primaryKey the primary key of this instance image
	*/
	public void setPrimaryKey(long primaryKey) {
		_instanceImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the instance image ID of this instance image.
	*
	* @return the instance image ID of this instance image
	*/
	public long getInstanceImageId() {
		return _instanceImage.getInstanceImageId();
	}

	/**
	* Sets the instance image ID of this instance image.
	*
	* @param InstanceImageId the instance image ID of this instance image
	*/
	public void setInstanceImageId(long InstanceImageId) {
		_instanceImage.setInstanceImageId(InstanceImageId);
	}

	/**
	* Returns the instance ID of this instance image.
	*
	* @return the instance ID of this instance image
	*/
	public long getInstanceId() {
		return _instanceImage.getInstanceId();
	}

	/**
	* Sets the instance ID of this instance image.
	*
	* @param InstanceId the instance ID of this instance image
	*/
	public void setInstanceId(long InstanceId) {
		_instanceImage.setInstanceId(InstanceId);
	}

	/**
	* Returns the image ID of this instance image.
	*
	* @return the image ID of this instance image
	*/
	public long getImageId() {
		return _instanceImage.getImageId();
	}

	/**
	* Sets the image ID of this instance image.
	*
	* @param imageId the image ID of this instance image
	*/
	public void setImageId(long imageId) {
		_instanceImage.setImageId(imageId);
	}

	/**
	* Returns the image u r l of this instance image.
	*
	* @return the image u r l of this instance image
	*/
	public java.lang.String getImageURL() {
		return _instanceImage.getImageURL();
	}

	/**
	* Sets the image u r l of this instance image.
	*
	* @param imageURL the image u r l of this instance image
	*/
	public void setImageURL(java.lang.String imageURL) {
		_instanceImage.setImageURL(imageURL);
	}

	/**
	* Returns the user ID of this instance image.
	*
	* @return the user ID of this instance image
	*/
	public long getUserId() {
		return _instanceImage.getUserId();
	}

	/**
	* Sets the user ID of this instance image.
	*
	* @param userId the user ID of this instance image
	*/
	public void setUserId(long userId) {
		_instanceImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this instance image.
	*
	* @return the user uuid of this instance image
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this instance image.
	*
	* @param userUuid the user uuid of this instance image
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_instanceImage.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this instance image.
	*
	* @return the company ID of this instance image
	*/
	public long getCompanyId() {
		return _instanceImage.getCompanyId();
	}

	/**
	* Sets the company ID of this instance image.
	*
	* @param companyId the company ID of this instance image
	*/
	public void setCompanyId(long companyId) {
		_instanceImage.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this instance image.
	*
	* @return the create date of this instance image
	*/
	public java.util.Date getCreateDate() {
		return _instanceImage.getCreateDate();
	}

	/**
	* Sets the create date of this instance image.
	*
	* @param createDate the create date of this instance image
	*/
	public void setCreateDate(java.util.Date createDate) {
		_instanceImage.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _instanceImage.isNew();
	}

	public void setNew(boolean n) {
		_instanceImage.setNew(n);
	}

	public boolean isCachedModel() {
		return _instanceImage.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_instanceImage.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _instanceImage.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _instanceImage.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_instanceImage.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _instanceImage.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_instanceImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstanceImageWrapper((InstanceImage)_instanceImage.clone());
	}

	public int compareTo(
		net.sareweb.mshowcase.model.InstanceImage instanceImage) {
		return _instanceImage.compareTo(instanceImage);
	}

	@Override
	public int hashCode() {
		return _instanceImage.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.InstanceImage> toCacheModel() {
		return _instanceImage.toCacheModel();
	}

	public net.sareweb.mshowcase.model.InstanceImage toEscapedModel() {
		return new InstanceImageWrapper(_instanceImage.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _instanceImage.toString();
	}

	public java.lang.String toXmlString() {
		return _instanceImage.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_instanceImage.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public InstanceImage getWrappedInstanceImage() {
		return _instanceImage;
	}

	public InstanceImage getWrappedModel() {
		return _instanceImage;
	}

	public void resetOriginalValues() {
		_instanceImage.resetOriginalValues();
	}

	private InstanceImage _instanceImage;
}