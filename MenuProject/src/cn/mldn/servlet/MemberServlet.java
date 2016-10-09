package cn.mldn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.IMemberService;
import cn.mldn.service.impl.DeptServiceImpl;
import cn.mldn.service.impl.MemberServiceImpl;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.util.vo.Member;

@SuppressWarnings("serial")
@WebServlet("/MemberServlet/*")
public class MemberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String status = uri.substring(uri.lastIndexOf("/") + 1);
		if (status != null) {
			try {
				Method method = this.getClass().getMethod(status, HttpServletRequest.class, HttpServletResponse.class);
				method.invoke(this, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String rid[] = request.getParameterValues("rid");
		List<Integer> rids = new ArrayList<Integer>();
		for (int x = 0; x < rid.length; x++) {
			rids.add(Integer.parseInt(rid[x]));
		}
		String mid = request.getParameter("member.mid");
		String name = request.getParameter("member.name");
		String password = request.getParameter("member.password");
		Member member = new Member();

		member.setMid(mid);
		member.setName(name);
		member.setPassword(password);
		member.setRoles(rids);

		String msg = "用户增加失败！！";
		String url = "errors.jsp";
		IMemberService memService = DAOFactory.getInstance(MemberServiceImpl.class);
		if (memService.add(member)) {
			memService.addMember_Role(mid, rids);
			url = "member_add.jsp";
			msg = "用户增加成功！！";
		}		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getRequestDispatcher("/MemberServlet/list").forward(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		IMemberService memService = DAOFactory.getInstance(MemberServiceImpl.class);
		List<Member> allMembers = memService.list();
		request.setAttribute("allMembers", allMembers);
		request.getRequestDispatcher("/pages/back/member/member_list.jsp").forward(request, response);
	}
}
