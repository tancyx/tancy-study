package com.tancy.test;

import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tancy
 * 2021/6/13 9:56
 * @description description
 */
public class Kaoshi {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("123abccd");
//        list.add("abcdc123");
//        list.add("1234abc");
//        list.add("ab1234cd");
//
//        test1(list);

//        Department department1 = new Department(1L, "语文");
//        Department department2 = new Department(2L, "数学");
//        Department department3 = new Department(3L, "体育");
//        Department department4 = new Department(4L, "历史");
//        Department department5 = new Department(5L, "政治");
//
//        department4.addChildren(department5);
//        department1.addChildren(department4);
//        department1.addChildren(department2);
//        department5.addChildren(department3);
//
//        List<Long> longList = test2(department1, "体育");
//        longList.forEach(aLong -> System.out.println(aLong));

        for (int i = 0; i < 10; i++) {
            threadTest();
        }

    }


    private static void test1(List<String> list) {
        Map<String, Integer> tmp = new HashMap<>();
        Pattern number = Pattern.compile("\\d+");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            Matcher matcher = number.matcher(s);
            if (matcher.find()) {
                String group = matcher.group();
                if (!tmp.containsKey(group)) {
                    tmp.put(group, i);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : tmp.entrySet()) {
            result.add(list.get(stringIntegerEntry.getValue()));
        }


        for (String s : result) {
            System.out.println(s);
        }

    }

    private static List<Long> test2(Department root, String query) {
        List<Long> result = new ArrayList<>();
        findByName(root, result, query);
        return result;
    }

    private static void findByName(Department parent, List<Long> result, String query) {
        if (parent.getName().equals(query)) {
            result.add(parent.getId());
        }
        if (Objects.isNull(parent.getChildren()) || parent.getChildren().isEmpty()) return;
        for (Department child : parent.getChildren()) {
            findByName(child, result, query);
        }
    }

    public static class Department{
        private Long id;
        private String name;
        private List<Department> children = new ArrayList<>();

        public Department() {
        }

        public Department(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void addChildren(Department children) {
            this.children.add(children);
        }
    }


    private static List<Integer> test4(List<List<Integer>> orderNums) {
        List<Integer> result = new ArrayList<>(orderNums.get(0));
        int oindex = 0, rindex = 0, cursor = 0;
        for (int i = 1; i < orderNums.size(); i++) {
            List<Integer> tmps = orderNums.get(i);
            oindex = tmps.size() - 1;
            rindex = result.size() - 1;
            cursor = tmps.size() + result.size() - 1;
            while (oindex >= 0) {
                if (rindex <= 0) {
                    result.add(rindex++, tmps.get(oindex));
                }
                if (result.get(rindex) >= tmps.get(oindex)) {
                    oindex--;
                    swap(result, cursor--, rindex--);
                }
                if (result.get(rindex) < tmps.get(oindex)) {
                    result.add(cursor--, tmps.get(oindex--));
                }
            }


        }

        return result;
    }

    private static void swap(List<Integer> nums, int index1, int index2) {
        int tmp = nums.get(index1);
        nums.add(index1, nums.get(index2));
        nums.add(index2, tmp);
    }


    private static void threadTest() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(new RunA());
        executor.submit(new RunB());
        executor.submit(new RunC());

    }

    static class RunA implements Runnable {
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    static class RunB implements Runnable {
        @Override
        public void run() {
            System.out.println("B");
        }
    }
    static class RunC implements Runnable {
        @Override
        public void run() {
            System.out.println("C");
        }
    }



}
