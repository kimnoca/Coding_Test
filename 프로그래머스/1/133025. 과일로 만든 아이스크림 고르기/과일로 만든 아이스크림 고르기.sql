-- 코드를 입력하세요
SELECT f.flavor 
from first_half f
inner join icecream_info i on f.flavor = i.flavor
where i.INGREDIENT_TYPE = 'fruit_based'
and total_order > 3000
order by total_order desc