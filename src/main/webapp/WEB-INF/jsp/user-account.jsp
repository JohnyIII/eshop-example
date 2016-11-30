<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pajut
  Date: 11/19/2016
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<h1>${user.name}</h1>

<b>${user.username}</b><br>

<i>${user.email}</i>
<br/>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>
            Order ID
        </th>
        <th>
            State
        </th>
        <th>
            Zip
        </th>
        <th>
            Street
        </th>
        <th>
            Link
        </th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty orders}">
        <c:forEach items="${orders}" var="userOrder">
            <tr>
                <td>
                        ${userOrder.id}
                </td>
                <td>
                        ${userOrder.state}
                </td>
                <td>
                        ${userOrder.zipCode}
                </td>
                <td>
                        ${userOrder.street}
                </td>
                <td>
                <a href='<spring:url value="/order/${userOrder.id}.html" />'>Order detail</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>

    </tbody>
</table>

