select count(*) AS fish_count
from fish_info i
join fish_name_info n 
on i.fish_type = n.fish_type
where n.fish_name = 'BASS' or n.fish_name = 'SNAPPER';