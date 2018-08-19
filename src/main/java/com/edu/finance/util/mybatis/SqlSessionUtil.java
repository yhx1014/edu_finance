package com.edu.finance.util.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import com.edu.finance.framework.context.SpringContextHolder;

public class SqlSessionUtil {
	
	private static SqlSession sqlSession = null;
	static{
		sqlSession = new SqlSessionTemplate((SqlSessionFactory)SpringContextHolder.getBean("sqlSessionFactory"));
	}
	
	public static <T> T getMapper(Class<T> clazz){
		Configuration config=sqlSession.getConfiguration();
        if(!config.hasMapper(clazz)){
            config.addMapper(clazz);
        }
        return sqlSession.getMapper(clazz);
	}
	
	public static SqlSession getSqlSession(){
		return sqlSession;
	}
}
