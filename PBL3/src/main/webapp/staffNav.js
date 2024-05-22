//MÀN QUẢN LÝ THÔNG TIN CÁ NHÂN

//phần heading
const viewProfilePage = document.getElementById("viewProfilePage");
const editProfilePage = document.getElementById("editProfilePage");
const HeaderBreadcrumbText = document.getElementById("HeaderBreadcrumbText");

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

//nút chỉnh sửa thông tin
const editButton = document.getElementById("editButton");
const cancelButton = document.getElementById("cancelButton");
const saveButton = document.getElementById("saveButton");

const EditProfilePasswordField = document.getElementById(
  "EditProfilePasswordField"
);
const EditProfilePasswordFieldEyeButton = document.getElementById(
  "EditProfilePasswordFieldEyeButton"
);

EditProfilePasswordFieldEyeButton.addEventListener("click", function () {
  if (EditProfilePasswordField.type === "password") {
    EditProfilePasswordField.type = "text";
  } else {
    EditProfilePasswordField.type = "password";
  }
});

editProfilePage.style.display = "none";
HeaderBreadcrumbText.textContent = "";

editButton.addEventListener("click", function () {
  editProfilePage.style.display = "";
  viewProfilePage.style.display = "none";
  HeaderBreadcrumbText.textContent = "Chỉnh sửa thông tin";
});

cancelButton.addEventListener("click", function () {
  editProfilePage.style.display = "none";
  viewProfilePage.style.display = "";
  HeaderBreadcrumbText.textContent = "";
});

saveButton.addEventListener("click", function () {
  location.reload();
});

var fileInput = document.createElement("input");
fileInput.type = "file";
fileInput.accept = "image/*";
fileInput.style.display = "none";
document.body.appendChild(fileInput);

var button = document.getElementById("EditProfileImageUploadButton");
var image = document.getElementById("EditProfileImageUploadShow");

button.addEventListener("click", function () {
  fileInput.click();
});

fileInput.addEventListener("change", function () {
  var file = fileInput.files[0];
  if (file) {
    var reader = new FileReader();
    reader.onload = function (e) {
      image.src = e.target.result;
    };
    reader.readAsDataURL(file);
  }
});
