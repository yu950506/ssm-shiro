package cn.yhs.learn.dao;

import cn.yhs.learn.domain.Permission;
import com.sun.deploy.security.TrustRecorder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.dao.PermissionDao
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:26
 * @Description: todo
 **/
@Repository
public interface PermissionDao {
    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from permission")
    @Results(id = "permissionAllMap", value = { // 结果集映射
            @Result(id = true, property = "id", column = "id"), // 指定主键
            @Result(property = "permissionName", column = "permission_name"), // 实体类和数据库的列名不唯一
            @Result(property = "permissionUrl", column = "permission_url"),
            @Result(property = "permissionDesc", column = "permission_desc")
    })
    List<Permission> findAll();

    /**
     * 根据角色id查询该角色拥有的全部权限信息
     *
     * @param roleId 角色id
     * @return
     */
    @Select("select * from permission where id in (select permission_id from role_permission where role_id = #{roleId})")
    @ResultMap("permissionAllMap")
    List<Permission> findAllByRoleId(Integer roleId);

    /**
     * 插入权限数据
     *
     * @param permission
     */
    @Insert("insert into permission(permission_name,permission_url,permission_desc) values (#{permissionName},#{permissionUrl},#{permissionDesc})")
    void save(Permission permission);

    /**
     * 根据权限id删除权限信息
     *
     * @param id
     */
    @Delete("delete from permission where id = #{id}")
    void deleteById(Integer id);


}
