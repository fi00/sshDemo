package cn.coolwind.ssh.core.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.plaf.PanelUI;
import java.util.List;

public class BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List sqlQuery(String sql,Object... values) {
        Query query = getSession().createSQLQuery(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    query.setParameter(i, values[i]);
                }
            }
        }
        return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    public void sqlUpdate(String sql, Object... values) {
        Query query = getSession().createSQLQuery(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    query.setParameter(i, values[i]);
                }
            }
        }
        query.executeUpdate();
    }

    public List<T> query(String hql, Object... values) {
        Query query = getSession().createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    query.setParameter(i, values[i]);
                }
            }
        }
        return query.list();
    }

    public void save(T model) {
        getSession().save(model);
    }

    public void saveOrUpdate(T model) {
        getSession().saveOrUpdate(model);
    }

    public void delete(T model) {
        getSession().delete(model);
    }

    public void update(T model) {
        getSession().update(model);
    }

}
