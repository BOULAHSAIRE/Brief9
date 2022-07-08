package DAO;
	import java.sql.Connection;
import java.sql.SQLException;
	import java.util.List;

import configuration.DataBase;
import model.Todo;
	
	public interface Dao {
		

		Connection connection = DataBase.get_connection();
			
			public 	void insertTodo(Todo todo) throws SQLException;
				
	         public    Todo selectTodo(long todoId);

				public List<Todo> selectAllTodos();

				public boolean deleteTodo(int id) throws SQLException;

				public boolean updateTodo(Todo todo) throws SQLException;

			}
		



