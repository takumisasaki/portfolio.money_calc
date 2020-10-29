<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div id="table">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>

        <p>こんにちは<c:out value="${login_person.name}" />さん</p>

                  <form method="get" action="<c:url value='/moneys/index' />">
                     <select name="year">
                     <c:forEach var="year" items="${moneys}"><option value="${year}" ><c:out value="${year}" /></option></c:forEach>
                    </select>年度の給料表を
                   <input type="submit" name="submit" value="表示" />
                 </form>
                 <br /><br />

              <%--
                <c:forEach var="money" items="${moneys}" varStatus="status">
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
        </table> --%>

        <p><a href="<c:url value='/moneys/new' />">バイト先の追加</a></p>
        </div>
    </c:param>
</c:import>