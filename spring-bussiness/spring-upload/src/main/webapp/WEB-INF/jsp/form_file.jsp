<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Form File</title>
</head>
<body>

    <form id='myupload' action='http://localhost:8080/uploadSign' method='post' enctype='multipart/form-data'>
        <div class="demo">
            <div class="btn">
                <span>添加附件</span>
                <input id="fileupload" type="file" name="file1"></div>
            <div class="progress">
                <span class="bar"></span>
                <span class="percent">0%</span></div>
            <!-- 显示已上传的文件名 -->
            <div class="files"></div>
            <!-- 显示已上传的图片-->
            <div class="showimg"></div>
        </div>
        <input type="submit" onclick="gosubmit2()" />
    </form>

    <script src="https://cdn.bootcss.com/jquery/1.6.4/jquery.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery.form/4.1.0/jquery.form.min.js"></script>
    <script type="text/javascript">
        var bar = $('.bar'); //进度条
        var percent = $('.percent'); //获取上传百分比
        var showimg = $('.showimg'); //显示图片的div
        var progress = $('.progress'); //显示进度的div
        var files = $('.files'); //文件上传控件的input元素
        var btn = $('.btn span'); //按钮文本
        function gosubmit2() {
            $("#myupload").ajaxSubmit({
                dataType: 'json',
                //返回数据类型
                beforeSend: function() {
                    showimg.empty();
                    progress.show();
                    var percentVal = '0%';
                    bar.width(percentVal);
                    percent.html(percentVal);
                    btn.html('上传中..');
                },
                //更新进度条事件处理代码
                uploadProgress: function(event, position, total, percentComplete) {
                    var percentVal = percentComplete + '%';
                    bar.width(percentVal);
                    percent.html(percentVal);
                },
                success: function(data) { //图片上传成功时
                    //获取服务器端返回的文件数据
                    alert(data.name + "," + data.pic + "," + data.size);
                },
                error: function(xhr) {
                    btn.html(上传失败);
                    bar.width('0');
                    files.html(xhr.responseText);
                }
            });
        }
    </script>

</body>
</html>
