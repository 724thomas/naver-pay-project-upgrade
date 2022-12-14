show tables;

SELECT * FROM USER_INFO;

INSERT INTO USER_INFO (user_id, user_pw, user_name, user_ph, user_addr)
VALUES ('a1234','a123!@#','tester1','010-1111-1111','home1'),
       ('b1234','b123!@#','tester2','010-2222-2222','home2'),
       ('c1234','c123!@#','tester3','010-3333-3333','home3'),
       ('d1234','d123!@#','tester4','010-4444-4444','home4'),
       ('e1234','e123!@#','tester5','010-5555-5555','home5'),
       ('f1234','f123!@#','tester6','010-6666-6666','home6'),
       ('g1234','g123!@#','tester7','010-7777-7777','home7'),
       ('h1234','h123!@#','tester8','010-8888-8888','home8'),
       ('i1234','i123!@#','tester9','010-9999-9999','home9');

INSERT INTO COMPANY (COMPANY_NAME, COMPANY_TEL, COMPANY_STORE, BUSINESS_NUMBER)
VALUES ('스마트 스토어1','02-111-1111','URL',1111),
       ('스마트 스토어2','02-222-2222','URL',2222),
       ('스마트 스토어3','02-333-3333','URL',3333),
       ('스마트 스토어4','02-444-4444','URL',4444),
       ('스마트 스토어5','02-555-5555','URL',5555),
       ('스마트 스토어6','02-666-6666','URL',6666),
       ('스마트 스토어7','02-777-7777','URL',7777),
       ('스마트 스토어8','02-888-8888','URL',8888),
       ('스마트 스토어9','02-999-9999','URL',9999),
       ('스마트 스토어10','02-100-1010','URL',1010);

INSERT INTO order_info (order_product_id, order_payment_id, order_date, used_point, order_money, user_serial_num, order_quantity )
values (10, 1, '2022-10-10', 0, 95313, 7, 1),
       (11, 8,'2020-10-13',0,45100,7,1),
       (12, 16,'2021-5-6',0,97155,8,1),
       (13, 16,'2021-6-7',0,97337,9,1),
       (14, 16,'2022-1-4',0,87497,1,1),
       (23, 16,'2020-1-20',0,62338,1,1),
       (24, 16,'2021-12-31',0,28847,1,1),
       (25, 16,'2021-8-13',0,15279,1,1),
       (26, 16,'2020-12-13',0,44533,1,1),
       (30, 19,'2022-3-3',0,47193,2,1),
       (31, 19,'2020-1-1',0,8909,2,1),
       (32, 11,'2021-11-11',0,16644,5,1),
       (33, 11,'2020-10-10',0,56324,5,1);


