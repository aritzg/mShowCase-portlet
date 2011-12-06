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

package net.sareweb.mshowcase.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.sareweb.mshowcase.model.Instance;
import net.sareweb.mshowcase.service.ActivityLocalService;
import net.sareweb.mshowcase.service.ActivityService;
import net.sareweb.mshowcase.service.CategoryLocalService;
import net.sareweb.mshowcase.service.CategoryService;
import net.sareweb.mshowcase.service.DealLocalService;
import net.sareweb.mshowcase.service.DealService;
import net.sareweb.mshowcase.service.FriendshipLocalService;
import net.sareweb.mshowcase.service.FriendshipService;
import net.sareweb.mshowcase.service.InstanceImageLocalService;
import net.sareweb.mshowcase.service.InstanceImageService;
import net.sareweb.mshowcase.service.InstanceLocalService;
import net.sareweb.mshowcase.service.InstanceService;
import net.sareweb.mshowcase.service.LocationLocalService;
import net.sareweb.mshowcase.service.LocationService;
import net.sareweb.mshowcase.service.OfferLocalService;
import net.sareweb.mshowcase.service.OfferService;
import net.sareweb.mshowcase.service.persistence.ActivityPersistence;
import net.sareweb.mshowcase.service.persistence.CategoryPersistence;
import net.sareweb.mshowcase.service.persistence.DealPersistence;
import net.sareweb.mshowcase.service.persistence.FriendshipPersistence;
import net.sareweb.mshowcase.service.persistence.InstanceImagePersistence;
import net.sareweb.mshowcase.service.persistence.InstancePersistence;
import net.sareweb.mshowcase.service.persistence.LocationPersistence;
import net.sareweb.mshowcase.service.persistence.OfferPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the instance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.sareweb.mshowcase.service.impl.InstanceLocalServiceImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see net.sareweb.mshowcase.service.impl.InstanceLocalServiceImpl
 * @see net.sareweb.mshowcase.service.InstanceLocalServiceUtil
 * @generated
 */
public abstract class InstanceLocalServiceBaseImpl
	implements InstanceLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link net.sareweb.mshowcase.service.InstanceLocalServiceUtil} to access the instance local service.
	 */

	/**
	 * Adds the instance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param instance the instance
	 * @return the instance that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Instance addInstance(Instance instance) throws SystemException {
		instance.setNew(true);

		instance = instancePersistence.update(instance, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(instance);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return instance;
	}

	/**
	 * Creates a new instance with the primary key. Does not add the instance to the database.
	 *
	 * @param InstanceId the primary key for the new instance
	 * @return the new instance
	 */
	public Instance createInstance(long InstanceId) {
		return instancePersistence.create(InstanceId);
	}

	/**
	 * Deletes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InstanceId the primary key of the instance
	 * @throws PortalException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteInstance(long InstanceId)
		throws PortalException, SystemException {
		Instance instance = instancePersistence.remove(InstanceId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(instance);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instance the instance
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteInstance(Instance instance) throws SystemException {
		instancePersistence.remove(instance);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(instance);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return instancePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return instancePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return instancePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return instancePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the instance with the primary key.
	 *
	 * @param InstanceId the primary key of the instance
	 * @return the instance
	 * @throws PortalException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance getInstance(long InstanceId)
		throws PortalException, SystemException {
		return instancePersistence.findByPrimaryKey(InstanceId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return instancePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Instance> getInstances(int start, int end)
		throws SystemException {
		return instancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of instances.
	 *
	 * @return the number of instances
	 * @throws SystemException if a system exception occurred
	 */
	public int getInstancesCount() throws SystemException {
		return instancePersistence.countAll();
	}

	/**
	 * Updates the instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instance the instance
	 * @return the instance that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Instance updateInstance(Instance instance) throws SystemException {
		return updateInstance(instance, true);
	}

	/**
	 * Updates the instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param instance the instance
	 * @param merge whether to merge the instance with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the instance that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Instance updateInstance(Instance instance, boolean merge)
		throws SystemException {
		instance.setNew(false);

		instance = instancePersistence.update(instance, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(instance);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return instance;
	}

	/**
	 * Returns the activity local service.
	 *
	 * @return the activity local service
	 */
	public ActivityLocalService getActivityLocalService() {
		return activityLocalService;
	}

	/**
	 * Sets the activity local service.
	 *
	 * @param activityLocalService the activity local service
	 */
	public void setActivityLocalService(
		ActivityLocalService activityLocalService) {
		this.activityLocalService = activityLocalService;
	}

	/**
	 * Returns the activity remote service.
	 *
	 * @return the activity remote service
	 */
	public ActivityService getActivityService() {
		return activityService;
	}

	/**
	 * Sets the activity remote service.
	 *
	 * @param activityService the activity remote service
	 */
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	/**
	 * Returns the activity persistence.
	 *
	 * @return the activity persistence
	 */
	public ActivityPersistence getActivityPersistence() {
		return activityPersistence;
	}

	/**
	 * Sets the activity persistence.
	 *
	 * @param activityPersistence the activity persistence
	 */
	public void setActivityPersistence(ActivityPersistence activityPersistence) {
		this.activityPersistence = activityPersistence;
	}

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the deal local service.
	 *
	 * @return the deal local service
	 */
	public DealLocalService getDealLocalService() {
		return dealLocalService;
	}

	/**
	 * Sets the deal local service.
	 *
	 * @param dealLocalService the deal local service
	 */
	public void setDealLocalService(DealLocalService dealLocalService) {
		this.dealLocalService = dealLocalService;
	}

	/**
	 * Returns the deal remote service.
	 *
	 * @return the deal remote service
	 */
	public DealService getDealService() {
		return dealService;
	}

	/**
	 * Sets the deal remote service.
	 *
	 * @param dealService the deal remote service
	 */
	public void setDealService(DealService dealService) {
		this.dealService = dealService;
	}

	/**
	 * Returns the deal persistence.
	 *
	 * @return the deal persistence
	 */
	public DealPersistence getDealPersistence() {
		return dealPersistence;
	}

	/**
	 * Sets the deal persistence.
	 *
	 * @param dealPersistence the deal persistence
	 */
	public void setDealPersistence(DealPersistence dealPersistence) {
		this.dealPersistence = dealPersistence;
	}

	/**
	 * Returns the friendship local service.
	 *
	 * @return the friendship local service
	 */
	public FriendshipLocalService getFriendshipLocalService() {
		return friendshipLocalService;
	}

	/**
	 * Sets the friendship local service.
	 *
	 * @param friendshipLocalService the friendship local service
	 */
	public void setFriendshipLocalService(
		FriendshipLocalService friendshipLocalService) {
		this.friendshipLocalService = friendshipLocalService;
	}

	/**
	 * Returns the friendship remote service.
	 *
	 * @return the friendship remote service
	 */
	public FriendshipService getFriendshipService() {
		return friendshipService;
	}

	/**
	 * Sets the friendship remote service.
	 *
	 * @param friendshipService the friendship remote service
	 */
	public void setFriendshipService(FriendshipService friendshipService) {
		this.friendshipService = friendshipService;
	}

	/**
	 * Returns the friendship persistence.
	 *
	 * @return the friendship persistence
	 */
	public FriendshipPersistence getFriendshipPersistence() {
		return friendshipPersistence;
	}

	/**
	 * Sets the friendship persistence.
	 *
	 * @param friendshipPersistence the friendship persistence
	 */
	public void setFriendshipPersistence(
		FriendshipPersistence friendshipPersistence) {
		this.friendshipPersistence = friendshipPersistence;
	}

	/**
	 * Returns the instance local service.
	 *
	 * @return the instance local service
	 */
	public InstanceLocalService getInstanceLocalService() {
		return instanceLocalService;
	}

	/**
	 * Sets the instance local service.
	 *
	 * @param instanceLocalService the instance local service
	 */
	public void setInstanceLocalService(
		InstanceLocalService instanceLocalService) {
		this.instanceLocalService = instanceLocalService;
	}

	/**
	 * Returns the instance remote service.
	 *
	 * @return the instance remote service
	 */
	public InstanceService getInstanceService() {
		return instanceService;
	}

	/**
	 * Sets the instance remote service.
	 *
	 * @param instanceService the instance remote service
	 */
	public void setInstanceService(InstanceService instanceService) {
		this.instanceService = instanceService;
	}

	/**
	 * Returns the instance persistence.
	 *
	 * @return the instance persistence
	 */
	public InstancePersistence getInstancePersistence() {
		return instancePersistence;
	}

	/**
	 * Sets the instance persistence.
	 *
	 * @param instancePersistence the instance persistence
	 */
	public void setInstancePersistence(InstancePersistence instancePersistence) {
		this.instancePersistence = instancePersistence;
	}

	/**
	 * Returns the instance image local service.
	 *
	 * @return the instance image local service
	 */
	public InstanceImageLocalService getInstanceImageLocalService() {
		return instanceImageLocalService;
	}

	/**
	 * Sets the instance image local service.
	 *
	 * @param instanceImageLocalService the instance image local service
	 */
	public void setInstanceImageLocalService(
		InstanceImageLocalService instanceImageLocalService) {
		this.instanceImageLocalService = instanceImageLocalService;
	}

	/**
	 * Returns the instance image remote service.
	 *
	 * @return the instance image remote service
	 */
	public InstanceImageService getInstanceImageService() {
		return instanceImageService;
	}

	/**
	 * Sets the instance image remote service.
	 *
	 * @param instanceImageService the instance image remote service
	 */
	public void setInstanceImageService(
		InstanceImageService instanceImageService) {
		this.instanceImageService = instanceImageService;
	}

	/**
	 * Returns the instance image persistence.
	 *
	 * @return the instance image persistence
	 */
	public InstanceImagePersistence getInstanceImagePersistence() {
		return instanceImagePersistence;
	}

	/**
	 * Sets the instance image persistence.
	 *
	 * @param instanceImagePersistence the instance image persistence
	 */
	public void setInstanceImagePersistence(
		InstanceImagePersistence instanceImagePersistence) {
		this.instanceImagePersistence = instanceImagePersistence;
	}

	/**
	 * Returns the location local service.
	 *
	 * @return the location local service
	 */
	public LocationLocalService getLocationLocalService() {
		return locationLocalService;
	}

	/**
	 * Sets the location local service.
	 *
	 * @param locationLocalService the location local service
	 */
	public void setLocationLocalService(
		LocationLocalService locationLocalService) {
		this.locationLocalService = locationLocalService;
	}

	/**
	 * Returns the location remote service.
	 *
	 * @return the location remote service
	 */
	public LocationService getLocationService() {
		return locationService;
	}

	/**
	 * Sets the location remote service.
	 *
	 * @param locationService the location remote service
	 */
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	/**
	 * Returns the location persistence.
	 *
	 * @return the location persistence
	 */
	public LocationPersistence getLocationPersistence() {
		return locationPersistence;
	}

	/**
	 * Sets the location persistence.
	 *
	 * @param locationPersistence the location persistence
	 */
	public void setLocationPersistence(LocationPersistence locationPersistence) {
		this.locationPersistence = locationPersistence;
	}

	/**
	 * Returns the offer local service.
	 *
	 * @return the offer local service
	 */
	public OfferLocalService getOfferLocalService() {
		return offerLocalService;
	}

	/**
	 * Sets the offer local service.
	 *
	 * @param offerLocalService the offer local service
	 */
	public void setOfferLocalService(OfferLocalService offerLocalService) {
		this.offerLocalService = offerLocalService;
	}

	/**
	 * Returns the offer remote service.
	 *
	 * @return the offer remote service
	 */
	public OfferService getOfferService() {
		return offerService;
	}

	/**
	 * Sets the offer remote service.
	 *
	 * @param offerService the offer remote service
	 */
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	/**
	 * Returns the offer persistence.
	 *
	 * @return the offer persistence
	 */
	public OfferPersistence getOfferPersistence() {
		return offerPersistence;
	}

	/**
	 * Sets the offer persistence.
	 *
	 * @param offerPersistence the offer persistence
	 */
	public void setOfferPersistence(OfferPersistence offerPersistence) {
		this.offerPersistence = offerPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("net.sareweb.mshowcase.model.Instance",
			instanceLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"net.sareweb.mshowcase.model.Instance");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return Instance.class;
	}

	protected String getModelClassName() {
		return Instance.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = instancePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ActivityLocalService.class)
	protected ActivityLocalService activityLocalService;
	@BeanReference(type = ActivityService.class)
	protected ActivityService activityService;
	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;
	@BeanReference(type = CategoryLocalService.class)
	protected CategoryLocalService categoryLocalService;
	@BeanReference(type = CategoryService.class)
	protected CategoryService categoryService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = DealLocalService.class)
	protected DealLocalService dealLocalService;
	@BeanReference(type = DealService.class)
	protected DealService dealService;
	@BeanReference(type = DealPersistence.class)
	protected DealPersistence dealPersistence;
	@BeanReference(type = FriendshipLocalService.class)
	protected FriendshipLocalService friendshipLocalService;
	@BeanReference(type = FriendshipService.class)
	protected FriendshipService friendshipService;
	@BeanReference(type = FriendshipPersistence.class)
	protected FriendshipPersistence friendshipPersistence;
	@BeanReference(type = InstanceLocalService.class)
	protected InstanceLocalService instanceLocalService;
	@BeanReference(type = InstanceService.class)
	protected InstanceService instanceService;
	@BeanReference(type = InstancePersistence.class)
	protected InstancePersistence instancePersistence;
	@BeanReference(type = InstanceImageLocalService.class)
	protected InstanceImageLocalService instanceImageLocalService;
	@BeanReference(type = InstanceImageService.class)
	protected InstanceImageService instanceImageService;
	@BeanReference(type = InstanceImagePersistence.class)
	protected InstanceImagePersistence instanceImagePersistence;
	@BeanReference(type = LocationLocalService.class)
	protected LocationLocalService locationLocalService;
	@BeanReference(type = LocationService.class)
	protected LocationService locationService;
	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	@BeanReference(type = OfferLocalService.class)
	protected OfferLocalService offerLocalService;
	@BeanReference(type = OfferService.class)
	protected OfferService offerService;
	@BeanReference(type = OfferPersistence.class)
	protected OfferPersistence offerPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(InstanceLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}