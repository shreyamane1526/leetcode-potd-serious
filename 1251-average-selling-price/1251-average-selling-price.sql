# Write your MySQL query statement below
SELECT p.product_id,CASE WHEN COUNT(u.units)<>0 THEN CAST(SUM(u.units*p.price)/SUM(u.units) AS DECIMAL(10,2)) ELSE 0 END AS average_price 
FROM Prices AS p 
LEFT JOIN UnitsSold AS u ON p.product_id=u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
