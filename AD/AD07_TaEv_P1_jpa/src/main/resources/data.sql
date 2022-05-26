--delete from categoria where id=1;
--delete from producto where id=1;



insert into categoria (id, nombre) values (1,'Apple');
insert into categoria (id, nombre) values (2,'Huawei');

insert into producto (nombre, descripcion, precio,categoria_id) values ('Iphone 13 Pro','146,7x71,5x7,65 mm 204 gramos', '1000 €', 1);
insert into producto (nombre, descripcion, precio,categoria_id) values ('Iphone 12','137,7x61,5x5,55 mm 187 gramos', '890 €', 1);
insert into producto (nombre, descripcion, precio,categoria_id) values ('P30 lite','107,2x61,4x5,63 mm 188 gramos', '120 €', 2);
insert into producto (nombre, descripcion, precio,categoria_id) values ('P30 Pro','107,2x61,4x5,63 mm 188 gramos', '75 €', 2);