/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import university.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SPACE
 */
public class CourseDetailsBean 
{
    private String CourseName;
    private HtmlOutputText CourseId, CourseDuration, CourseEligibility, CourseFee;

public CourseDetailsBean(){  }

Coursedetails course =new Coursedetails();

public void CourseDetailsAction(ValueChangeEvent vce)
{
    String cName= vce.getNewValue().toString();
    StringBuilder cID = new StringBuilder();
    StringBuilder cDuration = new StringBuilder();
    StringBuilder cEligibility = new StringBuilder();
    StringBuilder cFee = new StringBuilder();
    
    performLookup(cID,cName,cDuration,cEligibility,cFee);
    
    getCourseId().setValue(cID.toString());
    getCourseDuration().setValue(cDuration.toString());
    getCourseEligibility().setValue(cEligibility.toString());
    getCourseFee().setValue(cFee.toString());
}

void performLookup(StringBuilder cID, String cName, StringBuilder cDuration, StringBuilder cEligibility, StringBuilder cFee)
{
    ApplicationContext apc = new ClassPathXmlApplicationContext("university/spring-hibernate.xml");
    CourseDetailsDAO helper = (CourseDetailsDAO)apc.getBean("courseDetailsDao");
    List<Coursedetails> courses = new ArrayList<Coursedetails>();
    courses = helper.getcourseByName(cName);
    Iterator iterator;
    iterator = courses.iterator();
    while(iterator.hasNext())
    {
        course = (Coursedetails)iterator.next();
    }
    cID.append(course.getCourseid().toString());
    cDuration.append(course.getCourseduration().toString());
    cEligibility.append(course.getCourseeligibility().toString());
    cFee.append(course.getCoursefee().toString());
    
}
    public String getCourseName()
    {
    return CourseName;
    }
    public void setCourseName(String CourseName)
    {
    this.CourseName = CourseName;
    }
     public HtmlOutputText getCourseId()
    {
    return CourseId;
    }
    public void setCourseId(HtmlOutputText CourseId)
    {
    this.CourseId = CourseId;
    }
     public HtmlOutputText getCourseDuration()
    {
    return CourseDuration;
    }
    public void setCourseDuration(HtmlOutputText CourseDuration)
    {
    this.CourseDuration = CourseDuration;
    }
      public HtmlOutputText getCourseEligibility()
    {
    return CourseEligibility;
    }
    public void setCourseEligibility(HtmlOutputText CourseEligibility)
    {
    this.CourseEligibility = CourseEligibility;
    }
      public HtmlOutputText getCourseFee()
    {
    return CourseFee;
    }
    public void setCourseFee(HtmlOutputText CourseFee)
    {
    this.CourseFee = CourseFee;
    }
}

