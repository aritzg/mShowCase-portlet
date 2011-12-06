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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.OfferServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.OfferServiceSoap
 * @generated
 */
public class OfferSoap implements Serializable {
	public static OfferSoap toSoapModel(Offer model) {
		OfferSoap soapModel = new OfferSoap();

		soapModel.setOfferId(model.getOfferId());
		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setOfferText(model.getOfferText());
		soapModel.setBeginDate(model.getBeginDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setPrice(model.getPrice());
		soapModel.setTransactions(model.getTransactions());
		soapModel.setImageId(model.getImageId());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());

		return soapModel;
	}

	public static OfferSoap[] toSoapModels(Offer[] models) {
		OfferSoap[] soapModels = new OfferSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfferSoap[][] toSoapModels(Offer[][] models) {
		OfferSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfferSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfferSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfferSoap[] toSoapModels(List<Offer> models) {
		List<OfferSoap> soapModels = new ArrayList<OfferSoap>(models.size());

		for (Offer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfferSoap[soapModels.size()]);
	}

	public OfferSoap() {
	}

	public long getPrimaryKey() {
		return _offerId;
	}

	public void setPrimaryKey(long pk) {
		setOfferId(pk);
	}

	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public String getOfferText() {
		return _offerText;
	}

	public void setOfferText(String offerText) {
		_offerText = offerText;
	}

	public Date getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(Date beginDate) {
		_beginDate = beginDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public int getTransactions() {
		return _transactions;
	}

	public void setTransactions(int transactions) {
		_transactions = transactions;
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

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	private long _offerId;
	private long _InstanceId;
	private String _offerText;
	private Date _beginDate;
	private Date _endDate;
	private double _price;
	private int _transactions;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private long _companyId;
	private Date _createDate;
	private Date _modifyDate;
}