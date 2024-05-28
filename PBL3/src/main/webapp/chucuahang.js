$(document).ready(function () {
  $("#button_search").click(function () {
    $.ajax({
      url: "get_product_by_ajax", // URL of your Servlet
      type: "GET",
      dataType: "json",
      data: {
        // product_name: $("#search").val(),
        product_name: $(".search_san_pham").val(),
      },
      success: function (data) {
        let chuoi = "";
        data.forEach(function (item) {
          // chuoi +=
          //   '<tr><td><img src="' +
          //   item.anh_san_pham[0] +
          //   '" width="50px" alt="">' +
          //   item.ten_san_pham +
          //   "</td>" +
          //   "<td>100</td>" +
          //   "<td>100.000 VNĐ</td>" +
          //   "<td>Nam</td>" +
          //   "<td>" +
          //   item.danh_muc_san_pham +
          //   "</td>" +
          //   "<td>" +
          //   item.ten_nhan_hang +
          //   "</td></tr>";

          chuoi +=
            "<tr>" +
            "<td>" +
            '<div class="imgContainer">' +
            '<img src="' +
            item.anh_san_pham[0] +
            '" alt="">' +
            "</div>" +
            "</td>" +
            "<td>" +
            item.ten_san_pham +
            "</td>" +
            "<td>100</td>" +
            "<td>" +
            '<div class="d-flex justify-content-between">' +
            "<span>100.000</span>" +
            "<span><b>VND</b></span>" +
            "</div>" +
            "</td>" +
            "<td>Nam</td>" +
            "<td>" +
            item.danh_muc_san_pham +
            "</td>" +
            "<td>" +
            item.ten_nhan_hang +
            "</td>" +
            '<td><button type="button" class="btn btn-outline-danger p-1" id="deleteProduct">' +
            '<i class="bi bi-trash3-fill"></i></button></td>' +
            "</tr>";
        });
        $("#san_pham").html(chuoi);
      },
    });
  });
});

$(document).ready(function () {
  $("#button_search_nhan_vien").click(function () {
    console.log($(".search_nhan_vien").val());
    $.ajax({
      url: "load_nhan_vien_by_json", // URL of your Servlet
      type: "GET",
      dataType: "json",
      data: {
        name_nhan_vien: $(".search_nhan_vien").val(),
        // name_nhan_vien: $("#search_nhan_vien").val(),
      },
      // success: function (data) {
      //   let chuoi = "";
      //   data.forEach(function (item) {
      //     chuoi +=
      //       '<tr><td><img src="' +
      //       item.anh_dai_dien +
      //       '" width="50px" alt=""></td>' +
      //       "<td>" +
      //       item.ho_ten +
      //       "</td>" +
      //       '<td><c:if test="' +
      //       (item.gioi_tinh == true) +
      //       '">Nam</c:if>' +
      //       '<c:if test="' +
      //       (item.gioi_tinh != true) +
      //       '">Nữ</c:if></td>' +
      //       "<td>" +
      //       item.so_dien_thoai +
      //       "</td>" +
      //       '<td><button class = "buttonSearch">Chi tiết</button></td></tr>';
      //   });

      //   $("#nhan_vien").html(chuoi);
      // },
      success: function (data) {
        let chuoi = "";
        data.forEach(function (item) {
          chuoi +=
            "<tr>" +
            "<td>" +
            '<div class="imgContainerPortrait">' +
            '<img src="' +
            item.anh_dai_dien +
            '" alt="">' +
            "</div>" +
            "</td>" +
            "<td>" +
            item.ho_ten +
            "</td>" +
            "<td>" +
            '<c:if test="' +
            (item.gioi_tinh == true) +
            '">Nam</c:if>' +
            '<c:if test="' +
            (item.gioi_tinh != true) +
            '">Nữ</c:if>' +
            "</td>" +
            "<td>" +
            item.so_dien_thoai +
            "</td>" +
            '<input type="hidden" name="id" value="' +
            item.id_nguoi_dung +
            '">' +
            '<td><button class="btn btn-dark" id="button_search_nhan_vien">Chi tiết</button></td>' +
            "<td>" +
            '<button type="button" class="btn btn-dark px-3" id="viewProduct"><i class="bi bi-info-circle-fill"></i></button>' +
            "</td>";
          '<td><button type="button" class="btn btn-outline-danger p-1" id="deleteProduct">' +
            '<i class="bi bi-trash3-fill"></i></button></td>' +
            "</tr>";
        });

        $("#nhan_vien").html(chuoi);
      },
    });
  });
});

const khuVucSanPham = document.getElementById("san-pham");
const khuVucKhoHang = document.getElementById("kho-hang");
const khuVucDoanhThu = document.getElementById("doanh-thu");
const khuVucNhanVien = document.getElementById("nhan-vien");

const chucNangSanPham = document.getElementById("productList");
const chucNangDanhMuc = document.getElementById("categoryList");
const chucNangKhoHang = document.getElementById("inventorySidebar");
const chucNangDoanhThu = document.getElementById("incomeSidebar");
const chucNangNhanVien = document.getElementById("staffSidebar");

khuVucSanPham.style.display = "";
khuVucKhoHang.style.display = "none";
khuVucDoanhThu.style.display = "none";
khuVucNhanVien.style.display = "none";

function fadeIn(element) {
  let opacity = 0;
  const interval = setInterval(function () {
    if (opacity < 1) {
      opacity += 0.02;
      element.style.opacity = opacity;
    } else {
      clearInterval(interval);
    }
  }, 0.05);
}

function fadeOut(element) {
  let opacity = 1;
  const interval = setInterval(function () {
    if (opacity > 0) {
      opacity -= 0.1;
      element.style.opacity = opacity;
    } else {
      clearInterval(interval);
    }
  }, 0.05);
}

const HeaderBreadcrumbParentText = document.getElementById(
  "HeaderBreadcrumbParentText"
);
HeaderBreadcrumbParentText.innerText = "Danh sách sản phẩm";

chucNangSanPham.addEventListener("click", function () {
  HeaderBreadcrumbParentText.innerText = "Danh sách sản phẩm";
  fadeOut(khuVucKhoHang);
  fadeOut(khuVucDoanhThu);
  fadeOut(khuVucNhanVien);
  setTimeout(function () {
    khuVucKhoHang.style.display = "none";
    khuVucDoanhThu.style.display = "none";
    khuVucNhanVien.style.display = "none";
    fadeIn(khuVucSanPham);
    khuVucSanPham.style.display = "";
  }, 100);
});

chucNangKhoHang.addEventListener("click", function () {
  HeaderBreadcrumbParentText.innerText = "Kho hàng";
  fadeOut(khuVucSanPham);
  fadeOut(khuVucDoanhThu);
  fadeOut(khuVucNhanVien);
  setTimeout(function () {
    khuVucSanPham.style.display = "none";
    khuVucDoanhThu.style.display = "none";
    khuVucNhanVien.style.display = "none";
    fadeIn(khuVucKhoHang);
    khuVucKhoHang.style.display = "";
  }, 100);
});

chucNangDoanhThu.addEventListener("click", function () {
  HeaderBreadcrumbParentText.innerText = "Doanh thu";
  fadeOut(khuVucSanPham);
  fadeOut(khuVucKhoHang);
  fadeOut(khuVucNhanVien);
  setTimeout(function () {
    khuVucSanPham.style.display = "none";
    khuVucKhoHang.style.display = "none";
    khuVucNhanVien.style.display = "none";
    fadeIn(khuVucDoanhThu);
    khuVucDoanhThu.style.display = "";
  }, 100);
});

chucNangNhanVien.addEventListener("click", function () {
  HeaderBreadcrumbParentText.innerText = "Nhân viên";
  fadeOut(khuVucSanPham);
  fadeOut(khuVucKhoHang);
  fadeOut(khuVucDoanhThu);
  setTimeout(function () {
    khuVucSanPham.style.display = "none";
    khuVucKhoHang.style.display = "none";
    khuVucDoanhThu.style.display = "none";
    fadeIn(khuVucNhanVien);
    khuVucNhanVien.style.display = "";
  }, 100);
});
