package cn.coolwind.ssh.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TestDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List test() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select * from aaa");
        List list = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return list;
    }
}
