create database studentSystem;

use studentSystem;
--dept 表 
create table dept(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`dept_id` varchar(20) NOT NULL PRIMARY KEY,
	`name` varchar(20) NOT NULL unique,
	`place` varchar(255) NOT NULL,
	`size` int NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;






--major 表
create table major(
	`id` bigint UNSIGNED AUTO_INCREMENT NOT NULL unique,
	`major_id` varchar(20) NOT NULL PRIMARY KEY,
	`name` varchar (20)  NOT NULL,
	`dept_id` varchar(20) NOT NULL,
	foreign key(dept_id) references dept(dept_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


--class 表
create table class(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`class_id` varchar(20) NOT NULL PRIMARY KEY,
	`year_of_enrollment` int NOT NULL,
	`size` int NOT NULL,
	`major_id` varchar(20) NOT NULL,
	foreign key(major_id) references major(major_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



--student 表
create table student(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`student_id` varchar(20) NOT NULL PRIMARY KEY,
	`name` varchar(100) DEFAULT NULL,
	`age` int DEFAULT NULL,
	`class_id` varchar(20) NOT NULL,
	foreign key(class_id) references class(class_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



--stu_union 表
create table stu_union(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`stu_union_id` varchar(20) NOT NULL PRIMARY KEY,
	`name` varchar(20) NOT NULL unique,
	`established_year` int NOT NULL,
	`place` varchar(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;




--sjoin 表
create table sjoin(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`u_id` varchar(20) NOT NULL references stu_union(stu_union_id),
	`s_id` varchar(20) NOT NULL references student(student_id),
	`join_year` int NOT NULL,
	primary key ( u_id , s_id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;




--dormitory 表
create table dormitory(
	`id` bigint UNSIGNED NOT NULL AUTO_INCREMENT unique,
	`dormitory_id` varchar(20) PRIMARY KEY references dept(dept_id),
	`place` varchar(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



//视图
create view uname_utotal ( Uname, Utotal )
as
select name , count(*)
from stu_union , sjoin
where stu_union.stu_union_id=sjoin.u_id
group by stu_union.stu_union_id;



//触发器
CREATE TRIGGER INC AFTER INSERT
ON STUDENT FOR EACH ROW
BEGIN
UPDATE class SET size = size + 1 WHERE class_id = new.class_id;
UPDATE dept SET size = size + 1 WHERE dept_id = (SELECT dept_id FROM major WHERE major_id = (SELECT major_id FROM class WHERE class_id = new.class_id));
END

CREATE TRIGGER DECC AFTER DELETE
ON STUDENT
FOR EACH ROW
BEGIN
UPDATE class SET size = size - 1 WHERE class_id = old.class_id;
UPDATE dept SET size = size - 1 WHERE dept_id = (SELECT dept_id FROM major WHERE major_id = (SELECT major_id FROM class WHERE class_id = old.class_id));
END



//函数
CREATE DEFINER=`root`@`localhost` FUNCTION `change_classid`(`old_id` varchar(20),`new_id` varchar(20)) RETURNS int
BEGIN
	update class set class_id = new_id where class_id = old_id;
	RETURN (SELECT count(*) from student where class_id = new_id);
END



//游标存储过程
create
    definer = root@localhost procedure pro()
BEGIN
	
	DECLARE dept_size INT DEFAULT 0 ;
	DECLARE major_size INT DEFAULT 0;

  

  DECLARE var_deptid VARCHAR (20) DEFAULT NULL ;
  DECLARE var_name VARCHAR (20) DEFAULT NULL ;
	DECLARE unsize INT DEFAULT 0 ;
	DECLARE deptdone INT DEFAULT FALSE;
	
	
  DECLARE realsize INT DEFAULT 0 ;
  
  DECLARE deptcur CURSOR FOR SELECT dept_id AS var_deptid, dept.`name` as var_name, size as unsize FROM dept;
	
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET deptdone=TRUE;
  OPEN deptcur;  
	
	FETCH  deptcur into var_deptid, var_name, unsize; 
  
  WHILE NOT deptdone DO  
  
	
	       BEGIN
				 DECLARE var_size INT  DEFAULT 0;
		     DECLARE var_majorid VARCHAR (20) DEFAULT NULL ;
				 DECLARE majordone INT DEFAULT FALSE;
				 
		     DECLARE majorcur CURSOR FOR SELECT major_id AS var_majorid, dept_id AS var_deptid FROM major WHERE dept_id COLLATE utf8mb4_general_ci = var_deptid;
		     DECLARE CONTINUE HANDLER FOR NOT FOUND SET majordone=TRUE;
				 SET dept_size = 0;
         OPEN majorcur;  
				 
				 FETCH  majorcur into var_majorid, var_deptid;
         
         WHILE NOT majordone DO  
				 
				       BEGIN
		           DECLARE var_classid VARCHAR (20) DEFAULT NULL ;
							 DECLARE class_size INT  DEFAULT 0;
							 DECLARE classdone INT DEFAULT FALSE;
							 
		           DECLARE classcur CURSOR FOR SELECT class_id AS var_classid FROM class WHERE major_id COLLATE utf8mb4_general_ci = var_majorid;
		           DECLARE CONTINUE HANDLER FOR NOT FOUND SET classdone=TRUE;
							 SET major_size = 0;
               OPEN classcur;  
							 
               FETCH  classcur into var_classid;  
               
               WHILE NOT classdone DO
				           
							     SET var_size = (SELECT count(*) FROM student where class_id COLLATE utf8mb4_general_ci = var_classid);

							     
							     SET major_size = major_size + var_size;
							 
               FETCH  classcur into var_classid;  
				       END WHILE;  
               
               CLOSE classcur; 
		           END;
				 
				 
				 SET dept_size = dept_size + major_size;
				 FETCH  majorcur into var_majorid, var_deptid; 
				 END WHILE;  
          
         CLOSE majorcur; 
		     END;
				 
		 
		 
		 
		 
      IF unsize != dept_size THEN 
			UPDATE dept SET size = dept_size where dept_id COLLATE utf8mb4_general_ci   = var_deptid;
			SELECT dept_id, dept.`name`, size FROM dept WHERE dept_id  COLLATE utf8mb4_general_ci = var_deptid;
			SELECT unsize;
		  END IF;
     FETCH  deptcur into var_deptid, var_name, unsize; 
 END WHILE;  
  
  CLOSE deptcur;  

END;