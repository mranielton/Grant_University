/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Espi
 */
public class CourseDetailsDAO 
{
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    public CourseDetailsDAO()
    {
        Configuration configuration = new Configuration().configure();
    }
        public List getcourseByName(String courseName)
        {
            List<Coursedetails> courselist = null;
            try
            {
                Session session = sessionFactory.openSession();
                org.hibernate.Transaction tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(Coursedetails.class).add(Restrictions.eq("coursename",courseName));
                courselist=(List<Coursedetails>) criteria.list();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return courselist;
        }



}