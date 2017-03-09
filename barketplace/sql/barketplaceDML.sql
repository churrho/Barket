delete from transaction;
delete from product;
delete from customer;
commit;


-- transaction insert
insert into transaction(trans_no,sell_id,buy_id,brand_name,product_name,coupon_barcode,price,exp_date,content) values(seq_trans_no.nextval, '11', '22', '스타벅스', '스타벅스 아메리카노', '12345', 3500, '2017/03/31', '늦지않게 사용하세요 환불 안됩니다.');
insert into transaction(trans_no,sell_id,buy_id,brand_name,product_name,coupon_barcode,price,exp_date,content) values(seq_trans_no.nextval, '22', '11', '스타벅스', '스타벅스 돌체라떼', '23456', 4500, '2017/04/28', '방배역점에서만 사용가능합니다.');

-- customer insert
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('11','11','박명언','010-1111-1111','농협','110-266', 0, 10000);
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('22','22','김철호','010-2222-2222', '신한','110-255', 0, 30000);
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('33','33', '관리자', '010-3333-3333','신한','110-233',1,999999);

-- product insert
insert into product(product_name, brand_name) values('스타벅스 아메리카노','스타벅스');
insert into product(product_name, brand_name) values('스타벅스 돌체라떼', '스타벅스');
insert into product(product_name, brand_name) values('파리바게트 10000원 상품권', '파리바게트');
insert into product(product_name, brand_name) values('파리바게트 롤케익','파리바게트');

commit;
