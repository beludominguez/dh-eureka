create database dh;
CREATE TABLE `movie` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `genre` varchar(255) DEFAULT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `url_stream` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO movie(name, genre, url_stream) VALUES('Dark Shadows', 'Terror', 'https://www.netflix.com/title/70217909');
INSERT INTO movie(name, genre, url_stream) VALUES('Gremlins', 'Terror', 'https://www.netflix.com/title/562050');
INSERT INTO movie(name, genre, url_stream) VALUES('Minions', 'Comedy', 'https://www.netflix.com/title/80033394');
INSERT INTO movie(name, genre, url_stream) VALUES('World War Z', 'Terror', 'https://www.netflix.com/title/70262639');
INSERT INTO movie(name, genre, url_stream) VALUES('Kung-fu Panda', 'Comedy', 'https://www.netflix.com/title/70075480');
INSERT INTO movie(name, genre, url_stream) VALUES('Pacific Rim', 'Action', 'https://www.netflix.com/title/70267241');
INSERT INTO movie(name, genre, url_stream) VALUES('The Old Guard', 'Action', 'https://www.netflix.com/title/81038963');
INSERT INTO movie(name, genre, url_stream) VALUES('Pride & Prejudice', 'Romance', 'https://www.netflix.com/title/70032594');
