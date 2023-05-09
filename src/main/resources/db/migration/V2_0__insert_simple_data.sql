INSERT INTO groups (name, status)
VALUES ('Group 1', 'ACTIVE'),
       ('Group 2', 'ACTIVE'),
       ('Group 3', 'ACTIVE'),
       ('Group 4', 'ACTIVE'),
       ('Group 5', 'ACTIVE');

INSERT INTO student (full_name, email, status, group_id)
VALUES
    ('Student 1', 'student1@example.com', 'ACTIVE', 1),
    ('Student 2', 'student2@example.com', 'ACTIVE', 2),
    ('Student 3', 'student3@example.com', 'ACTIVE', 3),
    ('Student 4', 'student4@example.com', 'ACTIVE', 4),
    ('Student 5', 'student5@example.com', 'ACTIVE', 5);

INSERT INTO professor (full_name, email, status)
VALUES
    ('Professor 1', 'professor1@example.com', 'ACTIVE'),
    ('Professor 2', 'professor2@example.com', 'ACTIVE'),
    ('Professor 3', 'professor3@example.com', 'ACTIVE'),
    ('Professor 4', 'professor4@example.com', 'ACTIVE'),
    ('Professor 5', 'professor5@example.com', 'ACTIVE');


INSERT INTO course (name)
VALUES
    ('Course 1'),
    ('Course 2'),
    ('Course 3'),
    ('Course 4'),
    ('Course 5');


INSERT INTO course_professor (course_id, professor_id)
VALUES
    (1,1), (2,2), (3,3), (4,4), (5,5);

INSERT INTO lesson (course_id, professor_id, start_time, finish_time, group_id, date)
VALUES
    (1, 1, '09:00:00', '10:30:00', 1, '2023-04-20'),
    (2, 2, '10:30:00', '12:00:00', 2, '2023-04-20'),
    (3, 3, '13:00:00', '14:30:00', 3, '2023-04-20'),
    (4, 4, '14:30:00', '16:00:00', 4, '2023-04-20'),
    (5, 5, '16:00:00', '17:30:00', 5, '2023-04-20'),
    (1, 2, '09:00:00', '10:30:00', 2, '2023-04-21'),
    (2, 3, '10:30:00', '12:00:00', 3, '2023-04-21'),
    (3, 4, '13:00:00', '14:30:00', 4, '2023-04-21'),
    (4, 5, '14:30:00', '16:00:00', 5, '2023-04-21'),
    (5, 1, '16:00:00', '17:30:00', 1, '2023-04-21');