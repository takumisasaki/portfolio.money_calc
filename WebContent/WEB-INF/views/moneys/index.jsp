<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <body>
        <div id="table">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

        <h2>給料表</h2>

        <form method="get" action="<c:url value='/moneys/index' />">
                     <select name="year">
                     <c:forEach var="year" items="${moneys}"><option value="${year}" ><c:out value="${year}" /></option></c:forEach>
                    </select>年度の給料表を<input type="submit" name="submit" value="表示" />
                 </form>
                 <br /><br />
        <table id="money_list">
            <thead>
                <tr>
                    <th class="money_company">バイト先</th>
                    <th class="money_month">1月</th>
                    <th class="money_month">2月</th>
                    <th class="money_month">3月</th>
                    <th class="money_month">4月</th>
                    <th class="money_month">5月</th>
                    <th class="money_month">6月</th>
                    <th class="money_month">7月</th>
                    <th class="money_month">8月</th>
                    <th class="money_month">9月</th>
                    <th class="money_month">10月</th>
                    <th class="money_month">11月</th>
                    <th class="money_month">12月</th>
                    <th class="money_month">年間合計</th>

                </tr>
            </thead>
            <tbody>


               <p><c:out value="${login_person.name}" />さんの<c:out value="${year}" />年度の給料表</p>
                <c:forEach var="money" items="${m}" varStatus="status">
                    <c:choose>
                        <c:when test="${money.delete_flag == 0}" >
                    <tr class="row${status.count % 2}">
                        <c:if test="${sessionScope.login_person.id == money.person.id}" >
                        <td class="money_company"><a href="<c:url value='/moneys/edit?id=${money.id}' />"><c:out value="${money.company_name}" /></a></td>
                        </c:if>
                        <td class="money_month"><c:out value="${money.january}" /></td>
                        <td class="money_month"><c:out value="${money.february}" /></td>
                        <td class="money_month"><c:out value="${money.march}" /></td>
                        <td class="money_month"><c:out value="${money.april}" /></td>
                        <td class="money_month"><c:out value="${money.may}" /></td>
                        <td class="money_month"><c:out value="${money.june}" /></td>
                        <td class="money_month"><c:out value="${money.july}" /></td>
                        <td class="money_month"><c:out value="${money.august}" /></td>
                        <td class="money_month"><c:out value="${money.september}" /></td>
                        <td class="money_month"><c:out value="${money.october}" /></td>
                        <td class="money_month"><c:out value="${money.november}" /></td>
                        <td class="money_month"><c:out value="${money.december}" /></td>
                        <td class="money_month"><c:out value="${money.january + money.february + money.march + money.april +
                        money.may + money.june + money.july + money.august + money.september + money.october +  money.november + money.december}" /></td>
                    </tr>

                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                        <tr>
                            <th>月合計</th>
                            <td><c:out value="${m1}" /></td>
                            <td><c:out value="${m2}" /></td>
                            <td><c:out value="${m3}" /></td>
                            <td><c:out value="${m4}" /></td>
                            <td><c:out value="${m5}" /></td>
                            <td><c:out value="${m6}" /></td>
                            <td><c:out value="${m7}" /></td>
                            <td><c:out value="${m8}" /></td>
                            <td><c:out value="${m9}" /></td>
                            <td><c:out value="${m10}" /></td>
                            <td><c:out value="${m11}" /></td>
                            <td><c:out value="${m12}" /></td>
                            <td><c:out value="${m1 + m2 + m3 + m4 + m5 + m6
                            + m7 + m8 + m9 + m10 + m11 + m12}" /></td>
                        </tr>


            </tbody>
        </table>

        <p><a href="<c:url value='/moneys/new' />">バイト先の追加</a><a href="<c:url value='/index.html' />">　　トップページへ戻る</a></p>
        </div>
    </body>
    </c:param>
</c:import>