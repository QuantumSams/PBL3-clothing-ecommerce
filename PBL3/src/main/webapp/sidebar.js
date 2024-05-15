$(".menu > ul > li").click(function (e) {
  $(this).siblings().removeClass("active");
  $(this).toggleClass("active");
});

const passwordInput = document.getElementById("passwordField");
const togglePasswordVisibilityButton = document.getElementById("passwordEye");

togglePasswordVisibilityButton.addEventListener("click", function () {
  console.log("Toggle password visibility button clicked!");
  if (passwordInput.type === "password") {
    passwordInput.type = "text";
  } else {
    passwordInput.type = "password";
  }
});
