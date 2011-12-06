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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.LocationServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.LocationServiceSoap
 * @generated
 */
public class LocationSoap implements Serializable {
	public static LocationSoap toSoapModel(Location model) {
		LocationSoap soapModel = new LocationSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setAddress(model.getAddress());
		soapModel.setLat(model.getLat());
		soapModel.setLng(model.getLng());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setFaxNumber(model.getFaxNumber());
		soapModel.setImageId(model.getImageId());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static LocationSoap[] toSoapModels(Location[] models) {
		LocationSoap[] soapModels = new LocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[][] toSoapModels(Location[][] models) {
		LocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[] toSoapModels(List<Location> models) {
		List<LocationSoap> soapModels = new ArrayList<LocationSoap>(models.size());

		for (Location model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocationSoap[soapModels.size()]);
	}

	public LocationSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public double getLat() {
		return _lat;
	}

	public void setLat(double lat) {
		_lat = lat;
	}

	public double getLng() {
		return _lng;
	}

	public void setLng(double lng) {
		_lng = lng;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _locationId;
	private long _InstanceId;
	private String _address;
	private double _lat;
	private double _lng;
	private String _phoneNumber;
	private String _faxNumber;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private long _companyId;
	private Date _createDate;
}