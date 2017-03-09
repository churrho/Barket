delete from transaction;
delete from product;
delete from customer;
commit;


-- transaction insert
insert into transaction(trans_no,sell_id,buy_id,brand_name,product_name,coupon_barcode,price,exp_date,content) values(seq_trans_no.nextval, '11', '22', '��Ÿ����', '��Ÿ���� �Ƹ޸�ī��', '12345', 3500, '2017/03/31', '�����ʰ� ����ϼ��� ȯ�� �ȵ˴ϴ�.');
insert into transaction(trans_no,sell_id,buy_id,brand_name,product_name,coupon_barcode,price,exp_date,content) values(seq_trans_no.nextval, '22', '11', '��Ÿ����', '��Ÿ���� ��ü��', '23456', 4500, '2017/04/28', '��迪�������� ��밡���մϴ�.');

-- customer insert
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('11','11','�ڸ��','010-1111-1111','����','110-266', 0, 10000);
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('22','22','��öȣ','010-2222-2222', '����','110-255', 0, 30000);
insert into customer(id,password,name,phone,bank_name,bank_account,auth, cash) values ('33','33', '������', '010-3333-3333','����','110-233',1,999999);

-- product insert
insert into product(product_name, brand_name) values('��Ÿ���� �Ƹ޸�ī��','��Ÿ����');
insert into product(product_name, brand_name) values('��Ÿ���� ��ü��', '��Ÿ����');
insert into product(product_name, brand_name) values('�ĸ��ٰ�Ʈ 10000�� ��ǰ��', '�ĸ��ٰ�Ʈ');
insert into product(product_name, brand_name) values('�ĸ��ٰ�Ʈ ������','�ĸ��ٰ�Ʈ');

commit;
