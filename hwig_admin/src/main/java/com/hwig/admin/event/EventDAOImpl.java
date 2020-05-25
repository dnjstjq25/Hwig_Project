package com.hwig.admin.event;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO{

	@Inject
	SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.eventMapper";
	
	//이벤트 리스트
	@Override
	public List<EventVO> eList() throws Exception {
		
		return sql.selectList(namespace + ".eList");
	}
	
	//이벤트 등록
	@Override
	public int event_write(EventVO event) throws Exception {
		
		return sql.insert(namespace + ".event_write", event);
	}
	
	//이벤트 상세보기
	@Override
	public EventVO event_view(int event_id) throws Exception {
		
		return sql.selectOne(namespace + ".event_view", event_id);
	}
	
	//이벤트 수정
	@Override
	public int event_modify(EventVO event) throws Exception {
		
		return sql.update(namespace + ".event_modify", event);
	}

	//이벤트 삭제
	@Override
	public int event_delete(int event_id) throws Exception {
		
		return sql.delete(namespace + ".event_delete", event_id);
	}
	
	//이벤트 삭제시 아이디값 올려줌
	@Override
	public void event_id_d(EventVO event) throws Exception {
		
		sql.update(namespace + ".event_id_d", event);
	}

	@Override
	public List<EventVO> event_square() throws Exception {
		
		return sql.selectList(namespace + ".event_square");
	}

	@Override
	public List<EventVO> event_list() throws Exception {
		
		return sql.selectList(namespace + ".event_list");
	}

	@Override
	public List<EventVO> event_banner() throws Exception {
		
		return sql.selectList(namespace + ".event_banner");
	}

	@Override
	public EventVO event_content(int event_id) throws Exception {
		
		return sql.selectOne(namespace + ".event_content", event_id);
	}

}
