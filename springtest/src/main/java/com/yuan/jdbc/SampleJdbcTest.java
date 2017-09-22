package com.yuan.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by yuanxin on 17/9/22.
 */
public class SampleJdbcTest
{
    static Logger logger = LoggerFactory.getLogger(SampleJdbcTest.class);

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/mytest";

    //  Database credentials
    static final String USER = "user";

    static final String PASS = "pass";

    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            logger.info("STEP 2: Register JDBC driver");
            Class driver_class = Class.forName(JDBC_DRIVER);
            Driver driver = (Driver)driver_class.newInstance();
            DriverManager.registerDriver(driver);
            logger.info("STEP 3:Open a connection");
            logger.info("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            logger.info("STEP 4: Execute a query");
            logger.info("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, age, password FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            logger.info("STEP 5: Extract data from result set");
            while (rs.next())
            {
                //"Retrieve by column name");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String password = rs.getString("password");

                logger.info("Display values");
                logger.info("ID:{} ",  id);
                logger.info("age:{} ",  age);
                logger.info("name:{} ",  name);
                logger.info("password:{} ", password);
            }
            logger.info("STEP 6: Clean-up environment");
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException se)
        {
            logger.info("Handle errors for JDBC");
            se.printStackTrace();
        }
        catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException se2)
            {
            }// nothing we can do
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
