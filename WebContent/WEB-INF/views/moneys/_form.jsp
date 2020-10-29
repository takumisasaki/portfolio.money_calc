<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>
    </div>
</c:if>
<label for="name">氏名</label><br />
<c:out value="${sessionScope.login_person.name}" />
<br /><br />

<label for="company_name">バイト先名</label><br />
<input type="text" name="company_name" value="${money.company_name}" />
<br /><br />

<label for="year">年</label><br />
<input type="number" name="year" value="${money.year}" />
<br /><br />

<label for="january">1月</label><br />
<input type="number" name="january" value="${money.january}" />円
<br /><br />

<label for="febtuary">2月</label><br />
<input type="number" name="february" value="${money.february}" />円
<br /><br />

<label for="march">3月</label><br />
<input type="number" name="march" value="${money.march}" />円
<br /><br />

<label for="april">4月</label><br />
<input type="number" name="april" value="${money.april}" />円
<br /><br />

<label for="may">5月</label><br />
<input type="number" name="may" value="${money.may}" />円
<br /><br />

<label for="june">6月</label><br />
<input type="number" name="june" value="${money.june}" />円
<br /><br />

<label for="july">7月</label><br />
<input type="number" name="july" value="${money.july}" />円
<br /><br />

<label for="august">8月</label><br />
<input type="number" name="august" value="${money.august}" />円
<br /><br />

<label for="september">9月</label><br />
<input type="number" name="september" value="${money.september}" />円
<br /><br />

<label for="october">10月</label><br />
<input type="number" name="october" value="${money.october}" />円
<br /><br />

<label for="november">11月</label><br />
<input type="number" name="november" value="${money.november}" />円
<br /><br />

<label for="december">12月</label><br />
<input type="number" name="december" value="${money.december}" />円
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>



