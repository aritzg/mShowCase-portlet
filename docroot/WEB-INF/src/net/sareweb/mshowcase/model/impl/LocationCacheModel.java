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

import net.sareweb.mshowcase.model.Location;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author Aritz Galdos
 * @see Location
 * @generated
 */
public class LocationCacheModel implements CacheModel<Location>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", lng=");
		sb.append(lng);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationId(locationId);

		if (address == null) {
			locationImpl.setAddress(StringPool.BLANK);
		}
		else {
			locationImpl.setAddress(address);
		}

		locationImpl.setLat(lat);
		locationImpl.setLng(lng);
		locationImpl.setImageId(imageId);

		if (imageURL == null) {
			locationImpl.setImageURL(StringPool.BLANK);
		}
		else {
			locationImpl.setImageURL(imageURL);
		}

		locationImpl.setUserId(userId);
		locationImpl.setCompanyId(companyId);
		locationImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			locationImpl.setCreateDate(null);
		}
		else {
			locationImpl.setCreateDate(new Date(createDate));
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	public long locationId;
	public String address;
	public float lat;
	public float lng;
	public long imageId;
	public String imageURL;
	public long userId;
	public long companyId;
	public long groupId;
	public long createDate;
}