package org.example.statement;

import org.example.connection.DBConnection;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseStatement {

    private static Connection connection= DBConnection.getConnection();
    private static PreparedStatement preparedStatement=null;
    private static ResultSet resultSet=null;


    public static void findAllUsers(){
        String query="select * from users";
        try{
            preparedStatement= connection.prepareStatement(query);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer userId=resultSet.getInt("user_id");
                String userName=resultSet.getString("user_name");
                String userSurname=resultSet.getString("user_surname");
                Integer age=resultSet.getInt("user_age");

                System.out.println("userId: "+userId);
                System.out.println("userName: "+userName);
                System.out.println("userSurname: "+userSurname);
                System.out.println("userAge: "+age);

                DBConnection.closeConnection();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void findStudentById(Integer id){
        String query="select * from users where user_id=?";
        try{
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet= preparedStatement.executeQuery();

            if(resultSet.next()){
                Integer userId=resultSet.getInt("user_id");
                String userName=resultSet.getString("user_name");
                String userSurname=resultSet.getString("user_surname");
                Integer age=resultSet.getInt("user_age");

                System.out.println("userId: "+userId);
                System.out.println("userName: "+userName);
                System.out.println("userSurname: "+userSurname);
                System.out.println("userAge: "+age);

                DBConnection.closeConnection();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUserTable(){//create user_table
        String query="CREATE TABLE `db`.`users` (\n" +
                "  `user_id` INT NOT NULL,\n" +
                "  `user_name` VARCHAR(45) NULL,\n" +
                "  `user_surname` VARCHAR(45) NULL,\n" +
                "  `user_age` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`user_id`));" ;
        try{
            preparedStatement=connection.prepareStatement(query);

            preparedStatement.execute();
           DBConnection.closeConnection();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void insertUser(){
        String query= "insert into users(user_id,user_name,user_surname,user_age) values(?,?,?,?)";
        try{
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Bakir");
            preparedStatement.setString(3, "Asgarov");
            preparedStatement.setInt(4,20);
            preparedStatement.execute();
            DBConnection.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertOfObjectOfUser(User user){
        String query="insert into users(user_id,user_name,user_surname,user_age) values(?,?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,user.user_id());
            preparedStatement.setString(2,user.user_name());
            preparedStatement.setString(3,user.user_surname());
            preparedStatement.setInt(4,user.user_age());
            preparedStatement.execute();
            DBConnection.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateUser(User user,Integer userId){
        String query="update users set users.user_name=?,users.user_surname=?" +
                ",users.user_age=? where users.user_id=?";
         try{
             preparedStatement= connection.prepareStatement(query);
             preparedStatement.setString(1,user.user_name());
             preparedStatement.setString(2,user.user_surname());
             preparedStatement.setInt(3,user.user_age());
             preparedStatement.setInt(4,userId);
             preparedStatement.executeUpdate();
             DBConnection.closeConnection();
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }
    public static void deleteUserById(Integer userId){
    String query="delete from users where user_id=?";
       try{
        preparedStatement= connection.prepareStatement(query);
        preparedStatement.setInt(1,userId);
        preparedStatement.executeUpdate();
        DBConnection.closeConnection();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

}
