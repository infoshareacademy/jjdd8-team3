USE hfvdb;

insert into team(team_name) values ('HighFive');
insert into team(team_name) values ('Sales');
insert into team(team_name) values ('HR');
insert into team(team_name) values ('Admins');
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'mich.chmielewski@gmail.com', 'Michał', '2012-12-23', 26,  'Java developer', 'ADMIN', 'Chmielewski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'bartosz.dagiel@gmail.com', 'Bartek', '2012-12-23', 26,  'Java developer', 'ADMIN', 'Dagiel', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'bandurskim@gmail.com', 'Maciej', '2012-12-23', 26,  'Java developer', 'ADMIN', 'Bandurski', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'slezak.robert88@gmail.com', 'Robert', '2012-12-23', 26,  'Java developer', 'ADMIN', 'Ślęzak', 1);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Jan', '2012-12-23', 26,  'Specialist', 'EMPLOYEE', 'Jankowski', 2);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Janusz', '2015-12-23', 26, 'Specialist', 'EMPLOYEE', 'Kowaslki', 2);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'jjdd8highfive@gmail.com', 'Lukasz', '2015-12-23', 26, 'Specialist', 'EMPLOYEE', 'Szukasz', 3);
insert into employee(additional_entitlement, email, first_name, hire_date, holiday_entitlement, position, role, surname, team_id) values (2, 'marek.wladyslaw.zajac@gmail.com', 'Marek', '2015-12-23', 26, 'Java developer', 'ADMIN', 'Zając', 1);


insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 12, 1);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 9, 2);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 10, 3);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 9, 4);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 10, 5);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 10, 6);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 8, 7);
insert into entitlement(additional_left, current_year, on_demand_holiday_left, previous_year_left, vacation_left, vacation_taken, employee_id) values (1, '2020-01-01', 4, 0, 26, 15, 8);

insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (1, '2020-01-13', 'APPROVED', '2020-01-24', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (1, '2020-02-03', 'APPROVED', '2020-02-05', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (2, '2020-01-27', 'APPROVED', '2020-01-31', 'VACATION','2020-01-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (2, '2020-02-14', 'APPROVED', '2020-02-19', 'VACATION','2020-02-10 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (3, '2020-03-17', 'APPROVED', '2020-03-27', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (4, '2020-04-20', 'APPROVED', '2020-04-30', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (5, '2020-06-17', 'APPROVED', '2020-06-27', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (6, '2020-07-17', 'APPROVED', '2020-07-27', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (7, '2020-07-17', 'APPROVED', '2020-07-25', 'VACATION','2020-02-20 16:21:25.829997', '1');
insert into vacation (employee_id, from_date, vacation_status, to_date, vacation_type, date_of_request, reminder_email_sent) values (8, '2020-08-03', 'APPROVED', '2020-08-24', 'VACATION','2020-02-20 16:21:25.829997', '1');

insert into statistic (month_number, month_name, vacation_days_count) values (1, 'JANUARY', 14);
insert into statistic (month_number, month_name, vacation_days_count) values (2, 'FEBRUARY', 5);
insert into statistic (month_number, month_name, vacation_days_count) values (3, 'MARCH', 10);
insert into statistic (month_number, month_name, vacation_days_count) values (4, 'APRIL', 9);
insert into statistic (month_number, month_name, vacation_days_count) values (5, 'MAY', 8);
insert into statistic (month_number, month_name, vacation_days_count) values (6, 'JUNE', 10);
insert into statistic (month_number, month_name, vacation_days_count) values (7, 'JULY', 20);
insert into statistic (month_number, month_name, vacation_days_count) values (8, 'AUGUST', 15);
insert into statistic (month_number, month_name, vacation_days_count) values (9, 'SEPTEMBER', 0);
insert into statistic (month_number, month_name, vacation_days_count) values (10, 'OCTOBER', 0);
insert into statistic (month_number, month_name, vacation_days_count) values (11, 'NOVEMBER', 0);
insert into statistic (month_number, month_name, vacation_days_count) values (12, 'DECEMBER', 0);
