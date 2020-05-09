/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Sulaiman
 */
public class Appointement {
    
    private int SRN;
    private boolean isAvailapble;
    private lecturer lec;
    private String status;
    private String time;

    public Appointement(int SRN, String time) {
        this.SRN = SRN;
        this.time = time;
        isAvailapble =true;
        status ="pending";
        lec = new lecturer(0, "---");
        
    }

   

    public int getSRN() {
        return SRN;
    }

    public void setSRN(int SRN) {
        this.SRN = SRN;
    }

    public boolean getisAvailapble() {
        return isAvailapble;
    }

    public void setIsAvailapble(boolean isAvailapble) {
        this.isAvailapble = isAvailapble;
    }

    public lecturer getLec() {
        return lec;
    }

    public void setLec(lecturer lec) {
        this.lec = lec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
}
