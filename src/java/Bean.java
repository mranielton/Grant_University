/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.*;
/**
 *3
 * @author SPACE
 */

public class Bean {
    private String ID;
    private String PASS;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String address;
    private String phoneNumber;
    private String emailID;
    
    Student std = new Student();
    /**
     * Creates a new instance of Bean
     */
    public Bean() {
    }
    
    public String Action()
    {
        StringBuilder fName = new StringBuilder();
        StringBuilder lName = new StringBuilder();
        StringBuilder gndr = new StringBuilder();
        StringBuilder db = new StringBuilder();
        StringBuilder add = new StringBuilder();
        StringBuilder ph = new StringBuilder();
        StringBuilder email = new StringBuilder();
        ApplicationContext apc = new ClassPathXmlApplicationContext("university/spring-hibernate.xml");
        BeanDAO bhp = (BeanDAO)apc.getBean("beanDao");
        String uname=getID();
        String pass=getPASS();
        boolean b = false;
        List<Student> students = new ArrayList<Student>();
        students = bhp.getStudent();
        for(Iterator it=students.iterator();it.hasNext();)
        {
            std = (Student)it.next();
            if((std.getUserid().toString().equals(uname))&& (std.getPassword().toString().equals(pass)))
            {
                b=true;
                fName.append(std.getFirstname().toString());
                lName.append(std.getLastname().toString());
                gndr.append(std.getGender().toString());
                db.append(std.getDob().toString());
                add.append(std.getAddress().toString());
                ph.append(std.getPhone().toString());
                email.append(std.getEmail().toString());
                setValues(fName,lName,gndr,db,add,ph,email);
                break;
            }
            else
                b=false;
        }
        if(b==true)
        {
            return "student";
        }
        else
            return "error";
    }
    
    public void setValues(StringBuilder fName,StringBuilder lName,StringBuilder gndr,StringBuilder db,StringBuilder add,StringBuilder ph,StringBuilder email)
    {
        setFirstName(fName.toString());
        setLastName(lName.toString());
        setGender(gndr.toString());
        setDob(db.toString());
        setAddress(add.toString());
        setPhoneNumber(ph.toString());
        setEmailID(email.toString());
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getGender()
    {
        return gender;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getDob()
    {
        return dob;
    }
    public void setDob(String dob)
    {
        this.dob = dob;
    }
    
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmailID()
    {
        return emailID;
    }
    public void setEmailID(String emailID)
    {
        this.emailID = emailID;
    }
}