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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Instance}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Instance
 * @generated
 */
public class InstanceWrapper implements Instance, ModelWrapper<Instance> {
	public InstanceWrapper(Instance instance) {
		_instance = instance;
	}

	public Class<?> getModelClass() {
		return Instance.class;
	}

	public String getModelClassName() {
		return Instance.class.getName();
	}

	/**
	* Returns the primary key of this instance.
	*
	* @return the primary key of this instance
	*/
	public long getPrimaryKey() {
		return _instance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this instance.
	*
	* @param primaryKey the primary key of this instance
	*/
	public void setPrimaryKey(long primaryKey) {
		_instance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the instance ID of this instance.
	*
	* @return the instance ID of this instance
	*/
	public long getInstanceId() {
		return _instance.getInstanceId();
	}

	/**
	* Sets the instance ID of this instance.
	*
	* @param InstanceId the instance ID of this instance
	*/
	public void setInstanceId(long InstanceId) {
		_instance.setInstanceId(InstanceId);
	}

	/**
	* Returns the name of this instance.
	*
	* @return the name of this instance
	*/
	public java.lang.String getName() {
		return _instance.getName();
	}

	/**
	* Sets the name of this instance.
	*
	* @param name the name of this instance
	*/
	public void setName(java.lang.String name) {
		_instance.setName(name);
	}

	/**
	* Returns the description of this instance.
	*
	* @return the description of this instance
	*/
	public java.lang.String getDescription() {
		return _instance.getDescription();
	}

	/**
	* Returns the localized description of this instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this instance
	*/
	public java.lang.String getDescription(java.util.Locale locale) {
		return _instance.getDescription(locale);
	}

	/**
	* Returns the localized description of this instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _instance.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this instance
	*/
	public java.lang.String getDescription(java.lang.String languageId) {
		return _instance.getDescription(languageId);
	}

	/**
	* Returns the localized description of this instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this instance
	*/
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _instance.getDescription(languageId, useDefault);
	}

	public java.lang.String getDescriptionCurrentLanguageId() {
		return _instance.getDescriptionCurrentLanguageId();
	}

	public java.lang.String getDescriptionCurrentValue() {
		return _instance.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this instance.
	*
	* @return the locales and localized descriptions of this instance
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _instance.getDescriptionMap();
	}

	/**
	* Sets the description of this instance.
	*
	* @param description the description of this instance
	*/
	public void setDescription(java.lang.String description) {
		_instance.setDescription(description);
	}

	/**
	* Sets the localized description of this instance in the language.
	*
	* @param description the localized description of this instance
	* @param locale the locale of the language
	*/
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_instance.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this instance in the language, and sets the default locale.
	*
	* @param description the localized description of this instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_instance.setDescription(description, locale, defaultLocale);
	}

	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_instance.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this instance from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this instance
	*/
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_instance.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this instance from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this instance
	* @param defaultLocale the default locale
	*/
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_instance.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the phone number of this instance.
	*
	* @return the phone number of this instance
	*/
	public java.lang.String getPhoneNumber() {
		return _instance.getPhoneNumber();
	}

	/**
	* Sets the phone number of this instance.
	*
	* @param phoneNumber the phone number of this instance
	*/
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_instance.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the fax number of this instance.
	*
	* @return the fax number of this instance
	*/
	public java.lang.String getFaxNumber() {
		return _instance.getFaxNumber();
	}

	/**
	* Sets the fax number of this instance.
	*
	* @param faxNumber the fax number of this instance
	*/
	public void setFaxNumber(java.lang.String faxNumber) {
		_instance.setFaxNumber(faxNumber);
	}

	/**
	* Returns the email of this instance.
	*
	* @return the email of this instance
	*/
	public java.lang.String getEmail() {
		return _instance.getEmail();
	}

	/**
	* Sets the email of this instance.
	*
	* @param email the email of this instance
	*/
	public void setEmail(java.lang.String email) {
		_instance.setEmail(email);
	}

	/**
	* Returns the web page of this instance.
	*
	* @return the web page of this instance
	*/
	public java.lang.String getWebPage() {
		return _instance.getWebPage();
	}

	/**
	* Sets the web page of this instance.
	*
	* @param webPage the web page of this instance
	*/
	public void setWebPage(java.lang.String webPage) {
		_instance.setWebPage(webPage);
	}

	/**
	* Returns the category level0 of this instance.
	*
	* @return the category level0 of this instance
	*/
	public long getCategoryLevel0() {
		return _instance.getCategoryLevel0();
	}

	/**
	* Sets the category level0 of this instance.
	*
	* @param categoryLevel0 the category level0 of this instance
	*/
	public void setCategoryLevel0(long categoryLevel0) {
		_instance.setCategoryLevel0(categoryLevel0);
	}

	/**
	* Returns the category level1 of this instance.
	*
	* @return the category level1 of this instance
	*/
	public long getCategoryLevel1() {
		return _instance.getCategoryLevel1();
	}

	/**
	* Sets the category level1 of this instance.
	*
	* @param categoryLevel1 the category level1 of this instance
	*/
	public void setCategoryLevel1(long categoryLevel1) {
		_instance.setCategoryLevel1(categoryLevel1);
	}

	/**
	* Returns the category level2 of this instance.
	*
	* @return the category level2 of this instance
	*/
	public long getCategoryLevel2() {
		return _instance.getCategoryLevel2();
	}

	/**
	* Sets the category level2 of this instance.
	*
	* @param categoryLevel2 the category level2 of this instance
	*/
	public void setCategoryLevel2(long categoryLevel2) {
		_instance.setCategoryLevel2(categoryLevel2);
	}

	/**
	* Returns the logo image ID of this instance.
	*
	* @return the logo image ID of this instance
	*/
	public long getLogoImageId() {
		return _instance.getLogoImageId();
	}

	/**
	* Sets the logo image ID of this instance.
	*
	* @param logoImageId the logo image ID of this instance
	*/
	public void setLogoImageId(long logoImageId) {
		_instance.setLogoImageId(logoImageId);
	}

	/**
	* Returns the logo image u r l of this instance.
	*
	* @return the logo image u r l of this instance
	*/
	public java.lang.String getLogoImageURL() {
		return _instance.getLogoImageURL();
	}

	/**
	* Sets the logo image u r l of this instance.
	*
	* @param logoImageURL the logo image u r l of this instance
	*/
	public void setLogoImageURL(java.lang.String logoImageURL) {
		_instance.setLogoImageURL(logoImageURL);
	}

	/**
	* Returns the user ID of this instance.
	*
	* @return the user ID of this instance
	*/
	public long getUserId() {
		return _instance.getUserId();
	}

	/**
	* Sets the user ID of this instance.
	*
	* @param userId the user ID of this instance
	*/
	public void setUserId(long userId) {
		_instance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this instance.
	*
	* @return the user uuid of this instance
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instance.getUserUuid();
	}

	/**
	* Sets the user uuid of this instance.
	*
	* @param userUuid the user uuid of this instance
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_instance.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this instance.
	*
	* @return the company ID of this instance
	*/
	public long getCompanyId() {
		return _instance.getCompanyId();
	}

	/**
	* Sets the company ID of this instance.
	*
	* @param companyId the company ID of this instance
	*/
	public void setCompanyId(long companyId) {
		_instance.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this instance.
	*
	* @return the group ID of this instance
	*/
	public long getGroupId() {
		return _instance.getGroupId();
	}

	/**
	* Sets the group ID of this instance.
	*
	* @param groupId the group ID of this instance
	*/
	public void setGroupId(long groupId) {
		_instance.setGroupId(groupId);
	}

	/**
	* Returns the create date of this instance.
	*
	* @return the create date of this instance
	*/
	public java.util.Date getCreateDate() {
		return _instance.getCreateDate();
	}

	/**
	* Sets the create date of this instance.
	*
	* @param createDate the create date of this instance
	*/
	public void setCreateDate(java.util.Date createDate) {
		_instance.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _instance.isNew();
	}

	public void setNew(boolean n) {
		_instance.setNew(n);
	}

	public boolean isCachedModel() {
		return _instance.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_instance.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _instance.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _instance.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_instance.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _instance.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_instance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstanceWrapper((Instance)_instance.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Instance instance) {
		return _instance.compareTo(instance);
	}

	@Override
	public int hashCode() {
		return _instance.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Instance> toCacheModel() {
		return _instance.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Instance toEscapedModel() {
		return new InstanceWrapper(_instance.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _instance.toString();
	}

	public java.lang.String toXmlString() {
		return _instance.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_instance.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Instance getWrappedInstance() {
		return _instance;
	}

	public Instance getWrappedModel() {
		return _instance;
	}

	public void resetOriginalValues() {
		_instance.resetOriginalValues();
	}

	private Instance _instance;
}