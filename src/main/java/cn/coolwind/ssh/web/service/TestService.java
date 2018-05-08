package cn.coolwind.ssh.web.service;

import cn.coolwind.ssh.web.dao.TestDao;
import cn.coolwind.ssh.web.entity.Test;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List test() {
        return testDao.test();
    }

    @Transactional
    public void change(Test t) {
        Test test = testDao.getById(t.getId());

        if (test != null) {
            BeanUtils.copyProperties(test, t, "name","num");
        }
        testDao.saveOrUpdate(t);
    }

    public void delete(int id) {
        Test test = new Test();
        test.setId(id);
        testDao.delete(test);
    }


}
