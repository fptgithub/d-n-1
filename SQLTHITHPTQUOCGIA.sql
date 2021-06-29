create database DUAN1_THITHPT_2;

use DUAN1_THITHPT_2;

CREATE TABLE NGUOIDUNG(
TAIKHOAN VARCHAR(50) NOT NULL,
MATKHAU VARCHAR(50) NOT NULL,
TEN NVARCHAR(50),
GIOITINH NVARCHAR(20) not null,
MAVAITRO VARCHAR(20) NOT NULL,

CONSTRAINT PK_NGUOIDUNG_TAKHOAN primary key(TAIKHOAN)
);

create table MONHOC(
MAMONHOC VARCHAR(30) NOT NULL,
TENMONHOC NVARCHAR(50) NOT NULL,
THOIGIANTHI INT NOT NULL,
NGAYTHEM TIMESTAMP NOT NULL,
NGUOITHEM VARCHAR(50) not null,
NGAYSUA TIMESTAMP,
NGUOISUA VARCHAR(50) ,
TONGSOCAU INT,

CONSTRAINT PK_MONHOC_MAMONHOC PRIMARY KEY(MAMONHOC),
CONSTRAINT FK_MONHOC_NGUOIDUNG_NGUOITHEM FOREIGN KEY(NGUOITHEM) REFERENCES NGUOIDUNG(TAIKHOAN) ,
CONSTRAINT FK_MONHOC_NGUOIDUNG_NGUOISUA FOREIGN KEY(NGUOISUA) REFERENCES NGUOIDUNG(TAIKHOAN)
);


CREATE TABLE DETHI(
MADETHI VARCHAR(30) NOT NULL,
TENDETHI NVARCHAR(50) NOT NULL,
MAMONHOC VARCHAR(30) NOT NULL,
NGAYTHEM TIMESTAMP NOT NULL,
NGUOITHEM VARCHAR(50) NOT NULL,

CONSTRAINT PK_DETHI_MADETHI primary key(MADETHI),
CONSTRAINT FK_DETHI_NGUOIDUNG_NGUOITHEM FOREIGN KEY(NGUOITHEM) REFERENCES NGUOIDUNG(TAIKHOAN) ,
CONSTRAINT FK_DETHI_MONHOC_MAMONHOC foreign key(MAMONHOC) references MONHOC(MAMONHOC) ON DELETE CASCADE
);
update duan1_thithpt_2.dethi set motangan = 'Việc ôn thi sẽ trở nên dễ dàng hơn khi các em có trong tay đề luyện thi THPT Quốc gia 2020 môn Toán - Đề số 9 có đáp án được Học Tốt chia sẻ dưới đây. Thông qua việc thực hành với đề thi, các em không những được làm quen với cấu trúc đề thi THPT môn Toán chuẩn của Bộ GD&ĐT, mà còn giúp các em hệ thống những kiến thức trọng tâm của môn học.' where madethi = 'DT_09';
ALTER TABLE duan1_thithpt_2.dethi
ADD motangan nvarchar(1000);
ALTER TABLE duan1_thithpt_2.dethi
MODIFY COLUMN tendethi nvarchar(100);

CREATE TABLE CAUHOI(
MACAUHOI VARCHAR(20) NOT NULL,
NOIDUNG text,
IMAGE NVARCHAR(300),
MADETHI VARCHAR(30) NOT NULL,
NGAYSUA TIMESTAMP,
NGUOISUA VARCHAR(50),
doanvan text,

CONSTRAINT PK_CAUHOI_MACAUHOI primary key(MACAUHOI),
CONSTRAINT FK_CAUHOI_NGUOIDUNG_NGUOISUA FOREIGN KEY(NGUOISUA) REFERENCES NGUOIDUNG(TAIKHOAN),
CONSTRAINT FK_CAUHOI_DETHI_MADETHI foreign key(MADETHI) references DETHI(MADETHI) ON DELETE CASCADE
);


ALTER TABLE cauhoi
	DROP FOREIGN KEY FK_doanvan_cauhoi_madoanvan;
CREATE TABLE DAPAN(
MACAUHOI VARCHAR(20) NOT NULL,
MADAPAN VARCHAR(20) NOT NULL,
NOIDUNG text NOT NULL,
TRANGTHAI NVARCHAR(10),
NGAYSUA TIMESTAMP,
NGUOISUA VARCHAR(50),
loaidapan varchar(2),

constraint PK_DAPAN_MADAPAN primary key(MADAPAN),
constraint FK_DAPAN_CAUHOI_MACAUHOI foreign key(MACAUHOI) references CAUHOI(MACAUHOI) ON DELETE CASCADE,
CONSTRAINT FK_DAPAN_NGUOIDUNG_NGUOISUA FOREIGN KEY(NGUOISUA) REFERENCES NGUOIDUNG(TAIKHOAN)
);


CREATE TABLE thi(
MATHITHU INT NOT NULL AUTO_INCREMENT NOT NULL,
TAIKHOAN VARCHAR(50) NOT NULL, 
MADETHI VARCHAR(30) NOT NULL,
SOCAUDUNG INT,
SOCAUSAI INT,
SOCAUKHONGTRALOI INT,
THOIDIEMTHI timestamp NOT NULL,

constraint PK_THITHU_MATHITHU primary key(MATHITHU),
constraint FK_THITHU_NGUOIDUNG_TAIKHOAN foreign key(TAIKHOAN) references NGUOIDUNG(TAIKHOAN) ON DELETE CASCADE,
constraint FK_THITHU_DETHI_MADETHI foreign key(MADETHI) references DETHI(MADETHI) ON DELETE CASCADE
);

CREATE TABLE BINHLUAN(
MABINHLUAN INT auto_increment NOT NULL,
TAIKHOAN VARCHAR(50) NOT NULL,
MADETHI VARCHAR(30) NOT NULL,
NOIDUNG NVARCHAR(500),
NGAYTHEM TIMESTAMP NOT NULL,

constraint PK_BINHLUAN_MABINHLUAN primary key(MABINHLUAN),
constraint FK_BINHLUAN_NGUOIDUNG_TAIKHOAN foreign key(TAIKHOAN) references NGUOIDUNG(TAIKHOAN) ON DELETE CASCADE,
constraint FK_BINHLUAN_DETHI_MADETHI foreign key(MADETHI) references DETHI(MADETHI) ON DELETE CASCADE
);

CREATE TABLE DETHIYEUTHICH(
TAIKHOAN VARCHAR(50) NOT NULL,
MADETHI VARCHAR(30) NOT NULL,

constraint FK_CAUHOIYEUTHICH_NGUOIDUNG_TAIKHOAN foreign key(TAIKHOAN) references NGUOIDUNG(TAIKHOAN),
constraint FK_CAUHOIYEUTHICH_CAUHOI_MACAUHOI foreign key(MADETHI) references DETHI(MADETHI)
);

ALTER TABLE duan1_thithpt_2.doanvan_tienganh
MODIFY COLUMN noidung text;
use DUAN1_THITHPT_2;
insert into nguoidung(taikhoan,matkhau,ten,gioitinh,mavaitro) values('damvuong0987@gmail.com','xxmmbb','beo','nam','admin') ;
 select * from DUAN1_THITHPT_2.nguoidung left join doanvan_tienganh on doanvan_tienganh.madoanvan = cauhoi.madoanvan where cauhoi.madethi = 'DT_01' order by loaidapan asc DUAN1_THITHPT_2.monhoc on dethi.mamonhoc = monhoc.mamonhoc where monhoc.mamonhoc = 'TOAN';
-- select * from DUAN1_THITHPT_2.dethi where madethi like '%DT_24%';
-- delete from DUAN1_THITHPT_2.cauhoi where madethi in (select madethi from DUAN1_THITHPT_2.dethi where mamonhoc = 'NGOAI_NGU');
-- delete from DUAN1_THITHPT_2.dethi where mamonhoc = 'NGOAI_NGU';
-- delete from DUAN1_THITHPT_2.cauhoi where madethi like '%DT_24%';
-- delete from DUAN1_THITHPT_2.dapan where macauhoi like '%DT_24%';

use DUAN1_THITHPT_2;
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,TONGSOCAU) values('LICH_SU','lịch sử',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('DIA_LY','địa lý',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('TOAN','toán',90,'2020-11-13','damvuong0987@gmail.com',50);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('SINH_HOC','sinh học',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('GDCD','giáo dục công dân',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('HOA_HOC','hóa học',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('VAT_LY','vật lý',50,'2020-11-13','damvuong0987@gmail.com',40);
insert into monhoc(MaMonHoc,TenMonHoc,ThoiGianThi,ngaythem,nguoithem,tongsocau) values('NGOAI_NGU','ngoại ngữ',60,'2020-11-13','damvuong0987@gmail.com',50);