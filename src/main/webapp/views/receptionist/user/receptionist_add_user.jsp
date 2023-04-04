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

  <script src="https://cdn.tailwindcss.com"></script>
  <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/views/receptionist/user/receptionist_manage_user.jsp"><button class="m-6 px-6 py-3 bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold rounded-xl">Back to Home</button></a>

<form action="${pageContext.request.contextPath}/AddSalleServlet" method="post">
  <div class="space-y-4 mt-8 p-6 m-6">

    <div class="mb-6">
      <label for="name_id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
      <input type="text" name="name" id="name_id"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <div class="mb-6">
      <label for="email_id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
      <input type="text" id="email_id" name="email"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <div class="mb-6">
      <label for="password_id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">price per day</label>
      <input type="text" id="password_id" name="password"
             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    </div>

    <button class="mt-6 py-3 px-8 text-lg bg-teal-500 hover:bg-teal-700 rounded-xl text-white">Submit</button>

  </div>


</form>

</body>
</html>
