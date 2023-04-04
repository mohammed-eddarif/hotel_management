
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Reservation System</title>
    <link rel="stylesheet" href="<c:url value = "${pageContext.request.contextPath}../../css/bootstrapmin.css" />" >
    <link rel="stylesheet" href="<c:url value = "${pageContext.request.contextPath}../../css/home.css" />">
    <script src="<c:url value = "${pageContext.request.contextPath}../../js/bootstrapmin.js" /> "></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#" style="
  background: -webkit-linear-gradient(#03C8A8, #89D8D3);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;">ABBASSID Hotel</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact US</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" onsubmit="return false;">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-check btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="bg-img">
    <div class="header-container">
        <h1>Welcome!</h1>
        <p>You can reserve rooms online via this website.</p>
    </div>

    <form class="form-inline check-date-form-container" onsubmit="return checkForms();" method="POST"
          action="UserHomeServlet">
        <div class="form-group mx-sm-3 mb-2">
            <label class="check-lbl">Select</label>
            <select class="form-select p-2 rounded" aria-label="Default select example" name="reservation_type">
                <option selected>Choose here</option>
                <option value="room">room</option>
                <option value="salle">salle</option>
                <option value="table">table</option>
                <option value="pool">pool</option>
                <option value="night_club">night-club</option>
            </select>
        </div>

        <div class="form-group mx-sm-3 mb-2">
            <label class="check-lbl">Check-in date</label>
            <input type="date" id="checkInDate" name="checkInDate" class="form-control" placeholder="Check-in date">
        </div>

        <div class="form-group mx-sm-3 mb-2">
            <label class="check-lbl">Check-out date</label>
            <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" placeholder="Check-out date">
        </div>
        <button type="submit" class="btn btn-success mb-2">Check</button>
    </form>
</div>

<script type="text/javascript">
    function checkForms() {
        let checkInDate = document.getElementById('checkInDate').value,
            checkOutDate = document.getElementById('checkOutDate').value;

        let q = new Date();
        let checkIDate = new Date(checkInDate);
        let checkODate = new Date(checkOutDate);

        let nowDays = (q.getFullYear() * 365) + ((q.getMonth() + 1) * 31) + q.getDay();
        let checkInDays = (checkIDate.getFullYear() * 365) + ((checkIDate.getMonth() + 1) * 31) + checkIDate.getDay();
        let checkOutDays = (checkODate.getFullYear() * 365) + ((checkODate.getMonth() + 1) * 31) + checkODate.getDay();

        if (!Date.parse(checkInDate)) {
            window.alert("Please type the check in date");
            return false;
        }
        if (!Date.parse(checkOutDate)) {
            window.alert("Please type the check out date");
            return false;
        }

        if (nowDays > checkInDays) {
            alert("Check in date should be grower than today");
            return false;
        }
        if (checkInDays > checkOutDays) {
            alert("Check out date should be grower than check in date");
            return false;
        }

        return true;
    }
</script>
</body>
</html>