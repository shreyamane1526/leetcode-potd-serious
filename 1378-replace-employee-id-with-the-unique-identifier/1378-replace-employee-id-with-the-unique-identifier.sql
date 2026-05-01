# Write your MySQL query statement below
Select EmpUNI.unique_id,Emp.name from Employees As Emp
LEFT JOIN EmployeeUNI AS EmpUNI
ON EmpUNI.id=Emp.id;

