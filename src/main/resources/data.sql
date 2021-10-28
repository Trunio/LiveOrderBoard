DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS orders;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(255) not null
);

CREATE TABLE orders(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user INT NOT NULL,
  quantity INT NOT NULL,
  price DECIMAl(10,2) NOT NULL,
  type ENUM('BUY','SELL') NOT NULL,
  constraint fk_user_orders foreign key (id_user) references user(id)
);


INSERT INTO user (username) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');

INSERT INTO orders (id_user, quantity, price, type) VALUES
('1','100','10','BUY'),
('1','50','10','SELL'),
('1','100','10','BUY'),
('1','100','20','SELL');
