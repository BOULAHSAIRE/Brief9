package web;


	import DAO.IUserDao;
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import model.User;
	import java.io.IOException;

	/**
	 * Servlet implementation class Userservlet
	 */

	@WebServlet("/register")
	public class ResgisterController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private IUserDao IuserDao;

		public void init() {
			IuserDao = new IUserDao();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			register(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.sendRedirect("register/Register.jsp");
		}

		private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User candidat = new User();
			candidat.setFirstName(firstName);
			candidat.setLastName(lastName);
			candidat.setUsername(username);
			candidat.setPassword(password);

			try {
				int result = IuserDao.registerEmployee(candidat);
				if(result == 1) {
					request.setAttribute("NOTIFICATION", "User Registered Successfully!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("register/Register.jsp");
			dispatcher.forward(request, response);
		}
	}






