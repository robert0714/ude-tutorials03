package com.iisigroup.jtd.ude.tutorials03.services;
///*
// * Copyright (c) 2010-2020 IISI.
// * All rights reserved.
// *
// * This software is the confidential and proprietary information of IISI.
// */
//package com.iisigroup.jtd.ude.tutorials03.services;
//
//import com.iisigroup.jtd.ude.tutorials03.model.Contact;
//import com.iisigroup.ude.db.dbaccess.common.DBCellValue;
//import com.iisigroup.ude.db.dbaccess.common.DBRowMap;
//
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Field;
//import java.math.BigDecimal;
//import java.util.Set;
//import java.util.Map.Entry;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.commons.lang3.ClassUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.commons.lang3.reflect.FieldUtils;
//import org.joda.time.DateTime;
//import org.joda.time.convert.ConverterManager;
//import org.joda.time.format.DateTimeFormatter;
//import org.joda.time.format.ISODateTimeFormat;
//
///**
// *
// */
//public class ContactConvertor4UDE
//		implements
//		com.iisigroup.ude.db.dbaccess.common.PagedQueryResults.MapConverter<Contact> {
//	/** Logger Object. */
//	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
//			.getLogger(ContactConvertor4UDE.class);
//
//	public Contact convert(DBRowMap dbRowMap) {
//		return convertFromDBRowMap(dbRowMap);
//	}
//
//	private Contact convertFromDBRowMap(DBRowMap originalUnit) {
//		Contact result = new Contact(); 
//	
//		final Set<Entry<String, String>> entrySet = originalUnit.entrySet();
//		
//		for (Entry<String, String> unit : entrySet) {
//			final String colName = unit.getKey();
//			final String colValue = unit.getValue();
//			if (colValue == null) {
//				continue;
//			}
//			DBCellValue dbCellValue = originalUnit.getCell(colName);
//			Object value = dbCellValue.getData();
//			final String name = convertColumnKey(colName);
//			try {
//				PropertyDescriptor pd = PropertyUtils.getPropertyDescriptor(
//						result, name);
//
//				final Class<?> clzType = pd.getPropertyType();
//				final Class<?> valueType = colValue.getClass();
//				if (colValue != null
//						&& !ClassUtils.isAssignable(valueType,
//								clzType)) {
//					if (Long.class.equals(clzType)) {
//						
//						Long longValue = ((Number)value).longValue();
//						PropertyUtils.setProperty(result, name, longValue);
//						
//					} else if (Integer.class.equals(clzType )) {
//						
//						Integer integerValue = ((Number)value).intValue();
//						PropertyUtils.setProperty(result, name, integerValue);
//						
//					} else if (org.joda.time.DateTime.class.equals(clzType)) {
//						DateTimeFormatter format = ISODateTimeFormat.date();
//						org.joda.time.DateTime date = format.parseDateTime(colValue);
//						
//						PropertyUtils.setProperty(result, name, date);
//					}
//				}else{
//					PropertyUtils.setProperty(result, name, value);
//				}
//
//				
//			} catch (Exception e) {
//				LOGGER.error(e.getMessage(), e);
//			}
//		}
//		 
//		return result;
//	}
//
//	private String convertColumnKey(String columnName) {
//		final String[] strArray = StringUtils.splitPreserveAllTokens(
//				columnName, "_");
//		for (int i = 0; i < strArray.length; ++i) {
//			if (i != 0) {
//				strArray[i] = StringUtils.capitalize(strArray[i]);
//			} else {
//				strArray[i] = StringUtils.lowerCase(strArray[i]);
//			}
//		}
//		return StringUtils.join(strArray);
//	}
//}
