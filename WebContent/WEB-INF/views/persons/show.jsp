<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp" >
    <c:param name="content">
        <c:choose>
            <c:when test="${person != null}" >
                <h2>id : ${person.id} の詳細ページ</h2>

                <table class="person_show">
                    <tbody>
                        <tr>
                        <th>パーソン番号</th>
                        <td><c:out value="${person.number}" /></td>
                        </tr>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${person.name}" /></td>
                        </tr>

                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${person.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${person.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <p><a href="<c:url value='/persons/edit?id=${person.id}' />">編集</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/index.html' />">トップページへ</a></p>
    </c:param>
</c:import>