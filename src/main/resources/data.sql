INSERT INTO Books ( title, author, puplish_year, isbn) VALUES
( 'The Catcher in the Rye', 'J.D. Salinger', 1951, '978-0-316-76948-0'),
( 'To Kill a Mockingbird', 'Harper Lee', 1960, '978-0-06-112008-4'),
( '1984', 'George Orwell', 1949, '978-0-452-28423-4'),
( 'Pride and Prejudice', 'Jane Austen', 1813, '978-0-19-953556-9'),
( 'The Great Gatsby', 'F. Scott Fitzgerald', 1925, '978-0-7432-7356-5');


INSERT INTO patron (name, mobile_number, email, address) VALUES
('John Doe', '123-456-7890', 'johndoe@example.com', '123 Elm Street, Springfield, IL'),
('Jane Smith', '234-567-8901', 'janesmith@example.com', '456 Oak Avenue, Metropolis, IL'),
('Alice Johnson', '345-678-9012', 'alicejohnson@example.com', '789 Maple Drive, Gotham, NY'),
('Bob Brown', '456-789-0123', 'bobbrown@example.com', '101 Pine Road, Star City, CA'),
('Charlie Davis', '567-890-1234', 'charliedavis@example.com', '202 Cedar Lane, Central City, FL');



--INSERT INTO borrowing_details (patron_id, book_id, borrowing_date, return_date)
--VALUES (1, 2, '2024-08-10 14:30:00', '2024-08-20 14:30:00');
--
--INSERT INTO borrowing_details (patron_id, book_id, borrowing_date, return_date)
--VALUES (2, 3, '2024-08-12 09:00:00', '2024-08-22 09:00:00');
--
--INSERT INTO borrowing_details (patron_id, book_id, borrowing_date, return_date)
--VALUES (3, 1, '2024-08-14 16:45:00', '2024-08-23 09:00:00');
--
--INSERT INTO borrowing_details (patron_id, book_id, borrowing_date, return_date)
--VALUES (4, 2, '2024-08-15 11:15:00', '2024-08-25 11:15:00');
--
--INSERT INTO borrowing_details (patron_id, book_id, borrowing_date, return_date)
--VALUES (5, 3, '2024-08-16 08:30:00', '2024-08-25 09:00:00');


INSERT INTO Users (PASSWORD, USERNAME, ROLE) VALUES ('password123', 'elnouby', 'ADMIN');
INSERT INTO Users (PASSWORD, USERNAME, ROLE) VALUES ('secretpass', 'zuksh', 'USER');
INSERT INTO Users (PASSWORD, USERNAME, ROLE) VALUES ('mypassword', 'alice_smith', 'USER');
INSERT INTO Users (PASSWORD, USERNAME, ROLE) VALUES ('pass456', 'bob_jones', 'ADMIN');
