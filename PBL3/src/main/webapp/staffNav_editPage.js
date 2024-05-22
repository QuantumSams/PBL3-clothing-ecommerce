//MÀN CHỈNH SỬA THÔNG TIN CÁ NHÂN

//tải file ảnh lên
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

//nút hiển thị mật khẩu
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
