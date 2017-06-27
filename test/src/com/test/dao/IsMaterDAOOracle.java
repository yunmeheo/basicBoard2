package com.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<IsMater> selectAll(int startPage, int endPage) {
		
		Map<String,Object> map = new HashMap<>();
		System.out.println("IsMaterDAOOracle startPage : "+startPage+", endPage"+endPage);
		map.put("startPage", startPage);
		map.put("endPage",endPage);
		return session.selectList("IsMaterMapper.selectAll",map);
	}

	@Override
	public List<IsMater> selectAll() {
		return session.selectList("IsMaterMapper.selectAllList");
	}

	
	
	

}
