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

package net.sareweb.mshowcase.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Aritz Galdos
 */
public class CategoryPK implements Comparable<CategoryPK>, Serializable {
	public long categoryId;
	public long parentCategoryId;

	public CategoryPK() {
	}

	public CategoryPK(long categoryId, long parentCategoryId) {
		this.categoryId = categoryId;
		this.parentCategoryId = parentCategoryId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public int compareTo(CategoryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (categoryId < pk.categoryId) {
			value = -1;
		}
		else if (categoryId > pk.categoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (parentCategoryId < pk.parentCategoryId) {
			value = -1;
		}
		else if (parentCategoryId > pk.parentCategoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CategoryPK pk = null;

		try {
			pk = (CategoryPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((categoryId == pk.categoryId) &&
				(parentCategoryId == pk.parentCategoryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(categoryId) + String.valueOf(parentCategoryId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("categoryId");
		sb.append(StringPool.EQUAL);
		sb.append(categoryId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("parentCategoryId");
		sb.append(StringPool.EQUAL);
		sb.append(parentCategoryId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}