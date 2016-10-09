package cn.mldn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.service.IDeptService;
import cn.mldn.service.impl.DeptServiceImpl;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.util.vo.Dept;

@SuppressWarnings("serial")
@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet {
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
	
		request.getRequestDispatcher("/MemberServlet/list").forward(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		IDeptService deptService = DAOFactory.getInstance(DeptServiceImpl.class);
		List<Dept> allDepts = deptService.list();
		request.setAttribute("allDepts", allDepts);
		request.getRequestDispatcher("/pages/back/dept/dept_list.jsp").forward(request, response);
	}
}
