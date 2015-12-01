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

  ------prefecturesテーブル-----
  DROP TABLE prefectures;

CREATE TABLE prefectures
(
  pref_id text NOT NULL,
  pref_name text,
  CONSTRAINT prefectures_pkey PRIMARY KEY (pref_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE prefectures
  OWNER TO postgres;
  
    ------hobbyテーブル-----
  DROP TABLE hobbys;

CREATE TABLE hobbys
(
  hob_id text NOT NULL,
  hob_name text,
  CONSTRAINT hobbys_pkey PRIMARY KEY (hob_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hobbys
  OWNER TO postgres;
  
    ------sex-----
  DROP TABLE sex;

CREATE TABLE sex
(
  sex_id text NOT NULL,
  sex text,
  CONSTRAINT sex_pkey PRIMARY KEY (sex_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sex
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

  ------prefecturesテーブル-----
  DROP TABLE prefectures;

CREATE TABLE prefectures
(
  pref_id text NOT NULL,
  pref_name text NOT NULL,
  CONSTRAINT prefectures_pkey PRIMARY KEY (pref_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE prefectures
  OWNER TO postgres;
  
    ------xssテーブル-----
DROP TABLE xss;
CREATE TABLE xss
(
  xs_id serial NOT NULL,
  userid integer NOT NULL,
  xs_text text NOT NULL,
  CONSTRAINT xss_pkey PRIMARY KEY (xs_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE xss
  OWNER TO postgres;
  

