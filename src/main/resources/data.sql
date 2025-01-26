drop table if exists users;
drop table if exists roles;
drop table if exists users_roles;

create table users (
    id          bigserial,
    username    varchar(255) not null,
    password    varchar(255),
    email       varchar(255) unique,
    primary key (id)
);

create table roles (
    id          serial,
    name        varchar(255) not null,
    primary key (id)
);

create table users_roles (
    user_id     bigint not null,
    role_id     int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

insert into roles(name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users(username, password, email)
values ('admin', '$2a$12$bGEHqiS8c4NdDOw92Q3d.ehZDr5mdwq5fTWYQeWqj8xYTXPznQ37.', 'admin@mail.ru');

insert into users_roles (user_id, role_id) values (1, 2);

