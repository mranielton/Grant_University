package university;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

public class RegistrationHelper {
    Session session=null;
    boolean b=true;
    
    {
       this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public String insertStudent(Student std , Studentcourse sc)
    {
        org.hibernate.Transaction tx= session.beginTransaction();
        String uid=std.getUserid();
        System.out.println(uid);
        Query query=session.createQuery("FROM university.Student");
        List<Student> student=query.list();
        for(Iterator it=student.iterator(); it.hasNext(); )
        {
            Student st=(Student) it.next();
            if (st.getUserid().equals(uid))
                b=false;
        }
        if (b==false)
        {
            return "error";
        }
        else
        {
            try
            {
                int rgstnum=0;
                Query q=session.createQuery("Select max(registrationnumber)from Student");
              List currentRegNo= q.list();
              rgstnum=(Integer)currentRegNo.get(0)+1;
              std.setRegistrationnumber(rgstnum);
              sc.setRegistrationnumber(rgstnum);
              Serializable objID=session.save(std);
              session.saveOrUpdate(sc);
              tx.commit();
            }
            catch (Exception e)
            {
                if (tx !=null) {
                    tx.rollback();
                }
              System.out.println(e.getMessage());
            }
                    return "true";
        }
    }
}

