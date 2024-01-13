-- 코드를 입력하세요
# SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(HISTORY_ID) RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE CAR_ID IN (SELECT CAR_ID
#                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                     WHERE MONTH(START_DATE) >= 8 AND MONTH(END_DATE) <= 10
#                     GROUP BY CAR_ID
#                     HAVING COUNT(HISTORY_ID) >= 5
#                     )
# GROUP BY MONTH, CAR_ID
# HAVING RECORDS > 0
# ORDER BY MONTH ASC,CAR_ID DESC;

SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) >= 8 AND MONTH(START_DATE) <= 10 AND CAR_ID IN (SELECT CAR_ID
                                                                       FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                                       WHERE MONTH(START_DATE) >= 8 AND MONTH(START_DATE) <= 10
                                                                       GROUP BY CAR_ID
                                                                       HAVING COUNT(HISTORY_ID) >= 5)
GROUP BY MONTH, CAR_ID
HAVING RECORDS > 0
ORDER BY MONTH ASC, CAR_ID DESC;