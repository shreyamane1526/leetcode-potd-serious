# Write your MySQL query statement below
SELECT s.user_id,CASE WHEN COUNT(c.action)>0 THEN CAST(SUM(c.action='confirmed')/COUNT(c.action) AS DECIMAL(10,2)) ELSE 0 END AS confirmation_rate
FROM Signups AS s
LEFT JOIN Confirmations AS c
ON s.user_id=c.user_id
GROUP BY s.user_id;

