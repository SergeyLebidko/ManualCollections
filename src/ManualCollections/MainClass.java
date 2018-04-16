package ManualCollections;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("----- Тестирование массива переменной длины -----");
        System.out.println();



        System.out.println("----- Тестирование связного списка -----");
        System.out.println();

        System.out.println("Создаем список и последовательно помещаем в него три элемента");
        ManualList<String> sml = new ManualList<>();
        sml.addLast("A");
        sml.addLast("B");
        sml.addLast("C");
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());

        System.out.println("Удалаем элементы по одному из начала списка");
        sml.removeLast();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        sml.removeLast();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        sml.removeFirst();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        System.out.println();

        System.out.println("Заполняем список символами латинского алфавита");
        for (char a='A';a<='Z'; a++)sml.addLast(""+a);
        System.out.println("Размер "+sml.getSize());
        System.out.println("Содержимое "+sml);
        for (char a='z';a>='a'; a--)sml.addFirst(""+a);
        System.out.println("Размер "+sml.getSize());
        System.out.println("Содержимое "+sml);
        System.out.println("Пeрвый элемент "+sml.getFirst());
        System.out.println("Последний элемент "+sml.getLast());
        System.out.println();

        System.out.println("Удаляем по десять элементов в начале и в конце списка. Выводим на экран удаленные элементы");
        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeFirst());
        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeLast());
        System.out.println("Новый размер "+sml.getSize());
        System.out.println("Новое содержимое "+sml);
        System.out.println();

        System.out.println("Очищаем список");
        sml.clear();
        System.out.println("Список очищен размер списка "+sml.getSize());
        System.out.println();

        System.out.println("Снова заполняем список элементами");
        sml.addLast("100");
        sml.addLast("AAA");
        sml.addLast("***");
        sml.addLast("Git");
        sml.addLast("SQL");
        System.out.println("Новое содержимое "+sml);
        System.out.println();

        System.out.println("Получаем элемент с произвольным номером");
        System.out.println("Элемент №2 "+sml.get(2));
        System.out.println();

        System.out.println("Создаем новый список из элементов старого");
        ManualList<String> sml2=new ManualList<>(sml);
        System.out.println("Содержимое нового списка "+sml2);
        System.out.println();

    }

}
