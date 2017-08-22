/**
 * Created by Ulrik on 23-05-2017.
 */
package businesslogic;
import java.util.ArrayList;
import java.util.List;

public class Question {

    //region -- Field --
    int id = -22;
    String title = "Tidøl";
    String qText = "R du z3mq!";

    //An array list of Answers
    ArrayList answers = null;

    //endregion

    // Constructor
    public Question(int id, String title, String qText, ArrayList answers) {
        this.id = id;
        this.title = title;
        this.qText = qText;
        this.answers = answers;
    }


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


}// End of Class
