package com.hwig.admin.event;

import java.util.List;

public interface EventDAO {
	public List<EventVO> eList() throws Exception;
	public int event_write(EventVO event) throws Exception;
	public EventVO event_view(int event_id) throws Exception;
	public int event_modify(EventVO event) throws Exception;
	public int event_delete(int event_id) throws Exception;
	public void event_id_d(EventVO event) throws Exception;
	
	public List<EventVO> event_square() throws Exception;
	public List<EventVO> event_list() throws Exception;
	public List<EventVO> event_banner() throws Exception;
	public EventVO event_content(int event_id) throws Exception;
}
