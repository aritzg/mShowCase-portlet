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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.ActivityServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.ActivityServiceSoap
 * @generated
 */
public class ActivitySoap implements Serializable {
	public static ActivitySoap toSoapModel(Activity model) {
		ActivitySoap soapModel = new ActivitySoap();

		soapModel.setActivityId(model.getActivityId());
		soapModel.setType(model.getType());
		soapModel.setUserId(model.getUserId());
		soapModel.setUser2Id(model.getUser2Id());
		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setOfferId(model.getOfferId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static ActivitySoap[] toSoapModels(Activity[] models) {
		ActivitySoap[] soapModels = new ActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[][] toSoapModels(Activity[][] models) {
		ActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[] toSoapModels(List<Activity> models) {
		List<ActivitySoap> soapModels = new ArrayList<ActivitySoap>(models.size());

		for (Activity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivitySoap[soapModels.size()]);
	}

	public ActivitySoap() {
	}

	public long getPrimaryKey() {
		return _activityId;
	}

	public void setPrimaryKey(long pk) {
		setActivityId(pk);
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getUser2Id() {
		return _user2Id;
	}

	public void setUser2Id(long user2Id) {
		_user2Id = user2Id;
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
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

	private long _activityId;
	private String _type;
	private long _userId;
	private long _user2Id;
	private long _InstanceId;
	private long _offerId;
	private long _companyId;
	private Date _createDate;
}