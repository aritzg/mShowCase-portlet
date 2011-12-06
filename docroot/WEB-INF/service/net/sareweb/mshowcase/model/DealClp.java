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

import net.sareweb.mshowcase.service.DealLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Aritz Galdos
 */
public class DealClp extends BaseModelImpl<Deal> implements Deal {
	public DealClp() {
	}

	public Class<?> getModelClass() {
		return Deal.class;
	}

	public String getModelClassName() {
		return Deal.class.getName();
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

	public long getDealId() {
		return _dealId;
	}

	public void setDealId(long dealId) {
		_dealId = dealId;
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
		DealLocalServiceUtil.updateDeal(this);
	}

	@Override
	public Deal toEscapedModel() {
		return (Deal)Proxy.newProxyInstance(Deal.class.getClassLoader(),
			new Class[] { Deal.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DealClp clone = new DealClp();

		clone.setDealId(getDealId());
		clone.setUserId(getUserId());
		clone.setOfferId(getOfferId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());

		return clone;
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

		DealClp deal = null;

		try {
			deal = (DealClp)obj;
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

	private long _dealId;
	private long _userId;
	private String _userUuid;
	private long _offerId;
	private long _companyId;
	private Date _createDate;
}