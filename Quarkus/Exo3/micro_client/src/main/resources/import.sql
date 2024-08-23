DELETE FROM CLIENT;
INSERT INTO Client (name, email, telephone) VALUES ('Alexandre', 'test@mail.com','06-XX-XX-XX-XX');
ALTER TABLE Client ALTER COLUMN id RESTART WITH 2;