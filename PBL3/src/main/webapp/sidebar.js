$(".menu > ul > li").click(function (e) {
  $(this).siblings().removeClass("active");
  $(this).toggleClass("active");
});

const passwordInput = document.getElementById("passwordField");
const togglePasswordVisibilityButton = document.getElementById("passwordEye");

const editButton = document.getElementById("editButton");
const cancelButton = document.getElementById("cancelButton");
const saveButton = document.getElementById("saveButton");

togglePasswordVisibilityButton.addEventListener("click", function () {
  console.log("Toggle password visibility button clicked!");
  if (passwordInput.type === "password") {
    passwordInput.type = "text";
  } else {
    passwordInput.type = "password";
  }
});

//Hiding button
saveButton.style.display = "none";
cancelButton.style.display = "none";

editButton.addEventListener("click", function () {
  editButton.style.display = "none";
  saveButton.style.display = "";
  cancelButton.style.display = "";
});

//Show button
cancelButton.addEventListener("click", function () {
  editButton.style.display = "";
  saveButton.style.display = "none";
  cancelButton.style.display = "none";
});
