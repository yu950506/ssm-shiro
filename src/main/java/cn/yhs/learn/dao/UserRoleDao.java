package cn.yhs.learn.dao;

import cn.yhs.learn.domain.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.dao.UserRoleDao
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 15:39
 * @Description: todo
 **/
@Repository
public interface UserRoleDao {
    /**
     * 往用户角色中间表中插入一条数据
     *
     * @param userRole
     */
    @Insert("insert into user_role(user_id,role_id) values (#{userId},#{roleId})")
    void save(UserRole userRole);

    /**
     * 根据用户id和roleid 删除数据
     *
     * @param userRole
     */
    @Delete("delete from user_role where user_id = #{userId},role_id = #{roleId}")
    void delete(UserRole userRole);

    /**
     * 根据用户id 删除数据
     *
     * @param userId
     */
    @Delete("delete from user_role where user_id = #{userId}")
    void deleteByUserId(Integer userId);

    /**
     *  根据角色id 删除数据
     * @param roleId
     */
    @Delete("delete from user_role where role_id = #{roleId}")
    void deleteByRoleId(Integer roleId);
}
