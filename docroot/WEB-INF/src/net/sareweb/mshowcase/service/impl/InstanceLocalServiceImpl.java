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

import net.sareweb.mshowcase.model.Instance;
import net.sareweb.mshowcase.service.base.InstanceLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.sareweb.mshowcase.service.InstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Aritz Galdos
 * @see net.sareweb.mshowcase.service.base.InstanceLocalServiceBaseImpl
 * @see net.sareweb.mshowcase.service.InstanceLocalServiceUtil
 */
public class InstanceLocalServiceImpl extends InstanceLocalServiceBaseImpl {
	
	public Instance getInstanceByUserId(long userId){
		try {
			return getInstancePersistence().fetchByUserId(userId);
		} catch (SystemException e) {
			return null;
		}
	}
	
	public List<Instance> getInstancesInCategory(long categoryId){
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Instance.class);
		if(categoryId!=0){
			
			Criterion catLevel0Crt = PropertyFactoryUtil.forName("categoryLevel0").eq(categoryId);
			Criterion catLevel1Crt = PropertyFactoryUtil.forName("categoryLevel1").eq(categoryId);
			Criterion catLevel2Crt = PropertyFactoryUtil.forName("categoryLevel2").eq(categoryId);
			
			Criterion or1 =RestrictionsFactoryUtil.or(catLevel0Crt, catLevel1Crt);
			Criterion or2 =RestrictionsFactoryUtil.or(or1, catLevel2Crt);
			
			dq.add(or2);
		}
		
		try {
			return getInstancePersistence().findWithDynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
			return new Vector<Instance>();
		}
		
	}
}