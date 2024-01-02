create table if not exists oa_user (
    id int not null primary key auto_increment,
    name varchar(100) not null,
    age int not null,
    phone_number varchar(20) not null
);