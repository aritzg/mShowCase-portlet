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
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Category
 * @generated
 */
public class CategoryWrapper implements Category {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	public Class<?> getModelClass() {
		return Category.class;
	}

	public String getModelClassName() {
		return Category.class.getName();
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Returns the parent category ID of this category.
	*
	* @return the parent category ID of this category
	*/
	public long getParentCategoryId() {
		return _category.getParentCategoryId();
	}

	/**
	* Sets the parent category ID of this category.
	*
	* @param parentCategoryId the parent category ID of this category
	*/
	public void setParentCategoryId(long parentCategoryId) {
		_category.setParentCategoryId(parentCategoryId);
	}

	/**
	* Returns the name of this category.
	*
	* @return the name of this category
	*/
	public java.lang.String getName() {
		return _category.getName();
	}

	/**
	* Returns the localized name of this category in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this category
	*/
	public java.lang.String getName(java.util.Locale locale) {
		return _category.getName(locale);
	}

	/**
	* Returns the localized name of this category in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _category.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this category in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this category
	*/
	public java.lang.String getName(java.lang.String languageId) {
		return _category.getName(languageId);
	}

	/**
	* Returns the localized name of this category in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this category
	*/
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _category.getName(languageId, useDefault);
	}

	public java.lang.String getNameCurrentLanguageId() {
		return _category.getNameCurrentLanguageId();
	}

	public java.lang.String getNameCurrentValue() {
		return _category.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this category.
	*
	* @return the locales and localized names of this category
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _category.getNameMap();
	}

	/**
	* Sets the name of this category.
	*
	* @param name the name of this category
	*/
	public void setName(java.lang.String name) {
		_category.setName(name);
	}

	/**
	* Sets the localized name of this category in the language.
	*
	* @param name the localized name of this category
	* @param locale the locale of the language
	*/
	public void setName(java.lang.String name, java.util.Locale locale) {
		_category.setName(name, locale);
	}

	/**
	* Sets the localized name of this category in the language, and sets the default locale.
	*
	* @param name the localized name of this category
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_category.setName(name, locale, defaultLocale);
	}

	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_category.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this category from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this category
	*/
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_category.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this category from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this category
	* @param defaultLocale the default locale
	*/
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_category.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the position of this category.
	*
	* @return the position of this category
	*/
	public int getPosition() {
		return _category.getPosition();
	}

	/**
	* Sets the position of this category.
	*
	* @param position the position of this category
	*/
	public void setPosition(int position) {
		_category.setPosition(position);
	}

	/**
	* Returns the user ID of this category.
	*
	* @return the user ID of this category
	*/
	public long getUserId() {
		return _category.getUserId();
	}

	/**
	* Sets the user ID of this category.
	*
	* @param userId the user ID of this category
	*/
	public void setUserId(long userId) {
		_category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this category.
	*
	* @return the user uuid of this category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _category.getUserUuid();
	}

	/**
	* Sets the user uuid of this category.
	*
	* @param userUuid the user uuid of this category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_category.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this category.
	*
	* @return the company ID of this category
	*/
	public long getCompanyId() {
		return _category.getCompanyId();
	}

	/**
	* Sets the company ID of this category.
	*
	* @param companyId the company ID of this category
	*/
	public void setCompanyId(long companyId) {
		_category.setCompanyId(companyId);
	}

	public boolean isNew() {
		return _category.isNew();
	}

	public void setNew(boolean n) {
		_category.setNew(n);
	}

	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_category.persist();
	}

	public Category getWrappedCategory() {
		return _category;
	}

	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private Category _category;
}