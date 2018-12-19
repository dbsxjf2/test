package kr.or.kosta.mvc.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.kosta.dto.MyMemVO;
import kr.or.kosta.mvc.dao.MemberDaoInter;

@Controller
public class LoginCheckController {
	
	private static final Logger LOGGER 
	= Logger.getLogger(LoginCheckController.class.getName());
	String msg ="";
	
   @Autowired
   private MemberDaoInter memberDaoInter;
   
   
    @RequestMapping(value="/loginForm")
    public String loginForm() {
       return "loginForm";
    }
    
    /*
    @PostMapping("/loginProcess")
    public String loginProcess(MyMemVO vo, HttpSession session) {
       System.out.println("id"+vo.getId());
       System.out.println("pwd"+vo.getPwd());

       return "index";
    }
    
    @RequestMapping("/idcheck")
    public String idCheck(Model m,MyMemVO vo) {
      int cnt = memberDaoInter.loginChk(vo);
       m.addAttribute("login", cnt);
     
     return "loginform";
    }
    */
    
    @PostMapping("/loginProcess")
   public String loginProcess(HttpSession session,MyMemVO vo,@RequestHeader("User-Agent")String userAgent) {
    	
      System.out.println("id "+vo.getId());
      System.out.println("pwd "+vo.getPwd());
      System.out.println("userAgent "+userAgent);
      
      MyMemVO map = memberDaoInter.loginchk(vo);
      
      
      
      if(map.getCnt() == 0) {
         return "error";
         
         
         
      }else {
         session.setAttribute("uname",map.getName());
         session.setAttribute("uid", vo.getId());
         
         return "index";
      }
   }
   
   @GetMapping("/logout")
   public String logoutProcess(HttpSession session) {
      session.removeAttribute("uname");
      session.removeAttribute("uid");
      
      return "index";
   }
}