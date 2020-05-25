package com.hwig.admin.event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Inject
	EventService eService;
	
	//저장경로(고정)
	@Resource(name="savePath")
	private String savePath;
	
	//저장경로(바뀔 수 있음)
	@Resource(name="EventAttachPath")
	private String attachPath;
	
	//이벤트 목록 조회
	@RequestMapping(value = "/elist")
	public void eList(Model model) throws Exception{
		model.addAttribute("eList", eService.eList());
	}
	
	//이벤트 등록폼
	@RequestMapping(value = "/event_write")
	public void getEvent_write() throws Exception{
		
	}
	
	//이벤트 등록
	@RequestMapping(value = "/event_write", method = RequestMethod.POST)
	public String postEvent_write(EventVO event, MultipartFile[] file, RedirectAttributes rttr, HttpSession session) throws Exception{
		
		int count = 0;
		System.out.println(file[0].getOriginalFilename());
		System.out.println(file[1].getOriginalFilename());
		System.out.println(file[2].getOriginalFilename());
		System.out.println(file[3].getOriginalFilename());
		for(MultipartFile files : file)
		{
			if(files.getOriginalFilename() != null && !files.getOriginalFilename().equals("")) {
				//파일명 생성
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + files.getOriginalFilename();
				
				FileOutputStream fos = new FileOutputStream(savePath + attachPath + "/" + fileName);
				InputStream is = files.getInputStream();
				
				int readCount = 0;
				byte[] buffer = new byte[1024];
				
				while ((readCount = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
				fos.close();
				
				String path = session.getServletContext().getRealPath("/");
				System.out.println("■path:::"+path);
				
				if(count==0 && file[0].getOriginalFilename() != null && !file[0].getOriginalFilename().equals("")) {
					event.setEvent_content_img(attachPath + "/" + fileName);
					System.out.println("본문 이미지 등록"+event.getEvent_content_img()+" "+count);
				}
				else if(count==1 && file[1].getOriginalFilename() != null && !file[1].getOriginalFilename().equals("")) {
					event.setEvent_banner_img(attachPath + "/" + fileName);
					System.out.println("배너 이미지 등록"+event.getEvent_banner_img()+" "+count);
				}
				else if(count==2 && file[2].getOriginalFilename() != null && !file[2].getOriginalFilename().equals("")) {
					event.setEvent_square_img(attachPath + "/" + fileName);
					System.out.println("사각 이미지 등록"+event.getEvent_square_img()+" "+count);
				}
				else if(count==3 && file[3].getOriginalFilename() != null && !file[3].getOriginalFilename().equals("")) {
					event.setEvent_list_img(attachPath + "/" + fileName);
					System.out.println("리스트 이미지 등록"+event.getEvent_list_img()+" "+count);
				}
			}
			count++;
		}
		
		int result = eService.event_write(event);
		
		if(result == 1) {
	         rttr.addFlashAttribute("msg", "success");
	      }
	      else {
	         rttr.addFlashAttribute("msg", "fail");
	      }

		return "redirect:/event/elist";
	}
	
	//이벤트 조회
	@RequestMapping(value = "/event_view")
	public void event_view(@RequestParam("event_id") int event_id, Model model) throws Exception{
		
		EventVO event = eService.event_view(event_id);
		
		model.addAttribute("event_view", event);
	}
	
	//이벤트 수정폼
	@RequestMapping(value = "/event_modify")
	public void getEvent_modify(@RequestParam("event_id") int event_id, Model model ) throws Exception{
		
		EventVO event = eService.event_view(event_id);
		
		model.addAttribute("event_view", event);
	}
	
	//이벤트 수정
	@RequestMapping(value = "/event_modify", method = RequestMethod.POST)
	public String postEvent_modify(EventVO event, RedirectAttributes rttr, MultipartFile[] file, HttpServletRequest req, HttpSession session) throws Exception{
		
		int count = 0;
		
		for(MultipartFile files : file)
		{
			if(files.getOriginalFilename() != null && !files.getOriginalFilename().equals("")) {
				//기존 파일 삭제
				if(count==0) {
					new File(savePath + req.getParameter("event_content_img")).delete();
					System.out.println("기존 본문 이미지 삭제");
				}
				else if(count==1) {
					new File(savePath + req.getParameter("event_banner_img")).delete();
					System.out.println("기존 배너 이미지 삭제");
				}
				else if(count==2) {
					new File(savePath + req.getParameter("event_square_img")).delete();
					System.out.println("기존 사각 이미지 삭제");
				}
				else if(count==3) {
					new File(savePath + req.getParameter("event_list_img")).delete();
					System.out.println("기존 목록 이미지 삭제");
				}
				
				//파일명 생성
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + files.getOriginalFilename();
				
				FileOutputStream fos = new FileOutputStream(savePath + attachPath + "/" + fileName);
				InputStream is = files.getInputStream();
				
				int readCount = 0;
				byte[] buffer = new byte[1024];
				
				while ((readCount = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
				fos.close();
				String path = session.getServletContext().getRealPath("/");
				System.out.println("■path:::"+path);
				if(count==0) {
					event.setEvent_content_img(attachPath + "/" + fileName);
					System.out.println("본문 이미지 수정"+event.getEvent_content_img()+" "+count);
				}
				else if(count==1) {
					event.setEvent_banner_img(attachPath + "/" + fileName);
					System.out.println("배너 이미지 수정"+event.getEvent_banner_img()+" "+count);
				}
				else if(count==2) {
					event.setEvent_square_img(attachPath + "/" + fileName);
					System.out.println("사각 이미지 수정"+event.getEvent_square_img()+" "+count);
				}
				else if(count==3) {
					event.setEvent_list_img(attachPath + "/" + fileName);
					System.out.println("리스트 이미지 수정"+event.getEvent_list_img()+" "+count);
				}
			} else {
				if(count==0 && file[0].getOriginalFilename() != null && !file[0].getOriginalFilename().equals("")) {
					event.setEvent_content_img(req.getParameter("event_content_img"));
					System.out.println("본문 이미지 그대로");
				}
				else if(count==1 && file[1].getOriginalFilename() != null && !file[1].getOriginalFilename().equals("")) {
					event.setEvent_banner_img(req.getParameter("event_banner_img"));
					System.out.println("배너 이미지 수정");
				}
				else if(count==2 && file[2].getOriginalFilename() != null && !file[2].getOriginalFilename().equals("")) {
					event.setEvent_square_img(req.getParameter("event_square_img"));
					System.out.println("사각 이미지 수정");
				}
				else if(count==3 && file[3].getOriginalFilename() != null && !file[3].getOriginalFilename().equals("")) {
					event.setEvent_list_img(req.getParameter("event_list_img"));
					System.out.println("리스트 이미지 수정");
				}
			}
			count++;
		}
		int result = eService.event_modify(event);
		
		if(result == 1) {
	         rttr.addFlashAttribute("msg", "success");
	      }
	      else {
	         rttr.addFlashAttribute("msg", "fail");
	      }

		return "redirect:/event/elist";
	}
	
	//이벤트 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/event_delete", method = RequestMethod.GET)
	public String event_delete(EventVO event, int event_id, RedirectAttributes rttr, HttpServletRequest req) throws Exception
	{
		int count = 0;
		
		//기존 이미지 삭제
		for(int i=0; i<4; i++) {
			
			if(count==0) {
				new File(savePath + req.getParameter("event_content_img")).delete();
				System.out.println("경로에 있는 본문 이미지 삭제");
			}
			else if(count==1) {
				new File(savePath + req.getParameter("event_banner_img")).delete();
				System.out.println("경로에 있는 배너 이미지 삭제");
			}
			else if(count==2) {
				new File(savePath + req.getParameter("event_square_img")).delete();
				System.out.println("경로에 있는 사각 이미지 삭제");
			}
			else if(count==3) {
				new File(savePath + req.getParameter("event_list_img")).delete();
				System.out.println("경로에 있는 목록 이미지 삭제");
			}
		}
		
		int result = eService.event_delete(event_id);
		eService.event_id_d(event);

		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/event/elist";
	}
}
