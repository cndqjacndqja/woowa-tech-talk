create table if not exists user
(
    id bigint auto_increment not null,
    name varchar(255) not null unique,
    primary key(id)
);
