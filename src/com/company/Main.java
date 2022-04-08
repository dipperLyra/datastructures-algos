package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("One away: "+ oneAway("pale", "pales"));
    }

    public static int romanToINt(String s) {
        char[] c = s.toCharArray();
        int sum = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        for (int i = c.length - 1; i >= 0; i -= 2) {
            if (i - 1 < 0) {
                sum += m.get(c[i]);
            } else if (m.get(c[i]) > m.get(c[i - 1])) {
                sum += (m.get(c[i]) - m.get(c[i - 1]));
            } else {
                sum += (m.get(c[i]) + m.get(c[i - 1]));
            }
        }

        return sum;
    }

    // MCDLXXVI MMXX "MCDLXXVI"
    // convert Roman numeral string to equivalent Arabic figures
    public static int romanToInt(String s) {
        if (s.length() > 15) return 0;

        int sum = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        for (int i = 0; i <= s.length() - 1;) {
            if (!m.containsKey(s.charAt(i))) return 0;

            if (i + 1 > s.length() - 1) {
                sum += m.get(s.charAt(i));
                return sum;
            } else if (m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                sum += m.get(s.charAt(i + 1)) - m.get(s.charAt(i));
                i += 2;
            } else {
                sum += m.get(s.charAt(i));
                i++;
            }
            if (sum > 3999 || sum < 1) {
                return 0;
            }
        }
        return sum;
    }

    // Test string for unique characters
    public static boolean isUnique(String s) {
        Set<Character> characters = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (characters.contains(c)) {
                return false;
            }
            characters.add(c);
        }
        return true;
    }

    // Test that two strings are permutations of each other
    public static boolean isPermutation(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();

        Arrays.sort(a1); // nlog (n) uses quicksort
        Arrays.sort(b1); // nlog (n)

        String s1 = new String(a1);
        String s2 = new String(b1);

        return s1.equalsIgnoreCase(s2);
    }

    // Url encoding
    public static String urLify(String s) {
        char[] chars = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean oneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) >= 2) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int odd = 0;
        int loopLimit = Math.min(c1.length, c2.length);

        for (int i = 0; i <= loopLimit - 1; i++) {
            if (odd >= 2 ) return false;
            else if (c1[i] != c2[i]) odd++;
        }

        return true;
    }
}
