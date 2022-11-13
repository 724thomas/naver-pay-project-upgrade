show tables;



INSERT INTO COMPANY_TABLE(company_name, company_phone, company_url)
SELECT 'test', '01048430000', 'www.company.com'
WHERE NOT EXISTS (SELECT * FROM COMPANY_TABLE WHERE company_name = 'test');
