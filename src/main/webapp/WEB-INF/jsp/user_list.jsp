<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>用户管理主页</title>
</head>
<body>
// 用户信息：${user}

<s:hasPermission name="user:add">
    <a href="/user/add">用户添加</a>
</s:hasPermission>

<s:hasPermission name="user:delete">
    <a href="/user/delete">用户删除</a>
</s:hasPermission>

<s:hasPermission name="user:update">
    <a href="/user/update">用户更新</a>
</s:hasPermission>

<s:hasPermission name="user:find">
    <a href="/user/find">用户查找</a>
</s:hasPermission>


</body>
</html>
