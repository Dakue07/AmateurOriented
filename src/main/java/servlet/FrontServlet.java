package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.RequestContext;
import context.ResponseContext;
import controller.ApplicationController;
import controller.WebApplicationController;

public class FrontServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req, res);

	}

	private void doAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		System.out.println("ie-i");
		
		System.out.println(req.getParameter("name"));
		
		ServletContext context = getServletContext();
		String rootPath = context.getRealPath("/");
		
		
		//ApplicationControllerのインスタンスを取得
		ApplicationController app = new WebApplicationController();
		
		//RequestContextの実装クラスのインスタンスを取得
		RequestContext reqc = app.getRequest(req);
		
		reqc.setParameterMap(req.getParameterMap());
		//ResponseContextにhandleRequestメソッドの結果を格納
		ResponseContext resc = app.handleRequest(reqc, rootPath);
		System.out.println("もどってきちゃお");
		System.out.println(resc.getResult());
		
		//結果をResponseContextにセットする
		resc.setResponse(res);
		
		//forwardする
		app.handleResponse(reqc, resc);

//		if (command != null) {
//			command.init(rc);
//			ResponseContext resc = command.execute();
//			Object bean = resc.getResult();
//			req.setAttribute("data", bean);
//			System.out.println("front target: " + resc.getTarget());
//			req.getRequestDispatcher(resc.getTarget()).forward(req, res);
//
//		} else {
//			res.sendError(HttpServletResponse.SC_NOT_FOUND, "このページは存在しません");
//		}
	}
}
