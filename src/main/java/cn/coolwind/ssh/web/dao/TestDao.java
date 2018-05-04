package cn.coolwind.ssh.web.dao;

import cn.coolwind.ssh.core.base.BaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TestDao extends BaseDao {

    public List test() {
        String sql = "select * from aaa";
        List list = sqlQuery(sql);
        return list;
    }
}
