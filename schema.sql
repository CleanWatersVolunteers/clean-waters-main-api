-- Table pollution
CREATE TABLE IF NOT EXISTS pollution
(
    id                 BIGSERIAL PRIMARY KEY,
    longitude          VARCHAR(45)  NOT NULL,
    latitude           VARCHAR(45)  NOT NULL,
    comment            TEXT,
    old_data_container TEXT,
    status             VARCHAR(45)  NOT NULL,
    info_source        VARCHAR(255) NOT NULL,
    discovered_at      TIMESTAMP    NOT NULL,
    created_at         TIMESTAMP    NOT NULL,
    updated_at         TIMESTAMP,
    deleted_at         TIMESTAMP
);

-- Table pollution_type
CREATE TABLE IF NOT EXISTS pollution_type
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

-- Table pick_up_point
CREATE TABLE IF NOT EXISTS pick_up_point
(
    id            BIGSERIAL PRIMARY KEY,
    pollution_id  BIGINT       NOT NULL,
    longitude     VARCHAR(45)  NOT NULL,
    latitude      VARCHAR(45)  NOT NULL,
    comment       TEXT,
    status        VARCHAR(45)  NOT NULL,
    info_source   VARCHAR(255) NOT NULL,
    discovered_at TIMESTAMP,
    created_at    TIMESTAMP    NOT NULL,
    updated_at    TIMESTAMP,
    deleted_at    TIMESTAMP,
    CONSTRAINT fk_pick_up_point_pollution FOREIGN KEY (pollution_id)
        REFERENCES pollution (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table bird
CREATE TABLE IF NOT EXISTS bird
(
    id            BIGSERIAL PRIMARY KEY,
    longitude     VARCHAR(45)  NOT NULL,
    latitude      VARCHAR(45)  NOT NULL,
    status        VARCHAR(45)  NOT NULL,
    priority      INT,
    pollution_id  BIGINT,
    info_source   VARCHAR(255) NOT NULL,
    discovered_at TIMESTAMP,
    created_at    TIMESTAMP,
    updated_at    TIMESTAMP,
    deleted_at    TIMESTAMP,
    captured      BOOLEAN      NOT NULL,
    CONSTRAINT fk_bird_pollution FOREIGN KEY (pollution_id)
        REFERENCES pollution (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table pollution_type_pollution
CREATE TABLE IF NOT EXISTS pollution_type_pollution
(
    pollution_type_id BIGINT NOT NULL,
    pollution_id      BIGINT NOT NULL,
    PRIMARY KEY (pollution_type_id, pollution_id),
    CONSTRAINT fk_pollution_type_pollution_type FOREIGN KEY (pollution_type_id)
        REFERENCES pollution_type (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_pollution_type_pollution FOREIGN KEY (pollution_id)
        REFERENCES pollution (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table media
CREATE TABLE IF NOT EXISTS media
(
    id          BIGSERIAL PRIMARY KEY,
    object_key  VARCHAR(500) NOT NULL,
    bucket_name VARCHAR(255) NOT NULL,
    mime_type   VARCHAR(45)  NOT NULL,
    created_at  TIMESTAMP    NOT NULL
);

-- Table pollution_media
CREATE TABLE IF NOT EXISTS pollution_media
(
    pollution_id BIGINT NOT NULL,
    media_id     BIGINT NOT NULL,
    PRIMARY KEY (pollution_id, media_id),
    CONSTRAINT fk_pollution_media_pollution FOREIGN KEY (pollution_id)
        REFERENCES pollution (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_pollution_media_media FOREIGN KEY (media_id)
        REFERENCES media (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table pick_up_point_media
CREATE TABLE IF NOT EXISTS pick_up_point_media
(
    pick_up_point_id BIGINT NOT NULL,
    media_id         BIGINT NOT NULL,
    PRIMARY KEY (pick_up_point_id, media_id),
    CONSTRAINT fk_pick_up_point_media_pick_up_point FOREIGN KEY (pick_up_point_id)
        REFERENCES pick_up_point (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_pick_up_point_media_media FOREIGN KEY (media_id)
        REFERENCES media (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Table bird_has_media
CREATE TABLE IF NOT EXISTS bird_media
(
    bird_id  BIGINT NOT NULL,
    media_id BIGINT NOT NULL,
    PRIMARY KEY (bird_id, media_id),
    CONSTRAINT fk_bird_media_bird FOREIGN KEY (bird_id)
        REFERENCES bird (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_bird_media_media FOREIGN KEY (media_id)
        REFERENCES media (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);