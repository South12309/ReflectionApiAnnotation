package com.gb;

public class TestClass {

//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("BeforeSuite");
//    }

    @BeforeSuite
    public void beforeSuite2() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }

    @Test(number = 0)
    public void test0() {
        System.out.println("test0");
    }

    @Test(number = 1)
    public void test1() {
        System.out.println("test1");
    }

    @Test(number = 2)
    public void test2() {
        System.out.println("test2");
    }

    @Test(number = 3)
    public void test3() {
        System.out.println("test3");
    }

    @Test(number = 4)
    public void test4() {
        System.out.println("test4");
    }

    @Test(number = 5)
    public void test5() {
        System.out.println("test5");
    }

    @Test(number = 6)
    public void test6() {
        System.out.println("test6");
    }

    @Test(number = 7)
    public void test7() {
        System.out.println("test7");
    }
    @Test(number = 5)
    public void test05() {
        System.out.println("test5");
    }
    @Test(number = 7)
    public void test07() {
        System.out.println("test7");
    }
    @Test(number = 9)
    public void test09() {
        System.out.println("test9");
    }

}
