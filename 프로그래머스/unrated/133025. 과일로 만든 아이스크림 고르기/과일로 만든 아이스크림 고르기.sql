-- 코드를 입력하세요
SELECT F.FLAVOR
FROM FIRST_HALF AS F, ICECREAM_INFO AS I
WHERE F.FLAVOR = I.FLAVOR AND I.INGREDIENT_TYPE LIKE "%fruit%" AND F.TOTAL_ORDER > 3000
ORDER BY F.TOTAL_ORDER DESC;