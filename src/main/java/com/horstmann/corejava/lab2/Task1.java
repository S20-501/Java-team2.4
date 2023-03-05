import java.time.LocalDate;

public class Task1 {
    public static void main(String[] args) {
        //берем начало года
        LocalDate date = LocalDate.of(2023, 1, 1);
        for(int i=1; i<=12; i++) {

            //отступ в начале месяца
            int value =date.getDayOfWeek().getValue();
            if(value == 7)
                value = 1;
            else
                value = value+1;
            for (int j = 1; j < value; j++)
                System.out.print("\t");

            //вывод дней
            while (date.getMonthValue() == i) {
                if(date.getDayOfWeek().getValue() == 7)
                    System.out.print("\n");
                System.out.printf("%4d", date.getDayOfMonth());
                date = date.plusDays(1);
            }

            //конец месяца
            System.out.print("\n");
        }
    }
}