select FH.FLAVOR
from FIRST_HALF FH join ICECREAM_INFO II on FH.FLAVOR = II.FLAVOR
where FH.TOTAL_ORDER > 3000 and II.INGREDIENT_TYPE = 'fruit_based'
order by FH.TOTAL_ORDER DESC;