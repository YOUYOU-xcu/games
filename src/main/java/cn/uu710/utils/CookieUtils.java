package cn.uu710.utils;

import javax.servlet.http.Cookie;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 14:02
 */

public class CookieUtils {
    /**
     * 通过名称在cookie数组获取指定的cookie
     *
     */
    public static Cookie getCookieByName(String name,Cookie[] cookies){

        if (cookies!=null){
            for (Cookie c:cookies) {
                //通过名称获取
                if (name.equals(c.getName())){
//                    获取
                    return c;
                }
            }
        }

        return null;
    }
}
