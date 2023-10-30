<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>Flights</h1>
    <a href="airPlane/create"
       class="btn-primary p-2 m-2 rounded bg-image hover-overlay ripple shadow-1-strongdata-mdb-ripple-color=" light">Create
    a flight</a>
    <form class="form-inline" method="get" action="airPlane/read">
        <input class="form-control mr-sm-2" type="search" name="flightId" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Departure City</th>
            <th>Destination</th>
            <th>Departure Date</th>
            <th>Arrival Date</th>
            <th>Ticket Price</th>
            <th>Seat Count</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${flightList}" var="flight">
            <tr>
                <td>
                    <a href="airPlane/read&flightId=${flight.id}">${flight.id}</a>
                </td>
                <td>${flight.departureCity}</td>
                <td>${flight.destination}</td>
                <td>${flight.departureDate}</td>
                <td>${flight.arrivalDate}</td>
                <td>${flight.ticketPrice}</td>
                <td>${flight.seatCount}</td>
                <td>
                    <a href="airPlan/update&flightId=${flight.id}" class="btn btn-primary">Update</a>
                    <a href="airPlan/delete&flightId=${flight.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="js/js/bootstrap.min.js"></script>
</body>
</html>
