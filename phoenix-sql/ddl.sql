CREATE TABLE IF NOT EXISTS CROWD_ITEM (
     crowd_id VARCHAR,
     serial_number VARCHAR,
     account_id VARCHAR,
     buy_user_id VARCHAR,
     mobile_phone VARCHAR,
     CONSTRAINT PK PRIMARY KEY (crowd_id, account_id)
);