package cn.uu710.service;

import cn.uu710.domain.Admin;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:49
 */

public interface AdminService {
    Admin findAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
}
