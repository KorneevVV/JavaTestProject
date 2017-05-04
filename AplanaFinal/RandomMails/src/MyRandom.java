import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by USERrr on 04.05.2017.
 */
public class MyRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(randMails(10));
        }
    }

    public static String randMails(int mailLenght) {
        List<Character> simbols = new ArrayList<Character>();
        char[] mailAddress = new char[mailLenght];
        for (int i = 0, j = 0, k = 0; i < 62; i++) {
            if (i < 26) {
                simbols.add((char) ('A' + i));
            } else if (i < 52) {
                simbols.add((char) ('a' + j));
                j++;
            } else {
                simbols.add('0');
                simbols.add('1');
                simbols.add('2');
                simbols.add('3');
                simbols.add('4');
                simbols.add('5');
                simbols.add('6');
                simbols.add('7');
                simbols.add('8');
                simbols.add('9');
            }

        }

        Random mRand = new Random();
        for (int i = mailLenght - 1; i >= 1; i--) {
            Collections.shuffle(simbols);
            int j = mRand.nextInt(i + 1);
            mailAddress[i] = simbols.get(j);
        }
        String mail = new String(mailAddress);
        return mail + "@yandex.ru";
    }
}
