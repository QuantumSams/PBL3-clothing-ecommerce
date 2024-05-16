$(".menu > ul > li").click(function (e) {
  $(this).toggleClass("active");
  $(this).siblings().removeClass("active");
});

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

//Hiding button
editProfilePage.style.display = "none";
HeaderBreadcrumbText.textContent = "Thông tin cá nhân";

editButton.addEventListener("click", function () {
  editProfilePage.style.display = "";
  viewProfilePage.style.display = "none";
  HeaderBreadcrumbText.textContent = "Chỉnh sửa thông tin";
});

//Show button
cancelButton.addEventListener("click", function () {
  editProfilePage.style.display = "none";
  viewProfilePage.style.display = "";
  HeaderBreadcrumbText.textContent = "Thông tin cá nhân";
});

saveButton.addEventListener("click", function () {
  location.reload();
});

var fileInput = document.createElement("input");
fileInput.type = "file";
fileInput.accept = "image/*";
fileInput.style.display = "none";
document.body.appendChild(fileInput);

// Get the button and image elements
var button = document.getElementById("EditProfileImageUploadButton");
var image = document.getElementById("EditProfileImageUploadShow");

// Attach click event listener to the button
button.addEventListener("click", function () {
  fileInput.click();
});

// Attach change event listener to the file input
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

const HeaderBreadcrumbLink = document.getElementById("HeaderBreadcrumbLink");

HeaderBreadcrumbLink.addEventListener("click", function () {
  location.reload();
});
