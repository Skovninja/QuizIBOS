package businesslogic.surveymodule;

import datalayer.DBQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulrik on 23-05-2017.
 */
public class Quiz {

    //region --field --
    private int id = -11;
    private String title = "Kwees Tidøl";
    private String preAmp = "Wældgåmøn til...";

    //An array list of Questions
    private ArrayList<InterfaceQuestionType> questions;

    //endregion

    //region -- constructors --

    public Quiz(int id) {
        this.id = id;

        DBQuestion dBQ = new DBQuestion();
        questions = dBQ.getArrayListFrom(id);

        //Filling up the Questions in the ArrayList with their corresponding option objects
        for (InterfaceQuestionType iqt: questions) {
            iqt.fillFromDB();

        }

    }
    //endregion


    public ArrayList<InterfaceQuestionType> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        StringBuilder tS = new StringBuilder();

        tS.append("<h4>" + title + " (Qz-" + id + ")</h4>");
        tS.append("<p>" + preAmp + "<br>Array of Questions ->" + questions + "</p>");


        return tS.toString();

    }//End of toString

} //End of Class
