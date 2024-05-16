$(".menu > ul > li").click(function (e) {
  $(this).siblings().removeClass("active");
  $(this).toggleClass("active");
});

const passwordInput = document.getElementById("passwordField");
const togglePasswordVisibilityButton = document.getElementById("passwordEye");

const editButton = document.getElementById("editButton");
const cancelButton = document.getElementById("cancelButton");
const saveButton = document.getElementById("saveButton");

const viewProfilePage = document.getElementById("viewProfilePage");
const editProfilePage = document.getElementById("editProfilePage");

togglePasswordVisibilityButton.addEventListener("click", function () {
  console.log("Toggle password visibility button clicked!");
  if (passwordInput.type === "password") {
    passwordInput.type = "text";
  } else {
    passwordInput.type = "password";
  }
});

//Hiding button
editProfilePage.style.display = "none";

editButton.addEventListener("click", function () {
  editProfilePage.style.display = "";
  viewProfilePage.style.display = "none";
});

//Show button
cancelButton.addEventListener("click", function () {
  editProfilePage.style.display = "none";
  viewProfilePage.style.display = "";
});
