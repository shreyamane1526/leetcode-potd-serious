# Write your MySQL query statement below
SELECT s.student_id,s.student_name,sub.subject_name,CASE WHEN e.subject_name IS NOT NULL THEN COUNT(e.subject_name=sub.subject_name) 
ELSE 0 END AS attended_exams
FROM Students AS s
CROSS JOIN Subjects AS sub 
LEFT JOIN Examinations AS e ON s.student_id=e.student_id AND sub.subject_name=e.subject_name 
GROUP BY s.student_id,sub.subject_name
ORDER BY s.student_id,sub.subject_name;