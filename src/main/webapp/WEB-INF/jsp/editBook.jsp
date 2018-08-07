<%--
  Created by IntelliJ IDEA.
  User: bian17888
  Date: 2018/8/5
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/libs/bootstrap.min.css">
    <script src="/resources/libs/jquery-3.3.1.slim.min.js"></script>
    <script src="/resources/libs/popper.min.js"></script>
    <script src="/resources/libs/bootstrap.min.js"></script>
</head>
<body>

<section>
    <form:form modelAttribute="book">
        <form:errors path="*" cssClass="errorblock" element="div" />
        <div class="form-group">
            <label for="book_name">书名</label>
            <form:input path="name" id="book_name" class="form-control" />
        </div>
        <div class="form-group">
            <label for="book_score">评分</label>
            <form:input path="score" id="book_score" class="form-control" />
        </div>
        <div class="form-group">
            <label for="book_link">链接</label>
            <form:input path="link" id="book_link" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form:form>
</section>

</body>
</html>
