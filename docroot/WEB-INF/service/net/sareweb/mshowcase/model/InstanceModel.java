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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Instance service. Represents a row in the &quot;msc_Instance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.mshowcase.model.impl.InstanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.mshowcase.model.impl.InstanceImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see Instance
 * @see net.sareweb.mshowcase.model.impl.InstanceImpl
 * @see net.sareweb.mshowcase.model.impl.InstanceModelImpl
 * @generated
 */
public interface InstanceModel extends BaseModel<Instance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a instance model instance should use the {@link Instance} interface instead.
	 */

	/**
	 * Returns the primary key of this instance.
	 *
	 * @return the primary key of this instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this instance.
	 *
	 * @param primaryKey the primary key of this instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the instance ID of this instance.
	 *
	 * @return the instance ID of this instance
	 */
	public long getInstanceId();

	/**
	 * Sets the instance ID of this instance.
	 *
	 * @param InstanceId the instance ID of this instance
	 */
	public void setInstanceId(long InstanceId);

	/**
	 * Returns the name of this instance.
	 *
	 * @return the name of this instance
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this instance.
	 *
	 * @param name the name of this instance
	 */
	public void setName(String name);

	/**
	 * Returns the description of this instance.
	 *
	 * @return the description of this instance
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this instance
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this instance
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this instance
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this instance.
	 *
	 * @return the locales and localized descriptions of this instance
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this instance.
	 *
	 * @param description the description of this instance
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this instance in the language.
	 *
	 * @param description the localized description of this instance
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this instance in the language, and sets the default locale.
	 *
	 * @param description the localized description of this instance
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this instance from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this instance
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this instance from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this instance
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the phone number of this instance.
	 *
	 * @return the phone number of this instance
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this instance.
	 *
	 * @param phoneNumber the phone number of this instance
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the fax number of this instance.
	 *
	 * @return the fax number of this instance
	 */
	@AutoEscape
	public String getFaxNumber();

	/**
	 * Sets the fax number of this instance.
	 *
	 * @param faxNumber the fax number of this instance
	 */
	public void setFaxNumber(String faxNumber);

	/**
	 * Returns the email of this instance.
	 *
	 * @return the email of this instance
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this instance.
	 *
	 * @param email the email of this instance
	 */
	public void setEmail(String email);

	/**
	 * Returns the web page of this instance.
	 *
	 * @return the web page of this instance
	 */
	@AutoEscape
	public String getWebPage();

	/**
	 * Sets the web page of this instance.
	 *
	 * @param webPage the web page of this instance
	 */
	public void setWebPage(String webPage);

	/**
	 * Returns the category level0 of this instance.
	 *
	 * @return the category level0 of this instance
	 */
	public long getCategoryLevel0();

	/**
	 * Sets the category level0 of this instance.
	 *
	 * @param categoryLevel0 the category level0 of this instance
	 */
	public void setCategoryLevel0(long categoryLevel0);

	/**
	 * Returns the category level1 of this instance.
	 *
	 * @return the category level1 of this instance
	 */
	public long getCategoryLevel1();

	/**
	 * Sets the category level1 of this instance.
	 *
	 * @param categoryLevel1 the category level1 of this instance
	 */
	public void setCategoryLevel1(long categoryLevel1);

	/**
	 * Returns the category level2 of this instance.
	 *
	 * @return the category level2 of this instance
	 */
	public long getCategoryLevel2();

	/**
	 * Sets the category level2 of this instance.
	 *
	 * @param categoryLevel2 the category level2 of this instance
	 */
	public void setCategoryLevel2(long categoryLevel2);

	/**
	 * Returns the logo image ID of this instance.
	 *
	 * @return the logo image ID of this instance
	 */
	public long getLogoImageId();

	/**
	 * Sets the logo image ID of this instance.
	 *
	 * @param logoImageId the logo image ID of this instance
	 */
	public void setLogoImageId(long logoImageId);

	/**
	 * Returns the logo image u r l of this instance.
	 *
	 * @return the logo image u r l of this instance
	 */
	@AutoEscape
	public String getLogoImageURL();

	/**
	 * Sets the logo image u r l of this instance.
	 *
	 * @param logoImageURL the logo image u r l of this instance
	 */
	public void setLogoImageURL(String logoImageURL);

	/**
	 * Returns the user ID of this instance.
	 *
	 * @return the user ID of this instance
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this instance.
	 *
	 * @param userId the user ID of this instance
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this instance.
	 *
	 * @return the user uuid of this instance
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this instance.
	 *
	 * @param userUuid the user uuid of this instance
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the company ID of this instance.
	 *
	 * @return the company ID of this instance
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this instance.
	 *
	 * @param companyId the company ID of this instance
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this instance.
	 *
	 * @return the group ID of this instance
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this instance.
	 *
	 * @param groupId the group ID of this instance
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this instance.
	 *
	 * @return the create date of this instance
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this instance.
	 *
	 * @param createDate the create date of this instance
	 */
	public void setCreateDate(Date createDate);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Instance instance);

	public int hashCode();

	public CacheModel<Instance> toCacheModel();

	public Instance toEscapedModel();

	public String toString();

	public String toXmlString();
}