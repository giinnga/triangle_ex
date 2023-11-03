package org.example;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int sideA, sideB, sideC;

    sideA = sideLength(scanner, "A");
    sideB = sideLength(scanner, "B");
    sideC = sideLength(scanner, "C");

    if (triangle(sideA, sideB, sideC)) {
      String type = triangleType(sideA, sideB, sideC);
      System.out.println("この三角形は " + type + " です。");
    } else {
      System.out.println("入力された辺の長さでは三角形が成立しません。");
    }

    scanner.close();
  }

  private static int sideLength(Scanner scanner, String sideName) {
    int side;
    do {
      System.out.print("辺 " + sideName + " の長さを入力してください (1〜99): ");
      while (!scanner.hasNextInt()) {
        System.out.println("1から99の整数を半角数字で入力してください。");
        scanner.next(); // 不正な入力をスキップ
      }
      side = scanner.nextInt();
      if (side < 1 || side > 99) {
        System.out.println("1から99の整数を半角数字で入力してください。");
      }
    } while (side < 1 || side > 99);

    return side;
  }

  private static boolean triangle(int a, int b, int c) {
    // 三角形成立条件のチェック
    return a + b > c && a + c > b && b + c > a;
  }

  private static String triangleType(int a, int b, int c) {
    if (a == b && b == c) {
      return "正三角形";
    } else if (a == b || a == c || b == c) {
      return "二等辺三角形";
    } else {
      return "不等辺三角形";
    }
  }
}
