<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/28/2023
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="../../../css/bootstrapmin.css">
  <link rel="stylesheet" href="../../../css/available-rooms.css">
  <%--    <script src="../../js/bootstrapmin.js"></script>--%>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="header mb-5 m-5 mt-9 flex items-center justify-center">
  <h1 class="mb-4 text-4xl font-extrabold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white">Details of user<span class="underline underline-offset-3 decoration-8 decoration-blue-400 dark:decoration-blue-600"># ${user.id}</span></h1>
</div>

<a href="<%= request.getContextPath() %>/views/receptionist/salle/receptionist_manage_salle.jsp">
  <button class="m-5 bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded">
    Back Home
  </button>
</a>

<div class="p-6 bg-gray-100 rounded-xl m-5 mt-9">
  <h1 class="mb-6 text-3xl">User ID : ${user.id}</h1>
  <p class="text-gray-500"><strong>User Name : </strong>${user.name}</p>
  <p class="text-gray-500"><strong>User Email : </strong>${user.email}</p>
  <p class="text-gray-500"><strong>User Password: </strong>${user.password}</p>

  <div class="mt-6 p-6 bg-white rounded-xl">
    <a href="<%=request.getContextPath()%>/ReceptionistDetailsUserToUpdateServlet?id=${user.id}" class="inline-block mt-6 px-6 py-3 text-lg font-semibold bg-teal-500 text-white rounded-xl">Edit</a>
    <a href="<%=request.getContextPath()%>/ReceptionistDeleteUserServlet?id=${user.id}" class="inline-block mt-6 px-6 py-3 text-lg font-semibold bg-red-500 text-white rounded-xl">Delete</a>
  </div>
</div>


</body>
</html>
