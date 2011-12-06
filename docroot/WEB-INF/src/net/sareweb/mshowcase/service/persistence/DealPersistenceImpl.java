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

import net.sareweb.mshowcase.NoSuchDealException;
import net.sareweb.mshowcase.model.Deal;
import net.sareweb.mshowcase.model.impl.DealImpl;
import net.sareweb.mshowcase.model.impl.DealModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the deal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see DealPersistence
 * @see DealUtil
 * @generated
 */
public class DealPersistenceImpl extends BasePersistenceImpl<Deal>
	implements DealPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DealUtil} to access the deal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DealImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealModelImpl.FINDER_CACHE_ENABLED, DealImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealModelImpl.FINDER_CACHE_ENABLED, DealImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the deal in the entity cache if it is enabled.
	 *
	 * @param deal the deal
	 */
	public void cacheResult(Deal deal) {
		EntityCacheUtil.putResult(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealImpl.class, deal.getPrimaryKey(), deal);

		deal.resetOriginalValues();
	}

	/**
	 * Caches the deals in the entity cache if it is enabled.
	 *
	 * @param deals the deals
	 */
	public void cacheResult(List<Deal> deals) {
		for (Deal deal : deals) {
			if (EntityCacheUtil.getResult(DealModelImpl.ENTITY_CACHE_ENABLED,
						DealImpl.class, deal.getPrimaryKey()) == null) {
				cacheResult(deal);
			}
			else {
				deal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all deals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DealImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DealImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the deal.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Deal deal) {
		EntityCacheUtil.removeResult(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealImpl.class, deal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new deal with the primary key. Does not add the deal to the database.
	 *
	 * @param dealId the primary key for the new deal
	 * @return the new deal
	 */
	public Deal create(long dealId) {
		Deal deal = new DealImpl();

		deal.setNew(true);
		deal.setPrimaryKey(dealId);

		return deal;
	}

	/**
	 * Removes the deal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the deal
	 * @return the deal that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Deal remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the deal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dealId the primary key of the deal
	 * @return the deal that was removed
	 * @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Deal remove(long dealId) throws NoSuchDealException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Deal deal = (Deal)session.get(DealImpl.class, Long.valueOf(dealId));

			if (deal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + dealId);
				}

				throw new NoSuchDealException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					dealId);
			}

			return dealPersistence.remove(deal);
		}
		catch (NoSuchDealException nsee) {
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
	 * Removes the deal from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deal the deal
	 * @return the deal that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Deal remove(Deal deal) throws SystemException {
		return super.remove(deal);
	}

	@Override
	protected Deal removeImpl(Deal deal) throws SystemException {
		deal = toUnwrappedModel(deal);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, deal);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealImpl.class, deal.getPrimaryKey());

		return deal;
	}

	@Override
	public Deal updateImpl(net.sareweb.mshowcase.model.Deal deal, boolean merge)
		throws SystemException {
		deal = toUnwrappedModel(deal);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, deal, merge);

			deal.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(DealModelImpl.ENTITY_CACHE_ENABLED,
			DealImpl.class, deal.getPrimaryKey(), deal);

		return deal;
	}

	protected Deal toUnwrappedModel(Deal deal) {
		if (deal instanceof DealImpl) {
			return deal;
		}

		DealImpl dealImpl = new DealImpl();

		dealImpl.setNew(deal.isNew());
		dealImpl.setPrimaryKey(deal.getPrimaryKey());

		dealImpl.setDealId(deal.getDealId());
		dealImpl.setUserId(deal.getUserId());
		dealImpl.setOfferId(deal.getOfferId());
		dealImpl.setCompanyId(deal.getCompanyId());
		dealImpl.setCreateDate(deal.getCreateDate());

		return dealImpl;
	}

	/**
	 * Returns the deal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the deal
	 * @return the deal
	 * @throws com.liferay.portal.NoSuchModelException if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Deal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the deal with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchDealException} if it could not be found.
	 *
	 * @param dealId the primary key of the deal
	 * @return the deal
	 * @throws net.sareweb.mshowcase.NoSuchDealException if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Deal findByPrimaryKey(long dealId)
		throws NoSuchDealException, SystemException {
		Deal deal = fetchByPrimaryKey(dealId);

		if (deal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + dealId);
			}

			throw new NoSuchDealException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				dealId);
		}

		return deal;
	}

	/**
	 * Returns the deal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the deal
	 * @return the deal, or <code>null</code> if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Deal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the deal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dealId the primary key of the deal
	 * @return the deal, or <code>null</code> if a deal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Deal fetchByPrimaryKey(long dealId) throws SystemException {
		Deal deal = (Deal)EntityCacheUtil.getResult(DealModelImpl.ENTITY_CACHE_ENABLED,
				DealImpl.class, dealId);

		if (deal == _nullDeal) {
			return null;
		}

		if (deal == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				deal = (Deal)session.get(DealImpl.class, Long.valueOf(dealId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (deal != null) {
					cacheResult(deal);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DealModelImpl.ENTITY_CACHE_ENABLED,
						DealImpl.class, dealId, _nullDeal);
				}

				closeSession(session);
			}
		}

		return deal;
	}

	/**
	 * Returns all the deals.
	 *
	 * @return the deals
	 * @throws SystemException if a system exception occurred
	 */
	public List<Deal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Deal> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Deal> findAll(int start, int end,
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

		List<Deal> list = (List<Deal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEAL.concat(DealModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Deal>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Deal>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the deals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Deal deal : findAll()) {
			dealPersistence.remove(deal);
		}
	}

	/**
	 * Returns the number of deals.
	 *
	 * @return the number of deals
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEAL);

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
	 * Initializes the deal persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.Deal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Deal>> listenersList = new ArrayList<ModelListener<Deal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Deal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DealImpl.class.getName());
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
	private static final String _SQL_SELECT_DEAL = "SELECT deal FROM Deal deal";
	private static final String _SQL_COUNT_DEAL = "SELECT COUNT(deal) FROM Deal deal";
	private static final String _ORDER_BY_ENTITY_ALIAS = "deal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Deal exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DealPersistenceImpl.class);
	private static Deal _nullDeal = new DealImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Deal> toCacheModel() {
				return _nullDealCacheModel;
			}
		};

	private static CacheModel<Deal> _nullDealCacheModel = new CacheModel<Deal>() {
			public Deal toEntityModel() {
				return _nullDeal;
			}
		};
}