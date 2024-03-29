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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the friendship local service. This utility wraps {@link net.sareweb.mshowcase.service.impl.FriendshipLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipLocalService
 * @see net.sareweb.mshowcase.service.base.FriendshipLocalServiceBaseImpl
 * @see net.sareweb.mshowcase.service.impl.FriendshipLocalServiceImpl
 * @generated
 */
public class FriendshipLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.sareweb.mshowcase.service.impl.FriendshipLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the friendship to the database. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @return the friendship that was added
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship addFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFriendship(friendship);
	}

	/**
	* Creates a new friendship with the primary key. Does not add the friendship to the database.
	*
	* @param friendshipId the primary key for the new friendship
	* @return the new friendship
	*/
	public static net.sareweb.mshowcase.model.Friendship createFriendship(
		long friendshipId) {
		return getService().createFriendship(friendshipId);
	}

	/**
	* Deletes the friendship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param friendshipId the primary key of the friendship
	* @throws PortalException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFriendship(long friendshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFriendship(friendshipId);
	}

	/**
	* Deletes the friendship from the database. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFriendship(friendship);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static net.sareweb.mshowcase.model.Friendship fetchFriendship(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFriendship(friendshipId);
	}

	/**
	* Returns the friendship with the primary key.
	*
	* @param friendshipId the primary key of the friendship
	* @return the friendship
	* @throws PortalException if a friendship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship getFriendship(
		long friendshipId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFriendship(friendshipId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<net.sareweb.mshowcase.model.Friendship> getFriendships(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFriendships(start, end);
	}

	/**
	* Returns the number of friendships.
	*
	* @return the number of friendships
	* @throws SystemException if a system exception occurred
	*/
	public static int getFriendshipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFriendshipsCount();
	}

	/**
	* Updates the friendship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @return the friendship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship updateFriendship(
		net.sareweb.mshowcase.model.Friendship friendship)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFriendship(friendship);
	}

	/**
	* Updates the friendship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param friendship the friendship
	* @param merge whether to merge the friendship with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the friendship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.mshowcase.model.Friendship updateFriendship(
		net.sareweb.mshowcase.model.Friendship friendship, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFriendship(friendship, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static FriendshipLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FriendshipLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FriendshipLocalService.class.getName(), portletClassLoader);

			_service = new FriendshipLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FriendshipLocalServiceUtil.class,
				"_service");
			MethodCache.remove(FriendshipLocalService.class);
		}

		return _service;
	}

	public void setService(FriendshipLocalService service) {
		MethodCache.remove(FriendshipLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(FriendshipLocalServiceUtil.class,
			"_service");
		MethodCache.remove(FriendshipLocalService.class);
	}

	private static FriendshipLocalService _service;
}