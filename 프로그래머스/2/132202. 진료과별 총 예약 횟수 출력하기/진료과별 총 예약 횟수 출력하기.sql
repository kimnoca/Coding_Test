SELECT a.mcdp_cd as 진료과코드, count(*) as 5월예약건수
from appointment a
where a.APNT_YMD between DATE('2022-05-01') and DATE('2022-05-31')
group by a.mcdp_cd
ORDER BY count(*), a.mcdp_cd;