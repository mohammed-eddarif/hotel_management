<%@ page import="com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.places.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hotel.management.hotel_management.dao.places.salles.SalleDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.places.Salle" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/16/2023
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/home.css">

    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body>
<%
    RoomDaoImpl roomDao = new RoomDaoImpl();
    List<Room> rooms = roomDao.findAll();
    request.setAttribute("rooms", rooms);

    SalleDaoImpl salleDao = new SalleDaoImpl();
    List<Salle> salleList = salleDao.findAll();
    request.setAttribute("salleList", salleList);

%>

<%--<%--%>
<%--    RoomDaoImpl roomDao = new RoomDaoImpl();--%>
<%--    List<Room> rooms = roomDao.findAll();--%>
<%--%>--%>

<nav class="px-6 py-6 flex justify-between items-center border-b border-gray-200">
    <a href="#" class="text-3xl font-bold text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">ABBASSI
        HOTEL</a>

    <div class="space-x-6">
        <a href="${pageContext.request.contextPath}/views/receptionist/receptionist_home.jsp" class="text-xl font-semibold hover:text-gray-500">Home</a>

        <a href="${pageContext.request.contextPath}/views/receptionist/room/receptionist_manage_room.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Rooms</a>
        <a href="${pageContext.request.contextPath}/views/receptionist/salle/receptionist_manage_salle.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Salle</a>
        <a href="${pageContext.request.contextPath}/views/receptionist/user/receptionist_manage_user.jsp" class="text-lg font-semibold hover:text-gray-500">Manage users</a>
        <a href="${pageContext.request.contextPath}/login.jsp"
           class="px-6 py-3 text-lg font-semibold bg-red-500 text-white rounded-xl hover:bg-red-700">Log out</a>

    </div>
</nav>
<div class="bg-img">
    <div class="mt-6 px-6 py-12 bg-gray-100 rounded-xl opacity-95">
        <h2 class="mb-12 text-2xl text-center">Newest Rooms</h2>
        <div class="grid grid-cols-3 gap-3">
            <c:forEach items="${rooms}" var="room">
                <div>
                    <a href="<%=request.getContextPath()%>/ReceptionistManageRoomsToDetailRoomServlet?id=${room.room_id}">
                        <div class="p-6 bg-white rounded-t-xl">
                            <h2 class="text-2xl">Room #${room.room_id}</h2>
                            <p class="text-gray-500">Room for ${room.nbr_places} adult</p>
                            <p class="text-gray-500">Room in ${room.floor} floor</p>
                            <p class="text-gray-500">Price: ${room.price_per_day} DHs</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="mt-6 px-6 py-12 bg-gray-100 rounded-xl opacity-95">
        <h2 class="mb-12 text-2xl text-center">Newest Salles</h2>
        <div class="grid grid-cols-3 gap-3">
            <c:forEach items="${salleList}" var="salle">
                <div>
                    <a href="<%=request.getContextPath()%>/ReceptionistManageSalleToDetailsSalleServlet?id=${salle.id_salle}">
                        <div class="p-6 bg-white rounded-t-xl">
                            <h2 class="text-2xl">Salle #${salle.id_salle}</h2>
                            <p class="text-gray-500">Salle for ${salle.nbr_places} adult</p>
                            <p class="text-gray-500">Salle in ${salle.floor} floor</p>
                            <p class="text-gray-500">Price: ${salle.price_per_day} DHs</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
