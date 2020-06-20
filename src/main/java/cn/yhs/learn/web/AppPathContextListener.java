package cn.yhs.learn.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.web.AppPathContextListener
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 18:55
 * @Description: 自定义ContextListener, 定义AppPath
 **/
@Slf4j
public class AppPathContextListener implements ServletContextListener {
    /**
     * 容器启动的时候被调用,在全局域对象中声明属性 AppPath,整个项目的路劲
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        // 得到项目的路劲
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("AppPath", contextPath);
        log.info("容器启动并创建了一个全局的属性：AppPath => {}", contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
