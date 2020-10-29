<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>年収計算システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
          <div id="header">
            <div id="header_menu">
                <h1><a href="<c:url value='/' />">給料計算</a></h1>&nbsp;&nbsp;&nbsp;
            </div>
            <c:if test="${sessionScope.login_person != null}">
                <div id="person_name">
                    <a href="<c:url value='/persons/show?id=${login_person.id}' />"><c:out value="${sessionScope.login_person.name}" />さん&nbsp;&nbsp;&nbsp;</a><%-- <c:out value="${sessionScope.login_person.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp; --%>
                    <a href="<c:url value='/logout' />">ログアウト</a>
                </div>
            </c:if>

            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">

            </div>
        </div>
    </body>
</html>