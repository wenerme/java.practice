drop table if exists admins;

create table if not exists admins(
  id int(5) primary key auto_increment,
  username varchar(10) not null,
  password varchar(32) not null
);

insert into admins(username,password) values('�Ķ�',md5('123456'));
insert into admins(username,password) values('wener',md5('123456'));
insert into admins(username,password) values('xiao',md5('123456'));
insert into admins(username,password) values('ЦЦ',md5('123456'));
insert into admins(username,password) values('С��',md5('123456'));
insert into admins(username,password) values('xiaoxiao',md5('123456'));

select * from admins;

