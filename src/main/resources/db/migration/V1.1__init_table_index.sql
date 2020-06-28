

-- create log table
create table tbl_emp
(
  emp_id bigint auto_increment primary key,
  emp_name varchar(127) not null,
  dept_id int(4) not null,
  gender varchar(64) not null,
  mobile varchar(32) not null,
  address varchar(1024) not null,
  age smallint not null,
  create_time datetime not null default CURRENT_TIMESTAMP,
  update_time datetime not null default CURRENT_TIMESTAMP
);

create index idx_dept_emp on tbl_emp(dept_id);

-- create the service request
create table tbl_dept
(
  dept_id int not null primary key,
  dept_name varchar(128) not null
);


-- CREATE VIEW OF EMPDEPT
CREATE VIEW view_empdept AS
    select a.emp_id, a.emp_name, a.gender, a.mobile, a.address, a.age, a.create_time, a.update_time,
    b.dept_name
    from tbl_emp as a inner join tbl_dept as b on a.dept_id = b.dept_id;


--create index on table(columns);

insert into tbl_dept(dept_id, dept_name) values ( 1, 'test dept' );
insert into tbl_dept(dept_id, dept_name) values ( 2, 'product dept' );
insert into tbl_dept(dept_id, dept_name) values ( 3, 'business dept' );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test1', 1, 'male', '0908900300', 'test-address-1', 20 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test2', 2, 'female', '0908900301', 'test-address-2', 22 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test3', 3, 'male', '0908900302', 'test-address-3', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test4', 1, 'female', '0908900303', 'test-address-4', 26 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test5', 2, 'male', '0908900304', 'test-address-5', 28 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test6', 3, 'female', '0908900305', 'test-address-6', 30 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test7', 1, 'male', '0908900306', 'test-address-7', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test8', 2, 'female', '0908900307', 'test-address-8', 26 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test9', 3, 'male', '0908900308', 'test-address-9', 28 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test10', 1, 'female', '0908900309', 'test-address-10', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test11', 2, 'male', '0908900310', 'test-address-11', 26 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test12', 3, 'female', '0908900311', 'test-address-12', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test13', 1, 'male', '0908900312', 'test-address-13', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test14', 2, 'female', '0908900313', 'test-address-14', 24 );

insert into tbl_emp (emp_name, dept_id, gender, mobile, address, age)
VALUES ( 'test15', 3, 'male', '0908900314', 'test-address-15', 29 );