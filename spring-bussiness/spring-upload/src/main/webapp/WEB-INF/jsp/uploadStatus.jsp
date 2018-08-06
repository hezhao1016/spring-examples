<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Upload Status</title>
</head>
<body>

    <h1>Spring - Upload Status</h1>

    <c:if test="${not empty message}">
        <h2>${message}</h2>
    </c:if>

</body>
</html>