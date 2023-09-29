CREATE TABLE IF NOT EXISTS Content(
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    url VARCHAR(255),
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO Content (title, description, status, content_type, date_created)
VALUES ('Test Title', 'Test Description', 'DRAFT', 'ARTICLE', CURRENT_TIMESTAMP);