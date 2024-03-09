INSERT INTO thong_tin_loai_nguoi_dung(id, ten_loai_nguoi_dung)
VALUES (1, "khach hang");

INSERT INTO thong_tin_dang_nhap(id, ten_dang_nhap, mat_khau, id_loai_nguoi_dung)
VALUES (1234, "Giapdeptraivcl", "123", 1);
INSERT INTO thong_tin_dang_nhap(id, ten_dang_nhap, mat_khau, id_loai_nguoi_dung)  
VALUES (1235, "ThanhCong", "123", 1);
INSERT INTO thong_tin_dang_nhap(id, ten_dang_nhap, mat_khau, id_loai_nguoi_dung)  
VALUES (1236, "Huy", "123", 1);

SELECT id, ten_dang_nhap, mat_khau, id_loai_nguoi_dung  FROM thong_tin_dang_nhap;