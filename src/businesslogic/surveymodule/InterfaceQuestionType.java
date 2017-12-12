package businesslogic.surveymodule;

import java.util.List;

public interface InterfaceQuestionType {

    //region -- Getters --

    int getId();
    String getTitle();
    String getqText();
    List getOptions();

    String getHTML();

    void fillFromDB();

    //endregion


}
