drop table if exists groups;

create table if not exists groups(
    id int(5) primary key auto_increment,
    department varchar(10) not null,
    principal varchar(20) not null,
    functional varchar(30) not null,
    remark text not null 
);


insert into groups(department,principal,functional,remark) 
values('教学部','哈哈','技术培训','企业中常用的技术'),
('财务部','呵呵','公司财务管理','用友软件'),
('市场部','细细','高校活动','与上海市普通高校活动'),
('维护部','嘿嘿','公司设备维护','自行维护')
('财务部','文文','公司财务管理','用友软件'),
('市场部','笑笑','高校活动','与上海市普通高校活动'),
('维护部','呵呵','公司设备维护','自行维护')
;
