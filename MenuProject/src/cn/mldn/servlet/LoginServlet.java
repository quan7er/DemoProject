package cn.mldn.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.md5.MD5Code;
import cn.mldn.service.IMemberService;
import cn.mldn.service.impl.MemberServiceImpl;
import cn.mldn.util.factory.ServiceFactory;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String salt = "bWxkbmphdmE=" ;
		String password = new MD5Code().getMD5ofStr(request.getParameter("password")+ "{!(" + salt + ")!}");

		String code = request.getParameter("code");
		String rand = request.getSession().getAttribute("rand").toString();
		String msg = "用户登录失败！！";
		String url = "errors.jsp";
		
		if(rand.equalsIgnoreCase(code)){
			IMemberService MemberService = ServiceFactory.getInstance(MemberServiceImpl.class);
			Map<String,Object> map = null;
			boolean flag = false;
			try{
				map = MemberService.login(mid, password);
				flag = (Boolean) map.get("flag");
				if(flag){
					request.setAttribute("member", map.get("member"));
					url = "/pages/index.jsp";
					msg = "用户登录成功！！";
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher("/time_div.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		this.doGet(request, response);
	};
}
