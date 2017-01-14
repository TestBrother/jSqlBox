/**
 * Copyright (C) 2016 Yong Zhu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.drinkjava2.jsqlbox;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * In this class just copied some common DB access methods from default SqlBoxContext
 * 
 * @author Yong Zhu (Yong9981@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
public class Dao {

	private Dao() {
		// Hide default constructor
	}

	// == shortcut methods, just copy some common public static method here======
	public static Integer queryForInteger(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().queryForInteger(sql);
	}

	public static String queryForString(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().queryForString(sql);
	}

	public static <T> T queryForObject(Class<?> clazz, String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().queryForObject(clazz, sql);
	}

	public static void cacheSQL(String... sql) {
		SqlBoxContext.getDefaultSqlBoxContext().cacheSQL(sql);
	}

	public static Integer execute(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().execute(sql);
	}

	public static Integer executeInsert(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().executeInsert(sql);
	}

	public static Integer executeQuiet(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().executeQuiet(sql);
	}

	public static void executeCachedSQLs() {
		SqlBoxContext.getDefaultSqlBoxContext().executeCachedSQLs();
	}

	public static JdbcTemplate getDefaultJdbc() {
		return SqlBoxContext.getDefaultSqlBoxContext().getJdbc();
	}

	public static SqlBoxContext getDefaultContext() {
		return SqlBoxContext.getDefaultSqlBoxContext();
	}

	public static DatabaseType getDefaultDatabaseType() {
		return SqlBoxContext.getDefaultSqlBoxContext().getDatabaseType();
	}

	public static void refreshMetaData() {
		SqlBoxContext.getDefaultSqlBoxContext().refreshMetaData();
	}

	public static <T> T load(Class<?> entityOrBoxClass, Object entityID) {
		return SqlBoxContext.getDefaultSqlBoxContext().load(entityOrBoxClass, entityID);
	}

	public static List<Map<String, Object>> queryForList(String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().queryForList(sql);
	}

	public static <T> List<T> queryForDbList(Class<T> dbClass, String... sql) {
		return SqlBoxContext.getDefaultSqlBoxContext().queryForDbList(dbClass, sql);
	}

}
