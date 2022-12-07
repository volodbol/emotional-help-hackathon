INSERT INTO questionnaire(title)
VALUES ('Emotional map');

INSERT INTO question(questionnaire_id, question_text)
VALUES (1, 'Both negative and positive emotions serve me as a source of knowledge about how to act in life.'),
       (1, 'Negative emotions help me understand what I need to change in my life.'),
       (1, 'I am calm when I feel pressure from the outside.'),
       (1, 'I am able to observe the change in my feelings.'),
       (1, 'When necessary, I can be calm and focused to act following the demands of life.'),
       (1,
        'When necessary, I can evoke a wide range of positive emotions, such as fun, joy, inner upsurge, and humor.'),
       (1, 'I closely monitor my health.'),
       (1, 'After something has upset me, I can easily control my feelings.'),
       (1, 'I am able to listen to other people''s problems.'),
       (1, 'I do not dwell on negative emotions.');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (1, 'Disagree strongly', 2, 'JOY'),
       (1, 'Disagree', 1, 'JOY'),
       (1, 'Disagree slightly', 1, 'SADNESS'),
       (1, 'Agree slightly', 1, 'SADNESS'),
       (1, 'Agree', 1, 'FEAR'),
       (1, 'Agree strongly', 2, 'FEAR');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (2, 'Disagree strongly', 2, 'ANGRY'),
       (2, 'Disagree', 1, 'ANGRY'),
       (2, 'Disagree slightly', 1, 'FEAR'),
       (2, 'Agree slightly', 1, 'SURPRISE'),
       (2, 'Agree', 1, 'HAPPY'),
       (2, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (3, 'Disagree strongly', 2, 'FEAR'),
       (3, 'Disagree', 1, 'FEAR'),
       (3, 'Disagree slightly', 1, 'SADNESS'),
       (3, 'Agree slightly', 1, 'SURPRISE'),
       (3, 'Agree', 1, 'JOY'),
       (3, 'Agree strongly', 1, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (4, 'Disagree strongly', 2, 'SADNESS'),
       (4, 'Disagree', 1, 'SADNESS'),
       (4, 'Disagree slightly', 1, 'SADNESS'),
       (4, 'Agree slightly', 1, 'JOY'),
       (4, 'Agree', 1, 'SURPRISE'),
       (4, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (5, 'Disagree strongly', 2, 'ANGRY'),
       (5, 'Disagree', 1, 'ANGRY'),
       (5, 'Disagree slightly', 1, 'FEAR'),
       (5, 'Agree slightly', 1, 'SURPRISE'),
       (5, 'Agree', 1, 'JOY'),
       (5, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (6, 'Disagree strongly', 2, 'SADNESS'),
       (6, 'Disagree', 1, 'SADNESS'),
       (6, 'Disagree slightly', 1, 'FEAR'),
       (6, 'Agree slightly', 1, 'SURPRISE'),
       (6, 'Agree', 1, 'JOY'),
       (6, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (7, 'Disagree strongly', 2, 'SADNESS'),
       (7, 'Disagree', 1, 'SADNESS'),
       (7, 'Disagree slightly', 1, 'FEAR'),
       (7, 'Agree slightly', 1, 'JOY'),
       (7, 'Agree', 1, 'HAPPY'),
       (7, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (8, 'Disagree strongly', 2, 'ANGRY'),
       (8, 'Disagree', 1, 'ANGRY'),
       (8, 'Disagree slightly', 1, 'FEAR'),
       (8, 'Agree slightly', 1, 'JOY'),
       (8, 'Agree', 1, 'SURPRISE'),
       (8, 'Agree strongly', 1, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (9, 'Disagree strongly', 2, 'FEAR'),
       (9, 'Disagree', 1, 'SADNESS'),
       (9, 'Disagree slightly', 1, 'ANGRY'),
       (9, 'Agree slightly', 1, 'JOY'),
       (9, 'Agree', 1, 'SURPRISE'),
       (9, 'Agree strongly', 2, 'HAPPY');

INSERT INTO answer(question_id, answer_value, mark, answer_group)
VALUES (10, 'Disagree strongly', 2, 'SADNESS'),
       (10, 'Disagree', 2, 'FEAR'),
       (10, 'Disagree slightly', 1, 'ANGRY'),
       (10, 'Agree slightly', 1, 'SURPRISE'),
       (10, 'Agree', 2, 'JOY'),
       (10, 'Agree strongly', 2, 'HAPPY');

