# Write your MySQL query statement below
SELECT a1.machine_id,cAST(AVG(a1.timestamp-a2.timestamp) AS DECIMAL(10,3)) AS processing_time 
FROM Activity AS a1
INNER JOIN Activity AS a2
ON a1.machine_id=a2.machine_id
WHERE a1.process_id=a2.process_id AND a2.activity_type='start' AND a1.activity_type='end'
GROUP BY a1.machine_id;
