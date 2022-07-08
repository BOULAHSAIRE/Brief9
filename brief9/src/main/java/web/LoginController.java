package web;



	import java.io.IOException; 
	import DAO.ILoginDao;
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;
	import model.Login;


	public class LoginController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private ILoginDao IloginDao;

	    public LoginController() {
			IloginDao = new ILoginDao();

	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
				response.sendRedirect("Login/login.jsp");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			doGet(request, response);
		}
		private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);

			try {
				if (IloginDao.validate(login)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("todo/Todolist.jsp");
					dispatcher.forward(request, response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("user", username);
				    response.sendRedirect("login.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	}








	}







