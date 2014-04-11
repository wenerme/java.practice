drop table if exists groups;

create table if not exists groups(
    id int(5) primary key auto_increment,
    department varchar(10) not null,
    principal varchar(20) not null,
    functional varchar(30) not null,
    remark text not null 
);


insert into groups(department,principal,functional,remark) 
values('��ѧ��','����','������ѵ','��ҵ�г��õļ���'),
('����','�Ǻ�','��˾�������','�������'),
('�г���','ϸϸ','��У�','���Ϻ�����ͨ��У�'),
('ά����','�ٺ�','��˾�豸ά��','����ά��')
('����','����','��˾�������','�������'),
('�г���','ЦЦ','��У�','���Ϻ�����ͨ��У�'),
('ά����','�Ǻ�','��˾�豸ά��','����ά��')
;
