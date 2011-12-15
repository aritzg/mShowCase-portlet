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
 * This class is a wrapper for {@link OfferService}.
 * </p>
 *
 * @author    Aritz Galdos
 * @see       OfferService
 * @generated
 */
public class OfferServiceWrapper implements OfferService,
	ServiceWrapper<OfferService> {
	public OfferServiceWrapper(OfferService offerService) {
		_offerService = offerService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OfferService getWrappedOfferService() {
		return _offerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOfferService(OfferService offerService) {
		_offerService = offerService;
	}

	public OfferService getWrappedService() {
		return _offerService;
	}

	public void setWrappedService(OfferService offerService) {
		_offerService = offerService;
	}

	private OfferService _offerService;
}