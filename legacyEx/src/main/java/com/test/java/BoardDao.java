package com.test.java;

import java.util.List;
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
public int update(Map<String, Object>map) {
	return this.sqlSessionTemplate.update("board.update",map);
}
public List<Map<String, Object>> selectList(Map<String, Object> map){
	return this.sqlSessionTemplate.selectList("board.select_list",map);
}
}
