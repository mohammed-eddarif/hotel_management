<%@ page import="java.util.List" %>
<%@ page import="com.hotel.management.hotel_management.dao.places.pools.PoolDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.dao.places.night_clubs.NightClubDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.dao.places.terasses.TerasseDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.places.*" %>
<%@ page import="com.hotel.management.hotel_management.dao.places.tables.TableDaoImpl" %><%--
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
    PoolDaoImpl poolDao = new PoolDaoImpl();
    List<Pool> pools = poolDao.findAll();
    request.setAttribute("pools", pools);

    NightClubDaoImpl nightClubDao = new NightClubDaoImpl();
    List<NightClub> nightClubs = nightClubDao.findAll();
    request.setAttribute("nightClubs", nightClubs);

    TerasseDaoImpl terasseDao = new TerasseDaoImpl();
    List<Terasse> terasses = terasseDao.findAll();
    request.setAttribute("terasses", terasses);

    TableDaoImpl tableDao = new TableDaoImpl();
    List<Table> tables = tableDao.findAll();
    request.setAttribute("tables", tables);
%>


<nav class="px-6 py-6 flex justify-between items-center border-b border-gray-200">
    <a href="#" class="text-3xl font-bold text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">ABBASSI
        HOTEL</a>

    <div class="space-x-6">

        <a href="${pageContext.request.contextPath}/views/maitreOuvrage/maitre_ouvrage_home.jsp" class="text-xl font-semibold hover:text-gray-500">Home</a>
        <a href="${pageContext.request.contextPath}/views/maitreOuvrage/pool/maitreOuvrage_manage_pool.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Pools</a>
        <a href="${pageContext.request.contextPath}/views/maitreOuvrage/night-club/maitreOuvrage_manage_night-club.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Night-Club</a>
        <a href="${pageContext.request.contextPath}/views/maitreOuvrage/terasse/maitreOuvrage_manage_terasse.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Terasse</a>
        <a href="${pageContext.request.contextPath}/views/maitreOuvrage/table/maitreOuvrage_manage_table.jsp" class="text-lg font-semibold hover:text-gray-500">Manage Table</a>
        <a href="${pageContext.request.contextPath}/login.jsp" class="px-6 py-3 text-lg font-semibold bg-red-500 text-white rounded-xl hover:bg-red-700">Log out</a>

    </div>
</nav>
<div>

    <div class="mt-6 px-6 py-12 bg-gray-100 rounded-xl opacity-95">
        <h2 class="mb-12 text-2xl text-center">Newest Terasses</h2>
        <div class="grid grid-cols-3 gap-3">
            <c:forEach items="${terasses}" var="terasse">
                <div>
                    <a href="<%=request.getContextPath()%>/ReceptionistManageRoomsToDetailRoomServlet?id=${terasse.terasse_id}">
                        <div class="p-6 bg-white rounded-t-xl">
                            <h2 class="text-2xl">Terasse #${terasse.terasse_id}</h2>
                            <p class="text-gray-500">Terasse for ${terasse.nbr_places} adult</p>
                            <p class="text-gray-500">Price: ${terasse.price} DHs</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

</div>

</body>
</html>
