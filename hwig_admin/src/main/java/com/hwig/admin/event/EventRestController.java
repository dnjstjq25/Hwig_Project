package com.hwig.admin.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/event")
public class EventRestController {

		@Inject
		EventService eService;
		
		@GetMapping("/event_main")
		public Map<String,Object> event_main() throws Exception{
			
			Map<String,Object> responseEvent = new HashMap<String,Object>();
			List<EventVO> e_square = eService.event_square();
			List<EventVO> e_banner = eService.event_banner();
			
			responseEvent.put("square", e_square);
			responseEvent.put("banner", e_banner);
		
			return responseEvent;
		}
		@GetMapping("/event_list")
		public List<EventVO> event_list() throws Exception{
			
			return eService.event_list();
		}
		
		@GetMapping("/event_content")
		public EventVO event_content(@RequestParam("event_id") int event_id) throws Exception{
			
			return eService.event_content(event_id);
		}
}
