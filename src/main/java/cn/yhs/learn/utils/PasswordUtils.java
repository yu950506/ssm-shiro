package cn.yhs.learn.utils;

import cn.yhs.learn.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ProjectName: shiro-demo
 * @Name: cn.yhs.learn.utils.PasswordUtils
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 9:07
 * @Description: 密码加密工具
 **/
public class PasswordUtils {
    /**
     * shiro中定义的加密方式
     * MD5的方式
     * 散列2次
     * 加盐：用户名+邮箱
     *
     * @param username
     * @param password
     * @param email
     * @return
     */
    public static String shiroMd5(String username, String password, String email) {
        return new SimpleHash("md5", password, ByteSource.Util.bytes(username + email), 2).toString();
    }

    /**
     * 方法的重载
     *
     * @param user
     * @return
     */
    public static String shiroMd5(User user) {
        return shiroMd5(user.getUsername(), user.getPassword(), user.getEmail());
    }

}
