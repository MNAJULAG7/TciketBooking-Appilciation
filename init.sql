-- 1. Create databases
CREATE DATABASE IF NOT EXISTS user_service_db;
CREATE DATABASE IF NOT EXISTS event_service_db;
CREATE DATABASE IF NOT EXISTS seat_service_db;
CREATE DATABASE IF NOT EXISTS payment_service_db;
CREATE DATABASE IF NOT EXISTS booking_service_db;

-- 2. Drop user first (important fix)
DROP USER IF EXISTS 'manju'@'%';

-- 3. Create user again
CREATE USER 'manju'@'%' IDENTIFIED BY 'manju';

-- 4. Grant privileges
GRANT ALL PRIVILEGES ON user_service_db.* TO 'manju'@'%';
GRANT ALL PRIVILEGES ON event_service_db.* TO 'manju'@'%';
GRANT ALL PRIVILEGES ON seat_service_db.* TO 'manju'@'%';
GRANT ALL PRIVILEGES ON payment_service_db.* TO 'manju'@'%';
GRANT ALL PRIVILEGES ON booking_service_db.* TO 'manju'@'%';
-- 5. Apply changes
FLUSH PRIVILEGES