<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container mt-4">
    <h2>Update Flight</h2>
    <hr>

    <c:if test="${empty flightToUpdate}">
        <p class="alert alert-danger">Flight not found.</p>
    </c:if>

    <c:if test="${not empty flightToUpdate}">
        <form action="flight?action=update" method="post">
            <input type="hidden" name="flightId" value="${flightToUpdate.id}">
            <div class="form-group">
                <label for="departureCity">Departure City</label>
                <input type="text" class="form-control" id="departureCity" name="departureCity" value="${flightToUpdate.departureCity}">
            </div>
            <div class="form-group">
                <label for="destination">Destination</label>
                <input type="text" class="form-control" id="destination" name="destination" value="${flightToUpdate.destination}">
            </div>
            <div class="form-group">
                <label for="departureDate">Departure Date</label>
                <input type="datetime-local" class="form-control" id="departureDate" name="departureDate" value="${flightToUpdate.departureDate}">
            </div>
            <div class="form-group">
                <label for="arrivalDate">Arrival Date</label>
                <input type="datetime-local" class="form-control" id="arrivalDate" name="arrivalDate" value="${flightToUpdate.arrivalDate}">
            </div>
            <div class="form-group">
                <label for="ticketPrice">Ticket Price</label>
                <input type="text" class="form-control" id="ticketPrice" name="ticketPrice" value="${flightToUpdate.ticketPrice}">
            </div>
            <div class="form-group">
                <label for="seatCount">Seat Count</label>
                <input type="number" min="1" max="30" class="form-control" id="seatCount" name="seatCount" value="${flightToUpdate.seatCount}">
            </div>
            <!-- You can add more flight details input fields here -->
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </c:if>

    <a href="flight?action=all" class="btn btn-secondary mt-3">Back to Flight List</a>
</div>
<script src="js/js/bootstrap.min.js"></script>
</body>
</html>
