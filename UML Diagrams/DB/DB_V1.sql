/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     1/18/2015 6:50:25 PM                         */
/*==============================================================*/


drop table if exists ADDUSER;

drop table if exists ADMIN;

drop table if exists CHATGROUP;

drop table if exists JOINGROUP;

drop table if exists USER;

/*==============================================================*/
/* Table: ADDUSER                                               */
/*==============================================================*/
create table ADDUSER
(
   ID                   int not null,
   USERNAME             varchar(30) not null,
   USE_ID               int not null,
   USE_USERNAME         varchar(30) not null,
   RELATIONSTATUS       int not null,
   HISTORY              varchar(100),
   primary key (ID, USERNAME, USE_ID, USE_USERNAME)
);

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
create table ADMIN
(
   ADMINID              int not null,
   ADMINUSERNAME        varchar(30) not null,
   ADMINFIRSTNAME       varchar(30) not null,
   ADMINLASTNAME        varchar(30) not null,
   primary key (ADMINID)
);

/*==============================================================*/
/* Table: CHATGROUP                                             */
/*==============================================================*/
create table CHATGROUP
(
   GROUPID              int not null,
   GROUPNAME            varchar(50),
   primary key (GROUPID)
);

/*==============================================================*/
/* Table: JOINGROUP                                             */
/*==============================================================*/
create table JOINGROUP
(
   ID                   int not null,
   USERNAME             varchar(30) not null,
   GROUPID              int not null,
   HISTORYREFRANCE      varchar(100),
   primary key (ID, USERNAME, GROUPID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   ID                   int not null,
   USERNAME             varchar(30) not null,
   FIRSTNAME            varchar(30) not null,
   LASTNAME             varchar(30) not null,
   RPASSWORD            varchar(50) not null,
   DATEOFBIRTH          varchar(10) not null,
   GENDER               char(1) not null,
   MOBILENUMBER         varchar(12),
   IMAGEPROFILE         longblob,
   MODE                 smallint not null,
   STATUS               bool not null,
   primary key (ID, USERNAME)
);

alter table ADDUSER add constraint FK_ADDUSER foreign key (ID, USERNAME)
      references USER (ID, USERNAME) on delete restrict on update restrict;

alter table ADDUSER add constraint FK_ADDUSER2 foreign key (USE_ID, USE_USERNAME)
      references USER (ID, USERNAME) on delete restrict on update restrict;

alter table JOINGROUP add constraint FK_JOINGROUP foreign key (ID, USERNAME)
      references USER (ID, USERNAME) on delete restrict on update restrict;

alter table JOINGROUP add constraint FK_JOINGROUP2 foreign key (GROUPID)
      references CHATGROUP (GROUPID) on delete restrict on update restrict;

