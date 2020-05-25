package com.hwig.admin.MLogin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MLoginDAOImpl implements MLoginDAO{

	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.mloginMapper";

	@Override
	public MLoginVO mem_login(MLoginVO member) throws Exception {
		
		return sql.selectOne(namespace + ".mem_login", member);
	}
}
