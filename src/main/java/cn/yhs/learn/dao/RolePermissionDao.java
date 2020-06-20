package cn.yhs.learn.dao;

import cn.yhs.learn.domain.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.dao.RolePermissionDao
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:39
 * @Description: todo
 **/
@Repository
public interface RolePermissionDao {
    /**
     * 往角色权限中间表中插入语一条数据
     *
     * @param rolePermission
     */
    @Insert("insert into role_permission(role_id,permission_id) values (#{roleId},#{permissionId})")
    void save(RolePermission rolePermission);

    @Delete("delete from role_permission where role_id = #{roleId} and permission_id = #{permissionId}")
    void delete(RolePermission rolePermission);

    /**
     * 根据角色id 删除数据
     *
     * @param roleId
     */
    @Delete("delete from role_permission where role_id = #{roleId}")
    void deleteByRoleId(Integer roleId);
}
