create database class_student;
use class_student;
create table classManager(
    id int not null primary key auto_increment,
    name varchar(255) not null ,
    description varchar(255)
);
create table student(
    id int not null auto_increment primary key ,
    firstname varchar(50) not null ,
    lastname varchar(50) not null ,
    address varchar(50),
    class_id int,
    foreign key (class_id) references classManager(id)
);
insert into classManager(id, name, description) VALUES (1,'1A','Lớp 1A');
insert into classManager( name, description) VALUES ('1B','Lớp 1B');
insert into classManager( name, description) VALUES ('1C','Lớp 1C');
select *from classManager;
insert into student(id, firstname, lastname, address, class_id) VALUES (1,'Nguyễn','Thu Hà','Hà Nội',1);
insert into student( firstname, lastname, address, class_id) VALUES ('Nguyễn','Minh Đức','Hải Phòng',1);
insert into student( firstname, lastname,address, class_id) VALUES ('Nguyễn','Thanh Phong','Hà Nội',2);
insert into student( firstname, lastname, address, class_id) VALUES ('Trần','Thu Phương','Đà nẵng',3);
insert into student( firstname, lastname, address, class_id) VALUES ('Lê ','Quang Huy','Hà Nội',3);
insert into student( firstname, lastname, address, class_id) VALUES ('Phạm ','Thanh Thủy','Hải Phòng',2);
select * from student;


