package dao;

import Model.ClassManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO{

    public static final String INSERT_CLASS = "insert into classManager(name,description) values (?,?);";
    public static final String jdbcURL = "jdbc:mysql://localhost:3306/class_student";
    public static final String jdbcName = "root";
    public static final String jdbcPassword = "Huyen2002@123";
    public static final String SELECT_CLASS_BY_ID = "insert into id,name,description from classManager where id=?";
    public static final String SELECT_ALL_CLASS = "select*from classManager";

    public ClassDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    jdbcURL,
                    jdbcName,
                    jdbcPassword
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertClassManager(ClassManager classManager) throws SQLException {
        System.out.println(INSERT_CLASS);
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASS)
                ){
            preparedStatement.setString(1,classManager.getName());
            preparedStatement.setString(2,classManager.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public ClassManager selectClassManager(int id) {
        ClassManager classManager = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                classManager = new ClassManager(id,name,description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return classManager;
    }
        @Override
    public List<ClassManager> selectAllClassManager() {
        List<ClassManager> classes = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        SELECT_ALL_CLASS
                );

        ) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                ClassManager classManager = new ClassManager(id,name,description);
                classes.add(classManager);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return classes;
    }

    @Override
    public boolean deleteClassManager(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateClassManager(ClassManager classManager) throws SQLException {
        return false;
    }
}
