<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <td width="35" align="center">
                <form action="<spring:url value="/basket/remove.html"/>">
                    <input type="hidden" name="id" value="${orderedItem.item.id}"/>
                    <input type="image" src="resources/icons/delete.png" title="remove" width="30" height="30"
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

<form:form commandName="order" cssClass="form-horizontal registrationForm" >
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label"> Mesto:</label>
        <div class="col-sm-10">
            <form:input path="city" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="zipCode" class="col-sm-2 control-label"> Psc:</label>
        <div class="col-sm-10">
            <form:input path="zipCode" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="street" class="col-sm-2 control-label"> Ulice:</label>
        <div class="col-sm-10">
            <form:input path="street" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="state" class="col-sm-2 control-label"> Stat:</label>
        <div class="col-sm-10">
            <form:input path="state" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-2">
            <input type="submit" value="Save" class="btn btn-lg btn-primary">
        </div>
    </div>

    ${aa}
</form:form>