OneQuery:
DELETE e1 FROM EMPLOYEE e1, EMPLOYEE e2 WHERE e1.name = e2.name AND e1.id > e2.id;
1. Using rowid

SQL > delete from emp
where rowid not in
(select max(rowid) from emp group by empno);

This technique can be applied to almost scenarios. Group by operation should be on the columns which identify the duplicates.

2. Using self-join

SQL > delete from emp e1
where rowid not in
(select max(rowid) from emp e2
where e1.empno = e2.empno );

3. Using row_number()

SQL > delete from emp where rowid in
(
select rid from
(
select rowid rid,
row_number() over(partition by empno order by empno) rn
from emp
)
where rn > 1
);

This is another efficient way to delete duplicates

4. Using dense_rank()

SQL > delete from emp where rowid in
(
select rid from
(
select rowid rid,
dense_rank() over(partition by empno order by rowid) rn
from emp
)
where rn > 1
);

Here you can use both rank() and dens_rank() since both will give unique records when order by rowid.

5. Using group by

Consider the EMP table with below rows

10    Bill    2000
11    Bill    2000
12    Mark    3000
13    Mark    3000

SQL > delete from emp where
(empno,empname,salary) in
(
select max(empno),empname,salary from emp
group by empname,salary
);