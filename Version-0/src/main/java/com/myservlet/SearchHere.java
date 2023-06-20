package com.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.manager.MyConnection;

/**
 * Servlet implementation class SearchHere
 */
@WebServlet("/SearchHere")
public class SearchHere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchHere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String search = request.getParameter("search");

		String sql = "SELECT * FROM movie_details_list WHERE movie_name LIKE '%" + search + "%' ORDER BY datetime DESC";

		try {
			MyConnection dao = new MyConnection();
			ResultSet rs = dao.fetchData(sql);
			
			
			while(rs.next()) {
				int mid = rs.getInt("mid");
				String mname = rs.getString("movie_name");
				String mpic = rs.getString("image");
				String quality = rs.getString("Quality");
				
				out.println("<div class=\"col-sm-4\">\r\n"
						+ "	<a style=\"text-decoration: none;\" href='details.jsp?id="+mid+"'>			<div class=\"card m-2\">\r\n"
						+ "					<img width=\"300\" height=\"444\" src=\""+mpic+"\" alt=\"\" class=\"card-img-top\"\r\n"
						+ "						height=\"200px\">\r\n"
						+ "					<div class=\"card-footer\">\r\n"
						+ "						<small class=\"text-muted\">"+mname+" "+quality+"</small>\r\n"
						+ "					</div>\r\n"
						+ "				</div></a>\r\n"
						+ "			</div>");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



