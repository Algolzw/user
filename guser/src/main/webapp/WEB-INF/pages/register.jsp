<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
<form action="${path}/register" method="post">
    <fieldset>
        <legend>用户注册</legend>
        <div>
            <input type="text" name="username" placeholder="请输入用户名" autofocus>
        </div>
        <div>
            <input type="email" name="email" placeholder="请输入邮箱地址">
        </div>
        <div>
            <input type="password" name="password" placeholder="请输入密码">
        </div>

        <div>
            <input type="submit" id="register_btn" value="submit">
        </div>
    </fieldset>
    <script src="http://code.jquery.com/jquery-3.0.0.min.js"></script>
    <script>
        $(function(){
            $("#register_btn").bind('click',function(){
                var name = $("input[name='username']").val();
                alert(name);
            });
        });
    </script>
</body>
</html>
