SELECT a.animal_type, count(1) as count
from animal_ins a
group by a.animal_type
order by a.animal_type;