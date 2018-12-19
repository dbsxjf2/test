package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ActionForward;

public class MyFormAction implements Action {
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
		System.out.println("@ : FormAction");
		return new ActionForward(url, method);
	}
}
