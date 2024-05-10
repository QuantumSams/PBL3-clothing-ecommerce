<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="index.css">
<div class="header" style ="position: fixed; width:100%; z-index:99; background-color: white;" >
        <nav class="navbar navbar-expand-sm">
            <div class="col-1 center">
            </div>
            <div class="col-3 center">
                <ul class="navbar-nav">
                <a class = "nav-item" href="index.jsp"><img src="img/logoicqon.png" width = 100; alt=""></a>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Nữ</a>
                    <ul class="dropdown">
                        <li><a href="#">Áo thun</a></li>
                        <li><a href="#">áo ấm</a></li>
                        <li><a href="#">Áo vest</a></li>
                        <li><a href="#">Áo len</a></li>
                    </ul>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">nam</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Trẻ em</a>
                  </li>
                </ul>
              </div>
              <div class="col-4 center">
                <div class="search">
                    <form class = "d-flex">
                        <input class="form-control me 2 " type="search">
                        <button class="btn btn-outline-infor"><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i></button>
                    </form>
                </div>
              </div>
              <div class="col-4 center">
                <ul class="navbar-nav">
                    <c:if test = "${sessionScope.acc == null}">
                        <li class="nav-item">
                            <a href="login.jsp" class="nav-link"><i class="fa-solid fa-user" style="color: #000000;"></i></a>
                        </li>
                    </c:if>
                    <c:if test = "${sessionScope.acc != null }">
                    	<li class = "nav-item">
                    		<a href = "userInfor.jsp" class = "nav-link">Hello ${sessionScope.acc.ho_ten}</a>
                    	</li>
                    </c:if>
                    
                    <li class="nav-item">
                      <a class="nav-link" href="#"><i class="fa-solid fa-heart" style="color: #000000;"></i></a>
                    </li>
                    <li class="nav-item">
                        <a href="nguoidung.jsp" class="nav-link"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></i></a>
                    </li>
                    <c:if test = "${sessionScope.acc != null }">
                    	<li class = "nav-item">
                    		<a href = "logout" class = "nav-link">Log out</a>
                    	</li>
                    </c:if>
                  </ul>
                </div>
                </nav>
              </div>