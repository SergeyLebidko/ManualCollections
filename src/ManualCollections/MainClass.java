package ManualCollections;

public class MainClass {

    public static void main(String[] args) {
        ManualList<String> sml = new ManualList<>();
        sml.addLast("A");
        sml.addLast("B");
        sml.addLast("C");
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());

        System.out.println("----------- ");

        sml.removeLast();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        System.out.println();

        sml.removeLast();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        System.out.println();

        sml.removeFirst();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());
        System.out.println();

        sml.removeFirst();
        System.out.println("Размер " + sml.getSize());
        System.out.println("Содержимое " + sml.toString());

        System.out.println("----------- ");

        for (char a='A';a<='Z'; a++)sml.addLast(""+a);
        System.out.println("Содержимое "+sml);
        System.out.println("Размер "+sml.getSize());
        for (char a='z';a>='a'; a--)sml.addFirst(""+a);
        System.out.println("Содержимое "+sml);
        System.out.println("Размер "+sml.getSize());

        System.out.println("Пeрвый элемент "+sml.getFirst());
        System.out.println("Последний элемент "+sml.getLast());

        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeFirst());
        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeLast());

        System.out.println("Новый размер "+sml.getSize());
        System.out.println("Новое содержимое "+sml);

        sml.clear();
        System.out.println("Список очищен "+sml.isEmpty()+" размер списка "+sml.getSize());

        sml.addLast("100");
        sml.addLast("AAA");
        sml.addLast("***");
        sml.addLast("Git");
        sml.addLast("SQL");

        System.out.println("Новое содержимое "+sml);
        System.out.println("Элемент №2 "+sml.get(2));

        System.out.println();
        System.out.println("Создаем новый список из старого");
        ManualList<String> sml2=new ManualList<>(sml);
        System.out.println("Содержимое нового списка "+sml2);

    }

}
