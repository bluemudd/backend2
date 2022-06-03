package com.test.java;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
@Autowired
SqlSessionTemplate sqlSessionTemplate;
public int insert(Map<String, Object> map) {
	return this.sqlSessionTemplate.insert("board.insert", map);
}
public Map<String, Object> selectDetail(Map<String, Object> map){
	return this.sqlSessionTemplate.selectOne("board.select_detail", map);
}
}
