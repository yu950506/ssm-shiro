package cn.yhs.learn.service.impl;

import cn.yhs.learn.dao.RoleDao;
import cn.yhs.learn.dao.RolePermissionDao;
import cn.yhs.learn.dao.UserRoleDao;
import cn.yhs.learn.domain.Permission;
import cn.yhs.learn.domain.Role;
import cn.yhs.learn.domain.RolePermission;
import cn.yhs.learn.domain.UserRole;
import cn.yhs.learn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.impl.RoleServiceImpl
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:15
 * @Description: todo
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public List<Role> findAllByUserId(Integer userId) {
        return roleDao.findAllByUserId(userId);
    }

    /**
     * 删除角色，还要把中间表的数据进行删除
     *
     * @param roleId
     */
    @Override
    public void deleteById(Integer roleId) {
        // 1. 先删除中间表的数据
        userRoleDao.deleteByRoleId(roleId);
        rolePermissionDao.deleteByRoleId(roleId);
        // 2. 再删除角色表中数据
        roleDao.deleteById(roleId);
    }

    /**
     *  给角色添加权限
     * @param role
     * @param permission
     */
    @Override
    public void addPermission(Role role, Permission permission) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permission.getId());
        rolePermissionDao.save(rolePermission);
    }

    /**
     *  给角色删除权限
     * @param role
     * @param permission
     */
    @Override
    public void deletePermission(Role role, Permission permission) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permission.getId());
        rolePermissionDao.delete(rolePermission);
    }

    @Override
    public Role findByRoleId(Integer roleId) {
        return roleDao.findByRoleId(roleId);
    }
}
