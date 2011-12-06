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

package net.sareweb.mshowcase.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import net.sareweb.mshowcase.model.Friendship;
import net.sareweb.mshowcase.service.FriendshipLocalServiceUtil;

/**
 * The extended model base implementation for the Friendship service. Represents a row in the &quot;msc_Friendship&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FriendshipImpl}.
 * </p>
 *
 * @author Aritz Galdos
 * @see FriendshipImpl
 * @see net.sareweb.mshowcase.model.Friendship
 * @generated
 */
public abstract class FriendshipBaseImpl extends FriendshipModelImpl
	implements Friendship {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a friendship model instance should use the {@link Friendship} interface instead.
	 */
	public void persist() throws SystemException {
		FriendshipLocalServiceUtil.updateFriendship(this);
	}
}