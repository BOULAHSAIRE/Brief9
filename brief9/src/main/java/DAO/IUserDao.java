package DAO;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import configuration.DataBase;
	import model.User;

	public class IUserDao {
		
			   
		public int registerEmployee(User candidat) throws ClassNotFoundException {
					String INSERT_USERS_SQL = "INSERT INTO users"
							+ "  (first_name, last_name, username, password) VALUES "
							+ " (?, ?, ?, ?);";
					int result = 0;
					try (Connection connection =DataBase.get_connection();
							// Step 2:Create a statement using connection object
							PreparedStatement preparedStatement = connection.prepareStatement
									(INSERT_USERS_SQL)) {
						preparedStatement.setString(1, candidat.getFirstName());
						preparedStatement.setString(2, candidat.getLastName());
						preparedStatement.setString(3, candidat.getUsername());
						preparedStatement.setString(4, candidat.getPassword());

						System.out.println(preparedStatement);
						result = preparedStatement.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e);
					}
					return result;
				}

			

		

	}


