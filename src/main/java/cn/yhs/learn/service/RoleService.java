package cn.yhs.learn.service;

import cn.yhs.learn.domain.Permission;
import cn.yhs.learn.domain.Role;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.RoleService
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:10
 * @Description: todo
 **/
public interface RoleService {

    void save(Role role);

    List<Role> findAll();

    List<Role> findAllByUserId(Integer userId);

    void deleteById(Integer roleId);

    void addPermission(Role role, Permission permission);

    void deletePermission(Role role, Permission permission);

    Role findByRoleId(Integer roleId);

}
