package org.lsh.problem;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Long n = scanner.nextLong();
        Long m = scanner.nextLong();
        List<Long> arr1 = new ArrayList<>();
        List<Long> arr2 = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr1.add(scanner.nextLong());
            s1.push(arr1.indexOf(i));
        }
        for (int i = 0; i < m; i++) {
            arr2.add(scanner.nextLong());
            s2.push(arr2.indexOf(i));
        }

        long max = Math.max(n, m);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            if (arr1.indexOf(i) == arr2.indexOf(i)) {
                res.add(arr1.indexOf(i));
            } else {
                break;
            }
        }
        if (res.size() >= n || res.size() >= m) {
            for (int i = 0; i < res.size(); i++) {
                if (i == 0) {
                    System.out.print(res.get(i));
                } else {
                    System.out.print(" " + res.get(i));
                }
            }
        }
        Stack<Integer> s3 = new Stack<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (Objects.equals(s1.peek(), s2.peek())) {
                s3.push(s1.pop());
                s2.pop();
            } else {
                break;
            }
        }

        while (!s3.isEmpty()) {
            res.add(s3.pop());
        }

        for (int i = 0; i < res.size(); i++) {
            if (i == 0) {
                System.out.print(res.get(i));
            } else {
                System.out.print(" " + res.get(i));
            }
        }
    }
}
