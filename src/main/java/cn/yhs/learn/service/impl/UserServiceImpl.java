package cn.yhs.learn.service.impl;

import cn.yhs.learn.dao.UserDao;
import cn.yhs.learn.dao.UserRoleDao;
import cn.yhs.learn.domain.Role;
import cn.yhs.learn.domain.User;
import cn.yhs.learn.domain.UserRole;
import cn.yhs.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.impl.UserServiceImpl
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:15
 * @Description: todo
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;

    /**
     *  保存一条用户信息
     * @param user
     */
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    /**
     *  查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     *  根据用户名查询用户的所有信息，包括角色，以及角色的权限
     * @param username
     * @return
     */
    @Override
    public User findAllByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 删除用户,把用户角色表中维护的中间数据也要删除
     *
     * @param userId
     */
    @Override
    public void deleteById(Integer userId) {
        // 1. 先删除中间表的数据
        userRoleDao.deleteByUserId(userId);
        // 2. 再删除用户表的数据
        userDao.deleteById(userId);
    }

    /**
     * 给用户添加角色，实际就是往用户角色中间表中添加数据
     *
     * @param user
     * @param role
     */
    @Override
    public void addRole(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        userRoleDao.save(userRole);
    }

    /**
     * 给用户删除角色
     *
     * @param user
     * @param role
     */
    @Override
    public void deleteRole(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        userRoleDao.delete(userRole);
    }
}
