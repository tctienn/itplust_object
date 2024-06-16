package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserModel;
import service.LoginService;

/**
 * Servlet implementation class logins
 */
@WebServlet("/login")
public class logins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		UserModel user = new UserModel();
//		user.setUserName("ayyyyyyyyyy");
////		user = new UserModel(1, 1, 1, 1, 1, 1-1-1,1);
//        session.setAttribute("user", user);
//		request.getRequestDispatcher("login/Login.jsp").forward(request, response);
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
			case "loginsss":
				
				response.sendRedirect("/baocao/products");
				break;
			case "access":
				accessCreate(request, response);
				break;
			default:
				
				request.getRequestDispatcher("login/Login.jsp").forward(request, response);
				break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch(action) {
			case "signup":
			signUp(request, response);
			break;
			case "checksignup":
				
				break;
			case "login":
				login(request, response);
				break;
			default:
				response.sendRedirect("/baocao/login");
				break;
		}
		
	}

	
	
	
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
		LoginService loginService = new LoginService();
		UserModel user = loginService.login(request.getParameter("username"), request.getParameter("password"));
		if(user == null) { // trường hợp đăng nhập không thành công
			System.out.println("đăng nhập thất bại");
			response.sendRedirect("/baocao/login");
		}
		else {
			System.out.println("user " + user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("/baocao/products");
		}
		
	}
	
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
		LoginService loginService = new LoginService();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String sdt = request.getParameter("sdt");
		String gmail = request.getParameter("gmail");
		UserModel user = new UserModel(null, userName, password, sdt, null, null, gmail);
		loginService.createUser(user);
		request.getRequestDispatcher("login/SignUpCheck.jsp").forward(request, response);
		
	}
	
	private void accessCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginService loginService = new LoginService();
		Integer userId = Integer.parseInt(request.getParameter("iduser"));
		String token = request.getParameter("token");
		loginService.updateUserToken(userId, token);
		request.getRequestDispatcher("login/SignUpCheck.jsp").forward(request, response);
		
	}
	
	
	
	
	
}
