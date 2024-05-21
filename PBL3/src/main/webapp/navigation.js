$(".menu > ul > li").click(function (e) {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");
});

const HeaderBreadcrumbLink = document.getElementById("HeaderBreadcrumbLink");

HeaderBreadcrumbLink.addEventListener("click", function () {
  location.reload();
});
