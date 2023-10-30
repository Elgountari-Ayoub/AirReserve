<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container mt-4">
    <h2>Flight Details</h2>
    <hr>

    <c:if test="${empty flight}">
        <p class="alert alert-danger">Flight not found.</p>
    </c:if>

    <c:if test="${not empty flight}">
        <div class="row">
            <div class="col-md-6">
                <p><strong>Flight ID:</strong> ${flight.id}</p>
                <p><strong>Departure City:</strong> ${flight.departureCity}</p>
                <p><strong>Destination:</strong> ${flight.destination}</p>
                <p><strong>Departure Date:</strong> ${flight.departureDate}</p>
                <p><strong>Arrival Date:</strong> ${flight.arrivalDate}</p>
            </div>
            <div class="col-md-6">
                <p><strong>Ticket Price:</strong> ${flight.ticketPrice}</p>
                <p><strong>Seat Count:</strong> ${flight.seatCount}</p>
                <!-- You can add more flight details here -->
            </div>
        </div>
    </c:if>

    <a href="flight?action=all" class="btn btn-primary">Back to Flight List</a>
</div>
<jsp:include page="../../includes/footer.jsp"/>

