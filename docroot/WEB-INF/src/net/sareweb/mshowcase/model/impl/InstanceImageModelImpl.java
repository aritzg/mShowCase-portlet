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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.sareweb.mshowcase.model.InstanceImage;
import net.sareweb.mshowcase.model.InstanceImageModel;
import net.sareweb.mshowcase.model.InstanceImageSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the InstanceImage service. Represents a row in the &quot;msc_InstanceImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.sareweb.mshowcase.model.InstanceImageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InstanceImageImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see InstanceImageImpl
 * @see net.sareweb.mshowcase.model.InstanceImage
 * @see net.sareweb.mshowcase.model.InstanceImageModel
 * @generated
 */
@JSON(strict = true)
public class InstanceImageModelImpl extends BaseModelImpl<InstanceImage>
	implements InstanceImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a instance image model instance should use the {@link net.sareweb.mshowcase.model.InstanceImage} interface instead.
	 */
	public static final String TABLE_NAME = "msc_InstanceImage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "InstanceImageId", Types.BIGINT },
			{ "InstanceId", Types.BIGINT },
			{ "imageId", Types.BIGINT },
			{ "imageURL", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table msc_InstanceImage (InstanceImageId LONG not null primary key,InstanceId LONG,imageId LONG,imageURL VARCHAR(75) null,userId LONG,companyId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table msc_InstanceImage";
	public static final String ORDER_BY_JPQL = " ORDER BY instanceImage.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY msc_InstanceImage.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.sareweb.mshowcase.model.InstanceImage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.sareweb.mshowcase.model.InstanceImage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static InstanceImage toModel(InstanceImageSoap soapModel) {
		InstanceImage model = new InstanceImageImpl();

		model.setInstanceImageId(soapModel.getInstanceImageId());
		model.setInstanceId(soapModel.getInstanceId());
		model.setImageId(soapModel.getImageId());
		model.setImageURL(soapModel.getImageURL());
		model.setUserId(soapModel.getUserId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<InstanceImage> toModels(InstanceImageSoap[] soapModels) {
		List<InstanceImage> models = new ArrayList<InstanceImage>(soapModels.length);

		for (InstanceImageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.sareweb.mshowcase.model.InstanceImage"));

	public InstanceImageModelImpl() {
	}

	public long getPrimaryKey() {
		return _InstanceImageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInstanceImageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_InstanceImageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return InstanceImage.class;
	}

	public String getModelClassName() {
		return InstanceImage.class.getName();
	}

	@JSON
	public long getInstanceImageId() {
		return _InstanceImageId;
	}

	public void setInstanceImageId(long InstanceImageId) {
		_InstanceImageId = InstanceImageId;
	}

	@JSON
	public long getInstanceId() {
		return _InstanceId;
	}

	public void setInstanceId(long InstanceId) {
		_InstanceId = InstanceId;
	}

	@JSON
	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	@JSON
	public String getImageURL() {
		if (_imageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageURL;
		}
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	@JSON
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

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public InstanceImage toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (InstanceImage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					InstanceImage.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		InstanceImageImpl instanceImageImpl = new InstanceImageImpl();

		instanceImageImpl.setInstanceImageId(getInstanceImageId());
		instanceImageImpl.setInstanceId(getInstanceId());
		instanceImageImpl.setImageId(getImageId());
		instanceImageImpl.setImageURL(getImageURL());
		instanceImageImpl.setUserId(getUserId());
		instanceImageImpl.setCompanyId(getCompanyId());
		instanceImageImpl.setCreateDate(getCreateDate());

		instanceImageImpl.resetOriginalValues();

		return instanceImageImpl;
	}

	public int compareTo(InstanceImage instanceImage) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				instanceImage.getCreateDate());

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

		InstanceImage instanceImage = null;

		try {
			instanceImage = (InstanceImage)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = instanceImage.getPrimaryKey();

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<InstanceImage> toCacheModel() {
		InstanceImageCacheModel instanceImageCacheModel = new InstanceImageCacheModel();

		instanceImageCacheModel.InstanceImageId = getInstanceImageId();

		instanceImageCacheModel.InstanceId = getInstanceId();

		instanceImageCacheModel.imageId = getImageId();

		instanceImageCacheModel.imageURL = getImageURL();

		String imageURL = instanceImageCacheModel.imageURL;

		if ((imageURL != null) && (imageURL.length() == 0)) {
			instanceImageCacheModel.imageURL = null;
		}

		instanceImageCacheModel.userId = getUserId();

		instanceImageCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			instanceImageCacheModel.createDate = createDate.getTime();
		}
		else {
			instanceImageCacheModel.createDate = Long.MIN_VALUE;
		}

		return instanceImageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{InstanceImageId=");
		sb.append(getInstanceImageId());
		sb.append(", InstanceId=");
		sb.append(getInstanceId());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.mshowcase.model.InstanceImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InstanceImageId</column-name><column-value><![CDATA[");
		sb.append(getInstanceImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>InstanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = InstanceImage.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			InstanceImage.class
		};
	private long _InstanceImageId;
	private long _InstanceId;
	private long _imageId;
	private String _imageURL;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private Date _createDate;
	private transient ExpandoBridge _expandoBridge;
	private InstanceImage _escapedModelProxy;
}