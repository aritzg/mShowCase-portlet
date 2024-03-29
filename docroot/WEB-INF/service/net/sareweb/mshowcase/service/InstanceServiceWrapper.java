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
 * This class is a wrapper for {@link InstanceService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       InstanceService
 * @generated
 */
public class InstanceServiceWrapper implements InstanceService,
	ServiceWrapper<InstanceService> {
	public InstanceServiceWrapper(InstanceService instanceService) {
		_instanceService = instanceService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InstanceService getWrappedInstanceService() {
		return _instanceService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInstanceService(InstanceService instanceService) {
		_instanceService = instanceService;
	}

	public InstanceService getWrappedService() {
		return _instanceService;
	}

	public void setWrappedService(InstanceService instanceService) {
		_instanceService = instanceService;
	}

	private InstanceService _instanceService;
}