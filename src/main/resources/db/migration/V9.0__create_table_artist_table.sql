CREATE TABLE artist(
  naam VARCHAR(255) NOT NULL,
  genre ENUM('HIPHOP','RandB'),
  CONSTRAINT pk_artist PRIMARY KEY(naam)
);