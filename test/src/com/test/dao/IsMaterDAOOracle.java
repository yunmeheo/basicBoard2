package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.IsMater;

@Repository
public class IsMaterDAOOracle implements IsMaterDAO{
	
	@Autowired
	SqlSession session;

	@Override
	public void insert(IsMater im) {
		
		session.insert("IsMaterMapper.insert",im);
		
	}

	public List<IsMater> selectAll() {
		
		return session.selectList("IsMaterMapper.selectAll");
	}
	
	
	

}
