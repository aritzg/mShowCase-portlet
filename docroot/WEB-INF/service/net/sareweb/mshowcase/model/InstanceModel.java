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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

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