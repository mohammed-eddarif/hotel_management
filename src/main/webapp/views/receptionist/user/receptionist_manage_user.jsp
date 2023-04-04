<%@ page import="com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.places.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hotel.management.hotel_management.dao.users.UserDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.users.User" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/28/2023
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/home.css">

    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body>

<%
    UserDaoImpl userDao = new UserDaoImpl();
    List<User> users = userDao.findAll();

    request.setAttribute("users", users);
%>

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


<div class="mt-6 px-6 py-12 bg-gray-100 rounded-xl opacity-95">
    <a href="${pageContext.request.contextPath}/views/receptionist/user/receptionist_add_user.jsp">
        <button class="px-6 py-3 text-lg font-semibold bg-teal-500 text-white rounded-xl hover:bg-teal-700">
            Add User
        </button>
    </a>
    <h2 class="mb-12 text-2xl text-center">All Users</h2>
    <div class="grid grid-cols-3 gap-3">
        <c:forEach items="${users}" var="user">
            <div>
                <a href="<%=request.getContextPath()%>/ReceptionistManageUserToDetailUserServlet?id=${user.id}">
                    <div class="p-6 bg-white rounded-t-xl">
                        <h2 class="text-2xl">User ID :${user.id}</h2>
                        <p class="text-gray-500">Name : ${user.name}</p>
                        <p class="text-gray-500">Email : ${user.email}</p>
                        <p class="text-gray-500">Password : ${user.password}</p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

</div>


</body>
</html>
