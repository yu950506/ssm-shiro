<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
项目信息：${AppPath}
<hr>
用户信息：${user}

<%----%>
<a href="${AppPath}/user/logout">${user.username}用户退出</a>
</body>
</html>
