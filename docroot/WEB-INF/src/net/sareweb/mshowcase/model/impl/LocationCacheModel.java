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
		StringBundler sb = new StringBundler(25);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", InstanceId=");
		sb.append(InstanceId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", lng=");
		sb.append(lng);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setLocationId(locationId);
		locationImpl.setInstanceId(InstanceId);

		if (address == null) {
			locationImpl.setAddress(StringPool.BLANK);
		}
		else {
			locationImpl.setAddress(address);
		}

		locationImpl.setLat(lat);
		locationImpl.setLng(lng);

		if (phoneNumber == null) {
			locationImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			locationImpl.setPhoneNumber(phoneNumber);
		}

		if (faxNumber == null) {
			locationImpl.setFaxNumber(StringPool.BLANK);
		}
		else {
			locationImpl.setFaxNumber(faxNumber);
		}

		locationImpl.setImageId(imageId);

		if (imageURL == null) {
			locationImpl.setImageURL(StringPool.BLANK);
		}
		else {
			locationImpl.setImageURL(imageURL);
		}

		locationImpl.setUserId(userId);
		locationImpl.setCompanyId(companyId);

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
	public long InstanceId;
	public String address;
	public double lat;
	public double lng;
	public String phoneNumber;
	public String faxNumber;
	public long imageId;
	public String imageURL;
	public long userId;
	public long companyId;
	public long createDate;
}