/**
 * Created by Ulrik on 20-05-2017.
 */
package datalayer;

import businesslogic.surveymodule.Answer;

import java.sql.*;
import java.util.ArrayList;

public class DBQuestion extends DBCore {

    Connection conn = null;
    Statement prepS = null;
    ResultSet rs = null;


    ArrayList<Answer> answerList = null;

    public Object connectTo(Object questionID) {

        rs = null;
        conn = null;
        prepS = null;

        try {

            //region -- trylle --
            //STEP 2: Register JDBC driver
            if (debugDB) System.out.println("Registering Driver!");
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            if (debugDB) System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            if (debugDB) System.out.println("Creating statement...");
            //endregion


            getAnswerArray(questionID);


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {

            //region -- finally --
            // Closing all resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                if (prepS != null)
                    prepS.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            //endregion finally try

        }//end try
        if (debugDB) System.out.println("Farvel fra DB!");

        // returns ArrayList of Answers (null if invalid)
        return answerList;

    }//End of Function


    private void getAnswerArray(Object questionID) throws SQLException {
        //region -- Block to change --
        String sql = "SELECT a.answer_text, a.answer_id "
                + "FROM answers a "
                + " INNER JOIN questions_2_answers q2a "
                + " ON a.answer_id = q2a.answer_id "
                + " WHERE q2a.question_id = ?; ";
        PreparedStatement prepS = conn.prepareStatement(sql);

        prepS.setInt(1, (Integer) questionID);

        ResultSet rs = prepS.executeQuery();

        System.out.println("TEEEST"+rs+"     TEEEST");
        //STEP 5: Extract data from result set

        answerList = new ArrayList<>();

        while (rs.next()) {

            int rsID = rs.getInt("answer_id");
            String rsName = rs.getString("answer_text");

            answerList.add(new Answer(rsID, rsName));

        }
        System.out.println(answerList.toString());
        //endregion

    }


}// End Of Class
