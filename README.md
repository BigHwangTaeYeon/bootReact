# thymeleaf

create table board
(
    `id` INT not null auto_increment COMMENT '게시글ID', 
    `writer` VARCHAR(50) not null COMMENT '작성자', 
    `title` VARCHAR(50) not null COMMENT '제목', 
    `content` VARCHAR(1000) not null COMMENT '내용', 
    `regdate` DATETIME not null COMMENT '등록일자', 
    `update_date` DATETIME null COMMENT '수정일자', 
    `delete_date` DATETIME null COMMENT '삭제일자', 
    primary key (id)
)
;

ALTER TABLE board CONVERT TO CHARSET UTF8
;

insert into board (writer, title, content, regdate) values ('황태연', 'titleTest004', 'ContentTest004', '20230624') 
;

select
	id ,
	writer ,
	title ,
	content ,
	regdate ,
	update_date ,
	delete_date
from
	board
;