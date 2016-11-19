<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<table class="table table-striped table-bordered table-hover" >
    <thead>
    <tr>
        <th>remove</th>
        <th>item name</th>
        <th>quantity</th>
        <th>unit price</th>
        <th>ordered price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${basket.items}" var="orderedItem">
        <tr>
            <td>
                <form action="<spring:url value="/basket/remove.html"/>">
                    <input type="hidden" name="id" value="${orderedItem.item.id}"/>
                    <input type="image" src="<resources/icons/delete.png" title="remove"
                           onclick="return confirm('Really want to remove');">
                </form>
            </td>
            <td>
                    ${orderedItem.item.name}
            </td>
            <td>
                    ${orderedItem.quantity}
            </td>
            <td>
                    ${orderedItem.item.price} Kč
            </td>
            <td>
                    ${orderedItem.item.price * orderedItem.quantity} Kč
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>

<table class="table table-striped table-bordered ">
    <tr><td width="81 %"> </td>

        <td width="19%">Total price : ${total} Kč</td>
    </tr>
</table>