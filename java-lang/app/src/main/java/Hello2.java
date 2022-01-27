

class Hello2 {
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}

// ## 실습
// 1) 소스 디렉토리 생성
// - /src/main/java 폴더를 생성한다.
//
// 2) 소스 파일 생성
// - /src/main/java 폴더에 Hello2.java 파일을 작성한다.
//
// 3) 컴파일하기
// - 프로젝트 폴더에서 컴파일 할 때:
// 예) $ javac src/main/java/Hello2.java
// - 클래스 파일은 소스 파일이 있는 폴더에 생성된다.
// 예) /src/main/java/Hello2.class
//
// 3) 컴파일 하기2
// - 컴파일러가 생성한 파일을 소스 파일과 분리하여 관리하기
// - 프로젝트 폴더에서 컴파일 할 때:
// javac -d [컴파일 결과 파일을 둘 디렉토리 경로] [소스파일명]
// 예) $ javac -d bin/main src/main/java/Hello2.java
// - 클래스 파일은 컴파일 할 때 지정한 폴더에 생성된다.
// 예) /bin/main/Hello2.class
//
// 4) 실행하기
// - 프로젝트 폴더에서 실행 할 때:
// java -classpath [클래스가 있는 디렉토리 경로] 클래스이름
// java -cp [클래스가 있는 디렉토리 경로] 클래스이름
// 예) $ java -cp bin/main Hello2
//
