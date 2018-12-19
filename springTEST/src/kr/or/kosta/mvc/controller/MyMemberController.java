package kr.or.kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.kosta.dto.MyMemVO;
import kr.or.kosta.mvc.dao.MemberDaoInter;


@Controller
public class MyMemberController {
   //Dao�� ����
   @Autowired
   private MemberDaoInter memberDaoInter;
   
   //form
   @GetMapping("/member")
   public String myMemberForm() {
      return "member";
   }

   @PostMapping("/memberjoin")
   public String myMemberJoin(Model m,MyMemVO vo) {
      System.out.println(vo.getId());
      memberDaoInter.addMem(vo);
      return "index";
   }
   
   @GetMapping("/idcheck")
   public String idCheck(Model m, @RequestParam("id") String id) {
      int cnt = memberDaoInter.idChk(id);
      
/*      String msg ="�̹� ������� ���̵��Դϴ�.";
      if(cnt == 0) {
         msg="��� ������ ���̵��Դϴ�.";
      }*/
      m.addAttribute("cnt",cnt);
      return "idchk";
   }
}