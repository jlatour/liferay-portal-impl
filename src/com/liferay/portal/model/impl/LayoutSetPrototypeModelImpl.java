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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.LayoutSetPrototypeModel;
import com.liferay.portal.model.LayoutSetPrototypeSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the LayoutSetPrototype service. Represents a row in the &quot;LayoutSetPrototype&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.LayoutSetPrototypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutSetPrototypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetPrototypeImpl
 * @see com.liferay.portal.model.LayoutSetPrototype
 * @see com.liferay.portal.model.LayoutSetPrototypeModel
 * @generated
 */
@JSON(strict = true)
public class LayoutSetPrototypeModelImpl extends BaseModelImpl<LayoutSetPrototype>
	implements LayoutSetPrototypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout set prototype model instance should use the {@link com.liferay.portal.model.LayoutSetPrototype} interface instead.
	 */
	public static final String TABLE_NAME = "LayoutSetPrototype";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "layoutSetPrototypeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "settings_", Types.VARCHAR },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table LayoutSetPrototype (uuid_ VARCHAR(75) null,layoutSetPrototypeId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,name STRING null,description STRING null,settings_ STRING null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table LayoutSetPrototype";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.LayoutSetPrototype"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.LayoutSetPrototype"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.LayoutSetPrototype"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutSetPrototype toModel(LayoutSetPrototypeSoap soapModel) {
		LayoutSetPrototype model = new LayoutSetPrototypeImpl();

		model.setUuid(soapModel.getUuid());
		model.setLayoutSetPrototypeId(soapModel.getLayoutSetPrototypeId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setSettings(soapModel.getSettings());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutSetPrototype> toModels(
		LayoutSetPrototypeSoap[] soapModels) {
		List<LayoutSetPrototype> models = new ArrayList<LayoutSetPrototype>(soapModels.length);

		for (LayoutSetPrototypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.LayoutSetPrototype"));

	public LayoutSetPrototypeModelImpl() {
	}

	public long getPrimaryKey() {
		return _layoutSetPrototypeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLayoutSetPrototypeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_layoutSetPrototypeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return LayoutSetPrototype.class;
	}

	public String getModelClassName() {
		return LayoutSetPrototype.class.getName();
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getLayoutSetPrototypeId() {
		return _layoutSetPrototypeId;
	}

	public void setLayoutSetPrototypeId(long layoutSetPrototypeId) {
		_layoutSetPrototypeId = layoutSetPrototypeId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_name = name;
	}

	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String name = nameMap.get(locale);

			setName(name, locale, defaultLocale);
		}
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getSettings() {
		if (_settings == null) {
			return StringPool.BLANK;
		}
		else {
			return _settings;
		}
	}

	public void setSettings(String settings) {
		_settings = settings;
	}

	@JSON
	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LayoutSetPrototype toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (LayoutSetPrototype)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					LayoutSetPrototype.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		LayoutSetPrototypeImpl layoutSetPrototypeImpl = new LayoutSetPrototypeImpl();

		layoutSetPrototypeImpl.setUuid(getUuid());
		layoutSetPrototypeImpl.setLayoutSetPrototypeId(getLayoutSetPrototypeId());
		layoutSetPrototypeImpl.setCompanyId(getCompanyId());
		layoutSetPrototypeImpl.setCreateDate(getCreateDate());
		layoutSetPrototypeImpl.setModifiedDate(getModifiedDate());
		layoutSetPrototypeImpl.setName(getName());
		layoutSetPrototypeImpl.setDescription(getDescription());
		layoutSetPrototypeImpl.setSettings(getSettings());
		layoutSetPrototypeImpl.setActive(getActive());

		layoutSetPrototypeImpl.resetOriginalValues();

		return layoutSetPrototypeImpl;
	}

	public int compareTo(LayoutSetPrototype layoutSetPrototype) {
		long primaryKey = layoutSetPrototype.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LayoutSetPrototype layoutSetPrototype = null;

		try {
			layoutSetPrototype = (LayoutSetPrototype)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = layoutSetPrototype.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LayoutSetPrototypeModelImpl layoutSetPrototypeModelImpl = this;

		layoutSetPrototypeModelImpl._originalUuid = layoutSetPrototypeModelImpl._uuid;

		layoutSetPrototypeModelImpl._originalCompanyId = layoutSetPrototypeModelImpl._companyId;

		layoutSetPrototypeModelImpl._setOriginalCompanyId = false;

		layoutSetPrototypeModelImpl._originalActive = layoutSetPrototypeModelImpl._active;

		layoutSetPrototypeModelImpl._setOriginalActive = false;

		layoutSetPrototypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutSetPrototype> toCacheModel() {
		LayoutSetPrototypeCacheModel layoutSetPrototypeCacheModel = new LayoutSetPrototypeCacheModel();

		layoutSetPrototypeCacheModel.uuid = getUuid();

		String uuid = layoutSetPrototypeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			layoutSetPrototypeCacheModel.uuid = null;
		}

		layoutSetPrototypeCacheModel.layoutSetPrototypeId = getLayoutSetPrototypeId();

		layoutSetPrototypeCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutSetPrototypeCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutSetPrototypeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutSetPrototypeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutSetPrototypeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutSetPrototypeCacheModel.name = getName();

		String name = layoutSetPrototypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutSetPrototypeCacheModel.name = null;
		}

		layoutSetPrototypeCacheModel.description = getDescription();

		String description = layoutSetPrototypeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			layoutSetPrototypeCacheModel.description = null;
		}

		layoutSetPrototypeCacheModel.settings = getSettings();

		String settings = layoutSetPrototypeCacheModel.settings;

		if ((settings != null) && (settings.length() == 0)) {
			layoutSetPrototypeCacheModel.settings = null;
		}

		layoutSetPrototypeCacheModel.active = getActive();

		return layoutSetPrototypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", layoutSetPrototypeId=");
		sb.append(getLayoutSetPrototypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", settings=");
		sb.append(getSettings());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.LayoutSetPrototype");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutSetPrototypeId</column-name><column-value><![CDATA[");
		sb.append(getLayoutSetPrototypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>settings</column-name><column-value><![CDATA[");
		sb.append(getSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LayoutSetPrototype.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			LayoutSetPrototype.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _layoutSetPrototypeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _settings;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private LayoutSetPrototype _escapedModelProxy;
}