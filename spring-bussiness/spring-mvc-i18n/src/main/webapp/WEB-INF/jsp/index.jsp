<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Spring 国际化</title>
</head>
<body>

    <!-- 首先，项目会自动根据浏览器语言来加载不同的messages内容。 -->
    <!-- 然后，点击中文或者English也可以自由切换语言 -->

    <a href="/?lang=en_US">English(US)</a>
    <a href="/?lang=zh_CN">简体中文</a></br>

    <h3><spring:message code="hello"/> , <spring:message code="world"/></h3>
    <br />

</body>
</html>