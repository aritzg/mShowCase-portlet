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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.mshowcase.service.http.FriendshipServiceSoap}.
 *
 * @author    Aritz Galdos
 * @see       net.sareweb.mshowcase.service.http.FriendshipServiceSoap
 * @generated
 */
public class FriendshipSoap implements Serializable {
	public static FriendshipSoap toSoapModel(Friendship model) {
		FriendshipSoap soapModel = new FriendshipSoap();

		soapModel.setFriendshipId(model.getFriendshipId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUser2Id(model.getUser2Id());
		soapModel.setAccepted(model.getAccepted());
		soapModel.setRejected(model.getRejected());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static FriendshipSoap[] toSoapModels(Friendship[] models) {
		FriendshipSoap[] soapModels = new FriendshipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FriendshipSoap[][] toSoapModels(Friendship[][] models) {
		FriendshipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FriendshipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FriendshipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FriendshipSoap[] toSoapModels(List<Friendship> models) {
		List<FriendshipSoap> soapModels = new ArrayList<FriendshipSoap>(models.size());

		for (Friendship model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FriendshipSoap[soapModels.size()]);
	}

	public FriendshipSoap() {
	}

	public long getPrimaryKey() {
		return _friendshipId;
	}

	public void setPrimaryKey(long pk) {
		setFriendshipId(pk);
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

	private long _friendshipId;
	private long _userId;
	private long _user2Id;
	private boolean _accepted;
	private boolean _rejected;
	private long _companyId;
	private Date _createDate;
}