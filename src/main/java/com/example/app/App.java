package com.example.app;

import java.sql.*;

public class App {

    public static void callProcedure1() throws SQLException {
        Connection connection = ConnectionProvider.getConnection();
        CallableStatement callableStatement = connection.prepareCall("CALL CountByLast(?,?)");
        // Handle IN Type Parameters
        // setXYZType(Position,Value)
        callableStatement.setString(1,"Parab");

        // Handle OUT Type Parameters
        callableStatement.registerOutParameter(2, Types.INTEGER);

        // Execute The Callable Statement
        callableStatement.execute();
        int countValue = callableStatement.getInt(2);
        System.out.println("Number Of Rows : " +countValue);

    }

    public static void callProcedure() throws SQLException {
        // System.out.println("Calling Procedure");
        // Creating Connection
        Connection connection = ConnectionProvider.getConnection();

        // Statement : Calling Static Queries
        // PreparedStatement : Calling Dynamic Queries
        // CallableStatement : Calling Stored Procedures And Function

        CallableStatement callableStatement = connection.prepareCall("CALL SelectByLast(?)");
        /*
        * ? : Parameters
        * IN,OUT,INOUT
        * 
        * */
        // You have set all IN Parameters Like below Example
        callableStatement.setString(1,"Parab");
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            // Value Of Row
            System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("last_name")+" - "+resultSet.getString("city"));
        }

    }

    public static void main(String[] args) throws SQLException {
        // System.out.println("Hello, How are you?");
         callProcedure();
         callProcedure1();
    }
}
