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

import net.sareweb.mshowcase.service.FriendshipLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Aritz Galdos
 */
public class FriendshipClp extends BaseModelImpl<Friendship>
	implements Friendship {
	public FriendshipClp() {
	}

	public Class<?> getModelClass() {
		return Friendship.class;
	}

	public String getModelClassName() {
		return Friendship.class.getName();
	}

	public long getPrimaryKey() {
		return _friendshipId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFriendshipId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_friendshipId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getFriendshipId() {
		return _friendshipId;
	}

	public void setFriendshipId(long friendshipId) {
		_friendshipId = friendshipId;
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

	public boolean getAccepted() {
		return _accepted;
	}

	public boolean isAccepted() {
		return _accepted;
	}

	public void setAccepted(boolean accepted) {
		_accepted = accepted;
	}

	public boolean getRejected() {
		return _rejected;
	}

	public boolean isRejected() {
		return _rejected;
	}

	public void setRejected(boolean rejected) {
		_rejected = rejected;
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
		FriendshipLocalServiceUtil.updateFriendship(this);
	}

	@Override
	public Friendship toEscapedModel() {
		return (Friendship)Proxy.newProxyInstance(Friendship.class.getClassLoader(),
			new Class[] { Friendship.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FriendshipClp clone = new FriendshipClp();

		clone.setFriendshipId(getFriendshipId());
		clone.setUserId(getUserId());
		clone.setUser2Id(getUser2Id());
		clone.setAccepted(getAccepted());
		clone.setRejected(getRejected());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	public int compareTo(Friendship friendship) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), friendship.getCreateDate());

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

		FriendshipClp friendship = null;

		try {
			friendship = (FriendshipClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = friendship.getPrimaryKey();

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

		sb.append("{friendshipId=");
		sb.append(getFriendshipId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", user2Id=");
		sb.append(getUser2Id());
		sb.append(", accepted=");
		sb.append(getAccepted());
		sb.append(", rejected=");
		sb.append(getRejected());
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
		sb.append("net.sareweb.mshowcase.model.Friendship");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>friendshipId</column-name><column-value><![CDATA[");
		sb.append(getFriendshipId());
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
			"<column><column-name>accepted</column-name><column-value><![CDATA[");
		sb.append(getAccepted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejected</column-name><column-value><![CDATA[");
		sb.append(getRejected());
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

	private long _friendshipId;
	private long _userId;
	private String _userUuid;
	private long _user2Id;
	private boolean _accepted;
	private boolean _rejected;
	private long _companyId;
	private Date _createDate;
}