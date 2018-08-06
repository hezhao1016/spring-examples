<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
    <title>Spring 自定义异常页面</title>
</head>
<body>
    <div>
        <div id="navbar">
            <h1>系统异常统一处理</h1>
            <h3>错误信息：${msg}</h3>
            <h3>请求地址：${url}</h3>

            <h2>Debug</h2>
            <a href="https://www.google.com/webhp?hl=zh-CN#safe=strict&hl=zh-CN&q=${msg}"
               class="btn btn-primary btn-lg" target="_blank" id="Google">Google</a>
            <a href="https://www.baidu.com/s?wd=${msg}" class="btn btn-info btn-lg"  target="_blank" id="Baidu">Baidu</a>
            <a href="http://stackoverflow.com/search?q=${msg}"
               class="btn btn-default btn-lg"  target="_blank" id="StackOverFlow">StackOverFlow</a>
            <h2>异常堆栈跟踪日志StackTrace</h2>
            <c:forEach items="${stackTrace}" var="line">
                <div>${line}</div>
            </c:forEach>
        </div>
    </div>
</body>
</html>