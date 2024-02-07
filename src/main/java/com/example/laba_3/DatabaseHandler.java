package com.example.laba_3;
import java.sql.*;

public class DatabaseHandler extends Config{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString="jdbc:mysql://localhost:3306/pisl_3";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public ResultSet getUser(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=null;
        String select ="SELECT * FROM "+ Const.USER_TABLE + " WHERE "+
                Const.LOGIN + "=? AND "+ Const.PASSWORD + "=?";
        PreparedStatement preparedStatement= getDbConnection().prepareStatement(select);
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,password);
        resultSet=preparedStatement.executeQuery();
        return resultSet;
    }
    public int getUserId(String login) {

        int userId = -1; // Значение по умолчанию, если пользователь не найден

        try {

                    String s = "SELECT idUser FROM user WHERE login = ?";
            PreparedStatement preparedStatement= getDbConnection().prepareStatement(s);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("idUser");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return userId;
    }

    public void saveSurvey(int id, String brand, String os, String performance, String comments)
    {
        String query = "INSERT INTO user_response (user_id, brand, op_system, performance, comments) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getDbConnection().prepareStatement(query)) {
            // Установка значений параметров
            statement.setInt(1, id);
            statement.setString(2, brand);
            statement.setString(3, os);
            statement.setString(4, performance);
            statement.setString(5, comments);

            // Выполнение запроса
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getAllSurveyResults() {
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM user_response";
            PreparedStatement statement = getDbConnection().prepareStatement(query);

            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

}
