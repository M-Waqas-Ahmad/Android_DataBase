package pk.talmeez.muhaamad500.studentmanagementapp;

public class UserLogingModule {

    private String firstName ;
    private String secondName;
    private String email ;
    private String userName ;
    private String password ;

    public static final String USER_TABLE_NAME = "USER_TABLE";
    public static final String USER_FIRST_NAME_COL = "USER_FIRST_NAME";
    public static final String USER_SECOND_NAME_COL = "USER_SECOND_NAME";
    public static final String USER_EMAIL_COL = "USER_EMAIL";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_PASSWORD = "USER_PASSWORD";

    public static final String CREAT_USER_LOGIN_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s"

                                                            +"(%s TEXT PRIMARY KEY , %s TEXT ,%s TEXT ,%s TEXT , %s TEXT)",
                                                            USER_TABLE_NAME ,USER_EMAIL_COL ,USER_FIRST_NAME_COL ,USER_SECOND_NAME_COL,USER_NAME,USER_PASSWORD);
    public static final String DROP_USER_LOGIN_TABLE = String.format("DROP TABLE IF EXISTS %s ",USER_TABLE_NAME);
    public static final String SELECT_ALL_FROM_USER_TABLE = String.format("SELECT * FROM %s ",USER_TABLE_NAME);


    //constructor
    public UserLogingModule() {

    }
    public UserLogingModule(String firstName, String seconName, String email, String userName, String password) {
        this.firstName = firstName;
        this.secondName = seconName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    //getter setter


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
