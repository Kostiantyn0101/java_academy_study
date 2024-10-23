insert into role_names (role)
values ('ROLE_TEACHER'),
       ('ROLE_STUDENT');

insert into users (username, password, enabled)
values ('obiwan', 'obiwan', true),
       ('darthvader', 'darthvader', true),
       ('frodo', 'frodo', true),
       ('aragorn', 'aragorn', true),
       ('legolas', 'legolas', true),
       ('jonsnow', 'jonsnow', true),
       ('daenerys', 'daenerys', true);


insert into teachers (user_id, first_name, last_name)
values (1, 'Obi-Wan', 'Kenobi'),
       (2, 'Anakin', 'Skywalker');

insert into students (user_id, first_name, last_name)
values (3, 'Frodo', 'Baggins'),
       (4, 'Aragorn', 'Son of Arathorn'),
       (5, 'Legolas', 'Greenleaf'),
       (6, 'Jon', 'Snow'),
       (7, 'Daenerys', 'Targaryen');


insert into roles (user_id, role_id)
values (1, 1),
       (2, 1),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2);
