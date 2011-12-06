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

import net.sareweb.mshowcase.NoSuchInstanceImageException;
import net.sareweb.mshowcase.model.InstanceImage;
import net.sareweb.mshowcase.model.impl.InstanceImageImpl;
import net.sareweb.mshowcase.model.impl.InstanceImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the instance image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aritz Galdos
 * @see InstanceImagePersistence
 * @see InstanceImageUtil
 * @generated
 */
public class InstanceImagePersistenceImpl extends BasePersistenceImpl<InstanceImage>
	implements InstanceImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InstanceImageUtil} to access the instance image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InstanceImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageModelImpl.FINDER_CACHE_ENABLED,
			InstanceImageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageModelImpl.FINDER_CACHE_ENABLED,
			InstanceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the instance image in the entity cache if it is enabled.
	 *
	 * @param instanceImage the instance image
	 */
	public void cacheResult(InstanceImage instanceImage) {
		EntityCacheUtil.putResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageImpl.class, instanceImage.getPrimaryKey(),
			instanceImage);

		instanceImage.resetOriginalValues();
	}

	/**
	 * Caches the instance images in the entity cache if it is enabled.
	 *
	 * @param instanceImages the instance images
	 */
	public void cacheResult(List<InstanceImage> instanceImages) {
		for (InstanceImage instanceImage : instanceImages) {
			if (EntityCacheUtil.getResult(
						InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
						InstanceImageImpl.class, instanceImage.getPrimaryKey()) == null) {
				cacheResult(instanceImage);
			}
			else {
				instanceImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all instance images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InstanceImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InstanceImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the instance image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InstanceImage instanceImage) {
		EntityCacheUtil.removeResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageImpl.class, instanceImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new instance image with the primary key. Does not add the instance image to the database.
	 *
	 * @param InstanceImageId the primary key for the new instance image
	 * @return the new instance image
	 */
	public InstanceImage create(long InstanceImageId) {
		InstanceImage instanceImage = new InstanceImageImpl();

		instanceImage.setNew(true);
		instanceImage.setPrimaryKey(InstanceImageId);

		return instanceImage;
	}

	/**
	 * Removes the instance image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the instance image
	 * @return the instance image that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstanceImage remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the instance image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InstanceImageId the primary key of the instance image
	 * @return the instance image that was removed
	 * @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InstanceImage remove(long InstanceImageId)
		throws NoSuchInstanceImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InstanceImage instanceImage = (InstanceImage)session.get(InstanceImageImpl.class,
					Long.valueOf(InstanceImageId));

			if (instanceImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						InstanceImageId);
				}

				throw new NoSuchInstanceImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					InstanceImageId);
			}

			return instanceImagePersistence.remove(instanceImage);
		}
		catch (NoSuchInstanceImageException nsee) {
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
	 * Removes the instance image from the database. Also notifies the appropriate model listeners.
	 *
	 * @param instanceImage the instance image
	 * @return the instance image that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstanceImage remove(InstanceImage instanceImage)
		throws SystemException {
		return super.remove(instanceImage);
	}

	@Override
	protected InstanceImage removeImpl(InstanceImage instanceImage)
		throws SystemException {
		instanceImage = toUnwrappedModel(instanceImage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, instanceImage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageImpl.class, instanceImage.getPrimaryKey());

		return instanceImage;
	}

	@Override
	public InstanceImage updateImpl(
		net.sareweb.mshowcase.model.InstanceImage instanceImage, boolean merge)
		throws SystemException {
		instanceImage = toUnwrappedModel(instanceImage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, instanceImage, merge);

			instanceImage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
			InstanceImageImpl.class, instanceImage.getPrimaryKey(),
			instanceImage);

		return instanceImage;
	}

	protected InstanceImage toUnwrappedModel(InstanceImage instanceImage) {
		if (instanceImage instanceof InstanceImageImpl) {
			return instanceImage;
		}

		InstanceImageImpl instanceImageImpl = new InstanceImageImpl();

		instanceImageImpl.setNew(instanceImage.isNew());
		instanceImageImpl.setPrimaryKey(instanceImage.getPrimaryKey());

		instanceImageImpl.setInstanceImageId(instanceImage.getInstanceImageId());
		instanceImageImpl.setInstanceId(instanceImage.getInstanceId());
		instanceImageImpl.setImageId(instanceImage.getImageId());
		instanceImageImpl.setImageURL(instanceImage.getImageURL());
		instanceImageImpl.setUserId(instanceImage.getUserId());
		instanceImageImpl.setCompanyId(instanceImage.getCompanyId());
		instanceImageImpl.setCreateDate(instanceImage.getCreateDate());

		return instanceImageImpl;
	}

	/**
	 * Returns the instance image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the instance image
	 * @return the instance image
	 * @throws com.liferay.portal.NoSuchModelException if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstanceImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instance image with the primary key or throws a {@link net.sareweb.mshowcase.NoSuchInstanceImageException} if it could not be found.
	 *
	 * @param InstanceImageId the primary key of the instance image
	 * @return the instance image
	 * @throws net.sareweb.mshowcase.NoSuchInstanceImageException if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InstanceImage findByPrimaryKey(long InstanceImageId)
		throws NoSuchInstanceImageException, SystemException {
		InstanceImage instanceImage = fetchByPrimaryKey(InstanceImageId);

		if (instanceImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + InstanceImageId);
			}

			throw new NoSuchInstanceImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				InstanceImageId);
		}

		return instanceImage;
	}

	/**
	 * Returns the instance image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the instance image
	 * @return the instance image, or <code>null</code> if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InstanceImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the instance image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InstanceImageId the primary key of the instance image
	 * @return the instance image, or <code>null</code> if a instance image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InstanceImage fetchByPrimaryKey(long InstanceImageId)
		throws SystemException {
		InstanceImage instanceImage = (InstanceImage)EntityCacheUtil.getResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
				InstanceImageImpl.class, InstanceImageId);

		if (instanceImage == _nullInstanceImage) {
			return null;
		}

		if (instanceImage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				instanceImage = (InstanceImage)session.get(InstanceImageImpl.class,
						Long.valueOf(InstanceImageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (instanceImage != null) {
					cacheResult(instanceImage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InstanceImageModelImpl.ENTITY_CACHE_ENABLED,
						InstanceImageImpl.class, InstanceImageId,
						_nullInstanceImage);
				}

				closeSession(session);
			}
		}

		return instanceImage;
	}

	/**
	 * Returns all the instance images.
	 *
	 * @return the instance images
	 * @throws SystemException if a system exception occurred
	 */
	public List<InstanceImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<InstanceImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<InstanceImage> findAll(int start, int end,
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

		List<InstanceImage> list = (List<InstanceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INSTANCEIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INSTANCEIMAGE.concat(InstanceImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<InstanceImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<InstanceImage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the instance images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (InstanceImage instanceImage : findAll()) {
			instanceImagePersistence.remove(instanceImage);
		}
	}

	/**
	 * Returns the number of instance images.
	 *
	 * @return the number of instance images
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INSTANCEIMAGE);

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
	 * Initializes the instance image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.mshowcase.model.InstanceImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InstanceImage>> listenersList = new ArrayList<ModelListener<InstanceImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InstanceImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InstanceImageImpl.class.getName());
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
	private static final String _SQL_SELECT_INSTANCEIMAGE = "SELECT instanceImage FROM InstanceImage instanceImage";
	private static final String _SQL_COUNT_INSTANCEIMAGE = "SELECT COUNT(instanceImage) FROM InstanceImage instanceImage";
	private static final String _ORDER_BY_ENTITY_ALIAS = "instanceImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InstanceImage exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InstanceImagePersistenceImpl.class);
	private static InstanceImage _nullInstanceImage = new InstanceImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InstanceImage> toCacheModel() {
				return _nullInstanceImageCacheModel;
			}
		};

	private static CacheModel<InstanceImage> _nullInstanceImageCacheModel = new CacheModel<InstanceImage>() {
			public InstanceImage toEntityModel() {
				return _nullInstanceImage;
			}
		};
}