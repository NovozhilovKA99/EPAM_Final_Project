start transaction;
insert into Model (description, Type_id) values("TestModel1 type:1",1);
insert into Model (description, Type_id) values("TestModel2 type:1",1);
insert into Model (description, Type_id) values("TestModel3 type:1",1);

insert into Model (description, Type_id) values("TestModel1 type:2",2);
insert into Model (description, Type_id) values("TestModel2 type:2",2);
insert into Model (description, Type_id) values("TestModel3 type:2",2);

insert into Model (description, Type_id) values("TestModel1 type:3",3);
insert into Model (description, Type_id) values("TestModel2 type:3",3);
insert into Model (description, Type_id) values("TestModel3 type:3",3);

insert into Model (description, Type_id) values("TestModel1 type:4",4);
insert into Model (description, Type_id) values("TestModel2 type:4",4);
insert into Model (description, Type_id) values("TestModel3 type:4",4);

insert into Model (description, Type_id) values("TestModel1 type:5",5);
insert into Model (description, Type_id) values("TestModel2 type:5",5);
insert into Model (description, Type_id) values("TestModel3 type:5",5);
commit;
