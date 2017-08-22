/**
 * Created by Ulrik on 17-05-2017.
 */
package businesslogic;

import datalayer.*;

public class Login {

    public boolean isValid(String eName, String ePassword) {

        //hashing of EPassword (implement later)
        String hashPass = ePassword;

        // checkLoginInDB searches in user DB for match
        DBHandler loginCheck = new DBHandler();
        User loggedIn = loginCheck.checkLoginInDB(eName, hashPass);

        //region for debugging
        if (loggedIn == null) {
            System.out.println("Forkert Bruger eller Pass");
        } else {
            System.out.println(loggedIn.getUserName()+" is logged in");
        }//endregion

        //returns true if login values match
        return loggedIn != null;
    }


}// End of Class
