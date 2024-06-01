package com.functional_java.chapter2;

//파라미터가 아닌 람다 외부에서 정의된 변수를 람다식 내부에 저장하고 사용
public class Capture {

    static int staticAnswer = 42;
    private int instanceAnswer = 42;
    static void capture() {
        int theAnswer = 42;
        Runnable printAnswer = () -> System.out.println("the answer is " + theAnswer);
        printAnswer.run();
    }

    //캡처되는 지역 변수 (스태틱 영역)는 final이거나 effective final이어야 한다. (compile error)
    //지역 변수가 할당 해제 된 후에도 람다에서 사용 가능
//    public static void capture2() {
//        int theAnswer = 42;
//        Runnable changedAnswer = () -> {
//            theAnswer = 43;
//            System.out.println(theAnswer);
//        };
//        changeAnswer.run();
//    }

    //static 필드나 인스턴스 필드는 final 제약 x (힙 혹은 메서드 영역)
    static void capture3() {
        Runnable changedAnswer = () -> {
            staticAnswer = 43;
            System.out.println("the changed answer is " + staticAnswer);
        };
        changedAnswer.run();
    }

    void capture4() {
        Runnable changedAnswer = () -> {
            this.instanceAnswer = 43;
            System.out.println("the changed answer is " + this.instanceAnswer);
        };
        changedAnswer.run();
    }

    public static void main(String[] args) {
        capture();
        capture3();
    }
}

