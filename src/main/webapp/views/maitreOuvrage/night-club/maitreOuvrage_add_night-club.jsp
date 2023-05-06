<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/17/2023
  Time: 12:58 AM
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

<a href="${pageContext.request.contextPath}/views/maitreOuvrage/night-club/maitreOuvrage_manage_night-club.jsp"><button class="m-6 px-6 py-3 bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold rounded-xl">Back to Home</button></a>

<form action="AddNightClubServlet" method="post">
  <div class="space-y-4 mt-5 p-6">

    <div class="mb-6">
      <label for="id_nbr_places" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Places
        Number</label>
      <input type="text" id="id_nbr_places" name="nbr_places"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <div class="mb-6">
      <label for="id_price" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Price</label>
      <input type="text" id="id_price" name="price"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <button class="mt-6 py-3 px-8 text-lg bg-teal-500 hover:bg-teal-700 rounded-xl text-white">Submit</button>

  </div>

</form>

</body>
</html>
