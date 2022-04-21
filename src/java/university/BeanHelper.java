/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Espi
 */
public class BeanHelper 
{
    Session session = null;
    
    public BeanHelper()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }       
    
    public List getStudent()
    {
        List<Student> students=null;
        try
        {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from university.Student");
            students = (List<Student>) q.list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }
    
}
