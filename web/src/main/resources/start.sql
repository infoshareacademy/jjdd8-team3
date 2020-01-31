USE hfvdb;

insert into team(team_name) values ('HighFive Team');
insert into team(team_name) values ('HR Team');
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Jan', '2012-12-23', 23, "aaa", 'MANAGER', 'ADMIN', 'Jankowski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Janusz', '2015-12-23', 26, "aaa", 'MANAGER', 'ADMIN', 'Kowaslki', 2);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Lukasz', '2015-12-23', 26, "aaa", 'MANAGER', 'EMPLOYEE', 'Szukasz', 2);


insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 30, 2, 1);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 30, 2, 2;
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 5, 3);

insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (1, '2020-01-27', 'APPROVED', '2020-02-27', 'PARENTAL');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-01-27', 'APPROVED', '2020-01-31', 'VACATION');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (2, '2020-02-14', 'APPROVED', '2020-02-19', 'VACATION');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type) values (3, '2020-02-17', 'APPROVED', '2020-02-27', 'PARENTAL');

insert into statistic (month_number, month_name, vacation_days_count) values (1, 'JANUARY', 12);
insert into statistic (month_number, month_name, vacation_days_count) values (2, 'FEBRUARY', 11);
insert into statistic (month_number, month_name, vacation_days_count) values (3, 'MARCH', 10);
insert into statistic (month_number, month_name, vacation_days_count) values (4, 'APRIL', 9);
insert into statistic (month_number, month_name, vacation_days_count) values (5, 'MAY', 8);
insert into statistic (month_number, month_name, vacation_days_count) values (6, 'JUNE', 7);
insert into statistic (month_number, month_name, vacation_days_count) values (7, 'JULY', 6);
insert into statistic (month_number, month_name, vacation_days_count) values (8, 'AUGUST', 5);
insert into statistic (month_number, month_name, vacation_days_count) values (9, 'SEPTEMBER', 4);
insert into statistic (month_number, month_name, vacation_days_count) values (10, 'OCTOBER', 3);
insert into statistic (month_number, month_name, vacation_days_count) values (11, 'NOVEMBER', 2);
insert into statistic (month_number, month_name, vacation_days_count) values (12, 'DECEMBER', 1);
