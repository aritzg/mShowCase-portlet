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

import net.sareweb.mshowcase.service.InstanceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author Aritz Galdos
 */
public class InstanceClp extends BaseModelImpl<Instance> implements Instance {
	public InstanceClp() {
	}

	public Class<?> getModelClass() {
		return Instance.class;
	}

	public String getModelClassName() {
		return Instance.class.getName();
	}

	public long getPrimaryKey() {
		return _InstanceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInstanceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_InstanceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
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
				String description = descriptionMap.get(locale);

				setDescription(description, locale, defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getWebPage() {
		return _webPage;
	}

	public void setWebPage(String webPage) {
		_webPage = webPage;
	}

	public long getCategoryLevel0() {
		return _categoryLevel0;
	}

	public void setCategoryLevel0(long categoryLevel0) {
		_categoryLevel0 = categoryLevel0;
	}

	public long getCategoryLevel1() {
		return _categoryLevel1;
	}

	public void setCategoryLevel1(long categoryLevel1) {
		_categoryLevel1 = categoryLevel1;
	}

	public long getCategoryLevel2() {
		return _categoryLevel2;
	}

	public void setCategoryLevel2(long categoryLevel2) {
		_categoryLevel2 = categoryLevel2;
	}

	public long getLogoImageId() {
		return _logoImageId;
	}

	public void setLogoImageId(long logoImageId) {
		_logoImageId = logoImageId;
	}

	public String getLogoImageURL() {
		return _logoImageURL;
	}

	public void setLogoImageURL(String logoImageURL) {
		_logoImageURL = logoImageURL;
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public void persist() throws SystemException {
		InstanceLocalServiceUtil.updateInstance(this);
	}

	@Override
	public Instance toEscapedModel() {
		return (Instance)Proxy.newProxyInstance(Instance.class.getClassLoader(),
			new Class[] { Instance.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstanceClp clone = new InstanceClp();

		clone.setInstanceId(getInstanceId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setFaxNumber(getFaxNumber());
		clone.setEmail(getEmail());
		clone.setWebPage(getWebPage());
		clone.setCategoryLevel0(getCategoryLevel0());
		clone.setCategoryLevel1(getCategoryLevel1());
		clone.setCategoryLevel2(getCategoryLevel2());
		clone.setLogoImageId(getLogoImageId());
		clone.setLogoImageURL(getLogoImageURL());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	public int compareTo(Instance instance) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), instance.getCreateDate());

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

		InstanceClp instance = null;

		try {
			instance = (InstanceClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = instance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{InstanceId=");
		sb.append(getInstanceId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", faxNumber=");
		sb.append(getFaxNumber());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", webPage=");
		sb.append(getWebPage());
		sb.append(", categoryLevel0=");
		sb.append(getCategoryLevel0());
		sb.append(", categoryLevel1=");
		sb.append(getCategoryLevel1());
		sb.append(", categoryLevel2=");
		sb.append(getCategoryLevel2());
		sb.append(", logoImageId=");
		sb.append(getLogoImageId());
		sb.append(", logoImageURL=");
		sb.append(getLogoImageURL());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.Instance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faxNumber</column-name><column-value><![CDATA[");
		sb.append(getFaxNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webPage</column-name><column-value><![CDATA[");
		sb.append(getWebPage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryLevel0</column-name><column-value><![CDATA[");
		sb.append(getCategoryLevel0());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryLevel1</column-name><column-value><![CDATA[");
		sb.append(getCategoryLevel1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryLevel2</column-name><column-value><![CDATA[");
		sb.append(getCategoryLevel2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoImageId</column-name><column-value><![CDATA[");
		sb.append(getLogoImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoImageURL</column-name><column-value><![CDATA[");
		sb.append(getLogoImageURL());
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
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _InstanceId;
	private String _name;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _phoneNumber;
	private String _faxNumber;
	private String _email;
	private String _webPage;
	private long _categoryLevel0;
	private long _categoryLevel1;
	private long _categoryLevel2;
	private long _logoImageId;
	private String _logoImageURL;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
}