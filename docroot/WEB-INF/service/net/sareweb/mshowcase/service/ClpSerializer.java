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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import net.sareweb.mshowcase.model.ActivityClp;
import net.sareweb.mshowcase.model.CategoryClp;
import net.sareweb.mshowcase.model.DealClp;
import net.sareweb.mshowcase.model.FriendshipClp;
import net.sareweb.mshowcase.model.InstanceClp;
import net.sareweb.mshowcase.model.InstanceImageClp;
import net.sareweb.mshowcase.model.LocationClp;
import net.sareweb.mshowcase.model.OfferClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"mShowCase-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"mShowCase-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "mShowCase-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ActivityClp.class.getName())) {
			return translateInputActivity(oldModel);
		}

		if (oldModelClassName.equals(CategoryClp.class.getName())) {
			return translateInputCategory(oldModel);
		}

		if (oldModelClassName.equals(DealClp.class.getName())) {
			return translateInputDeal(oldModel);
		}

		if (oldModelClassName.equals(FriendshipClp.class.getName())) {
			return translateInputFriendship(oldModel);
		}

		if (oldModelClassName.equals(InstanceClp.class.getName())) {
			return translateInputInstance(oldModel);
		}

		if (oldModelClassName.equals(InstanceImageClp.class.getName())) {
			return translateInputInstanceImage(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
		}

		if (oldModelClassName.equals(OfferClp.class.getName())) {
			return translateInputOffer(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputActivity(BaseModel<?> oldModel) {
		ActivityClp oldCplModel = (ActivityClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.ActivityImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setActivityId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getActivityId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setType",
						new Class[] { String.class });

				String value1 = oldCplModel.getType();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUser2Id",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUser2Id());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setInstanceId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getInstanceId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setOfferId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getOfferId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getCompanyId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getCreateDate();

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputCategory(BaseModel<?> oldModel) {
		CategoryClp oldCplModel = (CategoryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.CategoryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCategoryId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setParentCategoryId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getParentCategoryId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value2 = oldCplModel.getName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPosition",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getPosition());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCompanyId());

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputDeal(BaseModel<?> oldModel) {
		DealClp oldCplModel = (DealClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.DealImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setDealId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getDealId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setOfferId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getOfferId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreateDate();

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputFriendship(BaseModel<?> oldModel) {
		FriendshipClp oldCplModel = (FriendshipClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.FriendshipImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setFriendshipId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getFriendshipId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUser2Id",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUser2Id());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setAccepted",
						new Class[] { Boolean.TYPE });

				Boolean value3 = new Boolean(oldCplModel.getAccepted());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setRejected",
						new Class[] { Boolean.TYPE });

				Boolean value4 = new Boolean(oldCplModel.getRejected());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCompanyId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getCreateDate();

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputInstance(BaseModel<?> oldModel) {
		InstanceClp oldCplModel = (InstanceClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.InstanceImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setInstanceId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getInstanceId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPhoneNumber",
						new Class[] { String.class });

				String value3 = oldCplModel.getPhoneNumber();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setFaxNumber",
						new Class[] { String.class });

				String value4 = oldCplModel.getFaxNumber();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value5 = oldCplModel.getEmail();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setWebPage",
						new Class[] { String.class });

				String value6 = oldCplModel.getWebPage();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCategoryLevel0",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getCategoryLevel0());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setCategoryLevel1",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getCategoryLevel1());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCategoryLevel2",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getCategoryLevel2());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getUserId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value11 = new Long(oldCplModel.getCompanyId());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getGroupId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value13 = oldCplModel.getCreateDate();

				method13.invoke(newModel, value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputInstanceImage(BaseModel<?> oldModel) {
		InstanceImageClp oldCplModel = (InstanceImageClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.InstanceImageImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setInstanceImageId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getInstanceImageId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setInstanceId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getInstanceId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setImageId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getImageId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setImageURL",
						new Class[] { String.class });

				String value3 = oldCplModel.getImageURL();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getCompanyId());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getCreateDate();

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputLocation(BaseModel<?> oldModel) {
		LocationClp oldCplModel = (LocationClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.LocationImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setLocationId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getLocationId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setInstanceId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getInstanceId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value2 = oldCplModel.getAddress();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setLat",
						new Class[] { Double.TYPE });

				Double value3 = new Double(oldCplModel.getLat());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLng",
						new Class[] { Double.TYPE });

				Double value4 = new Double(oldCplModel.getLng());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPhoneNumber",
						new Class[] { String.class });

				String value5 = oldCplModel.getPhoneNumber();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setFaxNumber",
						new Class[] { String.class });

				String value6 = oldCplModel.getFaxNumber();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setImageId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getImageId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setImageURL",
						new Class[] { String.class });

				String value8 = oldCplModel.getImageURL();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getUserId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getCompanyId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getCreateDate();

				method11.invoke(newModel, value11);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputOffer(BaseModel<?> oldModel) {
		OfferClp oldCplModel = (OfferClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.mshowcase.model.impl.OfferImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setOfferId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getOfferId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setInstanceId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getInstanceId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setOfferText",
						new Class[] { String.class });

				String value2 = oldCplModel.getOfferText();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setBeginDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getBeginDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setEndDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getEndDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setPrice",
						new Class[] { Double.TYPE });

				Double value5 = new Double(oldCplModel.getPrice());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setTransactions",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getTransactions());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setImageId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getImageId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setImageURL",
						new Class[] { String.class });

				String value8 = oldCplModel.getImageURL();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getUserId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value10 = new Long(oldCplModel.getCompanyId());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value11 = oldCplModel.getCreateDate();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setModifyDate",
						new Class[] { Date.class });

				Date value12 = oldCplModel.getModifyDate();

				method12.invoke(newModel, value12);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.ActivityImpl")) {
			return translateOutputActivity(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.CategoryImpl")) {
			return translateOutputCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.DealImpl")) {
			return translateOutputDeal(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.FriendshipImpl")) {
			return translateOutputFriendship(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.InstanceImpl")) {
			return translateOutputInstance(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.InstanceImageImpl")) {
			return translateOutputInstanceImage(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.OfferImpl")) {
			return translateOutputOffer(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputActivity(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ActivityClp newModel = new ActivityClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getActivityId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setActivityId(value0);

				Method method1 = oldModelClass.getMethod("getType");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setType(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getUser2Id");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUser2Id(value3);

				Method method4 = oldModelClass.getMethod("getInstanceId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setInstanceId(value4);

				Method method5 = oldModelClass.getMethod("getOfferId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setOfferId(value5);

				Method method6 = oldModelClass.getMethod("getCompanyId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value6);

				Method method7 = oldModelClass.getMethod("getCreateDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputCategory(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CategoryClp newModel = new CategoryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

				Method method1 = oldModelClass.getMethod("getParentCategoryId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setParentCategoryId(value1);

				Method method2 = oldModelClass.getMethod("getName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setName(value2);

				Method method2CurrentLanguageId = oldModelClass.getMethod(
						"getNameCurrentLanguageId");

				String value2CurrentLanguageId = (String)method2CurrentLanguageId.invoke(oldModel,
						(Object[])null);

				newModel.setNameCurrentLanguageId(value2CurrentLanguageId);

				Method method3 = oldModelClass.getMethod("getPosition");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setPosition(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getCompanyId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputDeal(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				DealClp newModel = new DealClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getDealId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setDealId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getOfferId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setOfferId(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getCreateDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputFriendship(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FriendshipClp newModel = new FriendshipClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getFriendshipId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setFriendshipId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getUser2Id");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUser2Id(value2);

				Method method3 = oldModelClass.getMethod("getAccepted");

				Boolean value3 = (Boolean)method3.invoke(oldModel,
						(Object[])null);

				newModel.setAccepted(value3);

				Method method4 = oldModelClass.getMethod("getRejected");

				Boolean value4 = (Boolean)method4.invoke(oldModel,
						(Object[])null);

				newModel.setRejected(value4);

				Method method5 = oldModelClass.getMethod("getCompanyId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value5);

				Method method6 = oldModelClass.getMethod("getCreateDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputInstance(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				InstanceClp newModel = new InstanceClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getInstanceId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setInstanceId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method2CurrentLanguageId = oldModelClass.getMethod(
						"getDescriptionCurrentLanguageId");

				String value2CurrentLanguageId = (String)method2CurrentLanguageId.invoke(oldModel,
						(Object[])null);

				newModel.setDescriptionCurrentLanguageId(value2CurrentLanguageId);

				Method method3 = oldModelClass.getMethod("getPhoneNumber");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setPhoneNumber(value3);

				Method method4 = oldModelClass.getMethod("getFaxNumber");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setFaxNumber(value4);

				Method method5 = oldModelClass.getMethod("getEmail");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setEmail(value5);

				Method method6 = oldModelClass.getMethod("getWebPage");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setWebPage(value6);

				Method method7 = oldModelClass.getMethod("getCategoryLevel0");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setCategoryLevel0(value7);

				Method method8 = oldModelClass.getMethod("getCategoryLevel1");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setCategoryLevel1(value8);

				Method method9 = oldModelClass.getMethod("getCategoryLevel2");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setCategoryLevel2(value9);

				Method method10 = oldModelClass.getMethod("getUserId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setUserId(value10);

				Method method11 = oldModelClass.getMethod("getCompanyId");

				Long value11 = (Long)method11.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value11);

				Method method12 = oldModelClass.getMethod("getGroupId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value12);

				Method method13 = oldModelClass.getMethod("getCreateDate");

				Date value13 = (Date)method13.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputInstanceImage(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				InstanceImageClp newModel = new InstanceImageClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getInstanceImageId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setInstanceImageId(value0);

				Method method1 = oldModelClass.getMethod("getInstanceId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setInstanceId(value1);

				Method method2 = oldModelClass.getMethod("getImageId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setImageId(value2);

				Method method3 = oldModelClass.getMethod("getImageURL");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setImageURL(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getCompanyId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value5);

				Method method6 = oldModelClass.getMethod("getCreateDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputLocation(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				LocationClp newModel = new LocationClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getLocationId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setLocationId(value0);

				Method method1 = oldModelClass.getMethod("getInstanceId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setInstanceId(value1);

				Method method2 = oldModelClass.getMethod("getAddress");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setAddress(value2);

				Method method3 = oldModelClass.getMethod("getLat");

				Double value3 = (Double)method3.invoke(oldModel, (Object[])null);

				newModel.setLat(value3);

				Method method4 = oldModelClass.getMethod("getLng");

				Double value4 = (Double)method4.invoke(oldModel, (Object[])null);

				newModel.setLng(value4);

				Method method5 = oldModelClass.getMethod("getPhoneNumber");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setPhoneNumber(value5);

				Method method6 = oldModelClass.getMethod("getFaxNumber");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setFaxNumber(value6);

				Method method7 = oldModelClass.getMethod("getImageId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setImageId(value7);

				Method method8 = oldModelClass.getMethod("getImageURL");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setImageURL(value8);

				Method method9 = oldModelClass.getMethod("getUserId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setUserId(value9);

				Method method10 = oldModelClass.getMethod("getCompanyId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value10);

				Method method11 = oldModelClass.getMethod("getCreateDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value11);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputOffer(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				OfferClp newModel = new OfferClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getOfferId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setOfferId(value0);

				Method method1 = oldModelClass.getMethod("getInstanceId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setInstanceId(value1);

				Method method2 = oldModelClass.getMethod("getOfferText");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setOfferText(value2);

				Method method2CurrentLanguageId = oldModelClass.getMethod(
						"getOfferTextCurrentLanguageId");

				String value2CurrentLanguageId = (String)method2CurrentLanguageId.invoke(oldModel,
						(Object[])null);

				newModel.setOfferTextCurrentLanguageId(value2CurrentLanguageId);

				Method method3 = oldModelClass.getMethod("getBeginDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setBeginDate(value3);

				Method method4 = oldModelClass.getMethod("getEndDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setEndDate(value4);

				Method method5 = oldModelClass.getMethod("getPrice");

				Double value5 = (Double)method5.invoke(oldModel, (Object[])null);

				newModel.setPrice(value5);

				Method method6 = oldModelClass.getMethod("getTransactions");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setTransactions(value6);

				Method method7 = oldModelClass.getMethod("getImageId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setImageId(value7);

				Method method8 = oldModelClass.getMethod("getImageURL");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setImageURL(value8);

				Method method9 = oldModelClass.getMethod("getUserId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setUserId(value9);

				Method method10 = oldModelClass.getMethod("getCompanyId");

				Long value10 = (Long)method10.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value10);

				Method method11 = oldModelClass.getMethod("getCreateDate");

				Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value11);

				Method method12 = oldModelClass.getMethod("getModifyDate");

				Date value12 = (Date)method12.invoke(oldModel, (Object[])null);

				newModel.setModifyDate(value12);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}