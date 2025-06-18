INSERT INTO users (username, password) VALUES 
('sample1', '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC'),
('sample2', '$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC');

INSERT INTO todos (task, deadline, category, start_time, end_time, place, memo, isTodoflag,user_id) VALUES
('メールの返信','2023-12-31', '仕事', '12:00' , '14:00', '横浜オフィス', '15:00までに返信', TRUE, 1),
('健康診断の予約','2024-1-1', 'プライベート', '12:00' , '14:00', '東京オフィス', '15:00までに返信', FALSE, 2);