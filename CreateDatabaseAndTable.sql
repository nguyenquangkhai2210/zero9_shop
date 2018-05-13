use master
go
--drop database SHOPPINGONLINE
--go

create database SHOPPINGONLINE
go

use SHOPPINGONLINE
go

create table tblRole(
	RoleID int primary key,
	RoleName varchar(100) not null unique,
	RoleDescription varchar(200)
)


create table tblEmployee(
	EmpID varchar(20) primary key,
	EmpUsername varchar(100) not null unique,
	EmpPassword varchar(100) not null check(len(EmpPassword) >= 10),
	EmpName nvarchar(100) not null,
	EmpPhone varchar(100) not null unique,
	EmpMail varchar(100) not null unique,
	EmpAddress nvarchar(200) not null,
	EmpGender varchar(20) check( EmpGender = 'Male'  or EmpGender = 'Female' or EmpGender = 'Other') default 'Other',
	EmpBirthdate date check( EmpBirthdate < getdate() ),
	StartDate date not null default getdate(),
	EndDate date,
	RoleID int foreign key references tblRole(RoleID) not null
)

create table tblCustomer (
	CusID varchar(20) primary key,
	CusUsername varchar(100) not null unique,
	CusPassword varchar(100) not null,
	CusName nvarchar(100) not null,
	CusPhone varchar(50) not null,
	CusMail varchar(100) not null unique,
	CusAddress nvarchar(200) not null,
	CusGender varchar(20),
	CusBirthdate date check( CusBirthdate <= getdate() ),
	StartDate date not null default getdate(), -- format date: yyyy-MM-dd
	Point int not null default 0, --Tiện cho query
)
/*
- Voucher được tạo ra từ CreatedTime đến EndedTime, sau thời gian này, voucher sẽ không còn tác dụng
- Voucher có nhiều Type, loại customer chuyển thành voucher, loại voucher dùng cho nhiều người. Nếu là loại chuyển
từ Point qua thì chỉ dùng được 1 lần và customer có thể share Code này cho customer khác. Nếu Code được sử dụng
thì isActive false.
*/
create table tblVoucher (
	Code varchar(20) primary key,
	SaleOff int not null,
	isActive bit not null default 1,
	CreatedTime date not null default getdate(),
	EndedTime date not null,
	Type varchar(20) not null default 'Once', 
	CusID varchar(20) foreign key references tblCustomer(CusID),
)


/*
- Order được tạo ra tại thời điểm CreatedTime
- Dựa trên ReservedPoint của các product để tính Point cho Order
- Point của Order được cộng vào Point của Customer.
- Nếu Point đã được cộng dồn thì isAvaiable false mục đích tránh trường hợp cộng dồn cùng 1 Order
- Thêm column Point để tiện query data
*/
create table tblOrder(
	OrderID varchar(20) primary key,
	CreatedTime date not null default getdate(),
	OrderSum float not null,
	Point int not null,
	isAvailable bit not null default 1,
	Code varchar(20) foreign key references tblVoucher(Code), 
	CusID varchar(20) foreign key references tblCustomer(CusID) not null,
)

create table tblProduct(
	ProID varchar(20) primary key,
	ProName varchar(200) not null,
	ProDescription varchar(500) not null,
	ProPrice float not null,
	Stock int not null,
	Categories varchar(100),
	CreatedTime date not null default getdate(),
	isActive bit not null default 1,
	SaleOff int not null default 0,
	ReservedPoint int not null default 0,
)
	

create table tblProductImage(
	Id int identity(1,1) primary key,
	ProID varchar(20) foreign key references tblProduct(ProID) not null,
	ProImage varchar(100) not null
)


create table tblVoucherModificationHistory(
	Id int identity(1,1) primary key,
	Code varchar(20) foreign key references tblVoucher(Code) not null,
	ModifiedBy varchar(20) foreign key references tblEmployee(EmpID) not null,
	ModifiedTime date not null default getdate(),
	Description nvarchar(500) not null
)

create table tblProductModificationHistory (
	Id int identity(1,1) primary key,
	ProID varchar(20) foreign key references tblProduct(ProID) not null,
	ModifiedBy varchar(20) foreign key references tblEmployee(EmpID) not null,
	ModifiedTime date not null default getdate(),
	Description nvarchar(500) not null
)

create table tblOrderProductDetails(
	Id int identity(1,1) not null primary key,
	OrderID varchar(20) foreign key references tblOrder(OrderID) not null,
	ProID varchar(20) foreign key references tblProduct(ProID) not null,
	Quantity int not null default 1 check(Quantity >= 1)
)

create table tblProcessOrderDetails (
	Id int identity(1,1) not null primary key,
	OrderID varchar(20) foreign key references tblOrder(OrderID) not null,
	ModifiedBy varchar(20) foreign key references tblEmployee(EmpID) not null,
	ModifiedTime date not null default getdate(),
	Status varchar(20) not null check (Status = 'Waiting' or Status = 'Done' or Status = 'Rejected' or Status = 'Processing') default 'Waiting',
	Description nvarchar(500),
)
/*
create table tblHistoryOfUsingVoucher(
	Code varchar(20) foreign key references tblVoucher(Code),
	CusID varchar(20) foreign key references tblCustomer(CusID),
	Time date not null default getdate(),
	primary key (Code, CusID),
)
*/