import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userID {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String dbUrl = "jdbc:mariadb://localhost:7777/cab302";
		String user = "root";
		String password = "root";
		//pass arguments from php
	
		try {
			connection = Database.getConnection(dbUrl, user, password);
			statement = connection.createStatement();
			

			String sql = String.format("SELECT userID FROM user WHERE username = '%s'", args[0]);
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("userID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(resultSet);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}
		
	}

}