package cn.yhs.learn.dao;

import cn.yhs.learn.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.dao.UserDao
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:26
 * @Description: todo
 **/
@Repository
public interface UserDao {

    /**
     * 查询所有用户的所有信息
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userAllMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "email", property = "email"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "status", property = "status"),
            @Result(property = "roleSet", column = "id", many = @Many(select = "cn.yhs.learn.dao.RoleDao.findAllByUserId"))
    })
    List<User> findAll();

    /**
     * 保存一个用户,不用给更新时间字段赋值
     *
     * @param user
     */
    @Insert("insert into user(username,password,gender,email,create_time,status) values (" +
            "#{username},#{password},#{gender},#{email},#{createTime},#{status})")
    void save(User user);

    /**
     * 根据用户id 删除用户
     *
     * @param userId
     */
    @Delete("delete from user where id = #{userId}")
    void deleteById(Integer userId);

    /**
     * 根据用户名查询用户的信息，包含用户的角色，以及该用户当前角色拥有的权限
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    @ResultMap("userAllMap")
    User findByUsername(String username);

}
