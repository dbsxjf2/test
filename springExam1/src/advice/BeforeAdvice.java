package advice;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import control.ControlServlet;

@Aspect
public class BeforeAdvice {
	@Before("execution(* action.TodayView.*(..))")
	public void beforeMethod(JoinPoint jp) { //, HttpServletRequest req
		String name = jp.getSignature().getName();
		Object[] obj = jp.getArgs();
		String hell = "hell";
		for(Object e : obj) {
			System.out.println(e);
			//req.setAttribute("msg", e);
		}
		//req.setAttribute("msg2", obj);
		//req.setAttribute("msg3", hell);
		System.out.println("name : "+name);
		
	}
}
