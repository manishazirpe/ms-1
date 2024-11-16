CREATE TABLE Student (
    Rollno SERIAL PRIMARY KEY,  -- Primary Key
    sname VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    class VARCHAR(10) NOT NULL
);

INSERT INTO Student (sname, address, class) VALUES
('Alice', '123 Main St', '10A'),
('Bob', '456 Elm St', '10B');

select * from Student;

CREATE TABLE Subject (
    Scode VARCHAR(10) PRIMARY KEY,  -- Primary Key
    subject_name VARCHAR(20) NOT NULL
);
INSERT INTO Subject (Scode, subject_name) VALUES
('MATH101', 'Mathematics'),
('PHY101', 'Physics');
select * from Subject;

CREATE TABLE Marks (
    Rollno INTEGER REFERENCES Student(Rollno) ON DELETE CASCADE,  -- Foreign Key to Student table
    Scode VARCHAR(10) REFERENCES Subject(Scode) ON DELETE CASCADE,  -- Foreign Key to Subject table
    marks_scored INTEGER CHECK (marks_scored >= 0 AND marks_scored <= 100),  -- Valid marks range
    PRIMARY KEY (Rollno, Scode)  -- Composite Primary Key for many-to-many relationship
);
INSERT INTO Marks (Rollno, Scode, marks_scored) VALUES
(1, 'MATH101', 95),
(1, 'PHY101', 89),
(2, 'MATH101', 88),
(2, 'CHEM101', 78),
(3, 'PHY101', 92);
select * from Marks;

*** Relation many_to_many***

Query 1: Retrieve All Students with Their Subjects and Marks
SELECT 
    Student.sname AS Student_Name, 
    Subject.subject_name AS Subject_Name, 
    Marks.marks_scored AS Marks
FROM 
    Marks
JOIN 
    Student ON Marks.Rollno = Student.Rollno
JOIN 
    Subject ON Marks.Scode = Subject.Scode;

Query 2: Find Students Who Scored Above 90 in Any Subject
SELECT 
    Student.sname AS Student_Name, 
    Subject.subject_name AS Subject_Name, 
    Marks.marks_scored AS Marks
FROM 
    Marks
JOIN 
    Student ON Marks.Rollno = Student.Rollno
JOIN 
    Subject ON Marks.Scode = Subject.Scode
WHERE 
    Marks.marks_scored > 90;


Query 3: List All Subjects Taken by a Specific Student (e.g., Alice)
sql
Copy code
SELECT 
    Subject.subject_name AS Subject_Name, 
    Marks.marks_scored AS Marks
FROM 
    Marks
JOIN 
    Subject ON Marks.Scode = Subject.Scode
WHERE 
    Marks.Rollno = 1;  -- Rollno for Alice

Using above database solve the following questions. 
A. Create a View
 1. To display student names of class ‘FYMScCA’
 CREATE VIEW FYMScCA_Students AS
SELECT sname 
FROM Student
WHERE class = 'FYMScCA';

-- Query to display data from the view
SELECT * FROM FYMScCA_Students;

2.View to Display Students, Subjects, and Marks with Scores Above 90:
 CREATE VIEW High_Scores AS
SELECT 
    Student.sname AS Student_Name,
    Subject.subject_name AS Subject,
    Marks.marks_scored AS Marks
FROM 
    Marks
JOIN 
    Student ON Marks.Rollno = Student.Rollno
JOIN 
    Subject ON Marks.Scode = Subject.Scode
WHERE 
    Marks.marks_scored > 90;

-- Query to display data from the view
SELECT * FROM High_Scores;

B. Function Using Cursor to Calculate Total Marks of Each Student
 -- Function to Calculate Total Marks for Each Student
CREATE OR REPLACE FUNCTION Calculate_Total_Marks()
RETURNS TABLE (Student_Name VARCHAR, Total_Marks INTEGER) AS $$
DECLARE
    student_record RECORD;
    total_marks INTEGER;
BEGIN
    FOR student_record IN SELECT Rollno, sname FROM Student LOOP
        -- Calculate total marks for the current student
        SELECT SUM(marks_scored) INTO total_marks 
        FROM Marks 
        WHERE Rollno = student_record.Rollno;

        -- Return the student's name and total marks
        RETURN QUERY SELECT student_record.sname, total_marks;
    END LOOP;
END;
$$ LANGUAGE plpgsql;

-- Query to call the function
SELECT * FROM Calculate_Total_Marks();






