package cn.yhs.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.domain.Role
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 14:49
 * @Description: todo
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissionList; // 1：N 一角色有多种权限
}
