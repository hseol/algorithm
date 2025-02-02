--FOOD_PRODUCT와 FOOD_ORDER 테이블에서 
--생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 
--이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 
--총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.


-- 생산일자가 2022년 5월인 애들 조회 
-- 이때 PRODUCT_ID가 겹치는 애들이 있기 때문에 AMOUNT를 합쳐준다.
SELECT PRODUCT_ID, SUM(AMOUNT)AS AMOUNT
FROM FOOD_ORDER
WHERE YEAR(PRODUCE_DATE)='2022' AND MONTH(PRODUCE_DATE)='05'
GROUP BY PRODUCT_ID

-- 같은 PRODUCT_ID로 조인해주고 AMOUNT랑 PRICE를 곱한 총 매출을 구해준다. 

SELECT A.PRODUCT_ID, B.PRODUCT_NAME,(A.AMOUNT*B.PRICE)AS TOTAL_SALES
FROM (SELECT PRODUCT_ID, SUM(AMOUNT)AS AMOUNT
FROM FOOD_ORDER
WHERE YEAR(PRODUCE_DATE)='2022' AND MONTH(PRODUCE_DATE)='05'
GROUP BY PRODUCT_ID) AS A JOIN FOOD_PRODUCT AS B ON A.PRODUCT_ID = B.PRODUCT_ID

-- 조건에 맞게 총매출 기준으로 내림차순 식품ID 기준 오름차순으로 정렬한다.

SELECT A.PRODUCT_ID, B.PRODUCT_NAME,(A.AMOUNT*B.PRICE)AS TOTAL_SALES
FROM (SELECT PRODUCT_ID, SUM(AMOUNT)AS AMOUNT
FROM FOOD_ORDER
WHERE YEAR(PRODUCE_DATE)='2022' AND MONTH(PRODUCE_DATE)='05'
GROUP BY PRODUCT_ID) AS A JOIN FOOD_PRODUCT AS B ON A.PRODUCT_ID = B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC,A.PRODUCT_ID;