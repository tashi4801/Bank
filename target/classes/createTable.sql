drop table member;
drop table bank;

CREATE TABLE member
  (
  id  SERIAL,
  name text not null,
  password text not null,
  primary key("id"));
  
  CREATE TABLE bank
  (
  id  SERIAL,
  date date,
  userid Integer not null,
  revenue Integer not null,
  spending Integer not null,
  stock Integer not null,
  memo text not null,
  primary key("id"));
  
  
  