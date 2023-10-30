<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container mt-4">
    <h2>Update Flight</h2>
    <hr>
    <form action="flight?action=create" method="post">
        <input type="hidden" name="flightId">

        <div class="form-group">
            <label for="airPlanes">AirPlanes</label>
            <select name="airPlane" id="airPlanes" class="form-control">
                <c:forEach items="${airPlanes}" var="airPlane">
                    <option value="${airPlane.matricule}">${airPlane.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="departureCity">Departure City</label>
            <input type="text" class="form-control" id="departureCity" name="departureCity">
        </div>
        <div class="form-group">
            <label for="destination">Destination</label>
            <input type="text" class="form-control" id="destination" name="destination">
        </div>
        <div class="form-group">
            <label for="departureDate">Departure Date</label>
            <input type="datetime-local" class="form-control" id="departureDate" name="departureDate">
        </div>
        <div class="form-group">
            <label for="arrivalDate">Arrival Date</label>
            <input type="datetime-local" class="form-control" id="arrivalDate" name="arrivalDate">
        </div>
        <div class="form-group">
            <label for="ticketPrice">Ticket Price</label>
            <input type="text" class="form-control" id="ticketPrice" name="ticketPrice">
        </div>
        <div class="form-group">
            <label for="seatCount">Seat Count</label>
            <input type="number" min="1" max="30" class="form-control" id="seatCount" name="seatCount">
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>

    <a href="flight?action=all" class="btn btn-secondary mt-3">Back to Flight List</a>
</div>
<jsp:include page="../../includes/footer.jsp"/>
