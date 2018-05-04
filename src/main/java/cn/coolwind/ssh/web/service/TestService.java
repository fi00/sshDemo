package cn.coolwind.ssh.web.service;

import cn.coolwind.ssh.web.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public List test() {
        return testDao.test();
    }
}
