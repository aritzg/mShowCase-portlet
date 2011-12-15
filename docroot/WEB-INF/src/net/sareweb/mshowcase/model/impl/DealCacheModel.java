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

import net.sareweb.mshowcase.model.Deal;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Deal in entity cache.
 *
 * @author Aritz Galdos
 * @see Deal
 * @generated
 */
public class DealCacheModel implements CacheModel<Deal>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{dealId=");
		sb.append(dealId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", offerId=");
		sb.append(offerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	public Deal toEntityModel() {
		DealImpl dealImpl = new DealImpl();

		dealImpl.setDealId(dealId);
		dealImpl.setUserId(userId);
		dealImpl.setOfferId(offerId);
		dealImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			dealImpl.setCreateDate(null);
		}
		else {
			dealImpl.setCreateDate(new Date(createDate));
		}

		dealImpl.resetOriginalValues();

		return dealImpl;
	}

	public long dealId;
	public long userId;
	public long offerId;
	public long companyId;
	public long createDate;
}