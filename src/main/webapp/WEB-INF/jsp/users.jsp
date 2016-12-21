<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>All Users</h1>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <td>
            Username
        </td>
        <td>User email</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>

    </c:forEach>
    </tbody>

</table>