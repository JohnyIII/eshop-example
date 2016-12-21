<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

    
    Order Detail

    <h1>${order.state}</h1>

   <h1> ${order.zipCode}</h1>

<h1> ${order.street}</h1>

<h1>${order.state}</h1>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <td>quantity</td>
        <td>Link</td>
        <td>image</td>
        <td>Description</td>
        <td>price</td>
    </tr>
    </thead>
<c:forEach items="${items}" var="item">
    <tr>
        <td width="5%">${item.quantity}</td>

        <td width="10%"><a href="<spring:url value="/items/${item.item.id}.html"/> "><c:out value="${item.item.name}"/></a></td>
        <td>
            <img src="/eshop/${item.item.image_url}" height="150" width="120"/>
        </td>
        <td width="65%">
                ${item.item.description}
        </td>
        <td width="7%">
                ${item.item.price} Kč
        </td>
    </tr>
</c:forEach>
</table>
    
    