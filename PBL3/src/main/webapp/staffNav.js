//MÀN QUẢN LÝ THÔNG TIN CÁ NHÂN


//thông tin cá nhân
//viewProfilePageName - tên người dùng
const viewProfilePageName = document.querySelector("#viewProfilePageName");

//viewProfilePageGender - giới tính
const viewProfilePageGender = document.querySelector("#viewProfilePageGender");

//viewProfilePagePhoneNum - số điện thoại
const viewProfilePagePhoneNum = document.querySelector(
  "#viewProfilePagePhoneNum"
);

//viewProfilePageAddress - địa chỉ
const viewProfilePageAddress = document.querySelector(
  "#viewProfilePageAddress"
);

//viewProfilePageAccount - tài khoản
const viewProfilePageAccount = document.getElementById(
  "viewProfilePageAccount"
);

//viewProfilePagePassword - mật khẩu
const viewProfilePagePassword = document.getElementById(
  "viewProfilePagePassword"
);

//viewProfilePageImage - ảnh đại diện
const viewProfilePageImage = document.querySelector("#viewProfilePageImage");

//thông tin cá nhân mặc định
window.addEventListener("load", function () {
  viewProfilePageName.innerText = "Nguyễn Văn X";
  viewProfilePageGender.innerText = "Nữ";
  viewProfilePagePhoneNum.innerText = "123456789";
  viewProfilePageAddress.innerText = "123 Main St";
  viewProfilePageAccount.value = "example@example.com";
  viewProfilePagePassword.value = "password";
  viewProfilePageImage.src =
    "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?q=80&w=2662&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
});

//nút hiển thị mật khẩu
const togglePasswordVisibilityButton = document.getElementById("passwordEye");
togglePasswordVisibilityButton.addEventListener("click", function () {
  if (viewProfilePagePassword.type === "password") {
    viewProfilePagePassword.type = "text";
  } else {
    viewProfilePagePassword.type = "password";
  }
});






