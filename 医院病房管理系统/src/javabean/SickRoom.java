package javabean;

public class SickRoom {
    private  String mno;
    private  String mname;
    private  String nno;
    private  String status;

    public String getNno() {
        return nno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setNno(String nno) {
        this.nno = nno;
    }

}
