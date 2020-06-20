package cn.yhs.learn.service;

import cn.yhs.learn.domain.Permission;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.PermissionService
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:10
 * @Description: todo
 **/
public interface PermissionService {
    void save(Permission permission);

    List<Permission> findAll();

    List<Permission> findAllByUserId(Integer  roleId);

    void deleteById(Integer permissionId);
}
