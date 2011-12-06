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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.InstanceImageServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.InstanceImageServiceSoap
 * @generated
 */
public class InstanceImageSoap implements Serializable {
	public static InstanceImageSoap toSoapModel(InstanceImage model) {
		InstanceImageSoap soapModel = new InstanceImageSoap();

		soapModel.setInstanceImageId(model.getInstanceImageId());
		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setImageId(model.getImageId());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static InstanceImageSoap[] toSoapModels(InstanceImage[] models) {
		InstanceImageSoap[] soapModels = new InstanceImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstanceImageSoap[][] toSoapModels(InstanceImage[][] models) {
		InstanceImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InstanceImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstanceImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstanceImageSoap[] toSoapModels(List<InstanceImage> models) {
		List<InstanceImageSoap> soapModels = new ArrayList<InstanceImageSoap>(models.size());

		for (InstanceImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstanceImageSoap[soapModels.size()]);
	}

	public InstanceImageSoap() {
	}

	public long getPrimaryKey() {
		return _InstanceImageId;
	}

	public void setPrimaryKey(long pk) {
		setInstanceImageId(pk);
	}

	public long getInstanceImageId() {
		return _InstanceImageId;
	}

	public void setInstanceImageId(long InstanceImageId) {
		_InstanceImageId = InstanceImageId;
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
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

	private long _InstanceImageId;
	private long _InstanceId;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private long _companyId;
	private Date _createDate;
}