package cn.coolwind.ssh.web.dao;

import cn.coolwind.ssh.core.base.BaseDao;
import cn.coolwind.ssh.web.entity.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author coolwind
 */
@Repository
public class TestDao extends BaseDao {

    public List test() {
        String sql = "select * from aaa";
        List list = sqlQuery(sql);
        return list;
    }

    public Test getById(int id) {
        String hql = "from Test where id = ?";
        List list =   query(hql,id);
        if (list.size() > 0) {
            return (Test) list.get(0);
        }else {
            return null;
        }
    }
}
