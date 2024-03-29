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
 * The base model interface for the Deal service. Represents a row in the &quot;msc_Deal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.mshowcase.model.impl.DealModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.mshowcase.model.impl.DealImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see Deal
 * @see net.sareweb.mshowcase.model.impl.DealImpl
 * @see net.sareweb.mshowcase.model.impl.DealModelImpl
 * @generated
 */
public interface DealModel extends BaseModel<Deal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a deal model instance should use the {@link Deal} interface instead.
	 */

	/**
	 * Returns the primary key of this deal.
	 *
	 * @return the primary key of this deal
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this deal.
	 *
	 * @param primaryKey the primary key of this deal
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the deal ID of this deal.
	 *
	 * @return the deal ID of this deal
	 */
	public long getDealId();

	/**
	 * Sets the deal ID of this deal.
	 *
	 * @param dealId the deal ID of this deal
	 */
	public void setDealId(long dealId);

	/**
	 * Returns the user ID of this deal.
	 *
	 * @return the user ID of this deal
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this deal.
	 *
	 * @param userId the user ID of this deal
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this deal.
	 *
	 * @return the user uuid of this deal
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this deal.
	 *
	 * @param userUuid the user uuid of this deal
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the offer ID of this deal.
	 *
	 * @return the offer ID of this deal
	 */
	public long getOfferId();

	/**
	 * Sets the offer ID of this deal.
	 *
	 * @param offerId the offer ID of this deal
	 */
	public void setOfferId(long offerId);

	/**
	 * Returns the instance ID of this deal.
	 *
	 * @return the instance ID of this deal
	 */
	public long getInstanceId();

	/**
	 * Sets the instance ID of this deal.
	 *
	 * @param InstanceId the instance ID of this deal
	 */
	public void setInstanceId(long InstanceId);

	/**
	 * Returns the company ID of this deal.
	 *
	 * @return the company ID of this deal
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this deal.
	 *
	 * @param companyId the company ID of this deal
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this deal.
	 *
	 * @return the create date of this deal
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this deal.
	 *
	 * @param createDate the create date of this deal
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

	public int compareTo(Deal deal);

	public int hashCode();

	public CacheModel<Deal> toCacheModel();

	public Deal toEscapedModel();

	public String toString();

	public String toXmlString();
}