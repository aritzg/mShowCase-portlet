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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.sareweb.mshowcase.NoSuchLocationException;
import net.sareweb.mshowcase.model.Location;
import net.sareweb.mshowcase.model.impl.LocationImpl;
import net.sareweb.mshowcase.model.impl.LocationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see LocationPersistence
 * @see LocationUtil
 * @generated
 */
public class LocationPersistenceImpl extends BasePersistenceImpl<Location>
	implements LocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocationUtil} to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, LocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	public void cacheResult(Location location) {
		EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey(), location);

		location.resetOriginalValues();
	}

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	public void cacheResult(List<Location> locations) {
		for (Location location : locations) {
			if (EntityCacheUtil.getResult(
						LocationModelImpl.ENTITY_CACHE_ENABLED,
						LocationImpl.class, location.getPrimaryKey()) == null) {
				cacheResult(location);
			}
			else {
				location.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LocationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LocationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the location.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Location location) {
		EntityCacheUtil.removeResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	public Location create(long locationId) {
		Location location = new LocationImpl();

		location.setNew(true);
		location.setPrimaryKey(locationId);

		return location;
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Location remove(long locationId)
		throws NoSuchLocationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Location location = (Location)session.get(LocationImpl.class,
					Long.valueOf(locationId));

			if (location == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + locationId);
				}

				throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					locationId);
			}

			return locationPersistence.remove(location);
		}
		catch (NoSuchLocationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the location from the database. Also notifies the appropriate model listeners.
	 *
	 * @param location the location
	 * @return the location that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location remove(Location location) throws SystemException {
		return super.remove(location);
	}

	@Override
	protected Location removeImpl(Location location) throws SystemException {
		location = toUnwrappedModel(location);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, location);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey());

		return location;
	}

	@Override
	public Location updateImpl(net.sareweb.mshowcase.model.Location location,
		boolean merge) throws SystemException {
		location = toUnwrappedModel(location);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, location, merge);

			location.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
			LocationImpl.class, location.getPrimaryKey(), location);

		return location;
	}

	protected Location toUnwrappedModel(Location location) {
		if (location instanceof LocationImpl) {
			return location;
		}

		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setNew(location.isNew());
		locationImpl.setPrimaryKey(location.getPrimaryKey());

		locationImpl.setLocationId(location.getLocationId());
		locationImpl.setInstanceId(location.getInstanceId());
		locationImpl.setAddress(location.getAddress());
		locationImpl.setLat(location.getLat());
		locationImpl.setLng(location.getLng());
		locationImpl.setPhoneNumber(location.getPhoneNumber());
		locationImpl.setFaxNumber(location.getFaxNumber());
		locationImpl.setImageId(location.getImageId());
		locationImpl.setImageURL(location.getImageURL());
		locationImpl.setUserId(location.getUserId());
		locationImpl.setCompanyId(location.getCompanyId());
		locationImpl.setCreateDate(location.getCreateDate());

		return locationImpl;
	}

	/**
	 * Returns the location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location
	 * @throws com.liferay.portal.NoSuchModelException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the location with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchLocationException} if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws net.sareweb.mshowcase.NoSuchLocationException if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Location findByPrimaryKey(long locationId)
		throws NoSuchLocationException, SystemException {
		Location location = fetchByPrimaryKey(locationId);

		if (location == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + locationId);
			}

			throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				locationId);
		}

		return location;
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Location fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Location fetchByPrimaryKey(long locationId)
		throws SystemException {
		Location location = (Location)EntityCacheUtil.getResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
				LocationImpl.class, locationId);

		if (location == _nullLocation) {
			return null;
		}

		if (location == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				location = (Location)session.get(LocationImpl.class,
						Long.valueOf(locationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (location != null) {
					cacheResult(location);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LocationModelImpl.ENTITY_CACHE_ENABLED,
						LocationImpl.class, locationId, _nullLocation);
				}

				closeSession(session);
			}
		}

		return location;
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Location> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Location> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 * @throws SystemException if a system exception occurred
	 */
	public List<Location> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Location> list = (List<Location>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCATION.concat(LocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Location>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the locations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Location location : findAll()) {
			locationPersistence.remove(location);
		}
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the location persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.Location")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Location>> listenersList = new ArrayList<ModelListener<Location>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Location>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LocationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = DealPersistence.class)
	protected DealPersistence dealPersistence;
	@BeanReference(type = FriendshipPersistence.class)
	protected FriendshipPersistence friendshipPersistence;
	@BeanReference(type = InstancePersistence.class)
	protected InstancePersistence instancePersistence;
	@BeanReference(type = InstanceImagePersistence.class)
	protected InstanceImagePersistence instanceImagePersistence;
	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	@BeanReference(type = OfferPersistence.class)
	protected OfferPersistence offerPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LOCATION = "SELECT location FROM Location location";
	private static final String _SQL_COUNT_LOCATION = "SELECT COUNT(location) FROM Location location";
	private static final String _ORDER_BY_ENTITY_ALIAS = "location.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Location exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LocationPersistenceImpl.class);
	private static Location _nullLocation = new LocationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Location> toCacheModel() {
				return _nullLocationCacheModel;
			}
		};

	private static CacheModel<Location> _nullLocationCacheModel = new CacheModel<Location>() {
			public Location toEntityModel() {
				return _nullLocation;
			}
		};
}