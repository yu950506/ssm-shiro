package cn.yhs.learn.service;

import cn.yhs.learn.domain.Role;
import cn.yhs.learn.domain.User;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.service.UserService
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 16:09
 * @Description: todo
 **/
public interface UserService {

    void save(User user);

    List<User> findAll();

    User findAllByUsername(String username);

    void deleteById(Integer userId);

    void addRole(User user,Role role);

    void deleteRole(User user,Role role);

}
