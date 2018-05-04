package cn.coolwind.ssh.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List test() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from aaa");
        return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }
}
