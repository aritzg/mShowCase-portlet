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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.sareweb.mshowcase.model.InstanceImage;

import java.util.List;

/**
 * The persistence utility for the instance image service. This utility wraps {@link InstanceImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstanceImagePersistence
 * @see InstanceImagePersistenceImpl
 * @generated
 */
public class InstanceImageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(InstanceImage instanceImage) {
		getPersistence().clearCache(instanceImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InstanceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InstanceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InstanceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static InstanceImage remove(InstanceImage instanceImage)
		throws SystemException {
		return getPersistence().remove(instanceImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static InstanceImage update(InstanceImage instanceImage,
		boolean merge) throws SystemException {
		return getPersistence().update(instanceImage, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static InstanceImage update(InstanceImage instanceImage,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(instanceImage, merge, serviceContext);
	}

	/**
	* Caches the instance image in the entity cache if it is enabled.
	*
	* @param instanceImage the instance image
	*/
	public static void cacheResult(
		net.sareweb.mshowcase.model.InstanceImage instanceImage) {
		getPersistence().cacheResult(instanceImage);
	}

	/**
	* Caches the instance images in the entity cache if it is enabled.
	*
	* @param instanceImages the instance images
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.mshowcase.model.InstanceImage> instanceImages) {
		getPersistence().cacheResult(instanceImages);
	}

	/**
	* Creates a new instance image with the primary key. Does not add the instance image to the database.
	*
	* @param InstanceImageId the primary key for the new instance image
	* @return the new instance image
	*/
	public static net.sareweb.mshowcase.model.InstanceImage create(
		long InstanceImageId) {
		return getPersistence().create(InstanceImageId);
	}

	/**
	* Removes the instance image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image that was removed
	* @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.InstanceImage remove(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceImageException {
		return getPersistence().remove(InstanceImageId);
	}

	public static net.sareweb.mshowcase.model.InstanceImage updateImpl(
		net.sareweb.mshowcase.model.InstanceImage instanceImage, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(instanceImage, merge);
	}

	/**
	* Returns the instance image with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceImageException} if it could not be found.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image
	* @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.InstanceImage findByPrimaryKey(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.mshowcase.NoSuchInstanceImageException {
		return getPersistence().findByPrimaryKey(InstanceImageId);
	}

	/**
	* Returns the instance image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InstanceImageId the primary key of the instance image
	* @return the instance image, or <code>null</code> if a instance image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.InstanceImage fetchByPrimaryKey(
		long InstanceImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(InstanceImageId);
	}

	/**
	* Returns all the instance images.
	*
	* @return the instance images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<net.sareweb.mshowcase.model.InstanceImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the instance images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of instance images.
	*
	* @return the number of instance images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InstanceImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InstanceImagePersistence)PortletBeanLocatorUtil.locate(net.sareweb.mshowcase.service.ClpSerializer.getServletContextName(),
					InstanceImagePersistence.class.getName());

			ReferenceRegistry.registerReference(InstanceImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(InstanceImagePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(InstanceImageUtil.class,
			"_persistence");
	}

	private static InstanceImagePersistence _persistence;
}