<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Picture</th>
        <th>Descritpion</th>
        <th>Prize</th>
        <th>Stock</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td width="10%"><a href="<spring:url value="/items/${item.id}.html"/> "><c:out value="${item.name}"/></a></td>
            <td>
                <img src="${item.image_url}" height="150" width="120"/>
            </td>
            <td width="70%">
                    ${item.description}
            </td>
            <td width="7%">
                    ${item.price} Kč
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.quantity>'0'}">
                        ${item.quantity} left
                    </c:when>
                    <c:otherwise>
                        None left.
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>