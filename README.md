# 쇼핑몰 관리 앱 실습 1조 결과물 - 의류 판매 관리자 앱

## 팀원
- 정지은
- 최영석
- 김재민

## 기능 소개
HomeFragment
상위 카테고리 누를 시에 상위 카테고리를 기반으로 옷 설정
하위 카테고리의 경우 상위 카테고리 물품이 없을 경우 하위 카테고리가 "전체" 하나만 나타남
하위 카테고리중에 전체를 누를시에  그외의 카테고리 해제 후 다시 옷목록 설정
하위 카테고리중에 전체 외에 다른 것을 누를 시에 "전체"의 체크가 풀리고 세부 카테고리 기반으로 옷 목록 설정
다른 Fragment 이동시 하위 카테고리는 전체로 고정되고 상위를 기반으로 다시 옷 목록 설정
