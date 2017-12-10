/**
 * Created by Ulrik on 23-05-2017.
 */
package businesslogic.surveymodule;
import datalayer.DBOption;
import datalayer.DBQuestion;

import java.util.ArrayList;
import java.util.List;

public class Question {

    //region -- Field --
    private int id = -22;
    private String title = "Tidøl";
    private String qText = "R du z3mq!";

    //An array list of Answers
    ArrayList answers = null;

    //endregion

    //region -- Constructors --
    public Question(int id, String title, String qText, ArrayList answers) {
        this.id = id;
        this.title = title;
        this.qText = qText;
        this.answers = answers;
    }

    public Question(int id) {
        this.id = id;

        //old DBQuestion replaced with DBOption
        //answers = (ArrayList) new DBQuestion().connectTo(id);
        answers = (ArrayList) new DBOption().getArrayListFrom(id);
        System.out.println(answers.toString());
    }
    //endregion

    //region -- Getters --

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getqText() {
        return qText;
    }

    public List getAnswers() {
        return answers;
    }

    //endregion


    @Override
    public String toString() {
        return "Question {" +
                "id=" + id +
                ", <br>title='" + title + '\'' +
                ", qText='" + qText + '\'' +
                ", <br>answers=" + answers +
                '}';
    }

}// End of Class
