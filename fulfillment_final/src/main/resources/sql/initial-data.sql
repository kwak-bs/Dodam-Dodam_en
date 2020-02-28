/* 1 */
insert into category (id, title, keycode, cat_type, disp_order)
values (1,'고객센터', 'cserviceroot', 'CATEGORY', 1);

insert into category (id, title, keycode, cat_type, disp_order)
values (2, 'K 쇼핑', 'kshoppingroot', 'CATEGORY', 2);

insert into category (id, title, keycode, cat_type, disp_order)
values (3, '샤오미 미니샵', 'xaiomishop', 'CATEGORY', 3);


/* 5 */

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (10, '인터넷 연결 방법', '인터넷', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 인터넷 연결방법');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (11, '리모컨 사용 방법', '리모컨', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 리모컨 사용방법');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (12, 'Skylife 이용하기', '스카이라이프', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'Skylife 이용하기');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (13, '안드로이드 사용방법', '안드로이드', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 안드로이드 사용방법');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (14, '고장해결', '고장', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 고장해결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (15, '기타', '이외', 1, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 기타 서비스');


insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description, keycode)
values (100, 'GS 홈쇼핑', '지에스', 2, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV gs 홈쇼핑', 'gsshop');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description, keycode)
values (101, '다이렉트 샵', '다이렉트', 2, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV 다이렉트 홈쇼핑','directshop');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description, keycode)
values (102, 'k 홈쇼핑', '지에스', 2, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-TV k 홈쇼핑','kshop');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description, keycode)
values (103, '현대 홈쇼핑', '지에스', 2, 'CATEGORY', 0, '다음중 선택 바랍니다.', 'SkyLife-shop 현대 홈쇼핑','hyundaishop');





insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (110,'파리 여행', '파리', 100, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품');

insert into detail(category_id, item_type, linkurl)
values (110, 'PRODUCT', '제품주소'); 

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (111,'gs 홈쇼핑 연결', '유선', 100, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품')

insert into detail(category_id, item_type, linkurl)
values (111, 'PRODUCT', '제품주소'); 

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (112,'gs 홈쇼핑 연결', '유선', 100, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품')

insert into detail(category_id, item_type, linkurl)
values (112, 'PRODUCT', '제품주소'); 

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (113,'gs 홈쇼핑 연결', '유선', 100, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품')

insert into detail(category_id, item_type, linkurl)
values (113, 'PRODUCT', '제품주소'); 


insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (120,'파리 여행', '파리', 101, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품');

insert into detail(category_id, item_type, linkurl)
values (120, 'PRODUCT', '제품주소'); 

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, description)
values (121,'파리 여행', '파리', 101, 'ITEM', 0, '현재 판매 중인 상품을 보여드릴게요','https://actions.o2o.kr/content/travel1.jpg' ,'현재 판매 중인 상품');

insert into detail(category_id, item_type, linkurl)
values (121, 'PRODUCT', '제품주소'); 







insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (20,'유선 연결방법', '유선', 10, 'ITEM', 0, '<speak>다음과 같이 시도해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/lan.mp3"></audio></speak>', 'https://actions.o2o.kr/content/lan.gif', '유션 연결방법 이미지', '설정-> 인터넷-> 유선 인터넷 연결(이더넷)-> 인터넷 케이블 연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (21,'무선 (바밀번호)연결방법', '무선', 10, 'ITEM', 0, '<speak>다음과 같이 시도해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/lan.mp3"></audio></speak>', 'https://actions.o2o.kr/content/lan.gif', '유션 연결방법 이미지', '설정-> 인터넷-> 무선 인터넷 연결(WiFi)-> 비밀번호 입력-> 인터넷 연결 ');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (22,'무선 (WPS) 연결방법', '더블유피에스', 10, 'ITEM', 0, '<speak>다음과 같이 시도해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/wps.mp3"></audio></speak>', 'https://actions.o2o.kr/content/wps.gif', '유션 연결방법 이미지', '설정-> 인터넷 -> 와이파이 -> WPS를 통해 연결-> 셋탑박스(공유기) WPS 찾아누름');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (30, '통합전원', '통합', 11, 'ITEM', 0, '<speak>다음과 같이 시도해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/test1.mp3"></audio></speak>', 'https://actions.o2o.kr/content/test1.gif', '리모컨 설정 이미지', '1. [확인 ○] + [선호채널] or [확인 ○] + [조용히] (동시에 누름) → LED ON \n2. [채널+] or [채널-] key를 천천히 TV화면이 꺼질때까지 누른다. (LED가 깜박임)\n 3. TV 화면이 꺼지면 [확인 ○] 누름 → 완료(LED 3회 점멸하며 꺼짐)');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (31,'이전', '나가기', 11, 'ITEM', 0, '다음과 같은 용도입니다.', '이전 - 현재화면 전 단계 이동 / 나가기 - 지금 메뉴에서 완전히 나감');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (32,'AI버튼', '인공지능', 11, 'ITEM', 0, '다음과 같은 용도입니다.', '홈버튼과 OK버튼을 함께 켜져있는 셋톱에 4초이상 누름');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (33,'색깔별버튼', '색', 11, 'ITEM', 0, '다음과 같은 용도입니다.', 'TV 화면에 보이는 색깔과 같은 버튼을 누름 (기능이 다름)');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (34,'외부입력', '외부', 11, 'ITEM', 0, '다음과 같은 용도입니다.', '외부선과 연결 시 선택');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (40,'마이페이지', '마이', 12, 'ITEM', 0, '다음과 같이 이용하세요.', '마이페이지 -> VOD 구매목록, 쿠폰, TV포인트 내역, TV정보 기록 / 스마트카드번호 정보');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (41,'공지(알림)페이지', '공지', 12, 'ITEM', 0, '다음과 같이 이용하세요.', '공지/ 알림 -> 각종 이벤트 및 안내사황 확인');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (42,'설정메뉴', '설정', 12, 'ITEM', 0, '다음과 같이 이용하세요.', '설정 -> 인터넷, 블루투스 (외부연결)');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (43,'VOD 구매방법', '브이오디', 12, 'ITEM', 0, '다음과 같이 이용하세요.', '영화 -> 보고싶은 영화 선택 -> 수신료 결제 (요금고지서 청구) / 신용카드 결제 (상세정보 입력) / 휴대폰 결제 / 간편 결제 (최초 등록 후 SMS 인증) / 쿠폰 결제 (금액만큼 할인) / TV 포인트 결제 (제휴포인트를 TV포인트로 전환)');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (50,'구글 계정추가 방법', '계정 추가', 13, 'ITEM', 0, '<speak>다음과 같이 이용해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/addgoogle.mp3"></audio></speak>', 'https://actions.o2o.kr/content/addgoogle.gif', '구글 계정추가 이미지', '구글 홈 -> 앱스 -> 구글계정 로그인');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, image_path, image_alt_text, description)
values (51,'구글 계정삭제 방법', '계정 삭제', 13, 'ITEM', 0, '<speak>다음과 같이 이용해 보시기 바랍니다. <audio src="https://actions.o2o.kr/content/deletegoogle.mp3"></audio></speak>', 'https://actions.o2o.kr/content/deletegoogle.gif', '구글 계정삭제 이미지', '앱스 -> 안드로이드 설정 -> 계정삭제');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (52,'유튜브 사용 방법', '유튜브', 13, 'ITEM', 0, '다음과 같이 이용하세요.', '구글 홈 -> 왼쪽 메뉴 -> 유튜브 선택 -> 영상 검색');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (53,'비밀번호 변경 방법', '비밀번호', 13, 'ITEM', 0, '다음과 같이 시도해 보시기 바랍니다.', '비밀번호가 아이들이나 청소년에게 알려 졌을 경우를 대비하여 부모님들이 원하실 때 임의로 비밀번호를 변경할 수 있습니다. * 비밀번호 변경 방법 - 안드로이드 UHD 수신기 : TV홈 → 설정 → 자녀안심 → 비밀번호 변경 - 일반 UHD 수신기 : 메뉴 → 설정 → 자녀안심설정 → 비밀번호 변경" + "- HD 수신기 : 메뉴 → 사용자 메뉴 → 기능설정 → 비밀번호 설정 ※ 기타 수신기의 경우 고객센터(1588-3002)를 통해 확인해주시기 바랍니다. 이 비밀번호는 전체 EPG에서 사용되기 때문에 꼭 기억해 주시기 바랍니다.');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (54,'안드로이드 앱 사용방법', '앱', 13, 'ITEM', 0, '다음과 같이 이용하세요.', '구글 플레이스토어 -> android TV remote control 앱 다운 -> 설정 -> 블루투스 -> 내 모바일 찾기 -> TV화면의 헤어링 클릭 -> 모바일 쌍으로 연결 클릭');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (55,'구글캐스팅 사용 방법', '캐스팅', 13, 'ITEM', 0, '다음과 같이 이용하세요.', '구글캐스팅 사용 방법입니다.'); 

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (60,'신호미약', '신호', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '안테나 선 연결 상태 확인 -> 전원 재연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (61,'모자이크', '모자이크', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '설정 -> 고급설정 -> 중계기 -> 신호상태 체크 -> 양호 - 전원 재연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (62,'검거나 파랗게 지지직', '검은', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '전원 재연결 -> HDMI 케이블 연결 확인 -> TV 외부입력이 HDMI인지 확인 -> 외부입력 번호와 화면 확인 -> 전원 재연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (63,'음성이 나오지 않음', '음성 안나옴', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '스마트카드(S/C) 재 삽입 -> 전원 재연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (64,'음성이 커졌다 작아졌다', '음성 볼륨', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '일부 / 전체 채널 음성 체크 -> 수신기 전원 OFF -> 일반 유선으로 음성 확인 -> 수신기 전원 재연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (65,'원격진단 요청하기', '원격', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '1588-3002 전화 -> 2번 고장문의 -> 2번 원격진단 -> 스마트카드번호 앞 2자리를 제외한 10자리와 #을 입력 -> 개인고객(생년월일 6자리) / 사업자고객(사업자번호 앞 6자리) -> 네트워크 확인');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (66,'AS 접수', '접수', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '1588-3002 전화연결');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (67,'리모건 TV전원 ON/OFF 이상', '전원 이상', 14, 'ITEM', 0, '다음과 같이 시도해보세요.', '리모컨 TV전원 버튼과 OK 버튼을 동시에 3초 이상 누름 -> 리모컨에 빨간 불 들어오면 채널 업 버튼을 TV가 꺼질때까지 천천히 수차례 누름 -> TV 화면이 꺼지면 OK 버튼을 누름 -> 다시 TV전원 버튼 누름');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (70,'스카이라이프 보이는 ARS', '보이는', 15, 'ITEM', 0, '다음과 같이 시도해보세요.', 'https://youtu.be/bi7rTZF_Hts');

insert into category (id, title, synonyms, parent_id, cat_type, disp_order, speach, description)
values (71,'스마트카드 번호 확인 방법', '스마트카드', 15, 'ITEM', 0, '다음과 같이 시도해보세요.', '마이페이지 -> ');

insert into detail(category_id, item_type, linkurl)
values (55, 'CUSTOMER_INFO', 'https://youtu.be/8okO6PB305g');

select *
from category;