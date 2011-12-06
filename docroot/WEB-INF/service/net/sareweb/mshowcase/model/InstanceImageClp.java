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

import net.sareweb.mshowcase.service.InstanceImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Aritz Galdos
 */
public class InstanceImageClp extends BaseModelImpl<InstanceImage>
	implements InstanceImage {
	public InstanceImageClp() {
	}

	public Class<?> getModelClass() {
		return InstanceImage.class;
	}

	public String getModelClassName() {
		return InstanceImage.class.getName();
	}

	public long getPrimaryKey() {
		return _InstanceImageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInstanceImageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_InstanceImageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public void persist() throws SystemException {
		InstanceImageLocalServiceUtil.updateInstanceImage(this);
	}

	@Override
	public InstanceImage toEscapedModel() {
		return (InstanceImage)Proxy.newProxyInstance(InstanceImage.class.getClassLoader(),
			new Class[] { InstanceImage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstanceImageClp clone = new InstanceImageClp();

		clone.setInstanceImageId(getInstanceImageId());
		clone.setInstanceId(getInstanceId());
		clone.setImageId(getImageId());
		clone.setImageURL(getImageURL());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	public int compareTo(InstanceImage instanceImage) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				instanceImage.getCreateDate());

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

		InstanceImageClp instanceImage = null;

		try {
			instanceImage = (InstanceImageClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = instanceImage.getPrimaryKey();

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

		sb.append("{InstanceImageId=");
		sb.append(getInstanceImageId());
		sb.append(", InstanceId=");
		sb.append(getInstanceId());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", imageURL=");
		sb.append(getImageURL());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.InstanceImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InstanceImageId</column-name><column-value><![CDATA[");
		sb.append(getInstanceImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageURL</column-name><column-value><![CDATA[");
		sb.append(getImageURL());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _InstanceImageId;
	private long _InstanceId;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private Date _createDate;
}