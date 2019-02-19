CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) UNIQUE,
  created_at TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE role (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) UNIQUE,
  created_at TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE user_role (
  user_id INTEGER REFERENCES "user" (id),
  role_id INTEGER REFERENCES role (id)
);