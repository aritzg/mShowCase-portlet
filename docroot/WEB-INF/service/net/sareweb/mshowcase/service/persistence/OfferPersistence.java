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

import net.sareweb.mshowcase.model.Offer;

/**
 * The persistence interface for the offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see OfferPersistenceImpl
 * @see OfferUtil
 * @generated
 */
public interface OfferPersistence extends BasePersistence<Offer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfferUtil} to access the offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the offer in the entity cache if it is enabled.
	*
	* @param offer the offer
	*/
	public void cacheResult(net.sareweb.mshowcase.model.Offer offer);

	/**
	* Caches the offers in the entity cache if it is enabled.
	*
	* @param offers the offers
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.Offer> offers);

	/**
	* Creates a new offer with the primary key. Does not add the offer to the database.
	*
	* @param offerId the primary key for the new offer
	* @return the new offer
	*/
	public net.sareweb.mshowcase.model.Offer create(long offerId);

	/**
	* Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param offerId the primary key of the offer
	* @return the offer that was removed
	* @throws net.sareweb.mshowcase.NoSuchOfferException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Offer remove(long offerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchOfferException;

	public net.sareweb.mshowcase.model.Offer updateImpl(
		net.sareweb.mshowcase.model.Offer offer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the offer with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchOfferException} if it could not be found.
	*
	* @param offerId the primary key of the offer
	* @return the offer
	* @throws net.sareweb.mshowcase.NoSuchOfferException if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Offer findByPrimaryKey(long offerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchOfferException;

	/**
	* Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param offerId the primary key of the offer
	* @return the offer, or <code>null</code> if a offer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Offer fetchByPrimaryKey(long offerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the offers.
	*
	* @return the offers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Offer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the offers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of offers
	* @param end the upper bound of the range of offers (not inclusive)
	* @return the range of offers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Offer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the offers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of offers
	* @param end the upper bound of the range of offers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of offers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Offer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the offers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of offers.
	*
	* @return the number of offers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Offer remove(Offer offer) throws SystemException;
}