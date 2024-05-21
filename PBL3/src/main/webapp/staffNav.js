const passwordInput = document.getElementById("passwordField");
const togglePasswordVisibilityButton = document.getElementById("passwordEye");

const EditProfilePasswordField = document.getElementById(
  "EditProfilePasswordField"
);
const EditProfilePasswordFieldEyeButton = document.getElementById(
  "EditProfilePasswordFieldEyeButton"
);

const editButton = document.getElementById("editButton");
const cancelButton = document.getElementById("cancelButton");
const saveButton = document.getElementById("saveButton");

const viewProfilePage = document.getElementById("viewProfilePage");
const editProfilePage = document.getElementById("editProfilePage");
const HeaderBreadcrumbText = document.getElementById("HeaderBreadcrumbText");

togglePasswordVisibilityButton.addEventListener("click", function () {
  if (passwordInput.type === "password") {
    passwordInput.type = "text";
  } else {
    passwordInput.type = "password";
  }
});
EditProfilePasswordFieldEyeButton.addEventListener("click", function () {
  console.log("Toggle password visibility button clicked!");
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
