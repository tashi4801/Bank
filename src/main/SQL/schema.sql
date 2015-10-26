DROP TABLE bank;

CREATE TABLE bank
(
  id serial NOT NULL,
  date date,
  userid integer NOT NULL,
  revenue integer NOT NULL,
  spending integer NOT NULL,
  stock integer NOT NULL,
  memo text NOT NULL,
  CONSTRAINT bank_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bank
  OWNER TO postgres;

  
  
-- Table: member

DROP TABLE member;

CREATE TABLE member
(
  id serial NOT NULL,
  name text NOT NULL,
  password text NOT NULL,
  CONSTRAINT member_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE member
  OWNER TO postgres;
