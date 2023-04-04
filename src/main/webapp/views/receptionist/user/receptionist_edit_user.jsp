<%@ page import="com.hotel.management.hotel_management.dao.places.rooms.RoomDaoImpl" %>
<%@ page import="com.hotel.management.hotel_management.model.places.Room" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/1/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../../css/bootstrapmin.css">
  <script src="https://cdn.tailwindcss.com"></script>

  <title>Title</title>
</head>
<body>




<form action="<%=request.getContextPath()%>/ReceptionistEditUserServlet" method="post">
  <div class="space-y-4 mt-5 p-6">
    <input type="hidden" name="id" id="id" value="${user.id}">

    <div class="mb-6">
      <label for="id_name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Places
        Number</label>
      <input type="text" id="id_name" name="name" value="${user.name}"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <div class="mb-6">
      <label for="id_email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
      <input type="text" name="email" id="id_email" value="${user.email}"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <div class="mb-6">
      <label for="id_password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
      <input type="text" id="id_password" name="password" value="${user.password}"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <button class="mt-6 py-3 px-8 text-lg bg-teal-500 hover:bg-teal-700 rounded-xl text-white">Submit</button>

  </div>
</form>

</body>
</html>
