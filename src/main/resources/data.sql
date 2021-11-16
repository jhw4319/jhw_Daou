insert into organization(id,parent_id,type,name,code,manager) values(1,null,'Company','ABC회사',null,null);
insert into organization(id,parent_id,type,name,code,manager) values(2,1,'Division','경영지원본부','M100',null);
insert into organization(id,parent_id,type,name,code,manager) values(3,1,'Division','SW 개발본부','S100',null);
insert into organization(id,parent_id,type,name,code,manager) values(4,3,'Division','플랫폼개발부','P100',null);
insert into organization(id,parent_id,type,name,code,manager) values(5,3,'Division','비즈서비스개발부','B100',null);
insert into organization(id,parent_id,type,name,code,manager) values(6,2,'Department','인사팀','M110',null);
insert into organization(id,parent_id,type,name,code,manager) values(7,2,'Department','총무팀','M120',null);
insert into organization(id,parent_id,type,name,code,manager) values(8,2,'Department','법무팀','M130',null);
insert into organization(id,parent_id,type,name,code,manager) values(9,4,'Department','비즈플랫폼팀','P110',null);
insert into organization(id,parent_id,type,name,code,manager) values(10,4,'Department','비즈서비스팀','P120',null);
insert into organization(id,parent_id,type,name,code,manager) values(11,4,'Department','그룹웨어개발팀','P130',null);
insert into organization(id,parent_id,type,name,code,manager) values(12,5,'Department','플랫폼서비스팀','B110',null);
insert into organization(id,parent_id,type,name,code,manager) values(13,5,'Department','모바일개발팀','B120',null);


insert into organization(id,parent_id,type,name,code,manager) values(14,1,'Member','사장',null,null);
insert into organization(id,parent_id,type,name,code,manager) values(15,2,'Member','김무개',null,true);
insert into organization(id,parent_id,type,name,code,manager) values(16,3,'Member','정무개',null,true);
insert into organization(id,parent_id,type,name,code,manager) values(17,4,'Member','남무개',null,true);
insert into organization(id,parent_id,type,name,code,manager) values(18,5,'Member','서무개',null,true);



