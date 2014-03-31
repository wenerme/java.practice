drop table if exists users;

create table if not exists users(
    id int(5) primary key auto_increment,
    enname varchar(20) not null,  
    cnname varchar(20) not null, 
    password varchar(32) not null,
    email varchar(30) not null, 
    beginDate date not null,
    endDate date not null,
    state varchar(1) not null,
    groups_id int(5),
    constraint groups_id_FK foreign key(groups_id) references groups(id)
);

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('haha','¹ş¹ş',md5('111111'),'haha@163.com','2014-1-1','2014-12-31','Y',1); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('heihei','ºÙºÙ',md5('222222'),'heihei@163.com','2014-1-1','2014-12-31','Y',2); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('hehe','ºÇºÇ',md5('333333'),'hehe@163.com','2014-1-1','2014-12-31','Y',3); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('hoho','»ğ»ğ',md5('444444'),'hoho@163.com','2014-1-1','2014-12-31','Y',4); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('xixi','ÎûÎû',md5('555555'),'xixi@163.com','2014-1-1','2014-12-31','N',5); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('soso','CC',md5('666666'),'soso@163.com','2014-1-1','2014-12-31','N',3); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('dudu','¶¼¶¼',md5('777777'),'dudu@163.com','2014-1-1','2014-12-31','Y',3); 

insert into users(enname,cnname,password,email,beginDate,endDate,state,groups_id)
values('benben','±¿±¿',md5('888888'),'benben@163.com','2014-1-1','2014-12-31','Y',3); 

select enname,cnname,email,beginDate,endDate,state,groups_id from users;




