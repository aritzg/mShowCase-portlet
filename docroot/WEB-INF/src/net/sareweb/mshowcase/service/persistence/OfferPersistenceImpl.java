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

import net.sareweb.mshowcase.NoSuchOfferException;
import net.sareweb.mshowcase.model.Offer;
import net.sareweb.mshowcase.model.impl.OfferImpl;
import net.sareweb.mshowcase.model.impl.OfferModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see OfferPersistence
 * @see OfferUtil
 * @generated
 */
public class OfferPersistenceImpl extends BasePersistenceImpl<Offer>
	implements OfferPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfferUtil} to access the offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfferImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, OfferImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, OfferImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer
	 */
	public void cacheResult(Offer offer) {
		EntityCacheUtil.putResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey(), offer);

		offer.resetOriginalValues();
	}

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers
	 */
	public void cacheResult(List<Offer> offers) {
		for (Offer offer : offers) {
			if (EntityCacheUtil.getResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
						OfferImpl.class, offer.getPrimaryKey()) == null) {
				cacheResult(offer);
			}
			else {
				offer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all offers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfferImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfferImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the offer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Offer offer) {
		EntityCacheUtil.removeResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param offerId the primary key for the new offer
	 * @return the new offer
	 */
	public Offer create(long offerId) {
		Offer offer = new OfferImpl();

		offer.setNew(true);
		offer.setPrimaryKey(offerId);

		return offer;
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the offer
	 * @return the offer that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Offer remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer that was removed
	 * @throws net.sareweb.mshowcase.NoSuchOfferException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer remove(long offerId)
		throws NoSuchOfferException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Offer offer = (Offer)session.get(OfferImpl.class,
					Long.valueOf(offerId));

			if (offer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + offerId);
				}

				throw new NoSuchOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					offerId);
			}

			return offerPersistence.remove(offer);
		}
		catch (NoSuchOfferException nsee) {
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
	 * Removes the offer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param offer the offer
	 * @return the offer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Offer remove(Offer offer) throws SystemException {
		return super.remove(offer);
	}

	@Override
	protected Offer removeImpl(Offer offer) throws SystemException {
		offer = toUnwrappedModel(offer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, offer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey());

		return offer;
	}

	@Override
	public Offer updateImpl(net.sareweb.mshowcase.model.Offer offer,
		boolean merge) throws SystemException {
		offer = toUnwrappedModel(offer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, offer, merge);

			offer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
			OfferImpl.class, offer.getPrimaryKey(), offer);

		return offer;
	}

	protected Offer toUnwrappedModel(Offer offer) {
		if (offer instanceof OfferImpl) {
			return offer;
		}

		OfferImpl offerImpl = new OfferImpl();

		offerImpl.setNew(offer.isNew());
		offerImpl.setPrimaryKey(offer.getPrimaryKey());

		offerImpl.setOfferId(offer.getOfferId());
		offerImpl.setInstanceId(offer.getInstanceId());
		offerImpl.setOfferText(offer.getOfferText());
		offerImpl.setBeginDate(offer.getBeginDate());
		offerImpl.setEndDate(offer.getEndDate());
		offerImpl.setPrice(offer.getPrice());
		offerImpl.setTransactions(offer.getTransactions());
		offerImpl.setImageId(offer.getImageId());
		offerImpl.setImageURL(offer.getImageURL());
		offerImpl.setUserId(offer.getUserId());
		offerImpl.setCompanyId(offer.getCompanyId());
		offerImpl.setCreateDate(offer.getCreateDate());
		offerImpl.setModifyDate(offer.getModifyDate());

		return offerImpl;
	}

	/**
	 * Returns the offer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the offer
	 * @return the offer
	 * @throws com.liferay.portal.NoSuchModelException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Offer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the offer with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchOfferException} if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer
	 * @throws net.sareweb.mshowcase.NoSuchOfferException if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer findByPrimaryKey(long offerId)
		throws NoSuchOfferException, SystemException {
		Offer offer = fetchByPrimaryKey(offerId);

		if (offer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + offerId);
			}

			throw new NoSuchOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				offerId);
		}

		return offer;
	}

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Offer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param offerId the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Offer fetchByPrimaryKey(long offerId) throws SystemException {
		Offer offer = (Offer)EntityCacheUtil.getResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
				OfferImpl.class, offerId);

		if (offer == _nullOffer) {
			return null;
		}

		if (offer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				offer = (Offer)session.get(OfferImpl.class,
						Long.valueOf(offerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (offer != null) {
					cacheResult(offer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OfferModelImpl.ENTITY_CACHE_ENABLED,
						OfferImpl.class, offerId, _nullOffer);
				}

				closeSession(session);
			}
		}

		return offer;
	}

	/**
	 * Returns all the offers.
	 *
	 * @return the offers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Offer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Offer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Offer> findAll(int start, int end,
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

		List<Offer> list = (List<Offer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFER.concat(OfferModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Offer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Offer>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the offers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Offer offer : findAll()) {
			offerPersistence.remove(offer);
		}
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OFFER);

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
	 * Initializes the offer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.Offer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Offer>> listenersList = new ArrayList<ModelListener<Offer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Offer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfferImpl.class.getName());
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
	private static final String _SQL_SELECT_OFFER = "SELECT offer FROM Offer offer";
	private static final String _SQL_COUNT_OFFER = "SELECT COUNT(offer) FROM Offer offer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "offer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Offer exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfferPersistenceImpl.class);
	private static Offer _nullOffer = new OfferImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Offer> toCacheModel() {
				return _nullOfferCacheModel;
			}
		};

	private static CacheModel<Offer> _nullOfferCacheModel = new CacheModel<Offer>() {
			public Offer toEntityModel() {
				return _nullOffer;
			}
		};
}