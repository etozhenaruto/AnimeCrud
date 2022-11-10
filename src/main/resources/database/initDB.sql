CREATE TABLE IF NOT EXISTS customerUsers (
    id SERIAL PRIMARY KEY,
    firs_name varchar(20) not null,
    last_name varchar(30) not null,
    age integer not null,
    salary integer,
    activate bool not null
);

alter table customerusers alter column id type bigint