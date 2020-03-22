/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     2020/3/22 15:21:51                           */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_T_ANNOUN_REFERENCE_T_USER') then
    alter table t_announcement
       delete foreign key FK_T_ANNOUN_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_APPLY_REFERENCE_T_USER') then
    alter table t_apply
       delete foreign key FK_T_APPLY_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_FEEDBA_REFERENCE_T_USER') then
    alter table t_feedback
       delete foreign key FK_T_FEEDBA_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_REPORT_REFERENCE_T_USER') then
    alter table t_report
       delete foreign key FK_T_REPORT_REFERENCE_T_USER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_TASK_REFERENCE_T_USER') then
    alter table t_task
       delete foreign key FK_T_TASK_REFERENCE_T_USER
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_announcement'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_announcement
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_apply'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_apply
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_feedback'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_feedback
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_file'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_file
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_report'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_report
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_task'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_task
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_user'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_user
end if;

/*==============================================================*/
/* Table: t_announcement                                        */
/*==============================================================*/
create table t_announcement 
(
   announcement_id      varchar(48)                    not null,
   user_id              varchar(48)                    null,
   announcement_content varchar(255)                   null,
   announcement_title   varchar(48)                    null,
   announcement_time    varchar(32)                    null,
   constraint PK_T_ANNOUNCEMENT primary key clustered (announcement_id)
);

comment on table t_announcement is 
'公告表';

/*==============================================================*/
/* Table: t_apply                                               */
/*==============================================================*/
create table t_apply 
(
   apply_id             varchar(48)                    not null,
   user_id              varchar(48)                    null,
   apply_time           varchar(32)                    null,
   company_name         varchar(48)                    null,
   company_site         varchar(48)                    null,
   company_phone        varchar(32)                    null,
   state                varchar(20)                    null,
   constraint PK_T_APPLY primary key clustered (apply_id)
);

comment on table t_apply is 
'实习申请表';

/*==============================================================*/
/* Table: t_feedback                                            */
/*==============================================================*/
create table t_feedback 
(
   feedback_id          varchar(48)                    not null,
   user_id              varchar(48)                    null,
   feedback_content     varchar(20)                    null,
   constraint PK_T_FEEDBACK primary key clustered (feedback_id)
);

comment on table t_feedback is 
'反馈表';

/*==============================================================*/
/* Table: t_file                                                */
/*==============================================================*/
create table t_file 
(
   file_id              varchar(48)                    not null,
   file_name            varchar(64)                    null,
   file_path            varchar(128)                   null,
   file_describe        varchar(48)                    null,
   type                 int                            null,
   constraint PK_T_FILE primary key clustered (file_id)
);

comment on table t_file is 
'文件表';

/*==============================================================*/
/* Table: t_report                                              */
/*==============================================================*/
create table t_report 
(
   report_id            varchar(48)                    not null,
   user_id              varchar(48)                    null,
   report_content       varchar(200)                   null,
   report_time          varchar(32)                    null,
   constraint PK_T_REPORT primary key clustered (report_id)
);

comment on table t_report is 
'报告表';

/*==============================================================*/
/* Table: t_task                                                */
/*==============================================================*/
create table t_task 
(
   task_id              varchar(48)                    not null,
   user_id              varchar(48)                    null,
   task_content         varchar(255)                   null,
   task_time            varchar(32)                    null,
   constraint PK_T_TASK primary key clustered (task_id)
);

comment on table t_task is 
'任务表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user 
(
   user_id              varchar(48)                    not null,
   name                 varchar(20)                    null,
   email                varchar(20)                    null,
   phone                varchar(20)                    null,
   user_name            varchar(32)                    null,
   id_card              varchar(18)                    null,
   password             varchar(20)                    null,
   role                 int                            null,
   sex                  varchar(10)                    null,
   constraint PK_T_USER primary key clustered (user_id)
);

comment on table t_user is 
'用户表';

alter table t_announcement
   add constraint FK_T_ANNOUN_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_apply
   add constraint FK_T_APPLY_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_feedback
   add constraint FK_T_FEEDBA_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_report
   add constraint FK_T_REPORT_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

alter table t_task
   add constraint FK_T_TASK_REFERENCE_T_USER foreign key (user_id)
      references t_user (user_id)
      on update restrict
      on delete restrict;

