# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "url" ("id" BIGSERIAL PRIMARY KEY,"url" VARCHAR(254) NOT NULL,"newUrl" VARCHAR(254) NOT NULL);

# --- !Downs

drop table "url";

