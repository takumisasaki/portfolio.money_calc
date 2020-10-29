<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${money != null}">
                <h2>給料 編集ページ</h2>
                <form method="POST" action="<c:url value='/moneys/update' />">
                    <c:import url="_form.jsp" />
                </form>
        <p><a href="<c:url value='/index.html' />">一覧に戻る</a></p>
        <p><a href="#" onclick="confirmDestroy();">この給料情報を消去する</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/moneys/destroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
            function confirmDestroy() {
                if(confirm("こちらの給料情報を消去しますか？")) {
                    document.forms[1].submit();
                }
            }

        </script>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>