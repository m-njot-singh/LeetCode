/* Write your PL/SQL query statement below */
select machine_id , round(avg(diff),3) as processing_time
from(
select machine_id,max(timestamp)-min(timestamp) diff
from Activity group by (machine_id,Process_id) 
)
group by machine_id;