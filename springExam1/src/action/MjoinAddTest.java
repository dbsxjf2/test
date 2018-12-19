package action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import control.ActionForward;
import control.ControlServlet;
import dao.DaoService;
import vo.MjoinVO;

public class MjoinAddTest implements Action {
	private String url;
	private boolean method;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setMethod(boolean method) {
		this.method = method;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("@ : AddTest");
		
		
		MjoinVO vo = new MjoinVO();
		vo.setId(req.getParameter("id"));
		vo.setPwd(req.getParameter("pwd"));
		vo.setName(req.getParameter("name"));
		vo.setInfo(req.getParameter("info"));
		req.setAttribute("tvo", vo);
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("config/context.xml");
		DaoService ds = ctx.getBean("dao", DaoService.class);
		try {
			ds.transactionTest(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ActionForward(url, method);
	}
}
