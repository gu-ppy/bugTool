create schema if not exists bugTool;
create table if not exists bugTool.`user-info` (
    id varchar(128) primary key  not null comment 'id',
    username varchar(20) not null comment 'username',
    `password` varchar(20) not null comment 'password',
    version int not null default 0 comment 'version'
);


create table if not exists bugTool.`server-info` (
    id varchar(128) primary key not null comment 'id',
    ip varchar(48) not null  comment 'ip',
    isIpv4 bit not null  default true comment 'ipv4',
    `password` varchar(128) not null comment 'current password',
    username varchar(64) not null comment 'current user'
);

create table if not exists bugTool.`default-server-account-info`(
    id varchar(128) primary key not null comment 'id',
    username varchar(48) not null comment 'username',
    `password` varchar(128) not null comment 'password'
);

create table if not exists bugTool.`bug-info` (
    id varchar(128) primary key not null comment 'id',
    ip varchar(48) not null comment 'relationShip ip',
    name varchar(48) not null comment 'bug describe',
    product varchar(48)  comment 'product',
    version varchar(24)  comment 'product version',
    logDir varchar(64) not null comment 'log Dir',
    context varchar(256) not null comment 'context'
)
-- create table if not exists bugTool.`machine-info` (
--     id varchar(128) primary key not null comment 'id',
--     ip varchar(48) not null comment 'relationShip ip',
--     // other info ...
-- )