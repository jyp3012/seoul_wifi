# seoutl_wifi


## 동작



처음 **내 위치 불러오기** 를 선택하면 geolocation를 통하여 내 위치를 불러 옵니다. 불러온 값은 내부 변수에 저장 되고 한번 더 눌러 줄 경우 화면에 반영이 됩니다.
이후 내 위치 저장하기를 누르면 DB에 gps_history 테이블에 저장이 된 후 ** 위치 불러오기 **를 누르게 되면 DB로 부터 저장된 위치를 불러옵니다.


**open api 와이파이 가져오기**를 누르게 되면 api로 부터 json형식의 데이터를 받고 내부에서 파싱을 통해 DB에 저장하게 됩니다.


**가까운 와이파이 보기** 를 누르게 되면 저장 됐 던 내 위치를 기반으로 가까운 와이파이 20개를 출력합니다. 화면에서 다시 **홈**을 눌러 갈 때 계산 됐 던 위치가 사라지고 **갸까운 와이파이 보기**를 다시 눌렀을 때 한번 더 실행 되는 방식으로 진행 됩니다.
