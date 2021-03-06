package Task1;

import java.sql.*;

public class Database {
    private static String adress="url",user="user",pass="pass",dr="org.postgresql.Driver";
    private static Database instance;
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    private Database() {
        try {
            Class.forName(dr);

            connection = DriverManager.getConnection(adress, user, pass);
            System.out.println("\n[Connection Established]\n");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (Database.instance == null) {
            Database.instance = new Database();
            return Database.instance;
        }
    }
    public void query(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                System.out.println(resultSet.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    class Application {
        public class main() {
            Database foo = Database.getInstance();
        foo.query("SELECT ...");
            Database bar = Database.getInstance();
        bar.query("SELECT ...");
        }
    }
}