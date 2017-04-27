--175. Combine Two Tables
--Table: Person
--
--+-------------+---------+
--| Column Name | Type   |
--+-------------+---------+
--| PersonId    | int     |
--| FirstName   | varchar |
--| LastName    | varchar |
--+-------------+---------+
--PersonId is the primary key column for this table.
--
--Table: Address
--+-------------+---------+
--| Column Name | Type    |
--+-------------+---------+
--| AddressId  | int     |
--| PersonId   | int     |
--| City        | varchar|
--| State       | varchar |
--+-------------+---------+
--AddressId is the primary key column for this table.
--
--Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:
--
--FirstName, LastName, City, State

-- Basic left join 左连接 left join ，是以左表的主键为主一一匹配进行连接
SELECT Person.FirstName, Person.LastName, Address.City, Address.State 
FROM Person 
LEFT JOIN Address 
ON Person.PersonId = Address.PersonId;

-- left join + using: 907ms
SELECT FirstName, LastName, City, State
FROM Person
LEFT JOIN Address
USING(PersonId);

-- natural left join: 940ms
SELECT FirstName, LastName, City, State
FROM Person
NATURAL LEFT JOIN Address;

--综上，左连接 left join 的方式耗时最短，为最优查询