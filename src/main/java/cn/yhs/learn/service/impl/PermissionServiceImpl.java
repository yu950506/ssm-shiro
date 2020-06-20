package cn.yhs.learn.service.impl;

import cn.yhs.learn.dao.PermissionDao;
import cn.yhs.learn.domain.Permission;
import cn.yhs.learn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.impl.PermissionServiceImpl
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:16
 * @Description: todo
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    /**
     *  查询所有权限
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    /**
     *  根据角色id查询所有权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findAllByUserId(Integer roleId) {
        return permissionDao.findAllByRoleId(roleId);
    }

    @Override
    public void deleteById(Integer permissionId) {
        permissionDao.deleteById(permissionId);
    }
}
