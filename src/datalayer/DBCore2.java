package datalayer;

import java.sql.*;
import java.util.ArrayList;

/**
 * Denne klasse er en abstrakt klasse derved kræves der en nedavning
 * for at kunne benytte sig af den. fordelen ved dette er at
 * den kan bruges til flere af de samme operationer, som henter via
 * en prepared statement med værdien index og returnere et tilfældigt defineret result set
 * dog skal denne "tilfældighed" specificeres i de nedarvede sub-klasser
 * som skal håndtere result set og returnere det som en ArrayList
 */

public abstract class DBCore2 {

    //region -- Field --

    public static final boolean debugDB = false;

    // JDBC driver name and database URL
    protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_URL = "jdbc:mysql://localhost:3006/ibosdata";

    //  Database credentials
    // HiddenDBInfo is GIt ignored to prevent public display
    protected static final String USER = HiddenDBInfo.hiddenUSER;
    protected static final String PASS = HiddenDBInfo.hiddenPASS;


    protected ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement prepS = null;
    protected String sql = null;

    protected ArrayList<Object> myAL;
//endregion


    public ArrayList getArrayListFrom(int questionID) {

        //Connection to DB to get a result set from an id
        connectAndReturnResultSet(questionID);

        myAL = new ArrayList<Object>();

        //Abstract method to convert result set to array list
        //method are to be defined in sub classes
        rStoArrayList();

        //Closing resources
        closeResources();

        return  myAL;
    }



    private ResultSet connectAndReturnResultSet(int questionID) {


        try {

            //region -- trylle --
            //STEP 2: Register JDBC driver
            if (debugDB) System.out.println("Registering Driver!");
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            if (debugDB) System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            if (debugDB) System.out.println("Creating statement...");
            //endregion


            //region -- Block to change --

            PreparedStatement prepS = conn.prepareStatement(sql);

            prepS.setInt(1, questionID);

            rs = prepS.executeQuery();

            //STEP 5:  return of result set
            return rs;

            //endregion


        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        //region -- finally --
        // Closing all resources
        //This is moved and done in the sub class


        //end try
        if (debugDB) System.out.println("Farvel fra DB!");

        return rs;

    }//End of Function

    protected abstract void rStoArrayList();

    private void closeResources() {
        // Closing all resources
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        try {
            if (prepS != null)
                prepS.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

}//End of Class
