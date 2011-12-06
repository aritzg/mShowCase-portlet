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

/**
 * <p>
 * This class is a wrapper for {@link Offer}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Offer
 * @generated
 */
public class OfferWrapper implements Offer {
	public OfferWrapper(Offer offer) {
		_offer = offer;
	}

	public Class<?> getModelClass() {
		return Offer.class;
	}

	public String getModelClassName() {
		return Offer.class.getName();
	}

	/**
	* Returns the primary key of this offer.
	*
	* @return the primary key of this offer
	*/
	public long getPrimaryKey() {
		return _offer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this offer.
	*
	* @param primaryKey the primary key of this offer
	*/
	public void setPrimaryKey(long primaryKey) {
		_offer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the offer ID of this offer.
	*
	* @return the offer ID of this offer
	*/
	public long getOfferId() {
		return _offer.getOfferId();
	}

	/**
	* Sets the offer ID of this offer.
	*
	* @param offerId the offer ID of this offer
	*/
	public void setOfferId(long offerId) {
		_offer.setOfferId(offerId);
	}

	/**
	* Returns the instance ID of this offer.
	*
	* @return the instance ID of this offer
	*/
	public long getInstanceId() {
		return _offer.getInstanceId();
	}

	/**
	* Sets the instance ID of this offer.
	*
	* @param InstanceId the instance ID of this offer
	*/
	public void setInstanceId(long InstanceId) {
		_offer.setInstanceId(InstanceId);
	}

	/**
	* Returns the offer text of this offer.
	*
	* @return the offer text of this offer
	*/
	public java.lang.String getOfferText() {
		return _offer.getOfferText();
	}

	/**
	* Returns the localized offer text of this offer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized offer text of this offer
	*/
	public java.lang.String getOfferText(java.util.Locale locale) {
		return _offer.getOfferText(locale);
	}

	/**
	* Returns the localized offer text of this offer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized offer text of this offer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getOfferText(java.util.Locale locale,
		boolean useDefault) {
		return _offer.getOfferText(locale, useDefault);
	}

	/**
	* Returns the localized offer text of this offer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized offer text of this offer
	*/
	public java.lang.String getOfferText(java.lang.String languageId) {
		return _offer.getOfferText(languageId);
	}

	/**
	* Returns the localized offer text of this offer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized offer text of this offer
	*/
	public java.lang.String getOfferText(java.lang.String languageId,
		boolean useDefault) {
		return _offer.getOfferText(languageId, useDefault);
	}

	public java.lang.String getOfferTextCurrentLanguageId() {
		return _offer.getOfferTextCurrentLanguageId();
	}

	public java.lang.String getOfferTextCurrentValue() {
		return _offer.getOfferTextCurrentValue();
	}

	/**
	* Returns a map of the locales and localized offer texts of this offer.
	*
	* @return the locales and localized offer texts of this offer
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getOfferTextMap() {
		return _offer.getOfferTextMap();
	}

	/**
	* Sets the offer text of this offer.
	*
	* @param offerText the offer text of this offer
	*/
	public void setOfferText(java.lang.String offerText) {
		_offer.setOfferText(offerText);
	}

	/**
	* Sets the localized offer text of this offer in the language.
	*
	* @param offerText the localized offer text of this offer
	* @param locale the locale of the language
	*/
	public void setOfferText(java.lang.String offerText, java.util.Locale locale) {
		_offer.setOfferText(offerText, locale);
	}

	/**
	* Sets the localized offer text of this offer in the language, and sets the default locale.
	*
	* @param offerText the localized offer text of this offer
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setOfferText(java.lang.String offerText,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_offer.setOfferText(offerText, locale, defaultLocale);
	}

	public void setOfferTextCurrentLanguageId(java.lang.String languageId) {
		_offer.setOfferTextCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized offer texts of this offer from the map of locales and localized offer texts.
	*
	* @param offerTextMap the locales and localized offer texts of this offer
	*/
	public void setOfferTextMap(
		java.util.Map<java.util.Locale, java.lang.String> offerTextMap) {
		_offer.setOfferTextMap(offerTextMap);
	}

	/**
	* Sets the localized offer texts of this offer from the map of locales and localized offer texts, and sets the default locale.
	*
	* @param offerTextMap the locales and localized offer texts of this offer
	* @param defaultLocale the default locale
	*/
	public void setOfferTextMap(
		java.util.Map<java.util.Locale, java.lang.String> offerTextMap,
		java.util.Locale defaultLocale) {
		_offer.setOfferTextMap(offerTextMap, defaultLocale);
	}

	/**
	* Returns the begin date of this offer.
	*
	* @return the begin date of this offer
	*/
	public java.util.Date getBeginDate() {
		return _offer.getBeginDate();
	}

	/**
	* Sets the begin date of this offer.
	*
	* @param beginDate the begin date of this offer
	*/
	public void setBeginDate(java.util.Date beginDate) {
		_offer.setBeginDate(beginDate);
	}

	/**
	* Returns the end date of this offer.
	*
	* @return the end date of this offer
	*/
	public java.util.Date getEndDate() {
		return _offer.getEndDate();
	}

	/**
	* Sets the end date of this offer.
	*
	* @param endDate the end date of this offer
	*/
	public void setEndDate(java.util.Date endDate) {
		_offer.setEndDate(endDate);
	}

	/**
	* Returns the price of this offer.
	*
	* @return the price of this offer
	*/
	public double getPrice() {
		return _offer.getPrice();
	}

	/**
	* Sets the price of this offer.
	*
	* @param price the price of this offer
	*/
	public void setPrice(double price) {
		_offer.setPrice(price);
	}

	/**
	* Returns the transactions of this offer.
	*
	* @return the transactions of this offer
	*/
	public int getTransactions() {
		return _offer.getTransactions();
	}

	/**
	* Sets the transactions of this offer.
	*
	* @param transactions the transactions of this offer
	*/
	public void setTransactions(int transactions) {
		_offer.setTransactions(transactions);
	}

	/**
	* Returns the image ID of this offer.
	*
	* @return the image ID of this offer
	*/
	public long getImageId() {
		return _offer.getImageId();
	}

	/**
	* Sets the image ID of this offer.
	*
	* @param imageId the image ID of this offer
	*/
	public void setImageId(long imageId) {
		_offer.setImageId(imageId);
	}

	/**
	* Returns the image u r l of this offer.
	*
	* @return the image u r l of this offer
	*/
	public java.lang.String getImageURL() {
		return _offer.getImageURL();
	}

	/**
	* Sets the image u r l of this offer.
	*
	* @param imageURL the image u r l of this offer
	*/
	public void setImageURL(java.lang.String imageURL) {
		_offer.setImageURL(imageURL);
	}

	/**
	* Returns the user ID of this offer.
	*
	* @return the user ID of this offer
	*/
	public long getUserId() {
		return _offer.getUserId();
	}

	/**
	* Sets the user ID of this offer.
	*
	* @param userId the user ID of this offer
	*/
	public void setUserId(long userId) {
		_offer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this offer.
	*
	* @return the user uuid of this offer
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _offer.getUserUuid();
	}

	/**
	* Sets the user uuid of this offer.
	*
	* @param userUuid the user uuid of this offer
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_offer.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this offer.
	*
	* @return the company ID of this offer
	*/
	public long getCompanyId() {
		return _offer.getCompanyId();
	}

	/**
	* Sets the company ID of this offer.
	*
	* @param companyId the company ID of this offer
	*/
	public void setCompanyId(long companyId) {
		_offer.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this offer.
	*
	* @return the create date of this offer
	*/
	public java.util.Date getCreateDate() {
		return _offer.getCreateDate();
	}

	/**
	* Sets the create date of this offer.
	*
	* @param createDate the create date of this offer
	*/
	public void setCreateDate(java.util.Date createDate) {
		_offer.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this offer.
	*
	* @return the modify date of this offer
	*/
	public java.util.Date getModifyDate() {
		return _offer.getModifyDate();
	}

	/**
	* Sets the modify date of this offer.
	*
	* @param modifyDate the modify date of this offer
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_offer.setModifyDate(modifyDate);
	}

	public boolean isNew() {
		return _offer.isNew();
	}

	public void setNew(boolean n) {
		_offer.setNew(n);
	}

	public boolean isCachedModel() {
		return _offer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_offer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _offer.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _offer.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_offer.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _offer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_offer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfferWrapper((Offer)_offer.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Offer offer) {
		return _offer.compareTo(offer);
	}

	@Override
	public int hashCode() {
		return _offer.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Offer> toCacheModel() {
		return _offer.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Offer toEscapedModel() {
		return new OfferWrapper(_offer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _offer.toString();
	}

	public java.lang.String toXmlString() {
		return _offer.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_offer.persist();
	}

	public Offer getWrappedOffer() {
		return _offer;
	}

	public void resetOriginalValues() {
		_offer.resetOriginalValues();
	}

	private Offer _offer;
}