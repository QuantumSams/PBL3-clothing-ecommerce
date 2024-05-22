//PHẦN ĐIỀU HƯỚNG TRANG XEM VÀ CHỈNH SỬA THÔNG TIN CÁ NHÂN

//phần heading
const viewProfilePage = document.getElementById("viewProfilePage");
const editProfilePage = document.getElementById("editProfilePage");
const HeaderBreadcrumbText = document.getElementById("HeaderBreadcrumbText");

editProfilePage.style.display = "none";
HeaderBreadcrumbText.textContent = "";

//các nút
const editButton = document.getElementById("editButton");
const cancelButton = document.getElementById("cancelButton");
const saveButton = document.getElementById("saveButton");

//nút chỉnh sửa
editButton.addEventListener("click", function () {
  editProfilePage.style.display = "";
  viewProfilePage.style.display = "none";
  HeaderBreadcrumbText.textContent = "Chỉnh sửa thông tin";
});

//nút 'hủy'
cancelButton.addEventListener("click", function () {
  editProfilePage.style.display = "none";
  viewProfilePage.style.display = "";
  HeaderBreadcrumbText.textContent = "";
});

//nút 'lưu'
saveButton.addEventListener("click", function () {
  location.reload();
});
