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

import net.sareweb.mshowcase.model.InstanceClp;
import net.sareweb.mshowcase.model.LocationClp;

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

		if (oldModelClassName.equals(InstanceClp.class.getName())) {
			return translateInputInstance(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
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

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getGroupId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreateDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLastModifiedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getLastModifiedDate();

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

				Method method1 = newModelClass.getMethod("setAddress",
						new Class[] { String.class });

				String value1 = oldCplModel.getAddress();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setLat",
						new Class[] { Float.TYPE });

				Float value2 = new Float(oldCplModel.getLat());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setLng",
						new Class[] { Float.TYPE });

				Float value3 = new Float(oldCplModel.getLng());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setImageId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getImageId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setImageURL",
						new Class[] { String.class });

				String value5 = oldCplModel.getImageURL();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getUserId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getCompanyId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getGroupId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getCreateDate();

				method9.invoke(newModel, value9);

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
					"net.sareweb.mshowcase.model.impl.InstanceImpl")) {
			return translateOutputInstance(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.mshowcase.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
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

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getGroupId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value4);

				Method method5 = oldModelClass.getMethod("getCreateDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value5);

				Method method6 = oldModelClass.getMethod("getLastModifiedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setLastModifiedDate(value6);

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

				Method method1 = oldModelClass.getMethod("getAddress");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setAddress(value1);

				Method method2 = oldModelClass.getMethod("getLat");

				Float value2 = (Float)method2.invoke(oldModel, (Object[])null);

				newModel.setLat(value2);

				Method method3 = oldModelClass.getMethod("getLng");

				Float value3 = (Float)method3.invoke(oldModel, (Object[])null);

				newModel.setLng(value3);

				Method method4 = oldModelClass.getMethod("getImageId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setImageId(value4);

				Method method5 = oldModelClass.getMethod("getImageURL");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setImageURL(value5);

				Method method6 = oldModelClass.getMethod("getUserId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setUserId(value6);

				Method method7 = oldModelClass.getMethod("getCompanyId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value7);

				Method method8 = oldModelClass.getMethod("getGroupId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value8);

				Method method9 = oldModelClass.getMethod("getCreateDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value9);

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