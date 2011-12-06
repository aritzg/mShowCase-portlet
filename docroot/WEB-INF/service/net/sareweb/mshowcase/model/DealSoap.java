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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.DealServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.DealServiceSoap
 * @generated
 */
public class DealSoap implements Serializable {
	public static DealSoap toSoapModel(Deal model) {
		DealSoap soapModel = new DealSoap();

		soapModel.setDealId(model.getDealId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOfferId(model.getOfferId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static DealSoap[] toSoapModels(Deal[] models) {
		DealSoap[] soapModels = new DealSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DealSoap[][] toSoapModels(Deal[][] models) {
		DealSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DealSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DealSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DealSoap[] toSoapModels(List<Deal> models) {
		List<DealSoap> soapModels = new ArrayList<DealSoap>(models.size());

		for (Deal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DealSoap[soapModels.size()]);
	}

	public DealSoap() {
	}

	public long getPrimaryKey() {
		return _dealId;
	}

	public void setPrimaryKey(long pk) {
		setDealId(pk);
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

	private long _dealId;
	private long _userId;
	private long _offerId;
	private long _companyId;
	private Date _createDate;
}