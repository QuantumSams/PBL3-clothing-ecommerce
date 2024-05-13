<!DOCTYPE html>
<html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <head>
        <link rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="css/custom.min.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Sarabun:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
            rel="stylesheet">

        <script src="https://unpkg.com/@phosphor-icons/web"></script>
        <link rel="stylesheet" href="sidebar.css" />
        <title>Sidebar template</title>
    </head>

    <body>
        <div class="container">
            <div class="sidebar">
                <div class="head">
                    <div class="user-img">
                        <img src="https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=2662&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                            alt>
                    </div>
                </div>
                <div class="nav">
                    <div class="menu">
                        <p class="title">Chức năng</p>
                        <ul>
                            <li class="active">
                                <a href="#">
                                    <i class="icon ph-bold ph-house-simple"></i>
                                    <span class="text">Đơn hàng</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="icon ph-bold ph-house-simple"></i>
                                    <span class="text">Chat</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="icon ph-bold ph-house-simple"></i>
                                    <span class="text">Cá nhân</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Jquery -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
            integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
            crossorigin="anonymous"></script>
        <script src="sidebar.js"></script>
    </body>

</html>