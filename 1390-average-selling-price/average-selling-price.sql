# Write your MySQL query statement below
select p.product_id ,
IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
from prices AS p
Left join UnitsSold AS u
ON
    p.product_id = u.product_id
    AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY
    p.product_id;