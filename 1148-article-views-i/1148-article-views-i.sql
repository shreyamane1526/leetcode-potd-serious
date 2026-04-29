# Write your MySQL query statement below
SELECT DISTINCT author_id AS id from Views
WHERE viewer_id=author_id
Order By id;