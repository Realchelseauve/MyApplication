package com.example.saransh.myapplication;

public class Registration1 {
    public static final String COLUMN_ID="id1";
    public static final String TABLE_NAME = "registration1";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_Severity= "severity";
    public static final String COLUMN_Failure  = "failure";
    public static final String COLUMN_CHOICE1 = "choice";
    private String phone;
    private String severity;
    private String failure;
    private int choice;
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_PHONE + " TEXT  PRIMARY KEY  ,"
                    + COLUMN_Severity + " TEXT NON NULL,"
                    +COLUMN_ID+" TEXT ,"+COLUMN_Failure+ " TEXT ,"
                    + COLUMN_CHOICE1 + " INTEGER DEFAULT 0"
                    + ")";
    public Registration1() {
    }
    public Registration1(String phone, String severity, String failure,int choice1) {
        this.phone = phone;
        this.severity = severity;
        this.failure = failure;
        this.choice=choice1;
        }
    public String getPhone() {
        return phone;
    }

    public String getseverity() {
        return severity;
    }
    public String getfailure(){return failure;}
    public int getChoice() {
        return choice;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    // public void setphon(String hone){this.hone=hone;}
    //  public void setslam(String slam){this.slam=slam;}
    //public String getphon(){return hone;}
    // public String getSlam(){return slam;}
    public void setseverity(String severity) {
        this.severity = severity;
    }
    public void setfailure(String failure){this.failure=failure;}
    public void setChoice(int choice) {
        this.choice = choice;
    }
}
