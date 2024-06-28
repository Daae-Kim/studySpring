import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumberBaseballGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] computerNumbers = generateUniqueNumbers();
        int attempts = 0;
        boolean gameWon = false;

        System.out.println("숫자 야구 게임을 시작합니다! 3자리 숫자를 맞춰보세요.");

        while (!gameWon) {
            attempts++;
            System.out.print("추측한 숫자를 입력하세요: ");
            String userInput = scanner.nextLine();

            if (userInput.length() != 3 || !userInput.matches("\\d{3}")) {
                System.out.println("잘못된 입력입니다. 3자리 숫자를 입력해주세요.");
                continue;
            }

            int[] userNumbers = new int[3];
            for (int i = 0; i < 3; i++) {
                userNumbers[i] = Character.getNumericValue(userInput.charAt(i));
            }

            int[] result = checkNumbers(computerNumbers, userNumbers);

            System.out.printf("결과: %d 스트라이크, %d 볼%n", result[0], result[1]);

            if (result[0] == 3) {
                gameWon = true;
                System.out.printf("축하합니다! %d번 만에 맞추셨습니다.%n", attempts);
            }
        }

        scanner.close();
    }

    private static int[] generateUniqueNumbers() {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(random.nextInt(10));
        }

        int[] numbers = new int[3];
        int index = 0;
        for (int number : uniqueNumbers) {
            numbers[index++] = number;
        }

        return numbers;
    }

    private static int[] checkNumbers(int[] computerNumbers, int[] userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strike++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }

    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
