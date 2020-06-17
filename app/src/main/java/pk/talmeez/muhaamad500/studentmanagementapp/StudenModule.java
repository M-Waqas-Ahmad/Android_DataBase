package pk.talmeez.muhaamad500.studentmanagementapp;



public class StudenModule {
    // student data members
    private String stdRollNumber ;
    private String stdName;
    private String stdFatherName;
    private float stdTotalFee ;






    //data member for database query and commands
    public static final String TABLE_NAME = "STUDENT_TABLE";
    public static final String STUDENT_ROLL_NUMBER_COL = "STD_ROLL_NUMBER";
    public static final String STUDENT_NAME_COL = "STD_NAME";
    public static final String STUDENT_FATHER_NAME_COL = "STD_FATHER_NAME";
    public static final String STUDENT_TOTAL_FEE_COL = "STD_TOTAL_FEE";
    public static  final String CREATE_STUDENT_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s "
                                                        +"(%s TEXT PRIMARY KEY , %s TEXT , %s TEXT , %s REAL)",
                                                        TABLE_NAME , STUDENT_ROLL_NUMBER_COL ,STUDENT_NAME_COL, STUDENT_FATHER_NAME_COL ,STUDENT_TOTAL_FEE_COL);
    public static final String DROP_STUDENT_TABLE = String.format("DROP TABLE IF EXISTS %s" , TABLE_NAME);
    public static final String SELECT_ALL_FROM_STUDENT_TABLE = String.format("SELECT * FROM %s" , TABLE_NAME);



    // ------------------------OVERLOADED CONSTRUCTOR------------------------------------------//
    //........................................................................................//
    public StudenModule() {

    }

    public StudenModule(String stdRollNumber, String stdName, String stdFatherName, float stdTotalFee) {
        this.stdRollNumber = stdRollNumber;
        this.stdName = stdName;
        this.stdFatherName = stdFatherName;
        this.stdTotalFee = stdTotalFee;
    }


    public StudenModule( String stdName,  String stdFatherName, float stdTotalFee ,String stdRollNumber) {
        this.stdRollNumber = stdRollNumber;
        this.stdName = stdName;
        this.stdFatherName = stdFatherName;
        this.stdTotalFee = stdTotalFee;
    }

    public StudenModule( String stdName, float stdTotalFee , String stdFatherName ,String stdRollNumber) {
        this.stdRollNumber = stdRollNumber;
        this.stdName = stdName;
        this.stdFatherName = stdFatherName;
        this.stdTotalFee = stdTotalFee;
    }



    //---------------------GETTER & SETTERS ----------------------------------//
    //----------------------------------------------------------------------///

    public String getStdRollNumber() {
        return stdRollNumber;
    }

    public void setStdRollNumber(String stdRollNumber) {
       this.stdRollNumber = stdRollNumber;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdFatherName() {
        return stdFatherName;
    }

    public void setStdFatherName(String stdFatherName) {
        this.stdFatherName = stdFatherName;
    }

    public float getStdTotalFee() {
        return stdTotalFee;
    }

    public boolean setStdTotalFee(float stdTotalFee) {
        if (stdTotalFee > 0) {
            this.stdTotalFee = stdTotalFee;
            return true;
        }else{
            return false;
        }
    }


}
