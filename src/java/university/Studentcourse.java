package university;
// Generated Aug 31, 2021 10:50:29 AM by Hibernate Tools 4.3.1



/**
 * Studentcourse generated by hbm2java
 */
public class Studentcourse  implements java.io.Serializable {


     private int registrationnumber;
     private String courseid;

    public Studentcourse() {
    }

	
    public Studentcourse(int registrationnumber) 
    {
        this.registrationnumber = registrationnumber;
    }
    public Studentcourse(int registrationnumber, String courseid)
    {
       this.registrationnumber = registrationnumber;
       this.courseid = courseid;
    }
   
    public int getRegistrationnumber()
    {
        return this.registrationnumber;
    }
    
    public void setRegistrationnumber(int registrationnumber) {
        this.registrationnumber = registrationnumber;
    }
    public String getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }




}


