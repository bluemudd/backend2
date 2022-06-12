package com.test.java;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; /*컨트롤러의 처리 결과를 보여 줄 뷰와 뷰에 전달할 값을 저장하는 용도*/

@Controller
public class NbController {
//	@GetMapping("NoticeBoard/create")
//	public String list(Model model) {
//		return "NoticeBoard/create";
//	}
//}
	@Autowired
	BoardService boardService;
	@GetMapping("/create")
	public ModelAndView create() {
		return new ModelAndView("NoticeBoard/create");
	}
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String boardId = this.boardService.create(map);
		if (boardId == null) {
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?boardId=" +boardId);
		}
		return mav;
	}
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map){
		Map<String, Object> detailMap = this.boardService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String boardId= map.get("boardId").toString();
		mav.addObject("boardId", boardId);
		mav.setViewName("/NoticeBoard/detail");
		return mav;
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object>map) {
		Map<String, Object> detailMap=this.boardService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/NoticeBoard/update");
		return mav;
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = this.boardService.edit(map);
		if (isUpdateSuccess) {
			String boardId =map.get("boardId").toString();
			mav.setViewName("redirect:/detail?boardId=" +boardId);
		}else {
			mav = this.update(map);
		}
		return mav;
	}
	@RequestMapping(value = "list")
	public ModelAndView list(@RequestParam Map<String, Object>map) {
		
		List<Map<String, Object>> list = this.boardService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		mav.setViewName("/NoticeBoard/list");
		return mav;
	}
}
