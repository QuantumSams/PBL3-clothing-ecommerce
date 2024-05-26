$(document).ready(function () {
  $(".productSidebar > a").on("click", function (e) {
    e.preventDefault();
    $(this).siblings(".submenu").slideToggle();
  });

  $(".menu > ul > li").click(function (e) {
    $(this).addClass("active");
    $(this).siblings().removeClass("active");

    if (!$(this).hasClass("productSidebar")) {
      $(".submenu > li").removeClass("active");
    }
  });

  $(".submenu > li").click(function (e) {
    $(this).addClass("active");
    $(this).siblings().removeClass("active");
  });
});

// $(".menu > ul > li").click(function (e) {
//   $(this).addClass("active");
//   $(this).siblings().removeClass("active");
// });

const HeaderBreadcrumbLink = document.getElementById("HeaderBreadcrumbLink");

HeaderBreadcrumbLink.addEventListener("click", function () {
  location.reload();
});
