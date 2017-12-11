/**
 * Created by Ulrik on 20-05-2017.
 */
package datalayer;

import businesslogic.surveymodule.Answer;

import java.sql.*;
import java.util.ArrayList;

/**
 * This classs whas the starting point for DB connection
 * it still contains User Log-inand User creation
 * it was inspired from
 */

public class DBHandler {

        //region -- Field --
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3006/ibosdata";

    //  Database credentials
    // HiddenDBInfo is GIt ignored to prevent public display
    static final String USER = HiddenDBInfo.hiddenUSER;
    static final String PASS = HiddenDBInfo.hiddenPASS;

//endregion


    public ArrayList getAnswersArrayList(int questionID) {

        Connection conn = null;
        Statement stmt = null;

        ArrayList <Answer> answerList = null;

        try {

            //region -- trylle --
            //STEP 2: Register JDBC driver
            System.out.println("Registering Driver!");
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //endregion


            String sql = "SELECT a.answer_text, a.answer_id "
                    + "FROM answers a "
                    + " INNER JOIN questions_2_answers q2a "
                    + " ON a.answer_id = q2a.answer_id "
                    + " WHERE q2a.question_id = ?; ";
            PreparedStatement prepS = conn.prepareStatement(sql);

            prepS.setInt(1,questionID );

            ResultSet rs = prepS.executeQuery();

            //STEP 5: Extract data from result set

            answerList = new ArrayList<>();

            while (rs.next()) {

                int rsID = rs.getInt("answer_id");
                String rsName = rs.getString("answer_text");

                answerList.add(new Answer(rsID, rsName));

            }
            System.out.println(answerList.toString());


            //STEP 6: Clean-up environment
            rs.close();
            //stmt.close();
            prepS.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //region -- finally --
            //finally block used to close resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//endregion finally try
        }//end try
        System.out.println("Farvel fra DB!");

        // returns ArrayList of Answers (null if invalid)
        return answerList;

    }//End of Function


    public User checkLoginInDB(String eName, String ePass) {

        Connection conn = null;
        Statement stmt = null;

        User userInfo = null;

        try {
            //region trylle
            //STEP 2: Register JDBC driver
            System.out.println("Registering Driver!");
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //endregion

            //region -- old SELECT ---
            //stmt = conn.createStatement();
            //String sql = "SELECT * FROM users WHERE user_name = '" + eName + "';";
            //ResultSet rs = stmt.executeQuery(sql);
            //endregion

            String sql = "SELECT * FROM users WHERE user_name = ? AND user_password = ?";
            PreparedStatement prepS = conn.prepareStatement(sql);

            prepS.setString(1, eName);
            prepS.setString(2, ePass);

            ResultSet rs = prepS.executeQuery();


            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int rsID = rs.getInt("user_id");
                boolean rsAdmin = rs.getBoolean("user_admin");
                String rsName = rs.getString("user_name");
                String rsPass = rs.getString("user_password");

                //Display values
                System.out.print("ID: " + rsID);
                System.out.print(", Admin: " + rsAdmin);
                System.out.print(", Name: " + rsName);
                System.out.println(", Password: " + rsPass);

                userInfo = new User(rsID, rsAdmin, rsName, rsPass);
            }
            //STEP 6: Clean-up environment
            rs.close();
            //stmt.close();
            prepS.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //region -- finally --
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//endregion finally try
        }//end try
        System.out.println("Goodbye!");

        // returns User object (null if invalid)
        return userInfo;

    }//End checkLoginInDB


    public void addUser() {

        Connection conn = null;
        Statement stmt = null;

        try {
            //region -- trylle --
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            //endregion

            // region -- gammel kode --
//            stmt = conn.createStatement();
//            String sql = "INSERT INTO ibosdata.users " + "VALUES (DEFAULT,'Zaraline2', 'testpass', TRUE )";
//            stmt.executeUpdate(sql);
            //endregion

            String sql = "INSERT INTO users (user_name, user_password, user_admin)"
                    + "VALUES (?,?,?)";
            PreparedStatement prepS = conn.prepareStatement(sql);

            prepS.setString(1, "Pulv");
            prepS.setString(2, "Pulvkode");
            prepS.setBoolean(3, false);

            prepS.execute();

            System.out.println("Inserted records into the table...");

            prepS.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //region -- finally --
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//endregion finally try
        }//end try
        System.out.println("Goodbye!");
    }//End addUser



}// End Of Class
