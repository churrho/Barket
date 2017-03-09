DROP TABLE product cascade constraint;
DROP TABLE customer cascade constraint;
DROP TABLE transaction cascade constraint;
DROP sequence seq_trans_no;
commit;

CREATE TABLE transaction ( 
	trans_no             int  NOT NULL,
	sell_id              varchar(50)  NOT NULL  ,
	buy_id               varchar(50),
	brand_name           varchar(50)  NOT NULL  ,
	product_name         varchar(50)  NOT NULL  ,
	coupon_barcode       varchar(50)  NOT NULL  ,
	price                int  NOT NULL  ,
	exp_date             date  NOT NULL  ,
	content              varchar(500)    ,
	calender             date   DEFAULT CURRENT_DATE ,
	proceed              int   DEFAULT 0 ,
	CONSTRAINT pk_table_transaction PRIMARY KEY ( trans_no )
 );


CREATE TABLE customer ( 
	id                   varchar(50)  NOT NULL  ,
	password             varchar(50)  NOT NULL  ,
	name                 varchar(50)  NOT NULL  ,
	phone                varchar(50)  NOT NULL  ,
	bank_name            varchar(50)  NOT NULL  ,
	bank_account         varchar(50)  NOT NULL  ,
	auth                 int   DEFAULT 0 ,
	cash                 int   DEFAULT 0 ,
	CONSTRAINT pk_table_customer PRIMARY KEY ( id )
 );


CREATE TABLE product ( 
	product_name         varchar(100)  NOT NULL  ,
	brand_name           varchar(50)  NOT NULL  ,
	CONSTRAINT pk_table_brand PRIMARY KEY ( product_name ),
	CONSTRAINT pk_table_product UNIQUE ( product_name, brand_name ) 
 );
commit;

ALTER TABLE transaction ADD CONSTRAINT fk_table_transaction_sell_id FOREIGN KEY ( sell_id ) REFERENCES customer( id );
ALTER TABLE transaction ADD CONSTRAINT fk_table_transaction_buy_id FOREIGN KEY ( buy_id ) REFERENCES customer( id );
ALTER TABLE transaction ADD CONSTRAINT fk_table_transaction_brand FOREIGN KEY ( product_name, brand_name ) REFERENCES product( product_name, brand_name) ;

commit;

create sequence seq_trans_no Increment by 1 start with 1;

commit;