create table organization (
    id bigint NOT NULL AUTO_INCREMENT,
    parent_id bigint,
    type varchar(20),
    name varchar(40),
    code varchar(10),
    manager boolean,
    primary key(id),
    foreign key (parent_id) references organization(id)
);
