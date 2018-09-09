CREATE OR REPLACE FUNCTION public.transferunitprice()
  RETURNS trigger AS
$BODY$
BEGIN
    SELECT Product.unitprice
        INTO NEW.unitprice
    FROM Product
    WHERE Product.productid = NEW.productid;

    RETURN NEW;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.transferunitprice()
  OWNER TO postgres;

CREATE OR REPLACE FUNCTION public.update_order_price()
  RETURNS trigger AS
$BODY$
    DECLARE
        delta DECIMAL(12, 4);
    BEGIN
        -- Work out the increment/decrement amount(s).
        IF (TG_OP = 'INSERT') THEN
            delta = NEW.quantity * NEW.unitprice;
        ELSIF (TG_OP = 'UPDATE') THEN
            delta = NEW.quantity * NEW.unitprice - OLD.quantity * OLD.unitprice;
        ELSIF (TG_OP = 'DELETE') THEN
            delta = - OLD.quantity * OLD.unitprice;
        END IF;

        -- Update the order row
        UPDATE orders 
        SET totalamount = totalamount + delta
        WHERE Orders.orderid = NEW.orderid;

        RETURN NEW;
    END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.update_order_price()
  OWNER TO postgres;