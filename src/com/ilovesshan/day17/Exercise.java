package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */
public class Exercise {
    public static void main(String[] args) {
        Exercise exercise = new Exercise();
        System.out.println(exercise.f1());
        System.out.println(exercise.f2());
        System.out.println(exercise.f3());
    }


    public int f1() {
        int i = 1;
        try {
            i++;
            throw new UserNameErrorException("error");
        } catch (Exception e) {
            e.printStackTrace();
            return i++;
        }
    }


    public int f2() {
        int i = 1;
        try {
            i++;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i++;
        } finally {
            i++;
        }

    }


    public int f3() {
        int i = 1;
        try {
            i++;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i++;
        } finally {
            i++;
            return i;
        }
    }

}
