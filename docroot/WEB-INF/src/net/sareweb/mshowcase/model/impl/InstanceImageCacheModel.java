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

import net.sareweb.mshowcase.model.InstanceImage;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing InstanceImage in entity cache.
 *
 * @author Aritz Galdos
 * @see InstanceImage
 * @generated
 */
public class InstanceImageCacheModel implements CacheModel<InstanceImage>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{InstanceImageId=");
		sb.append(InstanceImageId);
		sb.append(", InstanceId=");
		sb.append(InstanceId);
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

	public InstanceImage toEntityModel() {
		InstanceImageImpl instanceImageImpl = new InstanceImageImpl();

		instanceImageImpl.setInstanceImageId(InstanceImageId);
		instanceImageImpl.setInstanceId(InstanceId);
		instanceImageImpl.setImageId(imageId);

		if (imageURL == null) {
			instanceImageImpl.setImageURL(StringPool.BLANK);
		}
		else {
			instanceImageImpl.setImageURL(imageURL);
		}

		instanceImageImpl.setUserId(userId);
		instanceImageImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			instanceImageImpl.setCreateDate(null);
		}
		else {
			instanceImageImpl.setCreateDate(new Date(createDate));
		}

		instanceImageImpl.resetOriginalValues();

		return instanceImageImpl;
	}

	public long InstanceImageId;
	public long InstanceId;
	public long imageId;
	public String imageURL;
	public long userId;
	public long companyId;
	public long createDate;
}