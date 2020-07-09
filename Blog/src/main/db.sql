create database java30_blogdemo;
use java30_blogdemo;

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    name varchar(50) not null,
    password varchar(50) not null
);

drop table if exists article;
create table article (
    id int primary key auto_increment,
    title varchar(255) not null,
    content text not null,
    userId int not null,
    foreign key(userId) references user(userId)
);

insert into user values (null ,"admin1","123");
insert into user values (null ,"admin2","123");
insert into user values (null ,"admin3","123");

insert into article values (null ,"博客1","MySQL的安装",4);
insert into article values (null ,"博客2","Tomcat的部署",3);
insert into article values (null ,"博客3","Java面向对象",1);
insert into article values (null ,"博客4","Java环境变量配置",1);
insert into article values (null ,"博客5","Java基本数据类型",1);