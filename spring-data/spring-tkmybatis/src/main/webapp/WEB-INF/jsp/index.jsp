<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/static/css/default.css" rel="stylesheet"/>
    <link rel="icon" href="${ctx}/static/images/favicon.ico" type="image/x-icon"/>
    <meta charset="UTF-8"/>
    <title>用户列表</title>
</head>

<body>

<div class="contentDiv">

    <h5>Spring MVC</h5>

    <table class="table table-hover table-condensed">
        <legend>
            <strong>用户列表</strong>
        </legend>
        <thead>
        <tr>
            <th>用户编号</th>
            <th>名称</th>
            <th>用户名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <th>${user.id}</th>
                <td>${user.name}</td>
                <td>${user.userName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>