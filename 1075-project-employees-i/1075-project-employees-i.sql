# Write your MySQL query statement below
SELECT p.project_id, CAST(AVG(e.experience_years) AS DECIMAL(10,2)) AS average_years
FROM Project AS P 
JOIN Employee AS e
ON p.employee_id=e.employee_id
Group By p.project_id;
