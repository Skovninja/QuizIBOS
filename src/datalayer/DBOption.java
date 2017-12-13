package datalayer;

import businesslogic.surveymodule.Answer;

import java.sql.SQLException;

public class DBOption extends DBCore2{


    public DBOption() {


     sql = "SELECT a.answer_text, a.answer_id "
            + "FROM answers a "
            + " INNER JOIN questions_2_answers q2a "
            + " ON a.answer_id = q2a.answer_id "
            + " WHERE q2a.question_id = ?; ";
    }

    @Override
    protected void rStoArrayList() {

        try {
            while (rs.next()) {

                int rsID = rs.getInt("answer_id");
                String rsName = rs.getString("answer_text");

                myAL.add(new Answer(rsID, rsName));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


        }


    }


}//End of Class
