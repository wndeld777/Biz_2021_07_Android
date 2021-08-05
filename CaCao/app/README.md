# Android App 의 ActionBar Customizing
* Android App 의 기본 Activity 는 모두가 자동으로 구현되는 ActionBar 를 가지고 있다.
하지만 자동으로 생성되는 ActionBar 는 Customizing 하기가 어렵다.
* 자동으로 생성되는 ActionBar 를 보이지 않도록 설정하고 임의로 ActionBar 를 설정하여 Customizing 을 수행한다

## 순서
1. MainActivity 에 NoActionBar Theme 를 적용하여 자동 ActionBar 를 감춘다

2. ToolBar View Component 를 *.xml 파일에 추가하여 둔다
3. ToolBar 에 설정된 기본 Theme 를 적용하기
4. MainActivity 의 onCreate() method 에서 설정한 ToolBar 가 보이도록 설정

# Preference 만들기
* 어플에서 사용하는 "환경 설정"
* 어플이 실행되는데 필요한 여러가지 값들을 세팅하고, 그 세팅된 값을 유지하기 위한 정책
* Settings Activity 를 App 에 추가하고
root_preference.xml 파일에 필요한 항목들을 추가하고
적당한 곳에서 해당 Activity 를 열어서 값을 세팅하면
App 전체에서 해당 값을 사용할수 있게 된다

* setting 된 값이 필요한 곳에서
SharedPreference interface 를 사용하여 객체를 선언하고
PreferenceManager.getDefaultSharedPreference() method 를 실행하여
전체 값을 읽어 들인다
객체로 부터 getString() 등의 method 를 사용하여 각각 세팅된 개별 변수값을 추출하여 적용할 수 있다.