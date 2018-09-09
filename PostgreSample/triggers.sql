CREATE TRIGGER unitprice
  BEFORE INSERT
  ON public.orderitem
  FOR EACH ROW
  EXECUTE PROCEDURE public.transferunitprice();

CREATE TRIGGER update_order_price
  BEFORE INSERT
  ON public.orderitem
  FOR EACH ROW
  EXECUTE PROCEDURE public.update_order_price();

