CREATE TABLE `Thong_tin_dang_nhap` (
  `id` integer PRIMARY KEY,
  `ten_dang_nhap` varchar(30),
  `mat_khau` varchar(30),
  `id_loai_nguoi_dung` INTEGER,
  CONSTRAINT unique_name UNIQUE (ten_dang_nhap)
);

CREATE TABLE `Thong_tin_loai_nguoi_dung` (
  `id` integer PRIMARY KEY,
  `ten_loai_nguoi_dung` varchar(20)
);

CREATE TABLE `Thong_tin_nhan_vien` (
  `id_nhan_vien` integer PRIMARY KEY,
  `ho_ten` varchar(30),
  `gioi_tinh` bool,
  `ngay_sinh` date,
  `so_dien_thoai` integer,
  `dia_chi` varchar(50),
  `anh` mediumblob,
  `email` varchar(40)
);

CREATE TABLE `Thong_tin_khach_hang` (
  `id_khach_hang` integer PRIMARY KEY,
  `ten_tai_khoan` varchar(20),
  `ho_ten` varchar(30),
  `gioi_tinh` bool,
  `ngay_sinh` date,
  `so_dien_thoai` integer,
  `dia_chi` varchar(50),
  `anh` mediumblob,
  `email` varchar(40)
);

CREATE TABLE `Thong_tin_chu_shop` (
  `id_chu_shop` integer PRIMARY KEY,
  `ho_ten` varchar(30),
  `so_dien_thoai` integer,
  `email` varchar(40)
);

ALTER TABLE `Thong_tin_chu_shop` ADD FOREIGN KEY (`id_chu_shop`) REFERENCES `Thong_tin_dang_nhap` (`id`);

ALTER TABLE `Thong_tin_khach_hang` ADD FOREIGN KEY (`id_khach_hang`) REFERENCES `Thong_tin_dang_nhap` (`id`);

ALTER TABLE `Thong_tin_nhan_vien` ADD FOREIGN KEY (`id_nhan_vien`) REFERENCES `Thong_tin_dang_nhap` (`id`);

ALTER TABLE `Thong_tin_dang_nhap` ADD FOREIGN KEY (`id_loai_nguoi_dung`) REFERENCES `Thong_tin_loai_nguoi_dung` (`id`);
