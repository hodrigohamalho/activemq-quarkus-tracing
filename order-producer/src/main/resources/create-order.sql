drop table if exists orders;

create table orders (
  id INTEGER IDENTITY PRIMARY KEY,
  item varchar(100),
  amount integer,
  description varchar(100),
  processed boolean
);

INSERT INTO orders values(0, 'Ansible', 10, 'ansible product', true);
INSERT INTO orders values(1, 'Openshift', 10, 'Openshift product', true);
INSERT INTO orders values(2, 'Fuse', 10, 'Fuse product', true);
INSERT INTO orders values(3, 'Data virtualization', 10, 'Data virtualization product', true);
INSERT INTO orders values(4, 'BPM Suite', 10, 'BPM Suite product', true);
INSERT INTO orders values(5, '3Scale', 10, '3Scale product', true);
INSERT INTO orders values(6, 'RHSSO', 10, 'RHSSO product', true);
INSERT INTO orders values(7, 'Satellite', 10, 'Satellite product', true);
INSERT INTO orders values(8, 'Cloudforms', 10, 'Cloudforms product', true);
INSERT INTO orders values(9, 'Gluster', 10, 'Gluster product', true);
INSERT INTO orders values(10, 'Ceph', 10, 'Ceph product', true);