package cn.coolwind.ssh.core.base;

import java.util.HashMap;
import java.util.Map;
/**
 * @author coolwind
 */
public class BaseController {
    protected Map success(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("code",1);
        map.put("msg", "操作成功！");
        map.put("data", data);
        return map;
    }

    protected Map success() {
        Map<String, Object> map = new HashMap<>();
        return success(null);
    }

    protected Map failed(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("state",false);
        map.put("code", 0);
        map.put("msg", msg);
        return map;
    }
}
