/**
 * Created by Ulrik on 23-05-2017.
 */
package businesslogic.surveymodule;
import datalayer.DBOption;

import java.util.ArrayList;
import java.util.List;

public class Question implements InterfaceQuestionType{

    //region -- Field --
    private int id = -22;
    private String title = "Tidøl";
    private String qText = "Question has not got text!";
    private String  sbHTML = "";

    //An array list of options
    ArrayList<InterfaceOption> options = null;

    //endregion

    //region -- Constructors --
    public Question(int id, String title, String qText, ArrayList options) {
        this.id = id;
        this.title = title;
        this.qText = qText;
        this.options = this.options;
    }

    //This constructor is primarily used to test DB connection
    public Question(int id) {
        this.id = id;

        //old DBQuestionOld replaced with DBOption
        //options = (ArrayList) new DBQuestionOld().connectTo(id);
        options = new DBOption().getArrayListFrom(id);
    }

    public Question(int id, String title, String qText) {
        this.id = id;
        this.title = title;
        this.qText = qText;
        System.out.println("Hey from Question Constructor with ID :" + id);
    }

    //endregion

    //region -- Getters --

    @Override
    public String getHTML() {

        sbHTML += "<form action='/quiz' method='post'>\n";
        for (InterfaceOption o: options) {
            sbHTML += "<input name = 'radeoselection' type = 'radio'>" + o.getText() + "<br>\n";
        }
        sbHTML += "<input type='submit' value='Næste'>\n";
        sbHTML += "</form>";
        System.out.println(sbHTML);
        return sbHTML;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getqText() {
        return qText;
    }

    public List getOptions() {
        return options;
    }

    //endregion


    //Method used to fill up the ArrayList with option Objects
    @Override
    public void fillFromDB() {
        options = new DBOption().getArrayListFrom(id);
    }

    @Override
    public String toString() {
        StringBuilder tS = new StringBuilder();

        tS.append("<h5>" + title + " (Spg-" + id + ")</h5>");
        tS.append("<p>" + qText + "<br>" + options + "</p>");


        return tS.toString();


    }

}// End of Class
