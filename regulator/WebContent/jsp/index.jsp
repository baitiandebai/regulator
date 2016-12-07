<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面</title>
<base href="http://localhost:8180/regulator">
</head>
<body>
	<h1>这是一个测试页面啊</h1>
	<form action="http://localhost:8180/regulator/exposure/upload/excel" 
			method = "post" enctype="multipart/form-data">
		上传文件:<input type="file" name="file"/>
		<input type="submit" value="提交">
	</form>
</body>
</html>