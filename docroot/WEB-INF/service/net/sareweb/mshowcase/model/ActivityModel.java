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

/**
 * The base model interface for the Activity service. Represents a row in the &quot;msc_Activity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.mshowcase.model.impl.ActivityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.mshowcase.model.impl.ActivityImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see Activity
 * @see net.sareweb.mshowcase.model.impl.ActivityImpl
 * @see net.sareweb.mshowcase.model.impl.ActivityModelImpl
 * @generated
 */
public interface ActivityModel extends BaseModel<Activity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a activity model instance should use the {@link Activity} interface instead.
	 */

	/**
	 * Returns the primary key of this activity.
	 *
	 * @return the primary key of this activity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this activity.
	 *
	 * @param primaryKey the primary key of this activity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the activity ID of this activity.
	 *
	 * @return the activity ID of this activity
	 */
	public long getActivityId();

	/**
	 * Sets the activity ID of this activity.
	 *
	 * @param activityId the activity ID of this activity
	 */
	public void setActivityId(long activityId);

	/**
	 * Returns the type of this activity.
	 *
	 * @return the type of this activity
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this activity.
	 *
	 * @param type the type of this activity
	 */
	public void setType(String type);

	/**
	 * Returns the user ID of this activity.
	 *
	 * @return the user ID of this activity
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this activity.
	 *
	 * @param userId the user ID of this activity
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this activity.
	 *
	 * @return the user uuid of this activity
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this activity.
	 *
	 * @param userUuid the user uuid of this activity
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user2 ID of this activity.
	 *
	 * @return the user2 ID of this activity
	 */
	public long getUser2Id();

	/**
	 * Sets the user2 ID of this activity.
	 *
	 * @param user2Id the user2 ID of this activity
	 */
	public void setUser2Id(long user2Id);

	/**
	 * Returns the instance ID of this activity.
	 *
	 * @return the instance ID of this activity
	 */
	public long getInstanceId();

	/**
	 * Sets the instance ID of this activity.
	 *
	 * @param InstanceId the instance ID of this activity
	 */
	public void setInstanceId(long InstanceId);

	/**
	 * Returns the offer ID of this activity.
	 *
	 * @return the offer ID of this activity
	 */
	public long getOfferId();

	/**
	 * Sets the offer ID of this activity.
	 *
	 * @param offerId the offer ID of this activity
	 */
	public void setOfferId(long offerId);

	/**
	 * Returns the company ID of this activity.
	 *
	 * @return the company ID of this activity
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this activity.
	 *
	 * @param companyId the company ID of this activity
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this activity.
	 *
	 * @return the create date of this activity
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this activity.
	 *
	 * @param createDate the create date of this activity
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

	public int compareTo(Activity activity);

	public int hashCode();

	public CacheModel<Activity> toCacheModel();

	public Activity toEscapedModel();

	public String toString();

	public String toXmlString();
}