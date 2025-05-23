select count(*) fish_count 
from fish_info i
where i.fish_type in (
    select fish_type 
    from fish_name_info
    where fish_name = 'BASS' or fish_name = 'SNAPPER'
)