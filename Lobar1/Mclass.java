public class Mclass {
    public static void main(String[] args)  {
        System.out.println(dayIncrement("������� ���� 01.04.2015",4));
    }
    private static String dayIncrement (String in, int d){
        //����������� �����, �����, ��� �� ������� ������ in
        String inDay    = in.substring((in.length()-10), (in.length()-8));
        String inMonth  = in.substring((in.length()-8), (in.length()-5));
        String inYear   = in.substring(in.length()-5);
        //� ������� ���� ���������� ����������� ���������� ����
        int days = Integer.parseInt(inDay) + d;
        String day = Integer.toString(days);
        //��������� "0" ���� ����������
        if (days < 10){
            day = "0"+day;
        }
        return "���� ������� " + day + inMonth + inYear;
    }
}