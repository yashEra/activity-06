package app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.EmployeeDAO;
import app.entity.Employee;

/**
 * Servlet implementation class DispatcherServlet1
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		empdao = new EmployeeDAO();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedPage = request.getServletPath();

		if (requestedPage.equals("/new")) {
			createEmployee(request, response);
		}

		else if (requestedPage.equals("/view")) {
			getEmpList(request, response);
		}

		else if (requestedPage.equals("/update")) {
			if (request.getParameter("id") != null) {
				viewEmployee(request, response);
			} else {
				updateEmployee(request, response);
			}
		}

		else if (requestedPage.equals("/delete")) {
			deleteEmployee(request, response);
		}
	}

	private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee emp = new Employee();
		emp.setEmpid(request.getParameter("empid"));
		emp.setFirstname(request.getParameter("fname"));
		emp.setLastname(request.getParameter("lname"));

		empdao.saveEmployee(emp);
		response.sendRedirect("view");
	}

	private void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee emp = empdao.getEmployee(request.getParameter("id"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/employeeEdit.jsp");
		request.setAttribute("emp", emp);

		dispatcher.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee emp = new Employee();
		emp.setEmpid(request.getParameter("empid"));
		emp.setFirstname(request.getParameter("fname"));
		emp.setLastname(request.getParameter("lname"));

		empdao.updateEmployee(emp);
		response.sendRedirect("view");
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		empdao.deleteEmployee(request.getParameter("id"));
		response.sendRedirect("view");
	}

	private void getEmpList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/viewEmployee.jsp");

		List<Employee> emplist = empdao.getEmpList();
		request.setAttribute("emplist", emplist);

		dispatcher.forward(request, response);
	}
}
