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

package net.sareweb.mshowcase.service.impl;

import java.util.List;
import java.util.Vector;

import net.sareweb.mshowcase.model.Deal;
import net.sareweb.mshowcase.service.base.DealLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the deal local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.sareweb.mshowcase.service.DealLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Aritz Galdos
 * @see net.sareweb.mshowcase.service.base.DealLocalServiceBaseImpl
 * @see net.sareweb.mshowcase.service.DealLocalServiceUtil
 */
public class DealLocalServiceImpl extends DealLocalServiceBaseImpl {
	public List<Deal> getDealsByInstanceId(long instanceId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Deal.class);
		Criterion instanceIdCrt = PropertyFactoryUtil.forName("instanceId").eq(
				instanceId);
		dq.add(instanceIdCrt);
		try {
			return getInstancePersistence().findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
			return new Vector<Deal>();
		}
	}

	public long countDealsByInstanceId(long instanceId) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Deal.class);
		Criterion instanceIdCrt = PropertyFactoryUtil.forName("instanceId").eq(
				instanceId);
		dq.add(instanceIdCrt);
		try {
			return getInstancePersistence().countWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
			return 0;
		}
	}
}