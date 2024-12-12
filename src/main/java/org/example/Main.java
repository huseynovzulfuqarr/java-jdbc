package org.example;

import org.example.connection.DBConnection;
import org.example.model.User;
import org.example.statement.DatabaseStatement;

public class Main {
    public static void main(String[] args) throws Exception {

        //DBConnection.getConnection();
        System.out.println("Ela");
        //DatabaseStatement.findAllUsers();
        DatabaseStatement.findStudentById(1);
        //DatabaseStatement.createUserTable();
        //DatabaseStatement.insertUser();
//        User user=new User();
//        user.setUser_id(4);
//        user.setUser_name("Aga");
//        user.setUser_surname("Hasanli");
//        user.setUser_age(25);
        //DatabaseStatement.insertOfObjectOfUser(user);

//        User user2=new User();
//        user2.setUser_id(4);
//        user2.setUser_name("Rasim");
//        user2.setUser_surname("Abdullayev");
//        user2.setUser_age(30);
        //DatabaseStatement.updateUser(user2, user2.user_id());
         // DatabaseStatement.deleteUserById(4);



    }
}