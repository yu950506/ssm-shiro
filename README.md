# ssm-shiro整合

# 1.pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.yhs.learn</groupId>
    <artifactId>ssm-shiro</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>ssm-shiro</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <!--spring相关的版本的版本-->
        <spring-context.version>5.0.10.RELEASE</spring-context.version>
        <!--spring-security版本-->
        <spring-security.version>5.0.9.RELEASE</spring-security.version>
        <!--spring整合mybatis的版本-->
        <mybatis-spring.version>1.3.2</mybatis-spring.version>
        <!--spring整合junit的版本-->
        <spring-junit.version>5.0.10.RELEASE</spring-junit.version>
        <!--spring-shiro整合的版本-->
        <spring.shiro.version>1.3.2</spring.shiro.version>
        <!--servlet-->
        <servlet.version>2.5</servlet.version>
        <servlet-jsp.version>2.0</servlet-jsp.version>
        <!--数据层版本-->
        <mybatis.version>3.4.5</mybatis.version>
        <pagehelper.version>5.1.10</pagehelper.version>
        <druid.version>1.1.12</druid.version>
        <mysql.version>5.1.47</mysql.version>
        <!--工具层版本-->
        <jackson.version>2.9.8</jackson.version>
        <lombok.version>1.18.8</lombok.version>
        <slf4j.version>1.6.4</slf4j.version>
        <log4j.version>1.2.16</log4j.version>
        <junit.version>4.12</junit.version>
    </properties>

    <dependencies>
        <!--=============================== Web层 ================================-->
        <!--SpringSecurity版本-->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>${spring-security.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>${spring-security.version}</version>
        </dependency>
        <!--权限控制——页面级别的控制-->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-taglibs</artifactId>
            <version>${spring-security.version}</version>
        </dependency>
        <!--JSR250-->
        <!--方法级别的权限控制1.导入依赖-->
        <dependency>
            <groupId>javax.annotation</groupId>
            <artifactId>jsr250-api</artifactId>
            <version>1.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring-context.version}</version>
        </dependency>
        <!--导入servlet-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>${servlet.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl-api</artifactId>
            <version>1.2</version>
        </dependency>


        <!--=============================== SERVICE层 ================================-->
        <!--spring,自动会导入底层依赖的spring包-->
        <!--        <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-context</artifactId>
                    <version>${spring-context.version}</version>
                </dependency>-->
        <!--spring 面向切面编程必须加的jar-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring-context.version}</version>
        </dependency>
        <!--spring 事务-->
        <!--       <dependency>
                   <groupId>org.springframework</groupId>
                   <artifactId>spring-tx</artifactId>
                   <version>${spring-context.version}</version>
               </dependency>-->
        <!--spring 事务管理数据源-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring-context.version}</version>
        </dependency>

        <!--=============================== spring整合mybatis的jar ================================-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis-spring.version}</version>
        </dependency>
        <!--=============================== spring整合junit的jar ================================-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring-junit.version}</version>
            <!--  <scope>test</scope>-->
        </dependency>
        <!--=============================== spring整合shiro的jar ================================-->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>${spring.shiro.version}</version>
        </dependency>


        <!--=============================== DAO层 ================================-->
        <!--mybatis版本-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <!-- 分页插件版本 -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>${pagehelper.version}</version>
        </dependency>

        <!--数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>
        <!--mysql版本-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!--=============================== 工具层 ================================-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
        </dependency>


    </dependencies>

    <build>
        <finalName>ssm-shiro</finalName>
        <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
            <plugins>
                <plugin>
                    <artifactId>maven-clean-plugin</artifactId>
                    <version>3.1.0</version>
                </plugin>
                <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
                <plugin>
                    <artifactId>maven-resources-plugin</artifactId>
                    <version>3.0.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.0</version>
                </plugin>
                <plugin>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.1</version>
                </plugin>
                <plugin>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.2.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-install-plugin</artifactId>
                    <version>2.5.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-deploy-plugin</artifactId>
                    <version>2.8.2</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>

```

# 2.applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
    <!--1.配置基包扫描-->
    <context:component-scan base-package="cn.yhs.learn">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
    <!--2. 配置数据源-->
    <context:property-placeholder location="classpath*:jdbc.properties"/>
    <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
        <property name="driverClassName" value="${druid.jdbc.driverClassName}"/>
        <property name="url" value="${druid.jdbc.url}"/>
        <property name="username" value="${druid.jdbc.username}"/>
        <property name="password" value="${druid.jdbc.password}"/>
        <property name="maxWait" value="${druid.jdbc.maxWait}"/>
        <property name="maxActive" value="${druid.jdbc.maxActive}"/>
        <property name="initialSize" value="${druid.jdbc.initialSize}"/>
    </bean>

    <!--================================ dao 层 开始========================================-->
    <!--3. 配置SqlSessionFactory-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="plugins">
            <array>
                <!--配置分页插件-->
                <bean class="com.github.pagehelper.PageInterceptor" id="pageInterceptor">
                    <property name="properties">
                        <value>
                            helperDialect=mysql
                            reasonable=true
                        </value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>

    <!--4. 配置Mapper扫描-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer" id="mapperScannerConfigurer">
        <property name="basePackage" value="cn.yhs.learn.dao"/>
    </bean>
    <!--================================ dao 层 结束========================================-->
    <!--================================ service 层 开始========================================-->
    <!--5. 配置事务管理器-->
    <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--6. 配置声明式事务-->
    <tx:advice transaction-manager="transactionManager" id="txAdvice">
        <tx:attributes>
            <tx:method name="find*" read-only="true"/>
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>

    <!--7. 配置AOP进行切入-->
    <aop:config>
        <aop:pointcut id="pc1" expression="execution(* cn.yhs.learn.service.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pc1"/>
    </aop:config>
    <!--================================ service 层 结束========================================-->

    <!--8 .shiro 注解生效，还要在spring-mvc中进行启用-->
    <bean id="lifecycleBeanPostProcessor" class="org.apache.shiro.spring.LifecycleBeanPostProcessor"/>


</beans>
```

# 3.spring-mvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!--1. 基包扫描-->
    <context:component-scan base-package="cn.yhs.learn">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!--2. 配置事务解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--3.配置过滤静态资源-->
    <mvc:default-servlet-handler></mvc:default-servlet-handler>
    <mvc:annotation-driven></mvc:annotation-driven>

    <!--4. shiro 注解生效-->
    <bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"
          depends-on="lifecycleBeanPostProcessor">
        <property name="proxyTargetClass" value="true"/>
    </bean>

    <bean class="org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
        <property name="securityManager" ref="securityManager"/>
    </bean>

</beans>
```

# 4.spring-shiro.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 配置Shiro -->
    <!--1 声明凭证（密码）配置器-->
    <bean class="org.apache.shiro.authc.credential.HashedCredentialsMatcher" id="hashedCredentialsMatcher">
        <property name="hashAlgorithmName" value="md5"/><!--md5的方式进行加密-->
        <property name="hashIterations" value="2"/> <!--散列次数为2次-->
    </bean>
    <!--2  配置自定义的Realm-->
    <bean class="cn.yhs.learn.shiro.MyRealm" id="myRealm">
        <property name="credentialsMatcher" ref="hashedCredentialsMatcher"/>
    </bean>
    <!--3 配置WebSecurityManager-->
    <bean class="org.apache.shiro.web.mgt.DefaultWebSecurityManager" id="securityManager">
        <property name="realm" ref="myRealm"/>
    </bean>

    <!--4. 配置shiro的WEB过滤器-->
    <bean class="org.apache.shiro.spring.web.ShiroFilterFactoryBean" id="shiroFilter">
        <!--注入安全管理器-->
        <property name="securityManager" ref="securityManager"/>
        <!--要登录的url-->
        <property name="loginUrl" value="/login.jsp"/>
        <!--配置未授权的url-->
        <property name="unauthorizedUrl" value="/unauthorized.jsp"/>
        <!--配置过滤器链-->
        <property name="filterChainDefinitions">
            <value>
                /index.jsp = anon
                /login.jsp = anon
                <!-- 执行登录请求的操作-->
                /user/login = anon
                <!--用户退出执行的过滤器-->
                /user/logout = logout
                /unauthorized.jsp = anon
                <!--设置其他路劲全部拦截，只有认证通过之后才会资源查看-->
                /** = authc
            </value>
        </property>
    </bean>

</beans>
```

# 5.web.xml

```xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <!--1.web容器创建的时候加载并创建IOC容器-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:applicationContext.xml,classpath*:spring-shiro.xml</param-value>
    </context-param>

    <!--2.配置POST请求过滤连-->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <!--2.1 配置 shiroFilter-->
    <filter>
        <filter-name>shiroFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>shiroFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--3. 配置监听器创建IOC容器对象-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!--3.1 自定义的监听器，用于设置整个项目的全局路径-->
    <listener>
        <listener-class>cn.yhs.learn.web.AppPathContextListener</listener-class>
    </listener>

    <!--4. 配置前端控制器-->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:spring-mvc.xml</param-value>
        </init-param>
        <!--修改它的启动生命周期-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>

```

# 6.shiro自定义的Realm-认证、授权

```java
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
```

# 7.shiro加密方式（算法，加盐，散列）

```java
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

```



