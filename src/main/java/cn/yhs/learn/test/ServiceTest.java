package cn.yhs.learn.test;

import cn.yhs.learn.domain.Permission;
import cn.yhs.learn.domain.Role;
import cn.yhs.learn.domain.User;
import cn.yhs.learn.service.PermissionService;
import cn.yhs.learn.service.RoleService;
import cn.yhs.learn.service.UserService;
import cn.yhs.learn.utils.PasswordUtils;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.test.ServiceTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 14:44
 * @Description: todo
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 测试容器
     */
    @Test
    public void testContext() {
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

    /**
     *  给密码加密
     */
    @Test
    public void testPassword() {

        User user0 = userService.findAllByUsername("dev4"); //04982a7b598d0c733e36ec684ce1a4a1
        System.out.println("user0 = " + user0);
        SimpleHash simpleHash = new SimpleHash("md5", user0.getPassword(), ByteSource.Util.bytes(user0.getUsername() + user0.getEmail()) ,2);
        System.out.println("simpleHash = " + simpleHash);
        String shiroMd5 = PasswordUtils.shiroMd5(user0.getUsername(), user0.getPassword(), user0.getEmail());
        System.out.println("shiroMd5 = " + shiroMd5);


    }


    /**
     * 测试User添加
     */
    @Test
    public void testUserAdd() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            if (i % 5 == 0) user.setUsername("admin" + i);
            if (i % 5 == 1) user.setUsername("user" + i);
            if (i % 5 == 2) user.setUsername("test" + i);
            if (i % 5 == 3) user.setUsername("bug" + i);
            if (i % 5 == 4) user.setUsername("dev" + i);
            user.setPassword("123456");
            if (i % 2 == 0)
                user.setGender(true);
            else
                user.setGender(false);
            user.setEmail(user.getUsername() + "@163.com");
            user.setCreateTime(new Date());
            user.setStatus(true);
            userList.add(user);
        }
        for (User user : userList) {
            userService.save(user);
        }
    }

    @Test
    public void testUserFindAll() {
     /*   List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }*/

        User user = userService.findAllByUsername("admin0");
        System.out.println("user = " + user);
    }

    /**
     * 给用户添加角色
     */
    @Test
    public void testUserAddRole() {
        List<User> userList = userService.findAll();

        for (User user : userList) {
            if (user.getUsername().startsWith("admin")) {
                userService.addRole(user, roleService.findByRoleId(5));
            }
            if (user.getUsername().startsWith("user")) {
                userService.addRole(user, roleService.findByRoleId(4));
            }
            if (user.getUsername().startsWith("test")) {
                userService.addRole(user, roleService.findByRoleId(2));
            }
            if (user.getUsername().startsWith("bug")) {
                userService.addRole(user, roleService.findByRoleId(3));
            }
            if (user.getUsername().startsWith("dev")) {
                userService.addRole(user, roleService.findByRoleId(1));
            }

        }
    }


    /**
     * 测试Role,添加角色
     */
    @Test
    public void testRole() {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Role role = new Role();
            if (i % 5 == 0) {
                role.setRoleName("admin");
                role.setRoleDesc("我是管理员");
            }
            if (i % 5 == 1) {
                role.setRoleName("user");
                role.setRoleDesc("我是普通用户");
            }
            if (i % 5 == 2) {
                role.setRoleName("test");
                role.setRoleDesc("我是测试人员");
            }
            if (i % 5 == 3) {
                role.setRoleName("bug");
                role.setRoleDesc("我是bug生产者");
            }
            if (i % 5 == 4) {
                role.setRoleName("dev");
                role.setRoleDesc("我是开发人员");
            }
            roleSet.add(role);
        }
        for (Role role : roleSet) {
            roleService.save(role);
        }

    }

    @Test
    public void testFindAllRole() {
      /*  List<Role> roleList = roleService.findAll();
        for (Role role : roleList) {
            System.out.println("role = " + role);
        }*/
        Role role = roleService.findByRoleId(1);
        System.out.println("role = " + role);


    }


    /**
     * 测试Permission
     */
    @Test
    public void testPermission() {
        List<Permission> permissionList = new ArrayList<>();
       /* for (int i = 0; i < 5; i++) {
            Permission permission = new Permission();
            if (i % 5 == 0) {
                permission.setPermissionName("管理员权限");
                permission.setPermissionUrl("*:*");
                permission.setPermissionDesc("管理员拥有所有权限");
            }
            if (i % 5 == 1) {
                permission.setPermissionName("普通用户添加权限");
                permission.setPermissionUrl("user:add");
                permission.setPermissionDesc("用户添加权限");
            }
            if (i % 5 == 2) {
                permission.setPermissionName("普通用户删除权限");
                permission.setPermissionUrl("user:delete");
                permission.setPermissionDesc("用户删除权限");
            }
            if (i % 5 == 3) {
                permission.setPermissionName("普通用户修改权限");
                permission.setPermissionUrl("user:update");
                permission.setPermissionDesc("用户修改权限");
            }
            if (i % 5 == 4) {
                permission.setPermissionName("普通用户查找权限");
                permission.setPermissionUrl("user:find");
                permission.setPermissionDesc("用户查找权限");
            }
            permissionList.add(permission);
        }*/

        for (int i = 0; i < 4; i++) {
            Permission permission = new Permission();
            if (i % 5 == 0) {
                permission.setPermissionName("测试人员查找权限");
                permission.setPermissionUrl("test:find");
                permission.setPermissionDesc("测试人员查找权限");
            }
            if (i % 5 == 1) {
                permission.setPermissionName("测试人员添加权限");
                permission.setPermissionUrl("test:add");
                permission.setPermissionDesc("测试人员添加权限");
            }
            if (i % 5 == 2) {
                permission.setPermissionName("测试人员删除权限");
                permission.setPermissionUrl("test:delete");
                permission.setPermissionDesc("测试人员删除权限");
            }
            if (i % 5 == 3) {
                permission.setPermissionName("测试人员修改权限");
                permission.setPermissionUrl("test:update");
                permission.setPermissionDesc("测试人员修改权限");
            }
            permissionList.add(permission);
        }
        for (Permission permission : permissionList) {
            // System.out.println("permission = " + permission);
            permissionService.save(permission);
        }
    }



}
