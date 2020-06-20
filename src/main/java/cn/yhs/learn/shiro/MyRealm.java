package cn.yhs.learn.shiro;

import cn.yhs.learn.domain.Permission;
import cn.yhs.learn.domain.Role;
import cn.yhs.learn.domain.User;
import cn.yhs.learn.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.shiro.MyRealm
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 19:06
 * @Description: 自定义的 Realm
 **/

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 返回该Realm的的名称
     *
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    /**
     * 身份认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 从token中获取登录的用户名
        String username = token.getPrincipal().toString();
        // 2. 根据用户名去数据库中查询该用户
        User user = userService.findAllByUsername(username);
        // 3. 用户不为空
        if (null != user) {
            // 4. 加盐规则：用户名+邮箱
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername() + user.getEmail());
            // 5. 创建认证对象并返回
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, this.getName());
            return authenticationInfo;
        }
        return null;
    }

    /**
     * 权限授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1. 从 principals中获去身份信息
        User user = (User) principals.getPrimaryPrincipal();
        // 2.创建授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 3.往授权对象中添加角色列表
        Set<Role> roleSet = user.getRoleSet();
        if (null != roleSet && roleSet.size() > 0) {
            ArrayList<String> roles = new ArrayList<>();
            for (Role role : roleSet) {
                // 3.1 往角色集合中添加角色名称
                roles.add(role.getRoleName());
                // 4. 往授权对象中添加权限
                // 4.1 从角色中获取该角色拥有的权限
                List<Permission> permissionList = role.getPermissionList();
                if (null != permissionList && permissionList.size() > 0) {
                    for (Permission permission : permissionList) {
                        // 4.2 将权限信息逐个添加到授权对象中
                        authorizationInfo.addStringPermission(permission.getPermissionUrl());
                    }
                }
            }
            // 3.2 添加封装的所有角色集合
            authorizationInfo.addRoles(roles);
        }
        return authorizationInfo;
    }


}
