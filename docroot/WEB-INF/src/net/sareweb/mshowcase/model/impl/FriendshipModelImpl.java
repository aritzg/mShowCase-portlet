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

package net.sareweb.mshowcase.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.sareweb.mshowcase.model.Friendship;
import net.sareweb.mshowcase.model.FriendshipModel;
import net.sareweb.mshowcase.model.FriendshipSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the Friendship service. Represents a row in the &quot;msc_Friendship&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.sareweb.mshowcase.model.FriendshipModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FriendshipImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipImpl
 * @see net.sareweb.mshowcase.model.Friendship
 * @see net.sareweb.mshowcase.model.FriendshipModel
 * @generated
 */
@JSON(strict = true)
public class FriendshipModelImpl extends BaseModelImpl<Friendship>
	implements FriendshipModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a friendship model instance should use the {@link net.sareweb.mshowcase.model.Friendship} interface instead.
	 */
	public static final String TABLE_NAME = "msc_Friendship";
	public static final Object[][] TABLE_COLUMNS = {
			{ "friendshipId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "user2Id", Types.BIGINT },
			{ "accepted", Types.BOOLEAN },
			{ "rejected", Types.BOOLEAN },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table msc_Friendship (friendshipId LONG not null primary key,userId LONG,user2Id LONG,accepted BOOLEAN,rejected BOOLEAN,companyId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table msc_Friendship";
	public static final String ORDER_BY_JPQL = " ORDER BY friendship.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY msc_Friendship.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.sareweb.mshowcase.model.Friendship"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.sareweb.mshowcase.model.Friendship"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Friendship toModel(FriendshipSoap soapModel) {
		Friendship model = new FriendshipImpl();

		model.setFriendshipId(soapModel.getFriendshipId());
		model.setUserId(soapModel.getUserId());
		model.setUser2Id(soapModel.getUser2Id());
		model.setAccepted(soapModel.getAccepted());
		model.setRejected(soapModel.getRejected());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Friendship> toModels(FriendshipSoap[] soapModels) {
		List<Friendship> models = new ArrayList<Friendship>(soapModels.length);

		for (FriendshipSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.sareweb.mshowcase.model.Friendship"));

	public FriendshipModelImpl() {
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

	public Class<?> getModelClass() {
		return Friendship.class;
	}

	public String getModelClassName() {
		return Friendship.class.getName();
	}

	@JSON
	public long getFriendshipId() {
		return _friendshipId;
	}

	public void setFriendshipId(long friendshipId) {
		_friendshipId = friendshipId;
	}

	@JSON
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

	@JSON
	public long getUser2Id() {
		return _user2Id;
	}

	public void setUser2Id(long user2Id) {
		_user2Id = user2Id;
	}

	@JSON
	public boolean getAccepted() {
		return _accepted;
	}

	public boolean isAccepted() {
		return _accepted;
	}

	public void setAccepted(boolean accepted) {
		_accepted = accepted;
	}

	@JSON
	public boolean getRejected() {
		return _rejected;
	}

	public boolean isRejected() {
		return _rejected;
	}

	public void setRejected(boolean rejected) {
		_rejected = rejected;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Friendship toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Friendship)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Friendship.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		FriendshipImpl friendshipImpl = new FriendshipImpl();

		friendshipImpl.setFriendshipId(getFriendshipId());
		friendshipImpl.setUserId(getUserId());
		friendshipImpl.setUser2Id(getUser2Id());
		friendshipImpl.setAccepted(getAccepted());
		friendshipImpl.setRejected(getRejected());
		friendshipImpl.setCompanyId(getCompanyId());
		friendshipImpl.setCreateDate(getCreateDate());

		friendshipImpl.resetOriginalValues();

		return friendshipImpl;
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

		Friendship friendship = null;

		try {
			friendship = (Friendship)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Friendship> toCacheModel() {
		FriendshipCacheModel friendshipCacheModel = new FriendshipCacheModel();

		friendshipCacheModel.friendshipId = getFriendshipId();

		friendshipCacheModel.userId = getUserId();

		friendshipCacheModel.user2Id = getUser2Id();

		friendshipCacheModel.accepted = getAccepted();

		friendshipCacheModel.rejected = getRejected();

		friendshipCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			friendshipCacheModel.createDate = createDate.getTime();
		}
		else {
			friendshipCacheModel.createDate = Long.MIN_VALUE;
		}

		return friendshipCacheModel;
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

	private static ClassLoader _classLoader = Friendship.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Friendship.class
		};
	private long _friendshipId;
	private long _userId;
	private String _userUuid;
	private long _user2Id;
	private boolean _accepted;
	private boolean _rejected;
	private long _companyId;
	private Date _createDate;
	private transient ExpandoBridge _expandoBridge;
	private Friendship _escapedModelProxy;
}