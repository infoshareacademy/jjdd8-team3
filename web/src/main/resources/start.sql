USE hfvdb;

insert into team(team_name) values ('HighFive Team');
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'Vacation-Manager@HighFive.com"', 'Jan', '2012-12-23', 23, "aaa", 'MANAGER', 'ADMIN', 'Jankowski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, login, position, role, surname, team_id) values (2, 'Vacation-Manager@HighFive.com"', 'Janusz', '2015-12-23', 26, "aaa", 'MANAGER', 'ADMIN', 'Kowaslki', 1);

insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, employee_id) values (1, '2020-01-01', 4, 0, 26, 1);