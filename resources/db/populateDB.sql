INSERT INTO group (name)
VALUES
	('A-1'),
	('B-1'),
	('C-1'),
	('D-1'),
	('E-1');

INSERT INTO student (enrolment_date, first_name, last_name, email, phone_number, group_id)
VALUES
	('2000-12-22', 'A', 'AAA', 'a@a.com', '111111', 2),
	('2000-12-20', 'B', 'BBB', 'b@b.com', '222222', 5),
	('2000-11-03', 'C', 'CCC', 'c@c.com', '333333', 1),
	('2000-11-04', 'D', 'DDD', 'd@d.com', '777777', 2),
	('2000-11-05', 'E', 'EEE', 'e@e.com', '444444', 1),
	('2000-11-06', 'F', 'FFF', 'f@f.com', '555555', 3),
	('2000-11-07', 'G', 'GGG', 'g@g.com', '666666', 4),
	('2000-11-07', 'H', 'HHH', 'h@h.com', '777777', 1),
	('2000-11-04', 'I', 'III', 'i@i.com', '888888', 5);
