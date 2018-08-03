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
    <title>城市列表</title>
</head>

<body>

<div class="contentDiv">

    <h5>Spring MVC</h5>

    <table class="table table-hover table-condensed">
        <legend>
            <strong>城市列表</strong>
        </legend>
        <thead>
        <tr>
            <th>城市编号</th>
            <th>省份编号</th>
            <th>城市名称</th>
            <th>描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cityList}" var="city">
            <tr>
                <th>${city.id}</th>
                <td>${city.provinceId}</td>
                <td>${city.cityName}</td>
                <td>${city.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>