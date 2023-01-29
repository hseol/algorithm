https://school.programmers.co.kr/learn/courses/30/lessons/131116
SELECT food.category AS CATEGORY
    , food.price AS MAX_PRICE
    , food.product_name AS PRODUCT_NAME
FROM food_product AS food
WHERE food.category IN ('과자','국','김치','식용유')
    AND food.price IN (SELECT MAX(price) FROM food_product
                    GROUP BY category)
ORDER BY food.price DESC

https://school.programmers.co.kr/learn/courses/30/lessons/131532
SELECT YEAR(B.SALES_DATE) AS YEAR,MONTH(B.SALES_DATE) AS MONTH,A.GENDER AS GENDER,COUNT(DISTINCT A.USER_ID) AS USERS
FROM USER_INFO AS A JOIN ONLINE_SALE AS B ON A.USER_ID = B.USER_ID
GROUP BY YEAR,MONTH,GENDER
HAVING A.GENDER IS NOT NULL
ORDER BY YEAR,MONTH,GENDER ASC;