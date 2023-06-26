# thymeleaf

fetch pull clone 차이
fetch
    원격 저장소의 내용을 확인만 하고 로컬 데이터와 병합은 하고 싶지 않은 경우
    원격 저장소의 최신 이력 확인 가능
    원격 저장소의 코드를 받아와 기존 코드에 더해준다.(Merge가 아니다)
pull
    fetch + merge
clone
    pull + git remote add 주소

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
