package businesslogic.surveymodule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulrik on 23-05-2017.
 */
public class Quiz {

    //region --field --
    int id = -11;
    String title = "Kwees Tidøl";
    String preAmp = "Wældgåmøn til...";

    //An array list of Questions
    ArrayList<Question> questions;

    //endregion

    //region -- constructors --
    public Quiz(int id) {
        this.id = id;
        questions = new ArrayList();
        questions.add(new Question(3));
        questions.add(new Question(2));
    }
    //endregion


    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", preAmp='" + preAmp + '\'' +
                ", <br>questions=" + questions +
                '}';
    }//End of toString
} //End of Class
