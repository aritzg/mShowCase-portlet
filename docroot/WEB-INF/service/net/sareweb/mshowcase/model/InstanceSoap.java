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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.InstanceServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.InstanceServiceSoap
 * @generated
 */
public class InstanceSoap implements Serializable {
	public static InstanceSoap toSoapModel(Instance model) {
		InstanceSoap soapModel = new InstanceSoap();

		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setName(model.getName());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setLastModifiedDate(model.getLastModifiedDate());

		return soapModel;
	}

	public static InstanceSoap[] toSoapModels(Instance[] models) {
		InstanceSoap[] soapModels = new InstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstanceSoap[][] toSoapModels(Instance[][] models) {
		InstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstanceSoap[] toSoapModels(List<Instance> models) {
		List<InstanceSoap> soapModels = new ArrayList<InstanceSoap>(models.size());

		for (Instance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstanceSoap[soapModels.size()]);
	}

	public InstanceSoap() {
	}

	public long getPrimaryKey() {
		return _InstanceId;
	}

	public void setPrimaryKey(long pk) {
		setInstanceId(pk);
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	private long _InstanceId;
	private String _name;
	private long _userId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _lastModifiedDate;
}