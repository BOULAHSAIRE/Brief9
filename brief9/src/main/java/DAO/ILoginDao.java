package DAO;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import configuration.DataBase;
	import model.Login;
		
	public class ILoginDao {

				public boolean validate(Login login) throws ClassNotFoundException {
					boolean status = false;

					Class.forName("org.postgresql.Driver");

					try (Connection connection = DataBase.get_connection();
							// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement
		("select * from users where username = ? and password = ? ")) {
						preparedStatement.setString(1, login.getUsername());
						preparedStatement.setString(2, login.getPassword());

						System.out.println(preparedStatement);
						ResultSet rs = preparedStatement.executeQuery();
						status = rs.next();

					} catch (SQLException e) {
						System.out.println(e);
					}
					return status;
				}
			}

