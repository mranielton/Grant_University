/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import university.Student;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import university.*;
/**
 *
 * @author SPACE
 */

public class RegistrationForm {
private String firstName;
private String lastName;
private String gender;
private String address;
private String contactNumber;
private String emailID;
private String userID;
private String password;
private String confirmPassword;
private Date dateofBirth;
private String FinalPassword;
private String userIdError;
private String course;
    /**
     * Creates a new instance of RegistrationForm
     */

    
    
    public RegistrationForm() {
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
    this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
    this.lastName = lastName;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @param gender the first gender to set
     */
    public void setGender(String gender) {
    this.gender = gender;
    }
    /**
     * @return the Address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the first address to set
     */
    public void setAddress(String address) {
    this.address = address;
    }
     /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }
    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    }
    /**
     * @return the emailID
     */
    public String getEmailID() {
        return emailID;
    }
    /**
     * @param emailID the emailID to set
     */
    public void setEmailID(String emailID) {
    this.emailID = emailID;
    }
    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }
    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
    this.userID = userID;
    }
    /**
     * @Return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
    this.password = password;
    }
    /**
     * @Return the ConfirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }
    /**
     * @param ConfirmPassword the password to set
     */
    public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    }
    /**
     * @Return DateofBirth
     */
    public Date getDateofBirth() {
        return dateofBirth;
    }
    /**
     * @param dateofBirth the password to set
     */
    public void setDateofBirth (Date dateofBirth) 
    {
    this.dateofBirth = dateofBirth;
    }
    /**
     * @Return DateofBirth
     */
    public String getFinalPassword() {
        return FinalPassword;
    }
    /**
     * @param FinalPassword the password to set
     */
    public void setFinalPassword (String FinalPassword) {
    this.FinalPassword = FinalPassword;
    }
    public void validateEmail(FacesContext fc, UIComponent c, Object value) throws ValidatorException
    {
    String email= (String)value;
    Pattern mask = null;
    mask = Pattern.compile(".+@.+\\.[a-z]+");
    Matcher matcher = mask.matcher(email);
    if(!matcher.matches())
    {
    FacesMessage message = new FacesMessage();
    message.setDetail("Invalid e-mail ID");
    message.setSummary("Invalid e-mail ID");
    throw new ValidatorException(message);
    }
    }
    public void validateName(FacesContext fc, UIComponent c, Object value)
    {
        if (
            ((String)value).contains("!")||((String)value).contains("@")||((String)value).contains("#")||((String)value).contains("$")||((String)value).contains("%")||((String)value).contains("&")||((String)value).contains("*"))throw new
         ValidatorException(new FacesMessage("Name cannot contain special characters"));
    
    }
    
    public void validateFinalPassword(FacesContext fc, UIComponent c, Object value) throws ValidatorException
    {
    setFinalPassword((String) value);
    }
    public void validateCPassword(FacesContext fc, UIComponent c, Object value) throws ValidatorException
    {
    String cPassword= (String)value;
    RegistrationForm rf=new RegistrationForm();
    System.out.println(getFinalPassword());
    if (cPassword.compareTo(getFinalPassword())!=0)
    {
    FacesMessage message = new FacesMessage();
    message.setSummary("Password does not match");
    throw new ValidatorException(message);
    }
    }
    
    public String getCourse()
    {
        return course;
    }
    
    public void setCourse(String course)
    {
        this.course = course;
    }
    
    
    public String getUserIdError()
    {
        return userIdError;
    }
    public void setUserIdError(String userIdError)
    {
        this.userIdError = userIdError;
    }
    
    
    public String submitAction()
    {
        ApplicationContext apc = new ClassPathXmlApplicationContext("university/spring-hibernate.xml");
        RegistrationServices rghp = (RegistrationServices)apc.getBean("registrationDao");
        Student std = new Student();
        std.setFirstname(getFirstName().toString());
        std.setLastname(getLastName().toString());
        std.setGender(getGender());
        std.setDob(getDateofBirth());
        std.setAddress(getAddress());
        std.setPhone(getContactNumber());
        std.setEmail(getEmailID());
        std.setUserid(getUserID());
        std.setPassword(getPassword());
        Studentcourse sc = new Studentcourse();
        sc.setCourseid(getCourse());
        String msg = rghp.insertStudent(std, sc);
        if(msg.equals("error"))
        {
            setUserIdError("User Id already exists. Please select another UserId.");
            setUserID("");
            return "Registration";
        }
        else 
        {
            return "Success";
        }
        
    }
}
