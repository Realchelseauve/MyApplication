package com.example.saransh.myapplication;

public class Registration {
    public static final String COLUMN_ID="id";
    public static final String TABLE_NAME = "registration";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_DSLAM = "dslam";
    public static final String COLUMN_CHOICE = "choice";
   // public static final String COLUMN_HONE="hone";
 //   public static final String COLUMN_SLAM="slam";
    private String phone;
    private String dslam;
    private int choice;
    private String hone;
    private String slam;
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_PHONE + " TEXT  PRIMARY KEY  ,"
                    + COLUMN_DSLAM + " TEXT NON NULL,"
                    +COLUMN_ID+" TEXT ,"
                    + COLUMN_CHOICE + " INTEGER DEFAULT 0"
                    + ")";
    public Registration() {
    }
    public Registration(String phone, String dslam, int choice) {
        this.phone = phone;
        this.dslam = dslam;
        this.choice = choice;

    }
    public String getPhone() {
        return phone;
    }

    public String getDslam() {
        return dslam;
    }
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
    public void setDslam(String dslam) {
        this.dslam = dslam;
    }
    public void setChoice(int choice) {
        this.choice = choice;
    }
}






