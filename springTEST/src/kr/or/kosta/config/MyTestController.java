package kr.or.kosta.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyTestController {
	//git�� ����� ���ο� �ڵ�
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String myview() {
		return "myview";
	}
}
