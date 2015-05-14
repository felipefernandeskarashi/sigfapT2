package com.sigfap.admin.model.dao;

import java.sql.Types;

import org.hibernate.cfg.Environment;
import org.hibernate.dialect.PostgreSQL9Dialect;

public class SpecificPostgreSQLDialect extends PostgreSQL9Dialect {

	public SpecificPostgreSQLDialect() {
		super();
	}
}