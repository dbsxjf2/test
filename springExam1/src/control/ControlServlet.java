package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import action.Action;

@WebServlet("*.kosta")
public class ControlServlet extends HttpServlet{
	
	private static final long serialVersionUID = 320795611392287158L;
	
	private ApplicationContext ctx;
	
	public ControlServlet() {
		ctx = new GenericXmlApplicationContext("config/context.xml");
	}
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  process(request,response);
		 }
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  process(request,response);
		 }
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		  request.setCharacterEncoding("euc-kr");
		String query = request.getParameter("query");
		
		System.out.println("Query : " + query);
		
		if(query!=null) {
			Action action = ctx.getBean(query, Action.class);
			ActionForward af = action.execute(request, response);
			 StringBuffer path = new StringBuffer();
			  path.append("/WEB-INF/jsp/").append(af.getUrl());
			if(af.isMethod()) {
				response.sendRedirect(path.toString());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(path.toString());
				rd.forward(request, response);
			}
		}else {
			PrintWriter out = response.getWriter();
			out.println("<h3>이동용 페이지</h3>");
			out.println("<a href='*.kosta?query=form'>form으로 이동</a>");
			out.println("<a href='*.kosta?query=todayView'>todayView로 이동</a>");
		}
	}

}
