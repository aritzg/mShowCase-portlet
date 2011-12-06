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

/**
 * <p>
 * This class is a wrapper for {@link DealService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       DealService
 * @generated
 */
public class DealServiceWrapper implements DealService {
	public DealServiceWrapper(DealService dealService) {
		_dealService = dealService;
	}

	public DealService getWrappedDealService() {
		return _dealService;
	}

	public void setWrappedDealService(DealService dealService) {
		_dealService = dealService;
	}

	private DealService _dealService;
}