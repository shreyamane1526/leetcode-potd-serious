# Write your MySQL query statement below
SELECT w.id from Weather  AS w
JOIN 
Weather AS w2
ON DATEDIFF(w.recordDate,w2.recordDate)=1
GROUP BY w.recordDate
Having SUM(w2.temperature<w.temperature)=COUNT(w2.recordDate);