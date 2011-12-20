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

import net.sareweb.mshowcase.model.Instance;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Instance in entity cache.
 *
 * @author Aritz Galdos
 * @see Instance
 * @generated
 */
public class InstanceCacheModel implements CacheModel<Instance>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{InstanceId=");
		sb.append(InstanceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", webPage=");
		sb.append(webPage);
		sb.append(", categoryLevel0=");
		sb.append(categoryLevel0);
		sb.append(", categoryLevel1=");
		sb.append(categoryLevel1);
		sb.append(", categoryLevel2=");
		sb.append(categoryLevel2);
		sb.append(", logoImageId=");
		sb.append(logoImageId);
		sb.append(", logoImageURL=");
		sb.append(logoImageURL);
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

	public Instance toEntityModel() {
		InstanceImpl instanceImpl = new InstanceImpl();

		instanceImpl.setInstanceId(InstanceId);

		if (name == null) {
			instanceImpl.setName(StringPool.BLANK);
		}
		else {
			instanceImpl.setName(name);
		}

		if (description == null) {
			instanceImpl.setDescription(StringPool.BLANK);
		}
		else {
			instanceImpl.setDescription(description);
		}

		if (phoneNumber == null) {
			instanceImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			instanceImpl.setPhoneNumber(phoneNumber);
		}

		if (faxNumber == null) {
			instanceImpl.setFaxNumber(StringPool.BLANK);
		}
		else {
			instanceImpl.setFaxNumber(faxNumber);
		}

		if (email == null) {
			instanceImpl.setEmail(StringPool.BLANK);
		}
		else {
			instanceImpl.setEmail(email);
		}

		if (webPage == null) {
			instanceImpl.setWebPage(StringPool.BLANK);
		}
		else {
			instanceImpl.setWebPage(webPage);
		}

		instanceImpl.setCategoryLevel0(categoryLevel0);
		instanceImpl.setCategoryLevel1(categoryLevel1);
		instanceImpl.setCategoryLevel2(categoryLevel2);
		instanceImpl.setLogoImageId(logoImageId);

		if (logoImageURL == null) {
			instanceImpl.setLogoImageURL(StringPool.BLANK);
		}
		else {
			instanceImpl.setLogoImageURL(logoImageURL);
		}

		instanceImpl.setUserId(userId);
		instanceImpl.setCompanyId(companyId);
		instanceImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			instanceImpl.setCreateDate(null);
		}
		else {
			instanceImpl.setCreateDate(new Date(createDate));
		}

		instanceImpl.resetOriginalValues();

		return instanceImpl;
	}

	public long InstanceId;
	public String name;
	public String description;
	public String phoneNumber;
	public String faxNumber;
	public String email;
	public String webPage;
	public long categoryLevel0;
	public long categoryLevel1;
	public long categoryLevel2;
	public long logoImageId;
	public String logoImageURL;
	public long userId;
	public long companyId;
	public long groupId;
	public long createDate;
}