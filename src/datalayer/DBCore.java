package datalayer;

public class DBCore {

    //region -- Field --

    public static final boolean debugDB = false;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3006/ibosdata";

    //  Database credentials
    // HiddenDBInfo is GIt ignored to prevent public display
    static final String USER = HiddenDBInfo.hiddenUSER;
    static final String PASS = HiddenDBInfo.hiddenPASS;

//endregion



}//End of Class
