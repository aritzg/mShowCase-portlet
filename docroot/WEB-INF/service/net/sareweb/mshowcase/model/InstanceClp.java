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

import net.sareweb.mshowcase.service.InstanceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Aritz Galdos
 */
public class InstanceClp extends BaseModelImpl<Instance> implements Instance {
	public InstanceClp() {
	}

	public Class<?> getModelClass() {
		return Instance.class;
	}

	public String getModelClassName() {
		return Instance.class.getName();
	}

	public long getPrimaryKey() {
		return _InstanceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInstanceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_InstanceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		InstanceLocalServiceUtil.updateInstance(this);
	}

	@Override
	public Instance toEscapedModel() {
		return (Instance)Proxy.newProxyInstance(Instance.class.getClassLoader(),
			new Class[] { Instance.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstanceClp clone = new InstanceClp();

		clone.setInstanceId(getInstanceId());
		clone.setName(getName());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setLastModifiedDate(getLastModifiedDate());

		return clone;
	}

	public int compareTo(Instance instance) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), instance.getCreateDate());

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

		InstanceClp instance = null;

		try {
			instance = (InstanceClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = instance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{InstanceId=");
		sb.append(getInstanceId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.Instance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _InstanceId;
	private String _name;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _lastModifiedDate;
}