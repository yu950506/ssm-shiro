package cn.yhs.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.domain.Permission
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 14:49
 * @Description: todo
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Permission {
    private Integer id;
    private String permissionName;
    private String permissionUrl;
    private String permissionDesc;
}
