package cn.yhs.learn.dao;

import cn.yhs.learn.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.dao.RoleDao
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:26
 * @Description: todo
 **/
@Repository
public interface RoleDao {
    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from role")
    @Results(id = "roleAllMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "roleDesc", column = "role_desc"),
            @Result(property = "permissionList", column = "id", many = @Many(select = "cn.yhs.learn.dao.PermissionDao.findAllByRoleId"))
            // 1对多，根据角色id可以查询该角色所有的权限
    })
    List<Role> findAll();

    /**
     * 根据用户id查询该用户拥有的全部角色
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select role_id from user_role where user_id = #{userId})")
    @ResultMap("roleAllMap")
    List<Role> findAllByUserId(Integer userId);


    /**
     * 保存一条角色信息
     *
     * @param role
     */
    @Insert("insert into role(role_name,role_desc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 根据角色id 删除一条角色信息
     *
     * @param roleId
     */
    @Delete("delete from role where id = #{roleId}")
    void deleteById(Integer roleId);

    @Select("select * from role where id = #{roleId}")
    @ResultMap("roleAllMap")
    Role findByRoleId(Integer roleId);
}
