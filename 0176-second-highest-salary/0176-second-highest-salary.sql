/* Write your PL/SQL query statement below */
Select max(Salary) SecondHighestSalary from Employee where Salary <> (Select max(Salary) from Employee)