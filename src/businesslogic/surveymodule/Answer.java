/**
 * Created by Ulrik on 23-05-2017.
 */
package businesslogic.surveymodule;


import datalayer.DBCore2;

/**
 * Denne klasse implementerer InterfaceOption
 * formålet med dette interface er at der skal kunne hentes andre
 * objekter af typen InterfaceOption som står for at hente andre informationer eller andet
 * Question klassen er den klasse som bruger denne klasse her som options
 * i Questions svarmuligheder.
 */

public class Answer implements InterfaceOption {

    private int id = -55;
    private String text = "Lallesvar";


    //constructor
    public Answer(int id, String text) {
        this.id = id;
        this.text = text;
        if (DBCore2.debugDB)System.out.println("Answer object - created");
    }


    //region -- Getters --
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
    //endregion


    @Override
    public String toString() {
        return id +" " + text;
    }


} //End of Class
