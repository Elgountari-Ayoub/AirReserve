<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>Companies</h1>
    <a href="company/create" class="btn-primary p-2 m-2 rounded bg-image hover-overlay ripple shadow-1-strongdata-mdb-ripple-color=light">Create a company</a>
<%--    <form class="form-inline" method="get" action="company/find?name=${name}">--%>
<%--        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">--%>
<%--        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--    </form>--%>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>update</th>
            <th>delete</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${companiesList}" var="company">
            <tr>
                <td>${company.id}</td>
                <td>${company.name}</td>
                <td>
                    <a href="flight?action=update&flightId=${flight.id}" class="btn btn-primary">Update</a>
                    <a href="flight?action=delete&flightId=${flight.id}" class="btn btn-danger">Delete</a>
                    <a href="flight.reserve&flightId=${flight.id}" class="btn btn-success">Reserve</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../../includes/footer.jsp"/>

