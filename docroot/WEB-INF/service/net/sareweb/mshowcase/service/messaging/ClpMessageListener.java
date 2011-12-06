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

package net.sareweb.mshowcase.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import net.sareweb.mshowcase.service.ActivityLocalServiceUtil;
import net.sareweb.mshowcase.service.ActivityServiceUtil;
import net.sareweb.mshowcase.service.CategoryLocalServiceUtil;
import net.sareweb.mshowcase.service.CategoryServiceUtil;
import net.sareweb.mshowcase.service.ClpSerializer;
import net.sareweb.mshowcase.service.DealLocalServiceUtil;
import net.sareweb.mshowcase.service.DealServiceUtil;
import net.sareweb.mshowcase.service.FriendshipLocalServiceUtil;
import net.sareweb.mshowcase.service.FriendshipServiceUtil;
import net.sareweb.mshowcase.service.InstanceImageLocalServiceUtil;
import net.sareweb.mshowcase.service.InstanceImageServiceUtil;
import net.sareweb.mshowcase.service.InstanceLocalServiceUtil;
import net.sareweb.mshowcase.service.InstanceServiceUtil;
import net.sareweb.mshowcase.service.LocationLocalServiceUtil;
import net.sareweb.mshowcase.service.LocationServiceUtil;
import net.sareweb.mshowcase.service.OfferLocalServiceUtil;
import net.sareweb.mshowcase.service.OfferServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ActivityLocalServiceUtil.clearService();

			ActivityServiceUtil.clearService();
			CategoryLocalServiceUtil.clearService();

			CategoryServiceUtil.clearService();
			DealLocalServiceUtil.clearService();

			DealServiceUtil.clearService();
			FriendshipLocalServiceUtil.clearService();

			FriendshipServiceUtil.clearService();
			InstanceLocalServiceUtil.clearService();

			InstanceServiceUtil.clearService();
			InstanceImageLocalServiceUtil.clearService();

			InstanceImageServiceUtil.clearService();
			LocationLocalServiceUtil.clearService();

			LocationServiceUtil.clearService();
			OfferLocalServiceUtil.clearService();

			OfferServiceUtil.clearService();
		}
	}
}