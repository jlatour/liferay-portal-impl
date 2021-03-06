/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutCloneFactory {

	public static LayoutClone getInstance() {
		if (_layoutClone == null) {
			if (Validator.isNotNull(PropsValues.LAYOUT_CLONE_IMPL)) {
				if (_log.isDebugEnabled()) {
					_log.debug("Instantiate " + PropsValues.LAYOUT_CLONE_IMPL);
				}

				ClassLoader classLoader =
					PortalClassLoaderUtil.getClassLoader();

				try {
					_layoutClone = (LayoutClone)classLoader.loadClass(
						PropsValues.LAYOUT_CLONE_IMPL).newInstance();
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
		}
		else {
			if (_log.isDebugEnabled()) {
				_log.debug("Return " + _layoutClone.getClass().getName());
			}
		}

		return _layoutClone;
	}

	private static Log _log = LogFactoryUtil.getLog(LayoutCloneFactory.class);

	private static LayoutClone _layoutClone;

}