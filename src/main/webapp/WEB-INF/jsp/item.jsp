<%--
  Created by IntelliJ IDEA.
  User: Pajut
  Date: 11/19/2016
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>${item.name}</h1> <img src="../${item.image_url}"/>

<p>${item.description}</p>

<p>
    <b>cena za kus : ${item.price}</b>
</p>

<form action="baslet/add.html" class="form-horizontal">
    <div class="form-group">
        <input type="hidden" name="id" value="${item.id}">
        <label class="control-label col-lg-1">Mnozstvi:</label>
        <div class="col-lg-1">
            <input type="text" class="form-control" id="quantity" name="quantity" value="1" />
        </div>
        <input type="submit" class="btn btn-md btn-primary" value="Order" />
    </div>

</form>