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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Location
 * @generated
 */
public class LocationWrapper implements Location, ModelWrapper<Location> {
	public LocationWrapper(Location location) {
		_location = location;
	}

	public Class<?> getModelClass() {
		return Location.class;
	}

	public String getModelClassName() {
		return Location.class.getName();
	}

	/**
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this location.
	*
	* @return the location ID of this location
	*/
	public long getLocationId() {
		return _location.getLocationId();
	}

	/**
	* Sets the location ID of this location.
	*
	* @param locationId the location ID of this location
	*/
	public void setLocationId(long locationId) {
		_location.setLocationId(locationId);
	}

	/**
	* Returns the address of this location.
	*
	* @return the address of this location
	*/
	public java.lang.String getAddress() {
		return _location.getAddress();
	}

	/**
	* Sets the address of this location.
	*
	* @param address the address of this location
	*/
	public void setAddress(java.lang.String address) {
		_location.setAddress(address);
	}

	/**
	* Returns the lat of this location.
	*
	* @return the lat of this location
	*/
	public float getLat() {
		return _location.getLat();
	}

	/**
	* Sets the lat of this location.
	*
	* @param lat the lat of this location
	*/
	public void setLat(float lat) {
		_location.setLat(lat);
	}

	/**
	* Returns the lng of this location.
	*
	* @return the lng of this location
	*/
	public float getLng() {
		return _location.getLng();
	}

	/**
	* Sets the lng of this location.
	*
	* @param lng the lng of this location
	*/
	public void setLng(float lng) {
		_location.setLng(lng);
	}

	/**
	* Returns the image ID of this location.
	*
	* @return the image ID of this location
	*/
	public long getImageId() {
		return _location.getImageId();
	}

	/**
	* Sets the image ID of this location.
	*
	* @param imageId the image ID of this location
	*/
	public void setImageId(long imageId) {
		_location.setImageId(imageId);
	}

	/**
	* Returns the image u r l of this location.
	*
	* @return the image u r l of this location
	*/
	public java.lang.String getImageURL() {
		return _location.getImageURL();
	}

	/**
	* Sets the image u r l of this location.
	*
	* @param imageURL the image u r l of this location
	*/
	public void setImageURL(java.lang.String imageURL) {
		_location.setImageURL(imageURL);
	}

	/**
	* Returns the user ID of this location.
	*
	* @return the user ID of this location
	*/
	public long getUserId() {
		return _location.getUserId();
	}

	/**
	* Sets the user ID of this location.
	*
	* @param userId the user ID of this location
	*/
	public void setUserId(long userId) {
		_location.setUserId(userId);
	}

	/**
	* Returns the user uuid of this location.
	*
	* @return the user uuid of this location
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _location.getUserUuid();
	}

	/**
	* Sets the user uuid of this location.
	*
	* @param userUuid the user uuid of this location
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_location.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this location.
	*
	* @return the company ID of this location
	*/
	public long getCompanyId() {
		return _location.getCompanyId();
	}

	/**
	* Sets the company ID of this location.
	*
	* @param companyId the company ID of this location
	*/
	public void setCompanyId(long companyId) {
		_location.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this location.
	*
	* @return the group ID of this location
	*/
	public long getGroupId() {
		return _location.getGroupId();
	}

	/**
	* Sets the group ID of this location.
	*
	* @param groupId the group ID of this location
	*/
	public void setGroupId(long groupId) {
		_location.setGroupId(groupId);
	}

	/**
	* Returns the create date of this location.
	*
	* @return the create date of this location
	*/
	public java.util.Date getCreateDate() {
		return _location.getCreateDate();
	}

	/**
	* Sets the create date of this location.
	*
	* @param createDate the create date of this location
	*/
	public void setCreateDate(java.util.Date createDate) {
		_location.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _location.isNew();
	}

	public void setNew(boolean n) {
		_location.setNew(n);
	}

	public boolean isCachedModel() {
		return _location.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationWrapper((Location)_location.clone());
	}

	public int compareTo(Location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Location> toCacheModel() {
		return _location.toCacheModel();
	}

	public Location toEscapedModel() {
		return new LocationWrapper(_location.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_location.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Location getWrappedLocation() {
		return _location;
	}

	public Location getWrappedModel() {
		return _location;
	}

	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private Location _location;
}