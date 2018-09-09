CREATE TABLE public.customer
(
  customerid integer NOT NULL DEFAULT nextval('customer_customerid_seq'::regclass),
  customername character varying(50) NOT NULL,
  customerlastname character varying(50) NOT NULL,
  customercity character varying(50) NOT NULL,
  customerphone integer NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (customerid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customer
  OWNER TO postgres;


CREATE TABLE public.orderitem
(
  orderitemid integer NOT NULL DEFAULT nextval('orderitem_orderitemid_seq'::regclass),
  orderid integer NOT NULL,
  productid integer NOT NULL,
  unitprice numeric(12,4) NOT NULL DEFAULT 0,
  quantity integer NOT NULL,
  CONSTRAINT orderitem_pk PRIMARY KEY (orderitemid),
  CONSTRAINT orderitem_fk_order FOREIGN KEY (orderid)
      REFERENCES public.orders (orderid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT orderitem_fk_product FOREIGN KEY (productid)
      REFERENCES public.product (productid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.orderitem
  OWNER TO postgres;


CREATE TABLE public.orders
(
  orderid integer NOT NULL DEFAULT nextval('orders_orderid_seq'::regclass),
  ordernumber integer NOT NULL,
  customerid integer NOT NULL,
  totalamount numeric(12,4) NOT NULL,
  orderdate timestamp without time zone DEFAULT now(),
  CONSTRAINT orders_pk PRIMARY KEY (orderid),
  CONSTRAINT orders_fk FOREIGN KEY (customerid)
      REFERENCES public.customer (customerid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);

ALTER TABLE public.orders
  OWNER TO postgres;

CREATE TABLE public.product
(
  productid integer NOT NULL DEFAULT nextval('product_productid_seq'::regclass),
  productname character varying(100) NOT NULL,
  supplierid integer NOT NULL,
  unitprice numeric(12,4) NOT NULL,
  CONSTRAINT product_pk PRIMARY KEY (productid),
  CONSTRAINT product_fk FOREIGN KEY (supplierid)
      REFERENCES public.supplier (supplierid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO postgres;

CREATE TABLE public.product
(
  productid integer NOT NULL DEFAULT nextval('product_productid_seq'::regclass),
  productname character varying(100) NOT NULL,
  supplierid integer NOT NULL,
  unitprice numeric(12,4) NOT NULL,
  CONSTRAINT product_pk PRIMARY KEY (productid),
  CONSTRAINT product_fk FOREIGN KEY (supplierid)
      REFERENCES public.supplier (supplierid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.product
  OWNER TO postgres;

CREATE TABLE public.supplier
(
  supplierid integer NOT NULL DEFAULT nextval('supplier_supplierid_seq'::regclass),
  suppliername character varying(100) NOT NULL,
  suppliercity character varying(50) NOT NULL,
  supplierphone integer NOT NULL,
  CONSTRAINT supplier_pk PRIMARY KEY (supplierid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.supplier
  OWNER TO postgres;
