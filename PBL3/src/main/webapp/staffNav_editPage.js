//MÀN CHỈNH SỬA THÔNG TIN CÁ NHÂN

//EditProfileNameField - tên người dùng
const EditProfileNameField = document.getElementById("EditProfileNameField");

//EditProfileGenderRadioMale - giới tính nam
const EditProfileGenderRadioMale = document.getElementById(
  "EditProfileGenderRadioMale"
);

//EditProfileGenderRadioFemale - giới tính nữ
const EditProfileGenderRadioFemale = document.getElementById(
  "EditProfileGenderRadioFemale"
);

//EditProfilePhoneField - số điện thoại
const EditProfilePhoneField = document.getElementById("EditProfilePhoneField");

//EditProfileAddressField - địa chỉ
const EditProfileAddressField = document.getElementById(
  "EditProfileAddressField"
);

//EditProfileUsernameField - tài khoản
const EditProfileUsernameField = document.getElementById(
  "EditProfileUsernameField"
);

//EditProfilePasswordField - mật khẩu
const EditProfilePasswordField = document.getElementById(
  "EditProfilePasswordField"
);

//hiển thị mật khẩu
const EditProfilePasswordFieldEyeButton = document.getElementById(
  "EditProfilePasswordFieldEyeButton"
);

//EditProfileImageUploadButton - nút tải ảnh lên
const EditProfileImageUploadButton = document.getElementById(
  "EditProfileImageUploadButton"
);

//EditProfileImageUploadShow - anh dai dien
const EditProfileImageUploadShow = document.getElementById(
  "EditProfileImageUploadShow"
);

window.onload = function () {
  EditProfileNameField.value = viewProfilePageName.innerText;
  EditProfilePhoneField.value = viewProfilePagePhoneNum.innerText;

  if (viewProfilePageGender.innerText === "Nam") {
    EditProfileGenderRadioFemale.checked = false;
    EditProfileGenderRadioMale.checked = true;
  } else {
    EditProfileGenderRadioFemale.checked = true;
    EditProfileGenderRadioMale.checked = false;
  }

  EditProfileAddressField.value = viewProfilePageAddress.innerText;
  EditProfileUsernameField.value = viewProfilePageAccount.value;
  EditProfilePasswordField.value = viewProfilePagePassword.value;
  EditProfileImageUploadShow.src = viewProfilePageImage.src;
};

//tải file ảnh lên
var fileInput = document.createElement("input");
fileInput.type = "file";
fileInput.accept = "image/*";
fileInput.style.display = "none";
document.body.appendChild(fileInput);

EditProfileImageUploadButton.addEventListener("click", function () {
  fileInput.click();
});

fileInput.addEventListener("change", function () {
  var file = fileInput.files[0];
  if (file) {
    var reader = new FileReader();
    reader.onload = function (e) {
      EditProfileImageUploadShow.src = e.target.result;
    };
    reader.readAsDataURL(file);
  }
});

//nút hiển thị mật khẩu
EditProfilePasswordFieldEyeButton.addEventListener("click", function () {
  if (EditProfilePasswordField.type === "password") {
    EditProfilePasswordField.type = "text";
  } else {
    EditProfilePasswordField.type = "password";
  }
});
