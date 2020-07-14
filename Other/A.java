package Other;

class A {
    int ivar = 7;

    void m1() {
        System.out.print("A's m1, ");
    }

    void m2() {
        System.out.print("A's m2, ");
    }

    void m3() {
        System.out.print("A's m3, ");
    }
}

class B extends A {

    @Override
    void m1() {
        System.out.print("B's m1, ");
    }
}

class C extends B {

    @Override
    void m3() {
        System.out.print("C's m3 " + (ivar + 7) + ", ");
    }
}

class Mixed2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A d = new C();

        a.m2();
        b.m1();
        c.m3();
        d.m1();    // почему вывод B's m1????
    }
}