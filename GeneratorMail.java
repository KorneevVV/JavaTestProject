/**
 * Created by kracoz on 05.05.2017.
 */
public class GeneratorMail {
    private static final int MIN_NAME_EMAIL_LENGHT = 5;

    public static String generateNameMail(int maxNameEmailLenght){
        String dict = "abcd1efghi2jklmnop3qrstuv4wxyzABC5DEFG6HIJKL7MNOP8RSTU9VWXYZ0";
        int randomNameLenght =(int) (MIN_NAME_EMAIL_LENGHT + (Math.random() *(maxNameEmailLenght - MIN_NAME_EMAIL_LENGHT) ));// есди елать конкретный размер имени, то все еще проще
        StringBuilder generatedNameEmail = new StringBuilder();
        for (int i = 0; i < randomNameLenght; i++ ){
            generatedNameEmail.append(dict.charAt((int)(Math.random() * dict.length())));
        }
        return generatedNameEmail.toString();
    }

    public static void main(String[] args) {
        System.out.println(GeneratorMail.generateNameMail(15));
    }
}
