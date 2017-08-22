/**
 * Created by Ulrik on 23-05-2017.
 */
package businesslogic;

public class Answer {

    private int id = -55;
    private String text = "Lallesvar";


    //constructor
    public Answer(int id, String text) {
        this.id = id;
        this.text = text;
        System.out.println("Answer object - created");
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
