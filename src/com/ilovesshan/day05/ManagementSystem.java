package com.ilovesshan.day05;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/16
 * @description:
 */
public class ManagementSystem {
    static int command = 0;
    static String[] names = new String[]{};


    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入指令 添加员工(1)/删除员工(2)/修改员工(3)/查询员工(4)/退出(-1) : ");
            command = scanner.nextInt();
            if (command == -1) {
                break;
            } else if (command == 1) {
                System.out.print("请输姓名 : ");
                String name = scanner.next();
                add(name);
            } else if (command == 2) {
                System.out.print("请输要删除的姓名 : ");
                String name = scanner.next();
                del(name);
            } else if (command == 3) {
                System.out.print("请输被修改姓名 : ");
                String beEdit = scanner.next();

                System.out.print("请输新的姓名 : ");
                String newName = scanner.next();
                update(newName, beEdit);
            } else if (command == 4) {
                query();
            }
        }

        System.out.println("退出ManagementSystem...");
    }

    private static void add(String name) {
        String[] tempNames = new String[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            tempNames[i] = names[i];
        }
        tempNames[tempNames.length - 1] = name;
        names = tempNames;
    }

    private static void del(String name) {
        int findIndex = -1;

        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) {
                findIndex = i;
            }
        }

        System.out.println("找到的索引: " + findIndex);

        if (findIndex != -1) {
            for (int i = findIndex; i < names.length; i++) {
                if (i != names.length - 1) {
                    names[i] = names[i + 1];
                } else {
                    names[i] = null;
                }
            }
        }

        String[] temp = new String[names.length - 1];
        for (int i = 0; i < names.length-1; i++) {
            temp[i] = names[i];
        }
        names = temp;
    }

    private static void update(String name, String beEdit) {
        for (int i = 0; i < names.length; i++) {
            if (beEdit.equals(names[i])) {
                names[i] = name;
            }
        }
    }

    private static void query() {
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "\t");
        }
        System.out.println();
    }
}
