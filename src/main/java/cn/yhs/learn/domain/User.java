package cn.yhs.learn.domain;

import cn.yhs.learn.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.domain.User
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 14:47
 * @Description: todo
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean gender;
    private String genderStr; // 0：男，1：女
    private String email;
    private Date createTime;
    private String createTimeStr;
    private Date updateTime;
    private String updateTimeStr;
    private Boolean status;
    private String statusStr;// 0： 关闭，1 ：开启
    private Set<Role> roleSet; // 1：N 一个用户有多个角色

    public String getGenderStr() {
        return this.getGender() ? "男" : "女";
    }

    public String getCreateTimeStr() {
        return DateUtils.parseString(this.getCreateTime());
    }

    public String getUpdateTimeStr() {
        if(null== this.getUpdateTime()){
            return "用户没有更新";
        }
        return DateUtils.parseString(this.getUpdateTime());
    }

    public String getStatusStr() {
        return this.getStatus() ? "开启" : "关闭";
    }

}
