select RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, ROUND(AVG(RR.REVIEW_SCORE), 2) as SCORE
from REST_INFO RI join REST_REVIEW RR on RI.REST_ID = RR.REST_ID 
where RI.ADDRESS like '서울%'
group by RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS
order by SCORE DESC, FAVORITES DESC;