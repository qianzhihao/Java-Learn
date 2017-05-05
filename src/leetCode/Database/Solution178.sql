-- Rank Scores
-- Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.
--+----+-------+
--| Id | Score |
--+----+-------+
--| 1  | 3.50  |
--| 2  | 3.65  |
--| 3  | 4.00  |
--| 4  | 3.85  |
--| 5  | 4.00  |
--| 6  | 3.65  |
--+----+-------+
-- For example, given the above Scores table, your query should generate the following report(order by highest score); 
--+-------+------+
--| Score | Rank |
--+-------+------+
--| 4.00  | 1    |
--| 4.00  | 1    |
--| 3.85  | 2    |
--| 3.65  | 3    |
--| 3.65  | 3    |
--| 3.50  | 4    |
--+-------+------+

-- 1
select Score.Score, count(Ranking.Score) as Rank
	from Scores, 
	(select distinct Score
		from Scores
	) Ranking
	where Scores.Score <= Ranking.Score
	group by Scores.Id, Scores.Score
	order by Scores.Score desc;
	
-- 2
select
Score,
@rank := @rank + (@prev <> (@prev := Score)) Rank
from
Scores,
(select @rank := 0, @prev := -1) init
order by Score desc

-- 3
select
Score,
(select count(distinct Score) from Scores where Score >= s.Score) Rank
from Scores s
order by Score desc

-- 4
select
Score,
(select count(*) from (select distinct Score s from Scores) tmp where s >= Score) Rank
from Scores
order by Score desc

-- 5
select s.Score, count(distinct t.score) Rank
from Scores s join Scores t on s.Score <= t.score
group by s.Id
order by s.Score desc
	
	
	
	
	
	
	
	