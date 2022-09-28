package recourdsingers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RecourdSingers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        // Введення інформації про співаків
        System.out.println("Введіть кількість співаків => ");
        int n = sc.nextInt();    //	кількість співаків
        Singers singer[] = new Singers[n];
        System.out.println("Введіть інформацію про співаків: ");
        for (int i = 0; i < singer.length; i++) {
            sc.nextLine();    //	очищення буфера
            singer[i] = new Singers();
            System.out.print("Прізвище " + (i + 1) + "-го співака => ");
            singer[i].name = sc.nextLine();
            System.out.print("Рейтинг " + (i + 1) + "-го співака => ");
            singer[i].rating = sc.nextDouble();
            System.out.print("Кількість випущенних альбомів " + (i + 1) + "-им співаком => ");
            singer[i].numberofalbums = sc.nextInt();
        }

        // Виведення отриманої інформації
        System.out.println("\nХарактеристики співаків:");
        for (int i = 0; i < singer.length; i++) {
            System.out.println("" + singer[i].name + "\t" + "- рейтинг виконавця " + singer[i].rating +
                    ", кількість випущенних альбомів " + singer[i].numberofalbums);
        }

        // Виконавець з найбільшим рейтингом
        int nommax = 0;    //номер елемента для співака з максимальним рейтингом (початкове значення)
        double max = singer[nommax].rating; //максимальний рейтинг (початкове значення)
        for (int i = 0; i < singer.length; i++)
            if (singer[i].rating > max) {
                max = singer[i].rating;
                nommax = i;
            }
        System.out.println("\nНайпопулярніший виконавець: ");
        System.out.println("" + singer[nommax].name + "\t" + "- рейтинг виконавця " + singer[nommax].rating +
                ", кількість випущенних альбомів " + singer[nommax].numberofalbums);

        // Виконавець з к-тю випущенних альбомів більше середньої
        double s = 0;    //сумарна к-ть альбомів
        for (int i = 0; i < singer.length; i++)
            s += singer[i].numberofalbums;
        double sr = s / singer.length;
        // середня к-ть альбомів
        System.out.println("Середня к-ть альбомів =" + sr);
        System.out.println("\nВиконавець з к-тю випущенних альбомів більше середньої");
        for (int i = 0; i < singer.length; i++) {
            if (singer[i].numberofalbums > sr)
                System.out.println(singer[i].name + "\t" + "- рейтинг виконавця " + singer[i].rating +
                        ", кількість випущенних альбомів " + singer[i].numberofalbums);
        }

        // Пошук за назвою
        sc.nextLine();             // очищення буфера
        System.out.println("Введіть прізвище шуканого виконавця=>");
        String name = sc.nextLine();
        int nom = -1; //−1 – виконавець з шуканим прізвищем відсутній

        for (int i = 0; i < singer.length; i++)
            if (name.equalsIgnoreCase(singer[i].name))
                nom = i;

        if (nom!=-1){
            System.out.println("Такий виконавець є у списку. Це " + singer[nom].name + ", рейтинг виконавця " + singer[nom].rating +
                    ", кількість випущенних альбомів " + singer[nom].numberofalbums);
        }
        else System.out.println("Такого виконавця немає у списку.");

        Singers[] singersAsc = singer.clone();

       // Сортування масиву за прізвищем в алфавітному порядку
        Arrays.sort(singersAsc, Comparator.comparing(singers -> singers.name));
        System.out.println("\nСортування масиву за прізвищем в алфавітному порядку: ");
        for (int i = 0; i < singersAsc.length; i++) {
            System.out.println(singersAsc[i].name + "\tрейтинг виконавця " + singersAsc[i].rating +
                    "\tкількість випущенних альбомів " + singersAsc[i].numberofalbums);
        }

        // Сортування за прізвищем в зворотньому порядку
        Singers[] singersDesc = singer.clone();
        Arrays.sort(singersDesc, (singers, t1) -> t1.name.compareToIgnoreCase(singers.name));
        System.out.println("\nСортування за прізвищем в зворотньому порядку: ");
        for (int i = 0; i < singersDesc.length; i++) {
            System.out.println(singersDesc[i].name + "\tрейтинг виконавця " + singersDesc[i].rating +
                    "\tкількість випущенних альбомів " + singersDesc[i].numberofalbums);
        }

        // Редагування та виведення інформації про пісню після редагування
        for (int i = 0; i < singer.length; i++)
            System.out.printf("\n%d) %s ", i + 1, singer[i].name);
        System.out.println("\nВведіть співця (індекс) для редагування:");
        int selectedIndex = sc.nextInt() - 1;
        System.out.println("1) Прізвище");
        System.out.println("2) Рейтинг");
        System.out.println("3) Кількість випущенних альбомів");
        System.out.print("Введіть бажане поле (індекс) для редагування:");
        int selectedFieldIndex = sc.nextInt();
        Singers singerObject = singer[selectedIndex];
        switch (selectedFieldIndex) {
            case 1: {
                System.out.println("Прізвище: " + singerObject.name);
                System.out.println();
                System.out.print("Введіть нове прізвище: ");
                singerObject.name = sc.next().trim();
                break;
            }
            case 2: {
                System.out.println("Рейтинг: " + singerObject.rating);
                System.out.println();
                System.out.print("Введіть новий рейтинг: ");
                singerObject.rating = sc.nextDouble();
                break;
            }
            case 3: {
                System.out.println("Кількість випущенних альбомів: " + singerObject.numberofalbums);
                System.out.println();
                System.out.print("Введіть нову кількість випущених альбомів: ");
                singerObject.numberofalbums = sc.nextInt();
                break;
            }
        }
        singer[selectedIndex] = singerObject;
        System.out.println(" " + singerObject.name + " рейтинг " + singerObject.rating + ", кількість випущенних альбомів " + singerObject.numberofalbums);

    }
}