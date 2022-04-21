/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Espi
 */
public class BeanDAO {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    public BeanDAO()
    {
        Configuration configuration = new Configuration().configure();
    }
    
    public List getStudent()
    {
        List<Student> students=null;
        try
        {
            Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("FROM university.Student");
            students = (List<Student>) q.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }
    
    
}
