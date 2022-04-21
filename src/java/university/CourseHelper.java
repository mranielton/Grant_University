/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Espi
 */
public class CourseHelper {
    Session session = null;
    
public CourseHelper()
{
    session = HibernateUtil.getSessionFactory().getCurrentSession();
}
    
public List getcourseByName(String courseName)
    {
        List<Coursedetails> courselist=null;
        try
        {
            org.hibernate.Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria (Coursedetails.class)
            .add(Restrictions.eq("coursename", courseName));
            
            courselist = (List<Coursedetails>) criteria.list();
            tx.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return courselist;
    }
}