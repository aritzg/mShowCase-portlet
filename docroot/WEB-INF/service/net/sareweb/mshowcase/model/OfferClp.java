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

package net.sareweb.mshowcase.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import net.sareweb.mshowcase.service.OfferLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author Aritz Galdos
 */
public class OfferClp extends BaseModelImpl<Offer> implements Offer {
	public OfferClp() {
	}

	public Class<?> getModelClass() {
		return Offer.class;
	}

	public String getModelClassName() {
		return Offer.class.getName();
	}

	public long getPrimaryKey() {
		return _offerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOfferId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_offerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getOfferId() {
		return _offerId;
	}

	public void setOfferId(long offerId) {
		_offerId = offerId;
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public String getOfferText() {
		return _offerText;
	}

	public String getOfferText(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOfferText(languageId);
	}

	public String getOfferText(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getOfferText(languageId, useDefault);
	}

	public String getOfferText(String languageId) {
		return LocalizationUtil.getLocalization(getOfferText(), languageId);
	}

	public String getOfferText(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getOfferText(), languageId,
			useDefault);
	}

	public String getOfferTextCurrentLanguageId() {
		return _offerTextCurrentLanguageId;
	}

	public String getOfferTextCurrentValue() {
		Locale locale = getLocale(_offerTextCurrentLanguageId);

		return getOfferText(locale);
	}

	public Map<Locale, String> getOfferTextMap() {
		return LocalizationUtil.getLocalizationMap(getOfferText());
	}

	public void setOfferText(String offerText) {
		_offerText = offerText;
	}

	public void setOfferText(String offerText, Locale locale) {
		setOfferText(offerText, locale, LocaleUtil.getDefault());
	}

	public void setOfferText(String offerText, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(offerText)) {
			setOfferText(LocalizationUtil.updateLocalization(getOfferText(),
					"OfferText", offerText, languageId, defaultLanguageId));
		}
		else {
			setOfferText(LocalizationUtil.removeLocalization(getOfferText(),
					"OfferText", languageId));
		}
	}

	public void setOfferTextCurrentLanguageId(String languageId) {
		_offerTextCurrentLanguageId = languageId;
	}

	public void setOfferTextMap(Map<Locale, String> offerTextMap) {
		setOfferTextMap(offerTextMap, LocaleUtil.getDefault());
	}

	public void setOfferTextMap(Map<Locale, String> offerTextMap,
		Locale defaultLocale) {
		if (offerTextMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			Locale[] locales = LanguageUtil.getAvailableLocales();

			for (Locale locale : locales) {
				String offerText = offerTextMap.get(locale);

				setOfferText(offerText, locale, defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public Date getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(Date beginDate) {
		_beginDate = beginDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public int getTransactions() {
		return _transactions;
	}

	public void setTransactions(int transactions) {
		_transactions = transactions;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public void persist() throws SystemException {
		OfferLocalServiceUtil.updateOffer(this);
	}

	@Override
	public Offer toEscapedModel() {
		return (Offer)Proxy.newProxyInstance(Offer.class.getClassLoader(),
			new Class[] { Offer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfferClp clone = new OfferClp();

		clone.setOfferId(getOfferId());
		clone.setInstanceId(getInstanceId());
		clone.setOfferText(getOfferText());
		clone.setBeginDate(getBeginDate());
		clone.setEndDate(getEndDate());
		clone.setPrice(getPrice());
		clone.setTransactions(getTransactions());
		clone.setImageId(getImageId());
		clone.setImageURL(getImageURL());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());

		return clone;
	}

	public int compareTo(Offer offer) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), offer.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OfferClp offer = null;

		try {
			offer = (OfferClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = offer.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{offerId=");
		sb.append(getOfferId());
		sb.append(", InstanceId=");
		sb.append(getInstanceId());
		sb.append(", offerText=");
		sb.append(getOfferText());
		sb.append(", beginDate=");
		sb.append(getBeginDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", transactions=");
		sb.append(getTransactions());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", imageURL=");
		sb.append(getImageURL());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.Offer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>offerId</column-name><column-value><![CDATA[");
		sb.append(getOfferId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>offerText</column-name><column-value><![CDATA[");
		sb.append(getOfferText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginDate</column-name><column-value><![CDATA[");
		sb.append(getBeginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactions</column-name><column-value><![CDATA[");
		sb.append(getTransactions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageURL</column-name><column-value><![CDATA[");
		sb.append(getImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _offerId;
	private long _InstanceId;
	private String _offerText;
	private String _offerTextCurrentLanguageId;
	private Date _beginDate;
	private Date _endDate;
	private double _price;
	private int _transactions;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private Date _createDate;
	private Date _modifyDate;
}