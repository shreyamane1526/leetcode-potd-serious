# Write your MySQL query statement below
SELECT r.contest_id,CAST((COUNT(DISTINCT r.user_id)*100)/(SELECT COUNT(u.user_id) FROM Users AS u) AS DECIMAL(10,2)) AS percentage
from Register AS r
GROUP BY r.contest_id
ORDER BY percentage DESC,contest_id ASC;