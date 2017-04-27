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

--左连接 left join ，是以左表的主键为主一一匹配进行连接
select Person.FirstName, Person.LastName, Address.City, Address.State from Person left join Address on Person.PersonId = Address.PersonId;
 