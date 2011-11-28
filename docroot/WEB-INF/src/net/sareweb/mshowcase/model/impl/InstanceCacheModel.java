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

import net.sareweb.mshowcase.model.Instance;

import java.util.Date;

/**
 * The cache model class for representing Instance in entity cache.
 *
 * @author Aritz Galdos
 * @see Instance
 * @generated
 */
public class InstanceCacheModel implements CacheModel<Instance> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{InstanceId=");
		sb.append(InstanceId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Instance toEntityModel() {
		InstanceImpl instanceImpl = new InstanceImpl();

		instanceImpl.setInstanceId(InstanceId);
		instanceImpl.setUserId(userId);
		instanceImpl.setCompanyId(companyId);

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
	public long userId;
	public long companyId;
	public long createDate;
}