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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.sareweb.mshowcase.model.Activity;

import java.util.Date;

/**
 * The cache model class for representing Activity in entity cache.
 *
 * @author Aritz Galdos
 * @see Activity
 * @generated
 */
public class ActivityCacheModel implements CacheModel<Activity> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{activityId=");
		sb.append(activityId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", user2Id=");
		sb.append(user2Id);
		sb.append(", InstanceId=");
		sb.append(InstanceId);
		sb.append(", offerId=");
		sb.append(offerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Activity toEntityModel() {
		ActivityImpl activityImpl = new ActivityImpl();

		activityImpl.setActivityId(activityId);

		if (type == null) {
			activityImpl.setType(StringPool.BLANK);
		}
		else {
			activityImpl.setType(type);
		}

		activityImpl.setUserId(userId);
		activityImpl.setUser2Id(user2Id);
		activityImpl.setInstanceId(InstanceId);
		activityImpl.setOfferId(offerId);
		activityImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			activityImpl.setCreateDate(null);
		}
		else {
			activityImpl.setCreateDate(new Date(createDate));
		}

		activityImpl.resetOriginalValues();

		return activityImpl;
	}

	public long activityId;
	public String type;
	public long userId;
	public long user2Id;
	public long InstanceId;
	public long offerId;
	public long companyId;
	public long createDate;
}