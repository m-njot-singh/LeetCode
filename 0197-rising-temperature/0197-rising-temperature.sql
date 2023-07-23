/* Write your PL/SQL query statement below */
select distinct a.id from Weather a,Weather b
where (a.recordDate-b.recordDate)=1 and a.temperature>b.temperature;