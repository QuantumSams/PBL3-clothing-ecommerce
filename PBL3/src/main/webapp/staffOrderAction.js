//Xác nhận đơn hàng
const orderConfirmButton = document.getElementById("orderConfirmButton");

orderConfirmButton.addEventListener("click", function () {
  //TODO: đẩy dữ liệu lên server
  window.location.href = "staffOrderList.jsp";
});

//Huỷ đơn hàng
const orderCancelButton = document.getElementById("orderCancelButton");

orderCancelButton.addEventListener("click", function () {
  //TODO: chuyển trạng thái đơn sang "đã huỷ"
  window.location.href = "staffOrderList.jsp";
});
