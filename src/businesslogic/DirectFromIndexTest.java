package businesslogic;

import datalayer.DBHandler;

/**
 * Created by Ulrik on 20-05-2017.
 */
public class DirectFromIndexTest {

   public String displayTestInfo = "Muføl";
   public void testRun(){
       DBHandler test = new DBHandler();

       int testValue = 3;
       displayTestInfo = "<br>"+test.getAnswersArrayList(testValue).toString();
   }
}
