//tên đơn hàng ở đầu trang
const orderTitle = document.querySelector("#orderTitle");

//THÀNH TIỀN

//tổng giá trị đơn hàng
const orderValueSum = document.querySelector("#orderValueSum");
//phí giao hàng
const orderValueShippingFee = document.querySelector("#orderValueShippingFee");
//tổng giá trị đơn hàng
const orderValueTotal = document.querySelector("#orderValueTotal");
//giảm giá
const orderValueDiscount = document.querySelector("#orderValueDiscount");

function orderValueDefaultValues() {
  orderValueSum.innerText = "1000000";
  orderValueShippingFee.innerText = "0";
  orderValueDiscount.innerText = "0";

  orderValueTotal.innerText =
    parseInt(orderValueSum.innerText) +
    parseInt(orderValueShippingFee.innerText) -
    parseInt(orderValueDiscount.innerText);
}

//THÔNG TIN GIAO NHẬN

//tên người nhận
const shippingInfoName = document.querySelector("#shippingInfoName");
//SDT
const shippingInfoPhoneNum = document.querySelector("#shippingInfoPhoneNum");
//địa chỉ
const shippingInfoAddress = document.querySelector("#shippingInfoAddress");

function shippingDefaultValues() {
  shippingInfoName.innerText = "Nguyễn Văn A";
  shippingInfoPhoneNum.innerText = "123456789";
  shippingInfoAddress.innerText = "123 Main St";
}

//THÔNG TIN ĐƠN HÀNG

//số lượng
const orderInfoQuantity = document.querySelector("#orderInfoQuantity");
//ngày đặt
const orderInfoPlacingDate = document.querySelector("#orderInfoPlacingDate");
//ngày giao
const orderInfoShippingDate = document.querySelector("#orderInfoShippingDate");
//nhân viên xử lý
const orderInfoEmployee = document.querySelector("#orderInfoEmployee");
//trạng thái
const orderInfoStatus = document.querySelector("#orderInfoStatus");

function orderInfoDefaultValues() {
  orderInfoQuantity.innerText = "1";
  orderInfoPlacingDate.innerText = "01/01/2021";
  orderInfoShippingDate.innerText = "01/01/2021";
  orderInfoEmployee.innerText = "Nguyễn Văn B";
  orderInfoStatus.innerText = "Đợi xác nhận đơn hàng";
  orderInfoStatus.className = ORDER_STATUS["Đợi xác nhận đơn hàng"];
}

//GHI CHÚ ĐƠN HÀNG
const orderNote = document.querySelector("#orderNote");

function orderNoteDefaultValues() {
  orderNote.innerText = "Giao hàng vào giờ hành chính";
}

//giá trị mặc định
window.addEventListener("load", function () {
  orderTitle.innerText = "Đơn hàng 02";
  orderValueDefaultValues();
  shippingDefaultValues();
  orderInfoDefaultValues();
  orderNoteDefaultValues();
});
