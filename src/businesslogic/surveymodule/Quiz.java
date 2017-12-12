package businesslogic.surveymodule;

import datalayer.DBQuestion;

import java.util.ArrayList;

/**
 * Created by Ulrik on 23-05-2017.
 */
public class Quiz {

    //region --field --
    private int id = -11;
    private String title = "Kwees Tidøl";
    private String preAmp = "Wældgåmøn til...";

    //An array list of Quiz parts - primarily Question objects
    private ArrayList<InterfaceQuestionType> quizParts;

    private int currentQuizPart = 0;

    //endregion

    //region -- constructors --

    public Quiz(int id) {
        this.id = id;

        //Creates the database object to get an ArrayList of Questions
        DBQuestion dBQ = new DBQuestion();
        quizParts = dBQ.getArrayListFrom(id);

        //Filling up the Questions in the ArrayList with their corresponding option objects
        for (InterfaceQuestionType iqt: quizParts) {
            iqt.fillFromDB();
        }

        //adds the final "page" after the question chain
        quizParts.add(new PostQuestion());

    }
    //endregion

    //Getters
    public ArrayList<InterfaceQuestionType> getQuizParts() {
        return quizParts;
    }

    public void nextPart() {
        if (quizParts.size()-1 > currentQuizPart) {
            System.out.println("IF STATEMENT");
            currentQuizPart++;
            System.out.println("quisPart number incrementet to"+currentQuizPart);
        }else {
            System.out.println("Quiz Done!");
        }
    }

    public String getHTML() {
        //return "<h1>Quiz new test pointing at quizParts Array index</h1>";
        return quizParts.get(currentQuizPart).getHTML();
    }


    @Override
    public String toString() {
        StringBuilder tS = new StringBuilder();

        tS.append("<h4>" + title + " (Qz-" + id + ")</h4>");
        tS.append("<p>" + preAmp + "<br>Array of Questions ->" + quizParts + "</p>");


        return tS.toString();

    }//End of toString


} //End of Class
