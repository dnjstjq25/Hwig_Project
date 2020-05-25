package com.hwig.admin.event;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

	@Inject
	EventDAO dao;
	
	@Override
	public List<EventVO> eList() throws Exception {
		
		return dao.eList();
	}

	@Override
	public int event_write(EventVO event) throws Exception {
		
		return dao.event_write(event);
	}

	@Override
	public EventVO event_view(int event_id) throws Exception {
		
		return dao.event_view(event_id);
	}

	@Override
	public int event_modify(EventVO event) throws Exception {
		
		return dao.event_modify(event);
	}

	@Override
	public int event_delete(int event_id) throws Exception {
		
		return dao.event_delete(event_id);
	}

	@Override
	public void event_id_d(EventVO event) throws Exception {
		
		dao.event_id_d(event);
	}

	@Override
	public List<EventVO> event_square() throws Exception {
		
		return dao.event_square();
	}

	@Override
	public List<EventVO> event_list() throws Exception {
		
		return dao.event_list();
	}

	@Override
	public List<EventVO> event_banner() throws Exception {
		
		return dao.event_banner();
	}

	@Override
	public EventVO event_content(int event_id) throws Exception {
		
		return dao.event_content(event_id);
	}

}
