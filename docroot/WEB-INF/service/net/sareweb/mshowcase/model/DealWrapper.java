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
 * This class is a wrapper for {@link Deal}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       Deal
 * @generated
 */
public class DealWrapper implements Deal {
	public DealWrapper(Deal deal) {
		_deal = deal;
	}

	public Class<?> getModelClass() {
		return Deal.class;
	}

	public String getModelClassName() {
		return Deal.class.getName();
	}

	/**
	* Returns the primary key of this deal.
	*
	* @return the primary key of this deal
	*/
	public long getPrimaryKey() {
		return _deal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this deal.
	*
	* @param primaryKey the primary key of this deal
	*/
	public void setPrimaryKey(long primaryKey) {
		_deal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the deal ID of this deal.
	*
	* @return the deal ID of this deal
	*/
	public long getDealId() {
		return _deal.getDealId();
	}

	/**
	* Sets the deal ID of this deal.
	*
	* @param dealId the deal ID of this deal
	*/
	public void setDealId(long dealId) {
		_deal.setDealId(dealId);
	}

	/**
	* Returns the user ID of this deal.
	*
	* @return the user ID of this deal
	*/
	public long getUserId() {
		return _deal.getUserId();
	}

	/**
	* Sets the user ID of this deal.
	*
	* @param userId the user ID of this deal
	*/
	public void setUserId(long userId) {
		_deal.setUserId(userId);
	}

	/**
	* Returns the user uuid of this deal.
	*
	* @return the user uuid of this deal
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deal.getUserUuid();
	}

	/**
	* Sets the user uuid of this deal.
	*
	* @param userUuid the user uuid of this deal
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_deal.setUserUuid(userUuid);
	}

	/**
	* Returns the offer ID of this deal.
	*
	* @return the offer ID of this deal
	*/
	public long getOfferId() {
		return _deal.getOfferId();
	}

	/**
	* Sets the offer ID of this deal.
	*
	* @param offerId the offer ID of this deal
	*/
	public void setOfferId(long offerId) {
		_deal.setOfferId(offerId);
	}

	/**
	* Returns the company ID of this deal.
	*
	* @return the company ID of this deal
	*/
	public long getCompanyId() {
		return _deal.getCompanyId();
	}

	/**
	* Sets the company ID of this deal.
	*
	* @param companyId the company ID of this deal
	*/
	public void setCompanyId(long companyId) {
		_deal.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this deal.
	*
	* @return the create date of this deal
	*/
	public java.util.Date getCreateDate() {
		return _deal.getCreateDate();
	}

	/**
	* Sets the create date of this deal.
	*
	* @param createDate the create date of this deal
	*/
	public void setCreateDate(java.util.Date createDate) {
		_deal.setCreateDate(createDate);
	}

	public boolean isNew() {
		return _deal.isNew();
	}

	public void setNew(boolean n) {
		_deal.setNew(n);
	}

	public boolean isCachedModel() {
		return _deal.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_deal.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _deal.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _deal.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_deal.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _deal.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_deal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DealWrapper((Deal)_deal.clone());
	}

	public int compareTo(net.sareweb.mshowcase.model.Deal deal) {
		return _deal.compareTo(deal);
	}

	@Override
	public int hashCode() {
		return _deal.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.mshowcase.model.Deal> toCacheModel() {
		return _deal.toCacheModel();
	}

	public net.sareweb.mshowcase.model.Deal toEscapedModel() {
		return new DealWrapper(_deal.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _deal.toString();
	}

	public java.lang.String toXmlString() {
		return _deal.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_deal.persist();
	}

	public Deal getWrappedDeal() {
		return _deal;
	}

	public void resetOriginalValues() {
		_deal.resetOriginalValues();
	}

	private Deal _deal;
}