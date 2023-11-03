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
    int side = 0; // ここで辺の長さを格納するための変数を宣言
    String input;
    boolean isValid;

    do {
      System.out.print("辺 " + sideName + " の長さを入力してください (1〜99): "); // ユーザーに辺の長さの入力を求める
      input = scanner.next(); // 入力を文字列として読み取る
      isValid = input.matches("[1-9][0-9]?"); // 半角数字1〜99の正規表現チェック

      if (!isValid) {
        System.out.println("1から99の整数を半角数字で入力してください。");
      } else {
        side = Integer.parseInt(input); // ユーザーが入力した整数を文字列を整数に変換して変数sideに代入
        if (side < 1 || side > 99) {
          System.out.println("1から99の整数を半角数字で入力してください。");
        }
      }

    } while (side < 1 || side > 99)
        ;  // 入力された数値が1から99の範囲内であるまでループ

      return side;  // 最終的に適切な値が入力されたら、その値を呼び出し元のメソッドに返す
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
