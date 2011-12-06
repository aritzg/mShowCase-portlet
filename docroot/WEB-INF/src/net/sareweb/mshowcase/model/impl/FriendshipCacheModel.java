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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import net.sareweb.mshowcase.model.Friendship;

import java.util.Date;

/**
 * The cache model class for representing Friendship in entity cache.
 *
 * @author Aritz Galdos
 * @see Friendship
 * @generated
 */
public class FriendshipCacheModel implements CacheModel<Friendship> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{friendshipId=");
		sb.append(friendshipId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", user2Id=");
		sb.append(user2Id);
		sb.append(", accepted=");
		sb.append(accepted);
		sb.append(", rejected=");
		sb.append(rejected);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Friendship toEntityModel() {
		FriendshipImpl friendshipImpl = new FriendshipImpl();

		friendshipImpl.setFriendshipId(friendshipId);
		friendshipImpl.setUserId(userId);
		friendshipImpl.setUser2Id(user2Id);
		friendshipImpl.setAccepted(accepted);
		friendshipImpl.setRejected(rejected);
		friendshipImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			friendshipImpl.setCreateDate(null);
		}
		else {
			friendshipImpl.setCreateDate(new Date(createDate));
		}

		friendshipImpl.resetOriginalValues();

		return friendshipImpl;
	}

	public long friendshipId;
	public long userId;
	public long user2Id;
	public boolean accepted;
	public boolean rejected;
	public long companyId;
	public long createDate;
}