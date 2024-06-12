<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="index.css">
<style>
header ul li {
	display: inline-block;
	list-style: none;
}

.list {
	margin: 0 30px;
}

header ul .dropdown {
	position: absolute;
	width: 200px;
	background-color: white;
	box-shadow: 0 20px 20px #00000020;
	margin-top: -50px;
	opacity: 0;
	display: none;
	transition: all ease 0.5s;
}

header ul li:hover .dropdown {
	z-index: 99;
	opacity: 1;
	margin-top: 0;
	display: block;
}

header ul .dropdown li {
	margin: 0;
	width: 100%;
}
.dropdown-1{
	display: none;
}
.dropdown li:hover .dropdown-1{
	display: block;
	position: absolute;
	top: 0;
	left: 150px;
	width: 200px;
	background-color: white;
}
</style>
<header>

	<div class="header"
		style="position: fixed; width: 100%; z-index: 99; background-color: white;">
		<nav class="navbar navbar-expand-sm">
			<div class="col-4 center">
				<ul class="navbar-nav list">
					<a class="nav-item" href="trang_chu"><img
						src="img/logoicqon.png" width=100; alt=""></a>

					<c:forEach var="doi_tuong" items="${tree}">
						<li class="nav-item"><a class="nav-link" href="#">${doi_tuong.danh_muc_san_pham.category}</a>
							<ul class="dropdown">
								<c:forEach var="loai" items="${doi_tuong.node}">
									<li class="nav-item"><a class="nav-link" href="#">${loai.danh_muc_san_pham.category}</a>
										<ul class="dropdown-1">
											<c:forEach var="danh_muc" items="${loai.node}">
												<li class="nav-item">
													<a class="nav-link danh_muc_san_pham"  href="#">
														${danh_muc.danh_muc_san_pham.category}
														<input value="${danh_muc.danh_muc_san_pham.id}" type="hidden">
													</a>
												</li>
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-3 center">
				<div class="search">
					<div class="d-flex">
						<input class="form-control me 2 " type="search">
						<button class="btn btn-outline-infor">
							<i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
						</button>
					</div>
				</div>
			</div>
			<div class="col-5 center">
				<ul class="navbar-nav">
					<c:if test="${sessionScope.acc == null}">
						<li class="nav-item"><a href="login.jsp" class="nav-link"><i
								class="fa-solid fa-user" style="color: #000000;"></i></a></li>
					</c:if>
					<c:if test="${sessionScope.acc != null }">
						<li class="nav-item"><a href="nguoidung.jsp" class="nav-link">Hello
								${sessionScope.acc.ho_ten}</a></li>
					</c:if>

					<li class="nav-item"><a class="nav-link" href="nguoidung.jsp"><i
							class="fa-solid fa-heart" style="color: #000000;"></i></a></li>
					<li class="nav-item"><a href="nguoidung.jsp" class="nav-link"><i
							class="fa-solid fa-cart-shopping" style="color: #000000;"></i></i></a></li>
					<c:if test="${sessionScope.acc != null }">
						<li class="nav-item"><a href="logout" class="nav-link">Log
								out</a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</header>
<script>
	
</script>