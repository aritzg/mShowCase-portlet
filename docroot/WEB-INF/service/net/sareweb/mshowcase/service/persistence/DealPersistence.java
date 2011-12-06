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

package net.sareweb.mshowcase.service.persistence;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import net.sareweb.mshowcase.model.Deal;

/**
 * The persistence interface for the deal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see DealPersistenceImpl
 * @see DealUtil
 * @generated
 */
public interface DealPersistence extends BasePersistence<Deal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DealUtil} to access the deal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the deal in the entity cache if it is enabled.
	*
	* @param deal the deal
	*/
	public void cacheResult(net.sareweb.mshowcase.model.Deal deal);

	/**
	* Caches the deals in the entity cache if it is enabled.
	*
	* @param deals the deals
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Deal> deals);

	/**
	* Creates a new deal with the primary key. Does not add the deal to the database.
	*
	* @param dealId the primary key for the new deal
	* @return the new deal
	*/
	public net.sareweb.mshowcase.model.Deal create(long dealId);

	/**
	* Removes the deal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dealId the primary key of the deal
	* @return the deal that was removed
	* @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Deal remove(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchDealException;

	public net.sareweb.mshowcase.model.Deal updateImpl(
		net.sareweb.mshowcase.model.Deal deal, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the deal with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchDealException} if it could not be found.
	*
	* @param dealId the primary key of the deal
	* @return the deal
	* @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Deal findByPrimaryKey(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchDealException;

	/**
	* Returns the deal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dealId the primary key of the deal
	* @return the deal, or <code>null</code> if a deal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Deal fetchByPrimaryKey(long dealId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the deals.
	*
	* @return the deals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Deal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the deals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of deals
	* @param end the upper bound of the range of deals (not inclusive)
	* @return the range of deals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Deal> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the deals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of deals
	* @param end the upper bound of the range of deals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of deals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Deal> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the deals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of deals.
	*
	* @return the number of deals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Deal remove(Deal deal) throws SystemException;
}