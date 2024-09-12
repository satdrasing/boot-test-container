
CREATE SEQUENCE seq_vehicle START 4 INCREMENT 1;
create table vehicle (
    id bigserial primary key,
    name varchar(20)
);