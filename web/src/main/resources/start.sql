USE hfvdb;

insert into team(team_name) values ('HighFive Team');
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Jan', '2012-12-23', 23, "aaa", 'MANAGER', 'ADMIN', 'Jankowski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Janusz', '2015-12-23', 26, "aaa", 'MANAGER', 'ADMIN', 'Kowaslki', 1);

insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, employee_id) values (1, '2020-01-01', 4, 0, 30, 1);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, employee_id) values (1, '2020-01-01', 4, 0, 26, 2);

insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-01-27', 'APPLIED', '2020-02-27', 'PARENTAL');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-01-27', 'APPROVED', '2020-01-31', 'VACATION');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-05-27', 'APPLIED', '2020-06-07', 'PARENTAL');

update entitlement set days_taken = 2 where id = 1;

insert into statistic (month_number, month_name, vacation_days_count) values (1, "JANUARY", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (2, "FEBRUARY", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (3, "MARCH", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (4, "APRIL", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (5, "MAY", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (6, "JUNE", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (7, "JULY", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (8, "AUGUST", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (9, "SEPTEMBER", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (10, "OCTOBER", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (11, "NOVEMBER", 0);
insert into statistic (month_number, month_name, vacation_days_count) values (12, "DECEMBER", 0);
