package com.user.details.crud.admin.approved;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.manager.MyConnection;

/**
 * Servlet implementation class FetchUserData
 */
@WebServlet("/FetchUserData")
public class FetchUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		
		out.println("<h1 class='alert-danger text-center py-2'>All Users</h1>");
		
		out.println("<table class=\"table table-hover\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">User-Id</th>\r\n"
				+ "      <th scope=\"col\">Username</th>\r\n"
				+ "      <th scope=\"col\">Password</th>\r\n"
				+ "      <th scope=\"col\">Permision</th>\r\n"
				+ "      <th scope=\"col\">Delete</th>\r\n"
				+ "      <th scope=\"col\">update</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody>\r\n");
		
		try {
			MyConnection dao = new MyConnection();
			String sql ="SELECT * FROM `user_auth` ORDER BY datetime_now DESC;";
			ResultSet rs = dao.fetchData(sql);
			
			HttpSession session = req.getSession();
			String nowloginuser = (String) session.getAttribute("username");
			
			while(rs.next()) {
				if(nowloginuser.equals(rs.getString("username"))==false)
				{
					out.println(""
							+ "    <tr>\r\n"
							+ "      <th scope=\"row\">"+rs.getString("uid")+"</th>\r\n"
							+ "      <td>"+rs.getString("username")+"</td>\r\n"
							+ "      <td>********</td>\r\n"
							+ "      <td>"+rs.getString("permission_tokken")+"</td>\r\n"
							+ "      <td><a href='delete?id="+rs.getString("uid")+"' class='btn btn-danger'>Delete</a></td>\r\n"
							+ "      <td><a href='update-user?id="+rs.getString("uid")+"' class='btn btn-success'>Update</a></td>\r\n"
							+ "    </tr>\r\n");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
			out.println(""
				+ "  </tbody>\r\n"
				+ "</table>");
	}

}
