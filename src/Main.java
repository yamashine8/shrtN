import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sortM(int[] arrayInt) {
        int n = arrayInt.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayInt[j] < arrayInt[j - 1]) {
                    ex(arrayInt, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void ex(int[] arrayInt, int i, int j) {
        int temp = arrayInt[j];
        arrayInt[j] = arrayInt[i];
        arrayInt[i] = temp;
    }

    public static int searchN(int[] arrayInt, int target) {
        int left = 0;
        int right = arrayInt.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arrayInt[mid] == target) {
                return mid;
            }

            if (arrayInt[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число - ");
        String input = scanner.nextLine();
        int length = input.length();
        int[] arrayInt = new int[length];
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            arrayInt[i] = Character.getNumericValue(c);
        }
        sortM(arrayInt);
        for (int i = 0; i < length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println();
        System.out.print("Введите число которое хотите найти - ");
        int target = scanner.nextInt();
        int res =searchN(arrayInt,target);
        if(res == -1){
            System.out.println("Число не найдено");
        }else System.out.println("Число найдено");
        scanner.close();
    }
}