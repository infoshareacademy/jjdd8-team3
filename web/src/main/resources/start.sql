USE hfvdb;

insert into team(team_name) values ('HighFive Team');
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Jan', '2012-12-23', 23, "aaa", 'MANAGER', 'ADMIN', 'Jankowski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Janusz', '2015-12-23', 26, "aaa", 'MANAGER', 'ADMIN', 'Kowaslki', 1);

insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, employee_id) values (1, '2020-01-01', 4, 0, 30, 1);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, employee_id) values (1, '2020-01-01', 4, 0, 26, 2);

insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-01-27', 'APPLIED', '2020-02-27', 'PARENTAL');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-01-27', 'APPROVED', '2020-01-31', 'VACATION');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-05-27', 'APPLIED', '2020-06-07', 'PARENTAL');
