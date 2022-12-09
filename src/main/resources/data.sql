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

INSERT INTO advice(tip, video, answer_group)
VALUES ('1. Educate Yourself The first thing to do if you want to help someone with depression is to learn more about the illness. If you have never suffered from depression, it can be very difficult to empathize with someone who is. There are lots of very good resources online that you can refer to. So, do some research and then you will be much better equipped to offer your friend help and support. 2. Take It Seriously Depression is not something that someone can snap out of. You cant fix the problem with one good night out, for example. When you are talking to someone with depression, don''t try to make light of the condition. Depression is a serious illness. You won''t be able to help a depressed person by telling them to cheer up or to pull themselves together and get over it.',
        'https://www.youtube.com/watch?v=_l0Da-_x0sE',
        'SADNESS'),
       ('1. Allow yourself to sit with your fear for 2-3 minutes at a time. Breathe with it and say, “It’s okay. It feels lousy but emotions are like the ocean—the waves ebb and flow.” Have something nurturing planned immediately after your 2-3 minute sitting period is completed: Call the good friend waiting to hear from you; immerse yourself in an activity you know is enjoyable and engrossing. 2. Write down the things you are grateful for. Look at the list when you feel youre in a bad place. 3. Add to the list. Remind yourself that your anxiety is a storehouse of wisdom. 4. Write a letter, “Dear Anxiety, I am no longer intimidated by you. 5. What can you teach me?” Exercise. Exercise can refocus you (your mind can only focus on one thing at a time). Whether you go on a short walk, head to a boxing gym for an all-out sweat session, or turn on a 15-minute yoga video at home, exercise is good for you and it will ground you and help you feel more capable. 6. Use humor to deflate your worst fears. For instance, what are some ridiculous worst-case scenarios that might happen if you accept an invitation to deliver a speech to a crowd of 500 people? I might pee in my pants at the podium *** I will be arrested for giving the worst speech in history *** My first boyfriend (girlfriend) will be in the audience and heckle me. Appreciate your courage. Doreen would tell herself during difficult times, “Every time I don’t allow fear to keep me from doing something that scares me, I am making myself stronger and less likely to let the next fear attack stop me.”',
        'https://www.youtube.com/watch?v=e9pTjkXviT8',
        'FEAR'),
       ('1. Question your thought pattern Negative thoughts can take root in your mind and distort the severity of the situation. One way is to challenge your fears, ask if they’re true, and see where you can take back control. 2. Practice focused, deep breathing Try breathing in for 4 counts and breathing out for 4 counts for 5 minutes total. By evening out your breath, you’ll slow your heart rate which should help calm you down. The 4-7-8 technique is also known to help anxiety. 3. Use aromatherapy Whether they’re in essential oil form, incense, or a candle, natural scents like lavender, chamomile, and sandalwood can be very soothing. Aromatherapy is thought to help activate certain receptors in your brain, potentially easing anxiety.',
        'https://www.youtube.com/watch?v=_l0Da-_x0sE',
        'ANGRY'),
       ('Acknowledge the fact, and learn to accept that surprises and unexpected events are part of life and are unavoidable. When you accept this fact, to some extent, it will be easier to deal whatever happens in your life. Life is dynamic, not static. Change is part of life, and the sooner you acknowledge and accept this fact, the better it would be. The key to everything is your attitude. A positive attitude is an asset in unexpected situations. Not all unexpected events are negative. Sometimes, what seems like a problem, or even a disaster, could be a blessing in disguise. A negative event can awaken ambition, motivation, and persistence, which would lead to progress and success. Even getting fired from work, could eventually turn out well, as you might find a better and more satisfying job. A loss or failure can make you search for something better.',
        'https://www.youtube.com/watch?v=_l0Da-_x0sE',
        'SURPRISE'),
       ('1. Make sure your basic needs are met Before we get into the fun activities, let’s talk about your basic needs. Your mood is directly affected by factors like sleep and food. To give your brain the foundation it needs to feel happy, you need to be fed and well-rested. If your mood is low, try asking yourself: Have I had enough sleep? Have I had a nutritious meal recently? Did I drink enough water today? Often, you might feel moody without realizing that it’s because you’re tired or hungry. In that case, increasing happiness might be as simple as eating, taking a nap, or having a glass of water. You can read about evidence-based ways to improve your sleep here.',
        'https://www.youtube.com/watch?v=_l0Da-_x0sE',
        'JOY'),
       ('You are great, keep going',
        'https://www.youtube.com/watch?v=_l0Da-_x0sE',
        'HAPPY')
