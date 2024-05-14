$(".menu > ul > li").click(function (e) {
  $(this).siblings().removeClass("active");
  $(this).toggleClass("active");
});

const passwordInput = document.getElementById("new_password"); // replace with your password input field id
const togglePasswordVisibilityButton = document.getElementById(
  "togglePasswordVisibility"
); // replace with your eye button id

togglePasswordVisibilityButton.addEventListener("click", function () {
  if (passwordInput.type === "password") {
    passwordInput.type = "text";
  } else {
    passwordInput.type = "password";
  }
});
