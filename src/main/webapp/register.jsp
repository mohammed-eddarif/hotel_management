<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/15/2023
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

</head>
<body>

<section class="bg-gray-50 min-h-screen flex items-center justify-center">
    <!-- login container -->
    <div class="bg-gray-100 flex rounded-2xl shadow-lg max-w-3xl p-5 items-center">
        <!-- form -->
        <div class="md:w-1/2 px-8 md:px-16">
            <h2 class="font-bold text-2xl text-[#002D74]">Register</h2>
            <p class="text-xs mt-4 text-[#002D74]">If you are already a member, go back and log in</p>

            <form action="RegisterServlet" class="flex flex-col gap-4" method="post">
                <input class="p-2 mt-8 rounded-xl border" type="text" name="name" placeholder="name">
                <input class="p-2 rounded-xl border" type="email" name="email" placeholder="Email">
                <div class="relative">
                    <input class="p-2 rounded-xl border w-full" type="password" name="password" placeholder="Password"
                           id="id_password">
                    <button type="button" class="bi bi-eye absolute top-1/2 right-3 -translate-y-1/2">
                        <i id="togglePassword" class="fa fa-eye"></i>
                    </button>
                </div>
                <div class="relative">
                    <input class="p-2 rounded-xl border w-full" type="password" name="password1"
                           placeholder="Repeat Password"
                           id="id_password1">
                    <button type="button" class="bi bi-eye absolute top-1/2 right-3 -translate-y-1/2">
                        <i id="togglePassword1" class="fa fa-eye"></i>
                    </button>
                </div>
                <button class="bg-[#002D74] rounded-xl text-white py-2 hover:scale-105 duration-300">Register</button>
            </form>

            <div class="mt-3 text-xs flex justify-between items-center text-[#002D74]">
                <p>Already have an account?</p>
                <button class="py-2 px-5 bg-white border rounded-xl hover:scale-110 duration-300"
                        onclick="window.location.href='login.jsp';">Login
                </button>
            </div>

        </div>

        <!-- image -->
        <div class="md:block hidden w-1/2">
            <img class="rounded-2xl"
                 src="images/login.jpg">
        </div>
    </div>
</section>

<script>
    const togglePassword = document.querySelector('#togglePassword');
    const password = document.querySelector('#id_password');
    const togglePassword1 = document.querySelector('#togglePassword1');
    const password1 = document.querySelector('#id_password1');

    togglePassword.addEventListener('click', function (e) {
        // toggle the type attribute
        const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
        password.setAttribute('type', type);
        // toggle the eye slash icon
        this.classList.toggle('fa-eye-slash');
    });
    togglePassword1.addEventListener('click', function (e) {
        // toggle the type attribute
        const type = password1.getAttribute('type') === 'password1' ? 'text' : 'password1';
        password1.setAttribute('type', type);
        // toggle the eye slash icon
        this.classList.toggle('fa-eye-slash');
    });
</script>

</body>
</html>
