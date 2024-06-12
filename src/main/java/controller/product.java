package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartService;
import service.ProductService;

/**
 * Servlet implementation class product
 */
@WebServlet("/products")
public class product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductService productservice = new ProductService(); 
		request.setAttribute("products", productservice.getProductPage(1, 2) );
		CartService cartService = new CartService();
		System.out.println("cartitem" + cartService.getCartItems(1).size());
		request.setAttribute("cartItem", cartService.getCartItems(1) );
		request.setAttribute("cartItemSize", cartService.getCartItems(1).size() );
		request.getRequestDispatcher("user/index2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
