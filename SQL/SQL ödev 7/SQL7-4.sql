SELECT  country_id, COUNT(city) FROM city
GROUP BY country_id 
ORDER BY COUNT(city_id) DESC
LIMIT 1 ;