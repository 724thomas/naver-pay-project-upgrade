show tables;



INSERT INTO COMPANY_TABLE(company_name, company_phone, company_url)
SELECT 'test', '01048430000', 'www.company.com'
WHERE NOT EXISTS (SELECT * FROM COMPANY_TABLE WHERE company_name = 'test');

INSERT INTO USER_TABLE(user_id,user_pw,user_name,user_phone,user_point)
VALUES ('a123','a123!@#','이름','00000000','1');