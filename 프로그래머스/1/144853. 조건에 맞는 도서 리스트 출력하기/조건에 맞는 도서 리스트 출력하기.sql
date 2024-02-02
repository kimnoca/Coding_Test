-- 코드를 입력하세요
SELECT book_id, DATE_FORMAT(published_date, "%Y-%m-%d") 
from book 
where category = '인문' and 
Year(published_date) = 2021