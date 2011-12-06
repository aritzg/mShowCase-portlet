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

import net.sareweb.mshowcase.model.Deal;
import net.sareweb.mshowcase.model.DealModel;
import net.sareweb.mshowcase.model.DealSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the Deal service. Represents a row in the &quot;msc_Deal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.sareweb.mshowcase.model.DealModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DealImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see DealImpl
 * @see net.sareweb.mshowcase.model.Deal
 * @see net.sareweb.mshowcase.model.DealModel
 * @generated
 */
@JSON(strict = true)
public class DealModelImpl extends BaseModelImpl<Deal> implements DealModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a deal model instance should use the {@link net.sareweb.mshowcase.model.Deal} interface instead.
	 */
	public static final String TABLE_NAME = "msc_Deal";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dealId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "offerId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table msc_Deal (dealId LONG not null primary key,userId LONG,offerId LONG,companyId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table msc_Deal";
	public static final String ORDER_BY_JPQL = " ORDER BY deal.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY msc_Deal.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.sareweb.mshowcase.model.Deal"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.sareweb.mshowcase.model.Deal"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Deal toModel(DealSoap soapModel) {
		Deal model = new DealImpl();

		model.setDealId(soapModel.getDealId());
		model.setUserId(soapModel.getUserId());
		model.setOfferId(soapModel.getOfferId());
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
	public static List<Deal> toModels(DealSoap[] soapModels) {
		List<Deal> models = new ArrayList<Deal>(soapModels.length);

		for (DealSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.sareweb.mshowcase.model.Deal"));

	public DealModelImpl() {
	}

	public long getPrimaryKey() {
		return _dealId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDealId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_dealId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Deal.class;
	}

	public String getModelClassName() {
		return Deal.class.getName();
	}

	@JSON
	public long getDealId() {
		return _dealId;
	}

	public void setDealId(long dealId) {
		_dealId = dealId;
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
	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
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
	public Deal toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Deal)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Deal.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DealImpl dealImpl = new DealImpl();

		dealImpl.setDealId(getDealId());
		dealImpl.setUserId(getUserId());
		dealImpl.setOfferId(getOfferId());
		dealImpl.setCompanyId(getCompanyId());
		dealImpl.setCreateDate(getCreateDate());

		dealImpl.resetOriginalValues();

		return dealImpl;
	}

	public int compareTo(Deal deal) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), deal.getCreateDate());

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

		Deal deal = null;

		try {
			deal = (Deal)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = deal.getPrimaryKey();

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
	public CacheModel<Deal> toCacheModel() {
		DealCacheModel dealCacheModel = new DealCacheModel();

		dealCacheModel.dealId = getDealId();

		dealCacheModel.userId = getUserId();

		dealCacheModel.offerId = getOfferId();

		dealCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			dealCacheModel.createDate = createDate.getTime();
		}
		else {
			dealCacheModel.createDate = Long.MIN_VALUE;
		}

		return dealCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{dealId=");
		sb.append(getDealId());
		sb.append(", userId=");
		sb.append(getUserId());
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
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.Deal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dealId</column-name><column-value><![CDATA[");
		sb.append(getDealId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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

	private static ClassLoader _classLoader = Deal.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Deal.class
		};
	private long _dealId;
	private long _userId;
	private String _userUuid;
	private long _offerId;
	private long _companyId;
	private Date _createDate;
	private transient ExpandoBridge _expandoBridge;
	private Deal _escapedModelProxy;
}