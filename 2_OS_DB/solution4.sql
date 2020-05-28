use sakila;

-- 1
select f.title, count(fa.actor_id)
from film as f
join film_actor as fa
on f.film_id = fa.film_id
group by f.title ;

-- 2
select * 
from film
where title like "%Impossible%";

select * 
from film
where title = "Hunchback Impossible";

select f.title, count(*) as cnt
from film as f
join inventory as i
on f.film_id = i.film_id
where f.title = "Hunchback Impossible";


-- 3
select c.first_name, c.last_name, sum( ifnull(amount,0) ) as amount
from customer as c
join payment as p
on c.customer_id = p.customer_id
group by c.first_name, c.last_name;

-- 4
select c.first_name, c.last_name, ifnull(c.email, "No Email")
from customer as c
join address as a
on c.address_id = a.address_id
join city as ct
on a.city_id = ct.city_id
join country as co
on ct.country_id = co.country_id
where co.country = "Canada";

-- 5
select f.title
from film as f
join film_category as fc
on f.film_id = fc.film_id
join category as ca
on fc.category_id = ca.category_id
where ca.name = "Family";










