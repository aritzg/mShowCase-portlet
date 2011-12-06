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

import net.sareweb.mshowcase.model.InstanceImage;

/**
 * The persistence interface for the instance image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstanceImagePersistenceImpl
 * @see InstanceImageUtil
 * @generated
 */
public interface InstanceImagePersistence extends BasePersistence<InstanceImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstanceImageUtil} to access the instance image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the instance image in the entity cache if it is enabled.
	*
	* @param instanceImage the instance image
	*/
	public void cacheResult(
		net.sareweb.mshowcase.model.InstanceImage instanceImage);

	/**
	* Caches the instance images in the entity cache if it is enabled.
	*
	* @param instanceImages the instance images
	*/
	public void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.InstanceImage> instanceImages);

	/**
	* Creates a new instance image with the primary key. Does not add the instance image to the database.
	*
	* @param InstanceImageId the primary key for the new instance image
	* @return the new instance image
	*/
	public net.sareweb.mshowcase.model.InstanceImage create(
		long InstanceImageId);

	/**
	* Removes the instance image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image that was removed
	* @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.InstanceImage remove(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceImageException;

	public net.sareweb.mshowcase.model.InstanceImage updateImpl(
		net.sareweb.mshowcase.model.InstanceImage instanceImage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the instance image with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceImageException} if it could not be found.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image
	* @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.InstanceImage findByPrimaryKey(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceImageException;

	/**
	* Returns the instance image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image, or <code>null</code> if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.InstanceImage fetchByPrimaryKey(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the instance images.
	*
	* @return the instance images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the instance images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instance images
	* @param end the upper bound of the range of instance images (not inclusive)
	* @return the range of instance images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the instance images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instance images
	* @param end the upper bound of the range of instance images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of instance images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the instance images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of instance images.
	*
	* @return the number of instance images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public InstanceImage remove(InstanceImage instanceImage)
		throws SystemException;
}