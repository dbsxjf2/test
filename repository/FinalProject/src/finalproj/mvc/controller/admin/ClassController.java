package finalproj.mvc.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import finalproj.dto.ClassVO;
import finalproj.dto.StudentVO;
import finalproj.dto.TeacherVO;
import finalproj.mvc.dao.ClassDao;

@Controller
public class ClassController {
	@Autowired
	private ClassDao dao;

	@RequestMapping(value = "/classlist")
	public ModelAndView classList() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("clist");

		List<Map<String, Object>> list = dao.classList();
		mav.addObject("cla", list);

		return mav;
	}

	@RequestMapping(value = "/clogin")
	public ModelAndView clogin(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		if (id == null || id.equals("")) {
			mav.setViewName("clogin");
		} else {

			mav.setViewName("myclass");
			List<Map<String, Object>> list = dao.myclassList(id);
			mav.addObject("list", list);
		}
		return mav;
	}

	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("my_main");

		return mav;
	}

	@RequestMapping(value = "/myclasslist")
	public ModelAndView myclassList(HttpSession session, String cid, String cpwd) {

		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		map.put("id", cid);
		map.put("pwd", cpwd);
		System.out.println(map.get("id"));
		int check = dao.logcheck(map);
		System.out.println(check);

		if (check == 1) {
			session.setAttribute("id", cid);
			String id = (String) session.getAttribute("id");
			System.out.println(id);
			mav.setViewName("myclass");
			List<Map<String, Object>> list = dao.myclassList(id);

			mav.addObject("list", list);
		} else {
			mav.setViewName("clogin");
		}

		return mav;
	}

	@RequestMapping(value = "/classview",method=RequestMethod.GET)
	public ModelAndView classview(int cnum) {
       System.out.println("cnum="+cnum);
		ModelAndView mav = new ModelAndView();
		 List<StudentVO> list = dao.classview(cnum);
		 mav.addObject("list",list);
		 System.out.println("list:"+list);
          mav.setViewName("classviewer"); 
	    
		return mav;
	}

	@RequestMapping(value = "/create",method=RequestMethod.GET)
	public ModelAndView creatClass() {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("ccreate");
      		
		
		return mav;
	}
	
	@RequestMapping(value = "/accept",method=RequestMethod.POST)
	public ModelAndView classaccept(ClassVO vo) {
      ModelAndView mav = new ModelAndView();
      System.out.println(vo.getCname());
      System.out.println(vo.getCend());
      System.out.println(vo.getCroom());
      mav.setViewName("my_main");
      dao.addClass(vo);
      		
		
		return mav;
	}

}
