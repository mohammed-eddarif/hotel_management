<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Reservation System</title>
    <link rel="stylesheet" href="<c:url value = "${pageContext.request.contextPath}../../css/bootstrapmin.css" />">
    <link rel="stylesheet" href="<c:url value = "${pageContext.request.contextPath}../../css/reservation.css"/>">
    <script src="<c:url value = "${pageContext.request.contextPath}../../js/bootstrapmin.js"/>"></script>
</head>
<body>
<%
    String room_id = request.getAttribute("room_id").toString();
    String checkInDate = request.getAttribute("checkInDate").toString();
    String checkOutDate = request.getAttribute("checkOutDate").toString();
    float price_per_day = Float.parseFloat(request.getAttribute("price_per_day").toString());

    // calculate number of day
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = sdf.parse(checkInDate);
    Date d2 = sdf.parse(checkOutDate);
    int numberOfDays = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));

    double totalPrice = numberOfDays * price_per_day;
%>

<div class="header lead">
    <h1>Final Reservation</h1>
    <p>Please, fill the form for complete the reservation process.</p>
</div>

<div class="container">
    <div class="alert alert-info">
        <strong>Room N°: </strong>${room_id}
    </div>
    <div class="alert alert-info">
        <Strong>From: </Strong><span id='checkInDate'>${checkInDate}</span><br>
        <Strong>To: </Strong><span id='checkOutDate'>${checkOutDate}</span><br>
        <Strong>Number of days: </Strong><span id='dayNumbers'>10</span><br>
        <strong>Price for one night: </strong><span id='price_per_day'>${price_per_day} DHs</span><br>
        <strong>Total price: </strong> <span id='totalPrice'>${totalPrice}DHs</span>
    </div>
    <form action="UserReservationRoomServlet" method="POST">
        <input type="hidden" name="room_id" value="${room_id}">
        <input type="hidden" name="checkInDate" value="${checkInDate}">
        <input type="hidden" name="checkOutDate" value="${checkOutDate}">
        <div class="form-group">
            <label for="fullName">Full name</label>
            <input type="text" class="form-control" name="fullName" id="fullName" placeholder="Type full name">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp"
                   placeholder="Type your email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="phone" class="form-control" name="phone" id="phone" placeholder="Type phone number">
        </div>
        <div>
            <button type="submit" class="btn btn-success">Submit</button>
            <a href="<%= request.getContextPath() %>">
                <button class="btn btn-secondary" style="display: block; float: right; margin-bottom: 15px">Back to
                    Home
                </button>
            </a>
        </div>
    </form>
</div>

<script>
    // calculate total days
    var checkInDate = "${checkInDate}",
        checkOutDate = "${checkOutDate}",
        result = document.getElementById("dayNumbers");

    var checkInDateArray = checkInDate.split("-"),
        checkInDateDays = Number.parseInt(checkInDateArray[0]) * 365 + Number.parseInt(checkInDateArray[1]) * 31 + Number.parseInt(checkInDateArray[2]),
        dateOutDate = checkOutDate.split("-"),
        checkOutDateDays = Number.parseInt(checkOutDateArray[0]) * 365 + Number.parseInt(checkOutDateArray[1]) * 31 + Number.parseInt(checkOutDateArray[2]),
        diffDays = checkOutDateDays - checkInDateDays;

    result.innerText = diffDays;

    // calculate total price_per_day
    var price_per_day = ${price_per_day},
        totalPrice = document.getElementById("totalPrice");
    price_per_day = parseFloat(price_per_day);

    totalPrice.innerText = price_per_day * diffDays;
</script>
</body>
</html>
