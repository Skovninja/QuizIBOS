package businesslogic.surveymodule;

import java.util.List;

public class EndQType implements InterfaceQuestionType {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getqText() {
        return null;
    }

    @Override
    public List getOptions() {
        return null;
    }

    @Override
    public String getHTML() {
        return "<h1>Færdig er du sagde Yoda</h1>";
    }

    @Override
    public void fillFromDB() {

    }
}
