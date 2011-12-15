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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ActivityService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       ActivityService
 * @generated
 */
public class ActivityServiceWrapper implements ActivityService,
	ServiceWrapper<ActivityService> {
	public ActivityServiceWrapper(ActivityService activityService) {
		_activityService = activityService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ActivityService getWrappedActivityService() {
		return _activityService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedActivityService(ActivityService activityService) {
		_activityService = activityService;
	}

	public ActivityService getWrappedService() {
		return _activityService;
	}

	public void setWrappedService(ActivityService activityService) {
		_activityService = activityService;
	}

	private ActivityService _activityService;
}