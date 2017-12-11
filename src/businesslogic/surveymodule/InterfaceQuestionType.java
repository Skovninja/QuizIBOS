package businesslogic.surveymodule;

import java.util.List;

public interface InterfaceQuestionType {

    //region -- Getters --

    int getId();
    String getTitle();
    String getqText();
    List getOptions();

    void fillFromDB();

    //endregion


}
