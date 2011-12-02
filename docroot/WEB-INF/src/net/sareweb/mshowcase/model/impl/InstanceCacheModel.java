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
		StringBundler sb = new StringBundler(15);

		sb.append("{InstanceId=");
		sb.append(InstanceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
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

		instanceImpl.setUserId(userId);
		instanceImpl.setCompanyId(companyId);
		instanceImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			instanceImpl.setCreateDate(null);
		}
		else {
			instanceImpl.setCreateDate(new Date(createDate));
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			instanceImpl.setLastModifiedDate(null);
		}
		else {
			instanceImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		instanceImpl.resetOriginalValues();

		return instanceImpl;
	}

	public long InstanceId;
	public String name;
	public long userId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long lastModifiedDate;
}