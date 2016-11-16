<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Picture</th>
        <th>Descritpion</th>
        <th>Prize</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td width="10%"><c:out value="${item.name}"/></td>
            <td>
                <img src="${item.image_url}" height="150" width="120"/>
            </td>
            <td width="70%">
                ${item.description}
            </td>
            <td>
                ${item.price} Kč
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>