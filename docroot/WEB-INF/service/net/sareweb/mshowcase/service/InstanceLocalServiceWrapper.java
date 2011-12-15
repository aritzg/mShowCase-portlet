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

package net.sareweb.mshowcase.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link InstanceLocalService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       InstanceLocalService
 * @generated
 */
public class InstanceLocalServiceWrapper implements InstanceLocalService,
	ServiceWrapper<InstanceLocalService> {
	public InstanceLocalServiceWrapper(
		InstanceLocalService instanceLocalService) {
		_instanceLocalService = instanceLocalService;
	}

	/**
	* Adds the instance to the database. Also notifies the appropriate model listeners.
	*
	* @param instance the instance
	* @return the instance that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance addInstance(
		net.sareweb.mshowcase.model.Instance instance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.addInstance(instance);
	}

	/**
	* Creates a new instance with the primary key. Does not add the instance to the database.
	*
	* @param InstanceId the primary key for the new instance
	* @return the new instance
	*/
	public net.sareweb.mshowcase.model.Instance createInstance(long InstanceId) {
		return _instanceLocalService.createInstance(InstanceId);
	}

	/**
	* Deletes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InstanceId the primary key of the instance
	* @throws PortalException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteInstance(long InstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_instanceLocalService.deleteInstance(InstanceId);
	}

	/**
	* Deletes the instance from the database. Also notifies the appropriate model listeners.
	*
	* @param instance the instance
	* @throws SystemException if a system exception occurred
	*/
	public void deleteInstance(net.sareweb.mshowcase.model.Instance instance)
		throws com.liferay.portal.kernel.exception.SystemException {
		_instanceLocalService.deleteInstance(instance);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.sareweb.mshowcase.model.Instance fetchInstance(long InstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.fetchInstance(InstanceId);
	}

	/**
	* Returns the instance with the primary key.
	*
	* @param InstanceId the primary key of the instance
	* @return the instance
	* @throws PortalException if a instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance getInstance(long InstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.getInstance(InstanceId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of instances
	* @param end the upper bound of the range of instances (not inclusive)
	* @return the range of instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.mshowcase.model.Instance> getInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.getInstances(start, end);
	}

	/**
	* Returns the number of instances.
	*
	* @return the number of instances
	* @throws SystemException if a system exception occurred
	*/
	public int getInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.getInstancesCount();
	}

	/**
	* Updates the instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instance the instance
	* @return the instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance updateInstance(
		net.sareweb.mshowcase.model.Instance instance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.updateInstance(instance);
	}

	/**
	* Updates the instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param instance the instance
	* @param merge whether to merge the instance with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.mshowcase.model.Instance updateInstance(
		net.sareweb.mshowcase.model.Instance instance, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _instanceLocalService.updateInstance(instance, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _instanceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_instanceLocalService.setBeanIdentifier(beanIdentifier);
	}

	public net.sareweb.mshowcase.model.Instance getInstanceByUserId(long userId) {
		return _instanceLocalService.getInstanceByUserId(userId);
	}

	public java.util.List<net.sareweb.mshowcase.model.Instance> getInstancesInCategory(
		long categoryId) {
		return _instanceLocalService.getInstancesInCategory(categoryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InstanceLocalService getWrappedInstanceLocalService() {
		return _instanceLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInstanceLocalService(
		InstanceLocalService instanceLocalService) {
		_instanceLocalService = instanceLocalService;
	}

	public InstanceLocalService getWrappedService() {
		return _instanceLocalService;
	}

	public void setWrappedService(InstanceLocalService instanceLocalService) {
		_instanceLocalService = instanceLocalService;
	}

	private InstanceLocalService _instanceLocalService;
}