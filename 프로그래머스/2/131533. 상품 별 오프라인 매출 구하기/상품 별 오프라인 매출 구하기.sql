SELECT p.product_code as product_code, sum(p.price * s.sales_amount) as SALES
from product p
inner join offline_sale s on p.product_id = s.product_id
group by p.product_code
order by sum(p.price * s.sales_amount) desc, p.product_code asc;