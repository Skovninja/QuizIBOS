package datalayer;

import businesslogic.surveymodule.Answer;
import businesslogic.surveymodule.Question;

import java.sql.SQLException;

public class DBQuestion extends DBCore2{


    public DBQuestion() {


     sql = "SELECT q.question_title, q.question_text, q.question_id "
            + "FROM questions q "
            + " INNER JOIN quizzes_2_questions q2q "
            + " ON q.question_id = q2q.question_id "
            + " WHERE q2q.quiz_id = ?; ";
    }

    @Override
    protected void rStoArrayList() {

        try {
            while (rs.next()) {

                int rsID = rs.getInt("question_id");
                String rsTitle = rs.getString("question_title");
                String rsText  = rs.getString("question_text");

                myAL.add(new Question(rsID, rsTitle, rsText));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//End of rsToArrayList


}//End of Class
