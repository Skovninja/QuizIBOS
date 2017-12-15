package businesslogic.surveymodule;

import java.util.List;

/**
 * Dette interface er brugt til at indgå en kontrakt med Quiz klassen
 * derved kan flere klasser implementere dette og blive brugt på samme måde
 * af Quiz klassens objekter.
 * Derved kan Quiz klassens ArrayList af InterfaceQuestionType kalde de samme metoder
 * på forskellige klassers objekter ved en simpel ittertion over listen.
 */


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
