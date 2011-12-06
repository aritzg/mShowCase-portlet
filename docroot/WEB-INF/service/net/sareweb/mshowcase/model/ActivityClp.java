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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import net.sareweb.mshowcase.service.ActivityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Aritz Galdos
 */
public class ActivityClp extends BaseModelImpl<Activity> implements Activity {
	public ActivityClp() {
	}

	public Class<?> getModelClass() {
		return Activity.class;
	}

	public String getModelClassName() {
		return Activity.class.getName();
	}

	public long getPrimaryKey() {
		return _activityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setActivityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_activityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		ActivityLocalServiceUtil.updateActivity(this);
	}

	@Override
	public Activity toEscapedModel() {
		return (Activity)Proxy.newProxyInstance(Activity.class.getClassLoader(),
			new Class[] { Activity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ActivityClp clone = new ActivityClp();

		clone.setActivityId(getActivityId());
		clone.setType(getType());
		clone.setUserId(getUserId());
		clone.setUser2Id(getUser2Id());
		clone.setInstanceId(getInstanceId());
		clone.setOfferId(getOfferId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	public int compareTo(Activity activity) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), activity.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ActivityClp activity = null;

		try {
			activity = (ActivityClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = activity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{activityId=");
		sb.append(getActivityId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", user2Id=");
		sb.append(getUser2Id());
		sb.append(", InstanceId=");
		sb.append(getInstanceId());
		sb.append(", offerId=");
		sb.append(getOfferId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.Activity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activityId</column-name><column-value><![CDATA[");
		sb.append(getActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user2Id</column-name><column-value><![CDATA[");
		sb.append(getUser2Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offerId</column-name><column-value><![CDATA[");
		sb.append(getOfferId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _activityId;
	private String _type;
	private long _userId;
	private String _userUuid;
	private long _user2Id;
	private long _InstanceId;
	private long _offerId;
	private long _companyId;
	private Date _createDate;
}