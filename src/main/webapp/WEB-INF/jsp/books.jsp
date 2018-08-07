<%--
  Created by IntelliJ IDEA.
  User: bian17888
  Date: 2018/8/5
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>QuickStart - MVC</title>
    <link rel="stylesheet" href="/resources/libs/bootstrap.min.css">
    <script src="/resources/libs/jquery-3.3.1.slim.min.js"></script>
    <script src="/resources/libs/popper.min.js"></script>
    <script src="/resources/libs/bootstrap.min.js"></script>
</head>
<body>
<section>
    Language : <a href="?language=en">English</a> | <a href="?language=zh">中文</a>
    <h2><spring:message code="home.bookTitle" /></h2>
    <table class="table table-bordered" width="100%" cellpadding="0" cellspacing="0">
        <thead class="thead-light">
        <tr>
            <th>书名</th>
            <th>评分</th>
            <th>链接</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbod>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.score}</td>
                    <td><a href="${book.link}" target="_blank">${book.link}</a></td>
                    <td>
                        <a href="/books/edit?id=${book.id}" class="btn btn-link"><spring:message code="home.btnEdit" /></a>
                        <form:form modelAttribute="book" action="/books/delete/${book.id}">
                            <button type="submit" class="btn btn-danger"><spring:message code="home.btnDelete" /></button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </tbod>
    </table>
</section>

<section>
    <p><a class="btn btn-primary" href="/books/edit" title="add">新增</a></p>
</section>
</body>
</html>
