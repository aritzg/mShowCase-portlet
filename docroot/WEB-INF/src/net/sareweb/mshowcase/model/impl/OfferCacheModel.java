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

import net.sareweb.mshowcase.model.Offer;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Offer in entity cache.
 *
 * @author Aritz Galdos
 * @see Offer
 * @generated
 */
public class OfferCacheModel implements CacheModel<Offer>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{offerId=");
		sb.append(offerId);
		sb.append(", InstanceId=");
		sb.append(InstanceId);
		sb.append(", offerText=");
		sb.append(offerText);
		sb.append(", beginDate=");
		sb.append(beginDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", price=");
		sb.append(price);
		sb.append(", transactions=");
		sb.append(transactions);
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
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append("}");

		return sb.toString();
	}

	public Offer toEntityModel() {
		OfferImpl offerImpl = new OfferImpl();

		offerImpl.setOfferId(offerId);
		offerImpl.setInstanceId(InstanceId);

		if (offerText == null) {
			offerImpl.setOfferText(StringPool.BLANK);
		}
		else {
			offerImpl.setOfferText(offerText);
		}

		if (beginDate == Long.MIN_VALUE) {
			offerImpl.setBeginDate(null);
		}
		else {
			offerImpl.setBeginDate(new Date(beginDate));
		}

		if (endDate == Long.MIN_VALUE) {
			offerImpl.setEndDate(null);
		}
		else {
			offerImpl.setEndDate(new Date(endDate));
		}

		offerImpl.setPrice(price);
		offerImpl.setTransactions(transactions);
		offerImpl.setImageId(imageId);

		if (imageURL == null) {
			offerImpl.setImageURL(StringPool.BLANK);
		}
		else {
			offerImpl.setImageURL(imageURL);
		}

		offerImpl.setUserId(userId);
		offerImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			offerImpl.setCreateDate(null);
		}
		else {
			offerImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			offerImpl.setModifyDate(null);
		}
		else {
			offerImpl.setModifyDate(new Date(modifyDate));
		}

		offerImpl.resetOriginalValues();

		return offerImpl;
	}

	public long offerId;
	public long InstanceId;
	public String offerText;
	public long beginDate;
	public long endDate;
	public double price;
	public int transactions;
	public long imageId;
	public String imageURL;
	public long userId;
	public long companyId;
	public long createDate;
	public long modifyDate;
}