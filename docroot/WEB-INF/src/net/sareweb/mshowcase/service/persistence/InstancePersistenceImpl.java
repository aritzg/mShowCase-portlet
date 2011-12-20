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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.sareweb.mshowcase.NoSuchInstanceException;
import net.sareweb.mshowcase.model.Instance;
import net.sareweb.mshowcase.model.impl.InstanceImpl;
import net.sareweb.mshowcase.model.impl.InstanceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstancePersistence
 * @see InstanceUtil
 * @generated
 */
public class InstancePersistenceImpl extends BasePersistenceImpl<Instance>
	implements InstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InstanceUtil} to access the instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceModelImpl.FINDER_CACHE_ENABLED, InstanceImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			InstanceModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceModelImpl.FINDER_CACHE_ENABLED, InstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceModelImpl.FINDER_CACHE_ENABLED, InstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the instance in the entity cache if it is enabled.
	 *
	 * @param instance the instance
	 */
	public void cacheResult(Instance instance) {
		EntityCacheUtil.putResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImpl.class, instance.getPrimaryKey(), instance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(instance.getUserId()) }, instance);

		instance.resetOriginalValues();
	}

	/**
	 * Caches the instances in the entity cache if it is enabled.
	 *
	 * @param instances the instances
	 */
	public void cacheResult(List<Instance> instances) {
		for (Instance instance : instances) {
			if (EntityCacheUtil.getResult(
						InstanceModelImpl.ENTITY_CACHE_ENABLED,
						InstanceImpl.class, instance.getPrimaryKey()) == null) {
				cacheResult(instance);
			}
			else {
				instance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Instance instance) {
		EntityCacheUtil.removeResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImpl.class, instance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(instance.getUserId()) });
	}

	/**
	 * Creates a new instance with the primary key. Does not add the instance to the database.
	 *
	 * @param InstanceId the primary key for the new instance
	 * @return the new instance
	 */
	public Instance create(long InstanceId) {
		Instance instance = new InstanceImpl();

		instance.setNew(true);
		instance.setPrimaryKey(InstanceId);

		return instance;
	}

	/**
	 * Removes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the instance
	 * @return the instance that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instance remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InstanceId the primary key of the instance
	 * @return the instance that was removed
	 * @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance remove(long InstanceId)
		throws NoSuchInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Instance instance = (Instance)session.get(InstanceImpl.class,
					Long.valueOf(InstanceId));

			if (instance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + InstanceId);
				}

				throw new NoSuchInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					InstanceId);
			}

			return instancePersistence.remove(instance);
		}
		catch (NoSuchInstanceException nsee) {
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
	 * Removes the instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instance the instance
	 * @return the instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instance remove(Instance instance) throws SystemException {
		return super.remove(instance);
	}

	@Override
	protected Instance removeImpl(Instance instance) throws SystemException {
		instance = toUnwrappedModel(instance);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, instance);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		InstanceModelImpl instanceModelImpl = (InstanceModelImpl)instance;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(instanceModelImpl.getUserId()) });

		EntityCacheUtil.removeResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImpl.class, instance.getPrimaryKey());

		return instance;
	}

	@Override
	public Instance updateImpl(net.sareweb.mshowcase.model.Instance instance,
		boolean merge) throws SystemException {
		instance = toUnwrappedModel(instance);

		boolean isNew = instance.isNew();

		InstanceModelImpl instanceModelImpl = (InstanceModelImpl)instance;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, instance, merge);

			instance.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImpl.class, instance.getPrimaryKey(), instance);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(instance.getUserId()) }, instance);
		}
		else {
			if ((instanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(instanceModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(instance.getUserId()) },
					instance);
			}
		}

		return instance;
	}

	protected Instance toUnwrappedModel(Instance instance) {
		if (instance instanceof InstanceImpl) {
			return instance;
		}

		InstanceImpl instanceImpl = new InstanceImpl();

		instanceImpl.setNew(instance.isNew());
		instanceImpl.setPrimaryKey(instance.getPrimaryKey());

		instanceImpl.setInstanceId(instance.getInstanceId());
		instanceImpl.setName(instance.getName());
		instanceImpl.setDescription(instance.getDescription());
		instanceImpl.setPhoneNumber(instance.getPhoneNumber());
		instanceImpl.setFaxNumber(instance.getFaxNumber());
		instanceImpl.setEmail(instance.getEmail());
		instanceImpl.setWebPage(instance.getWebPage());
		instanceImpl.setCategoryLevel0(instance.getCategoryLevel0());
		instanceImpl.setCategoryLevel1(instance.getCategoryLevel1());
		instanceImpl.setCategoryLevel2(instance.getCategoryLevel2());
		instanceImpl.setLogoImageId(instance.getLogoImageId());
		instanceImpl.setLogoImageURL(instance.getLogoImageURL());
		instanceImpl.setUserId(instance.getUserId());
		instanceImpl.setCompanyId(instance.getCompanyId());
		instanceImpl.setGroupId(instance.getGroupId());
		instanceImpl.setCreateDate(instance.getCreateDate());

		return instanceImpl;
	}

	/**
	 * Returns the instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the instance
	 * @return the instance
	 * @throws com.liferay.portal.NoSuchModelException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instance with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceException} if it could not be found.
	 *
	 * @param InstanceId the primary key of the instance
	 * @return the instance
	 * @throws net.sareweb.mshowcase.NoSuchInstanceException if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance findByPrimaryKey(long InstanceId)
		throws NoSuchInstanceException, SystemException {
		Instance instance = fetchByPrimaryKey(InstanceId);

		if (instance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + InstanceId);
			}

			throw new NoSuchInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				InstanceId);
		}

		return instance;
	}

	/**
	 * Returns the instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the instance
	 * @return the instance, or <code>null</code> if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Instance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InstanceId the primary key of the instance
	 * @return the instance, or <code>null</code> if a instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance fetchByPrimaryKey(long InstanceId)
		throws SystemException {
		Instance instance = (Instance)EntityCacheUtil.getResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
				InstanceImpl.class, InstanceId);

		if (instance == _nullInstance) {
			return null;
		}

		if (instance == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				instance = (Instance)session.get(InstanceImpl.class,
						Long.valueOf(InstanceId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (instance != null) {
					cacheResult(instance);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InstanceModelImpl.ENTITY_CACHE_ENABLED,
						InstanceImpl.class, InstanceId, _nullInstance);
				}

				closeSession(session);
			}
		}

		return instance;
	}

	/**
	 * Returns the instance where userId = &#63; or throws a {@link net.sareweb.mshowcase.NoSuchInstanceException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching instance
	 * @throws net.sareweb.mshowcase.NoSuchInstanceException if a matching instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance findByUserId(long userId)
		throws NoSuchInstanceException, SystemException {
		Instance instance = fetchByUserId(userId);

		if (instance == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInstanceException(msg.toString());
		}

		return instance;
	}

	/**
	 * Returns the instance where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching instance, or <code>null</code> if a matching instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the instance where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching instance, or <code>null</code> if a matching instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Instance fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_INSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(InstanceModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Instance> list = q.list();

				result = list;

				Instance instance = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					instance = list.get(0);

					cacheResult(instance);

					if ((instance.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, instance);
					}
				}

				return instance;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Instance)result;
			}
		}
	}

	/**
	 * Returns all the instances.
	 *
	 * @return the instances
	 * @throws SystemException if a system exception occurred
	 */
	public List<Instance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Instance> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of instances
	 * @param end the upper bound of the range of instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of instances
	 * @throws SystemException if a system exception occurred
	 */
	public List<Instance> findAll(int start, int end,
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

		List<Instance> list = (List<Instance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTANCE.concat(InstanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Instance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Instance>)QueryUtil.list(q, getDialect(),
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
	 * Removes the instance where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId)
		throws NoSuchInstanceException, SystemException {
		Instance instance = findByUserId(userId);

		instancePersistence.remove(instance);
	}

	/**
	 * Removes all the instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Instance instance : findAll()) {
			instancePersistence.remove(instance);
		}
	}

	/**
	 * Returns the number of instances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching instances
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of instances.
	 *
	 * @return the number of instances
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INSTANCE);

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
	 * Initializes the instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.Instance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Instance>> listenersList = new ArrayList<ModelListener<Instance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Instance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InstanceImpl.class.getName());
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
	private static final String _SQL_SELECT_INSTANCE = "SELECT instance FROM Instance instance";
	private static final String _SQL_SELECT_INSTANCE_WHERE = "SELECT instance FROM Instance instance WHERE ";
	private static final String _SQL_COUNT_INSTANCE = "SELECT COUNT(instance) FROM Instance instance";
	private static final String _SQL_COUNT_INSTANCE_WHERE = "SELECT COUNT(instance) FROM Instance instance WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "instance.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "instance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Instance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Instance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InstancePersistenceImpl.class);
	private static Instance _nullInstance = new InstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Instance> toCacheModel() {
				return _nullInstanceCacheModel;
			}
		};

	private static CacheModel<Instance> _nullInstanceCacheModel = new CacheModel<Instance>() {
			public Instance toEntityModel() {
				return _nullInstance;
			}
		};
}