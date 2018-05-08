package cn.coolwind.ssh.core.base;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    protected Map success(Object list) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", 1);
        map.put("msg", "操作成功！");
        map.put("data", list);
        return map;
    }

    protected Map success() {
        Map<String, Object> map = new HashMap<>();
        return success(null);
    }

    protected Map failed(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", 0);
        map.put("msg", msg);
        return map;
    }
}
