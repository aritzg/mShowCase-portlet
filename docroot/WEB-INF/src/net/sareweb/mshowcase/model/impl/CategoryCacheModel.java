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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.sareweb.mshowcase.model.Category;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Aritz Galdos
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", position=");
		sb.append(position);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setParentCategoryId(parentCategoryId);

		if (name == null) {
			categoryImpl.setName(StringPool.BLANK);
		}
		else {
			categoryImpl.setName(name);
		}

		categoryImpl.setPosition(position);
		categoryImpl.setUserId(userId);
		categoryImpl.setCompanyId(companyId);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	public long categoryId;
	public long parentCategoryId;
	public String name;
	public int position;
	public long userId;
	public long companyId;
}