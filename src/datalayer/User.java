package datalayer;

/**
 * Created by Ulrik on 20-05-2017.
 */
public class User {

    private int userID = -33;
    private boolean userAdmin = false;
    private String userName = "Nøt Nafn";
    private String password = "Sødmælk";

    public User(int userID, boolean userAdmin, String userName, String password) {
        this.userID = userID;
        this.userAdmin = userAdmin;
        this.userName = userName;
        this.password = password;

        System.out.println(userName+" Object Created...");
    }

    //region getters
    public int getUserID() {
        return userID;
    }

    public boolean isUserAdmin() {
        return userAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    //endregion

}// End Class User
