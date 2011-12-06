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

import net.sareweb.mshowcase.NoSuchFriendshipException;
import net.sareweb.mshowcase.model.Friendship;
import net.sareweb.mshowcase.model.impl.FriendshipImpl;
import net.sareweb.mshowcase.model.impl.FriendshipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the friendship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipPersistence
 * @see FriendshipUtil
 * @generated
 */
public class FriendshipPersistenceImpl extends BasePersistenceImpl<Friendship>
	implements FriendshipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FriendshipUtil} to access the friendship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FriendshipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipModelImpl.FINDER_CACHE_ENABLED, FriendshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipModelImpl.FINDER_CACHE_ENABLED, FriendshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the friendship in the entity cache if it is enabled.
	 *
	 * @param friendship the friendship
	 */
	public void cacheResult(Friendship friendship) {
		EntityCacheUtil.putResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipImpl.class, friendship.getPrimaryKey(), friendship);

		friendship.resetOriginalValues();
	}

	/**
	 * Caches the friendships in the entity cache if it is enabled.
	 *
	 * @param friendships the friendships
	 */
	public void cacheResult(List<Friendship> friendships) {
		for (Friendship friendship : friendships) {
			if (EntityCacheUtil.getResult(
						FriendshipModelImpl.ENTITY_CACHE_ENABLED,
						FriendshipImpl.class, friendship.getPrimaryKey()) == null) {
				cacheResult(friendship);
			}
			else {
				friendship.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all friendships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FriendshipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FriendshipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the friendship.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Friendship friendship) {
		EntityCacheUtil.removeResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipImpl.class, friendship.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new friendship with the primary key. Does not add the friendship to the database.
	 *
	 * @param friendshipId the primary key for the new friendship
	 * @return the new friendship
	 */
	public Friendship create(long friendshipId) {
		Friendship friendship = new FriendshipImpl();

		friendship.setNew(true);
		friendship.setPrimaryKey(friendshipId);

		return friendship;
	}

	/**
	 * Removes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the friendship
	 * @return the friendship that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Friendship remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param friendshipId the primary key of the friendship
	 * @return the friendship that was removed
	 * @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Friendship remove(long friendshipId)
		throws NoSuchFriendshipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Friendship friendship = (Friendship)session.get(FriendshipImpl.class,
					Long.valueOf(friendshipId));

			if (friendship == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + friendshipId);
				}

				throw new NoSuchFriendshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					friendshipId);
			}

			return friendshipPersistence.remove(friendship);
		}
		catch (NoSuchFriendshipException nsee) {
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
	 * Removes the friendship from the database. Also notifies the appropriate model listeners.
	 *
	 * @param friendship the friendship
	 * @return the friendship that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Friendship remove(Friendship friendship) throws SystemException {
		return super.remove(friendship);
	}

	@Override
	protected Friendship removeImpl(Friendship friendship)
		throws SystemException {
		friendship = toUnwrappedModel(friendship);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, friendship);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipImpl.class, friendship.getPrimaryKey());

		return friendship;
	}

	@Override
	public Friendship updateImpl(
		net.sareweb.mshowcase.model.Friendship friendship, boolean merge)
		throws SystemException {
		friendship = toUnwrappedModel(friendship);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, friendship, merge);

			friendship.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
			FriendshipImpl.class, friendship.getPrimaryKey(), friendship);

		return friendship;
	}

	protected Friendship toUnwrappedModel(Friendship friendship) {
		if (friendship instanceof FriendshipImpl) {
			return friendship;
		}

		FriendshipImpl friendshipImpl = new FriendshipImpl();

		friendshipImpl.setNew(friendship.isNew());
		friendshipImpl.setPrimaryKey(friendship.getPrimaryKey());

		friendshipImpl.setFriendshipId(friendship.getFriendshipId());
		friendshipImpl.setUserId(friendship.getUserId());
		friendshipImpl.setUser2Id(friendship.getUser2Id());
		friendshipImpl.setAccepted(friendship.isAccepted());
		friendshipImpl.setRejected(friendship.isRejected());
		friendshipImpl.setCompanyId(friendship.getCompanyId());
		friendshipImpl.setCreateDate(friendship.getCreateDate());

		return friendshipImpl;
	}

	/**
	 * Returns the friendship with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the friendship
	 * @return the friendship
	 * @throws com.liferay.portal.NoSuchModelException if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Friendship findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the friendship with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchFriendshipException} if it could not be found.
	 *
	 * @param friendshipId the primary key of the friendship
	 * @return the friendship
	 * @throws net.sareweb.mshowcase.NoSuchFriendshipException if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Friendship findByPrimaryKey(long friendshipId)
		throws NoSuchFriendshipException, SystemException {
		Friendship friendship = fetchByPrimaryKey(friendshipId);

		if (friendship == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + friendshipId);
			}

			throw new NoSuchFriendshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				friendshipId);
		}

		return friendship;
	}

	/**
	 * Returns the friendship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the friendship
	 * @return the friendship, or <code>null</code> if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Friendship fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the friendship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param friendshipId the primary key of the friendship
	 * @return the friendship, or <code>null</code> if a friendship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Friendship fetchByPrimaryKey(long friendshipId)
		throws SystemException {
		Friendship friendship = (Friendship)EntityCacheUtil.getResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
				FriendshipImpl.class, friendshipId);

		if (friendship == _nullFriendship) {
			return null;
		}

		if (friendship == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				friendship = (Friendship)session.get(FriendshipImpl.class,
						Long.valueOf(friendshipId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (friendship != null) {
					cacheResult(friendship);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FriendshipModelImpl.ENTITY_CACHE_ENABLED,
						FriendshipImpl.class, friendshipId, _nullFriendship);
				}

				closeSession(session);
			}
		}

		return friendship;
	}

	/**
	 * Returns all the friendships.
	 *
	 * @return the friendships
	 * @throws SystemException if a system exception occurred
	 */
	public List<Friendship> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the friendships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendships
	 * @param end the upper bound of the range of friendships (not inclusive)
	 * @return the range of friendships
	 * @throws SystemException if a system exception occurred
	 */
	public List<Friendship> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the friendships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendships
	 * @param end the upper bound of the range of friendships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of friendships
	 * @throws SystemException if a system exception occurred
	 */
	public List<Friendship> findAll(int start, int end,
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

		List<Friendship> list = (List<Friendship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FRIENDSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FRIENDSHIP.concat(FriendshipModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Friendship>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Friendship>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the friendships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Friendship friendship : findAll()) {
			friendshipPersistence.remove(friendship);
		}
	}

	/**
	 * Returns the number of friendships.
	 *
	 * @return the number of friendships
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FRIENDSHIP);

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
	 * Initializes the friendship persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.Friendship")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Friendship>> listenersList = new ArrayList<ModelListener<Friendship>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Friendship>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FriendshipImpl.class.getName());
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
	private static final String _SQL_SELECT_FRIENDSHIP = "SELECT friendship FROM Friendship friendship";
	private static final String _SQL_COUNT_FRIENDSHIP = "SELECT COUNT(friendship) FROM Friendship friendship";
	private static final String _ORDER_BY_ENTITY_ALIAS = "friendship.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Friendship exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FriendshipPersistenceImpl.class);
	private static Friendship _nullFriendship = new FriendshipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Friendship> toCacheModel() {
				return _nullFriendshipCacheModel;
			}
		};

	private static CacheModel<Friendship> _nullFriendshipCacheModel = new CacheModel<Friendship>() {
			public Friendship toEntityModel() {
				return _nullFriendship;
			}
		};
}