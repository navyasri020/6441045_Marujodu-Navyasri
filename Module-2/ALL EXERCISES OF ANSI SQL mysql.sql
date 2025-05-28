1. User Upcoming Events:
SELECT u.name, ev.name AS event_name, ev.date_start
FROM UserProfiles u
JOIN EventRegistrations er ON u.id = er.user_id
JOIN EventList ev ON er.event_id = ev.id
WHERE ev.status = 'upcoming' AND u.location = ev.location
ORDER BY ev.date_start;

2. Top Rated Events:
SELECT ev.name, AVG(fb.score) AS average_score, COUNT(*) AS feedback_total
FROM EventFeedback fb
JOIN EventList ev ON fb.event_id = ev.id
GROUP BY ev.id
HAVING COUNT(*) >= 10
ORDER BY average_score DESC;

3. Inactive Users (no registrations in last 90 days):
SELECT * FROM UserProfiles
WHERE id NOT IN (
  SELECT user_id FROM EventRegistrations
  WHERE created_at >= CURRENT_DATE - INTERVAL 90 DAY
);

4. Peak Session Hours (10 AM to 12 PM):
SELECT ev.name, COUNT(*) AS total_sessions
FROM EventSchedule s
JOIN EventList ev ON s.event_id = ev.id
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '11:59:59'
GROUP BY s.event_id;

5. Most Active Cities:
SELECT up.location, COUNT(DISTINCT er.user_id) AS user_count
FROM UserProfiles up
JOIN EventRegistrations er ON up.id = er.user_id
GROUP BY up.location
ORDER BY user_count DESC
LIMIT 5;

6. Event Resource Summary:
SELECT ev.name,
       SUM(r.type = 'pdf') AS total_pdfs,
       SUM(r.type = 'image') AS total_images,
       SUM(r.type = 'link') AS total_links
FROM EventAssets r
JOIN EventList ev ON r.event_id = ev.id
GROUP BY r.event_id;

7. Low Feedback Alerts:
SELECT up.name, ev.name AS event_name, fb.score, fb.notes
FROM EventFeedback fb
JOIN UserProfiles up ON fb.user_id = up.id
JOIN EventList ev ON fb.event_id = ev.id
WHERE fb.score < 3;

8. Sessions per Upcoming Event:
SELECT ev.name, COUNT(s.id) AS session_total
FROM EventList ev
LEFT JOIN EventSchedule s ON ev.id = s.event_id
WHERE ev.status = 'upcoming'
GROUP BY ev.id;

9. Organizer Event Summary:
SELECT up.name, ev.status, COUNT(*) AS total_events
FROM EventList ev
JOIN UserProfiles up ON ev.host_id = up.id
GROUP BY up.id, ev.status;

10. Feedback Gap:
SELECT DISTINCT ev.name
FROM EventList ev
JOIN EventRegistrations er ON ev.id = er.event_id
WHERE ev.id NOT IN (
  SELECT DISTINCT event_id FROM EventFeedback
);

11. Daily New User Count (last 7 days):
SELECT created_at, COUNT(*) AS new_users
FROM UserProfiles
WHERE created_at >= CURRENT_DATE - INTERVAL 7 DAY
GROUP BY created_at;

12. Event with Maximum Sessions:
SELECT ev.name, COUNT(s.id) AS session_count
FROM EventList ev
JOIN EventSchedule s ON ev.id = s.event_id
GROUP BY ev.id
HAVING session_count = (
  SELECT MAX(session_total)
  FROM (
    SELECT COUNT(*) AS session_total
    FROM EventSchedule
    GROUP BY event_id
  ) AS subq
);

13. Average Rating per City:
SELECT ev.location, AVG(fb.score) AS avg_score
FROM EventFeedback fb
JOIN EventList ev ON fb.event_id = ev.id
GROUP BY ev.location;

14. Most Registered Events:
SELECT ev.name, COUNT(er.user_id) AS total_signups
FROM EventList ev
JOIN EventRegistrations er ON ev.id = er.event_id
GROUP BY ev.id
ORDER BY total_signups DESC
LIMIT 3;

15. Event Session Time Conflict:
SELECT s1.event_id, s1.id AS session1, s2.id AS session2
FROM EventSchedule s1
JOIN EventSchedule s2 ON s1.event_id = s2.event_id
AND s1.id < s2.id
AND s1.end_time > s2.start_time AND s1.start_time < s2.end_time;

16. Unregistered Active Users:
SELECT * FROM UserProfiles
WHERE created_at >= CURRENT_DATE - INTERVAL 30 DAY
AND id NOT IN (SELECT user_id FROM EventRegistrations);

17. Multi-Session Speakers:
SELECT speaker, COUNT(*) AS sessions_hosted
FROM EventSchedule
GROUP BY speaker
HAVING sessions_hosted > 1;

18. Events Without Resources:
SELECT name
FROM EventList
WHERE id NOT IN (SELECT DISTINCT event_id FROM EventAssets);

19. Completed Events with Feedback Summary:
SELECT ev.name, COUNT(DISTINCT er.user_id) AS attendees,
       AVG(fb.score) AS avg_feedback
FROM EventList ev
LEFT JOIN EventRegistrations er ON ev.id = er.event_id
LEFT JOIN EventFeedback fb ON ev.id = fb.event_id
WHERE ev.status = 'completed'
GROUP BY ev.id;

20. User Engagement Index:
SELECT up.name,
       COUNT(DISTINCT er.event_id) AS attended,
       COUNT(DISTINCT fb.id) AS feedbacks
FROM UserProfiles up
LEFT JOIN EventRegistrations er ON up.id = er.user_id
LEFT JOIN EventFeedback fb ON up.id = fb.user_id
GROUP BY up.id;

21. Top Feedback Providers:
SELECT up.name, COUNT(fb.id) AS total_feedbacks
FROM EventFeedback fb
JOIN UserProfiles up ON fb.user_id = up.id
GROUP BY up.id
ORDER BY total_feedbacks DESC
LIMIT 5;

22. Duplicate Registrations Check:
SELECT user_id, event_id, COUNT(*) AS reg_count
FROM EventRegistrations
GROUP BY user_id, event_id
HAVING reg_count > 1;

23. Registration Trends (Monthly for last 12 months):
SELECT DATE_FORMAT(created_at, '%Y-%m') AS reg_month,
       COUNT(*) AS registrations
FROM EventRegistrations
WHERE created_at >= CURRENT_DATE - INTERVAL 12 MONTH
GROUP BY reg_month
ORDER BY reg_month;

24. Average Session Duration per Event:
SELECT ev.name, 
       AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS avg_minutes
FROM EventList ev
JOIN EventSchedule s ON ev.id = s.event_id
GROUP BY ev.id;

25. Events Without Sessions:
SELECT name
FROM EventList
WHERE id NOT IN (SELECT DISTINCT event_id FROM EventSchedule);

