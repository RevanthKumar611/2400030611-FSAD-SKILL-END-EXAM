package com.klef.fsad.exam;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.Query;
import java.util.Date;
import java.util.List;
public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Transport t1 = new Transport();
        t1.setName("Bus");
        t1.setDate(new Date());
        t1.setStatus("Active");
        t1.setType("Public");
        t1.setCost(100.0);
        session.save(t1);
        Transport t2 = new Transport();
        t2.setName("Train");
        t2.setDate(new Date());
        t2.setStatus("Delayed");
        t2.setType("Railway");
        t2.setCost(150.0);
        session.save(t2);
        tx.commit();
        session.beginTransaction();
        String hql = "from Transport where name like :param";
        Query query = session.createQuery(hql);
        query.setParameter("param", "%");  // fetch all
        List<Transport> list = query.list();
        for(Transport t : list)
        {
            System.out.println(
                t.getId()+" "+t.getName()+" "+
                t.getStatus()+" "+t.getType()+" "+
                t.getCost()
            );
        }
        session.close();
        sf.close();
    }
}
