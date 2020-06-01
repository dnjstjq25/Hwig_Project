# 휙(식품 쇼핑몰) 프로젝트

### 1. 개요
 - 제작기간 : 20.02.26 ~ 20.06.05
 - 참여인원 : 6명 (프론트엔드3명, 백엔드3명)
 - 주제 : 식품쇼핑몰
***
### 2. 내가 맡은 역할
 - 팀장
 - 전체적인 DB설계(drwa.io, exerd)
 - 고객페이지 및 관리자 및 판매자 페이지 각종 게시판 구현(고객페이지는 Rest API) 
 - 고객페이지 로그인 세션관리
 - 관리자페이지 및 판매자페이지 메인화면(차트, 문의목록)
 - AWS로 구축된 서버에 프로젝트 배포 및 관리
***
### 3. 기술스택
 - JAVA
 - JSP
 - Spring Framework
 - DataBase(Oracle)
 - HTML( ~ JQuery까지 화면구현)
 - CSS
 - Javascript
 - JQuery
 - linux(ubuntu) -> 서버관리
 - AWS EC2 -> 서버구축
***
### 4. 프로젝트 관리자 및 판매자 페이지 UI -> 부트스트랩 사용
![관리자_메인](https://user-images.githubusercontent.com/54284354/82807257-609d7f80-9ec2-11ea-9c0f-bf0b6dd3ad28.png)
관리자 메인페이지 
![관리자_공지목록](https://user-images.githubusercontent.com/54284354/82807280-6c894180-9ec2-11ea-9551-a7d92b205176.png)
관리자 공지사항 목록
![관리자_공지_상세](https://user-images.githubusercontent.com/54284354/82807284-6eeb9b80-9ec2-11ea-9cc0-8ff6708cefef.png)
관리자 공지사항 상세 페이지
![관리자_FAQ목록](https://user-images.githubusercontent.com/54284354/82807290-70b55f00-9ec2-11ea-9b72-c05e87470111.png)
관리자 자주묻는질문 목록
![관리자_이벤트폼](https://user-images.githubusercontent.com/54284354/82807301-74e17c80-9ec2-11ea-9a42-8c5e4e5cb84a.png)
관리자 이벤트 폼
![관리자_QNA목록](https://user-images.githubusercontent.com/54284354/82807307-7743d680-9ec2-11ea-86bf-8daf4950def0.png)
관리자 QNA 목록
![관리자_QNA_상세](https://user-images.githubusercontent.com/54284354/82807309-78750380-9ec2-11ea-9b1c-f08b8d114402.png)
관리자 QNA 상세 -> 질문의 카테고리에 따라서 버튼클릭으로만 빠르게 답변을 처리할 수 있는 템플릿을 제작하였다.
양식은 카테고리당 3개까지 작성가능하고 수정, 삭제도 일반 게시판과 동일하게 동작한다.
![판매자_메인](https://user-images.githubusercontent.com/54284354/82807318-7c088a80-9ec2-11ea-9082-d01ad00e571f.png)
판매자 메인페이지 -> 판매자가 판매중인 상품에 대한 후기를 최신순으로 보여준다.
### 4. 고객 페이지 UI
![고객_메인](https://user-images.githubusercontent.com/54284354/82807340-87f44c80-9ec2-11ea-9d39-ecfa99210c49.png)
고객 이벤트 페이지 -> 관리자 페이지에서 이미지 경로를 업로드하면 서버에 저장되있는 이미지를 보여준다.
![고객_공지사항](https://user-images.githubusercontent.com/54284354/82807350-8aef3d00-9ec2-11ea-8604-2486465ef99c.png)
고객 공지사항 -> 관리자 페이지에서 업로드한 DB를 가져와서 보여준다.
![고객_FAQ목록](https://user-images.githubusercontent.com/54284354/82807353-8cb90080-9ec2-11ea-9a88-98ab44897cef.png)
고객 자주묻는질문 목록
![고객_QNA_목록](https://user-images.githubusercontent.com/54284354/82807357-8e82c400-9ec2-11ea-9020-336856ae3773.png)
고객 QNA 목록
![고객_상품후기_목록](https://user-images.githubusercontent.com/54284354/82807362-92164b00-9ec2-11ea-9d63-4cfcbf8c3bc3.png)
고객 상품후기 목록(마이페이지)

