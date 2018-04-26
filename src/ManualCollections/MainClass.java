package ManualCollections;

public class MainClass {

    private static void testArr(){
        System.out.println("----- Тестирование массива переменной длины -----");
        System.out.println();

        System.out.println("Создаем массив и последовательно помещаем в него четыре элемента");
        ManualArray<String> aml=new ManualArray<>();
        aml.add("A");
        aml.add("B");
        aml.add("C");
        aml.add("E");
        System.out.println("Содержимое "+aml);
        System.out.println();

        System.out.println("Вставляем элемент в позицию 3");
        aml.insert("D", 3);
        System.out.println("Обновленное содержимое "+aml);
        System.out.println("Длина массива "+aml.size());
        System.out.println();

        System.out.println("Вставляем элементы в позиции 0 и 5");
        aml.insert("*", 0);
        aml.insert("+", 5);
        System.out.println("Обновленное содаржимое "+aml);
        System.out.println();

        System.out.println("Очищаем массив");
        aml.clear();
        System.out.println("Размер после очистки "+aml.size()+" Содержимое после очистки "+aml);
        System.out.println();

        System.out.println("Добавляем 26 элементов");
        for (char c='A';c<='Z';c++)aml.add(""+c+((int)c-64));
        System.out.println("Содаржимое списка "+aml);
        System.out.println("Длина списка "+aml.size());
        System.out.println();

        System.out.println("Удаляем первый элемент. Удаленный элемент "+aml.remove(0));
        System.out.println("Удаляем последний элемент. Удаленный элемент "+aml.remove(24));
        System.out.println("Удаляем десять элементов в середине списка");
        for (int i=10;i<20;i++)aml.remove(10);
        System.out.println("Выводим список");
        for (String s: aml) System.out.println(s);
        System.out.println();

        System.out.println("Создаем новый массив на основе старого");
        ManualArray<String> aml2=new ManualArray<>(aml);
        System.out.println("Содержимое нового массива "+aml2);
        System.out.println();

        System.out.println("Выводим содержиомое нового массива поэлементно");
        for (int i=0;i<aml2.size();i++) System.out.println(aml2.get(i));
        System.out.println();

        System.out.println("Поэлментно изменяем содержмое ячеек массива");
        for (int i=0;i<aml2.size();i++)aml2.set(aml2.get(i)+"_*", i);
        System.out.println("Новый массив"+aml2);
        System.out.println();

        System.out.println("Очищаем новый массив");
        aml.clear();
        System.out.println(aml.isEmpty()?"Массив очищен":"В массиве остались элементы");
        System.out.println();
    }

    private static void testList(){
        System.out.println("----- Тестирование связного списка -----");
        System.out.println();

        System.out.println("Создаем список и последовательно помещаем в него три элемента");
        ManualList<String> sml = new ManualList<>();
        sml.addLast("A");
        sml.addLast("B");
        sml.addLast("C");
        System.out.println("Размер " + sml.size());
        System.out.println("Содержимое " + sml.toString());

        System.out.println("Удалаем элементы по одному из начала списка");
        sml.removeLast();
        System.out.println("Размер " + sml.size());
        System.out.println("Содержимое " + sml.toString());
        sml.removeLast();
        System.out.println("Размер " + sml.size());
        System.out.println("Содержимое " + sml.toString());
        sml.removeFirst();
        System.out.println("Размер " + sml.size());
        System.out.println("Содержимое " + sml.toString());
        System.out.println();

        System.out.println("Заполняем список символами латинского алфавита");
        for (char a='A';a<='Z'; a++)sml.addLast(""+a);
        System.out.println("Размер "+sml.size());
        System.out.println("Содержимое "+sml);
        for (char a='z';a>='a'; a--)sml.addFirst(""+a);
        System.out.println("Размер "+sml.size());
        System.out.println("Содержимое "+sml);
        System.out.println("Пeрвый элемент "+sml.getFirst());
        System.out.println("Последний элемент "+sml.getLast());
        System.out.println();

        System.out.println("Удаляем по десять элементов в начале и в конце списка. Выводим на экран удаленные элементы");
        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeFirst());
        for (int i=0;i<10;i++) System.out.println("Удален элемент "+sml.removeLast());
        System.out.println("Новый размер "+sml.size());
        System.out.println("Новое содержимое "+sml);
        System.out.println();

        System.out.println("Очищаем список");
        sml.clear();
        System.out.println("Список очищен размер списка "+sml.size());
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

        System.out.println("Изменяем элемент в середине списка на \"X7X\"");
        sml2.set("X7X",2);
        System.out.println("Изменяем элемент в начале списка на \"JSE\"");
        sml2.set("JSE",0);
        System.out.println("Изменяем элемент в конце списка на \"+++\"");
        sml2.set("+++",4);
        System.out.println("Список после изменений "+sml2);
        System.out.println();

        System.out.println("Удаляем два элемента из середины нового списка");
        sml2.remove(1);
        sml2.remove(2);
        System.out.println("Содержимое списка "+sml2);
        System.out.println("Удаляем еще два элемента");
        sml2.remove(0);
        sml2.remove(1);
        System.out.println("Новый список "+sml2);
        System.out.println();

    }

    private static void testSet(){
        System.out.println("----- Тестирование множества -----");
        ManualSet<String> mss=new ManualSet<>();
        mss.add("A01");
        mss.add("15B");
        mss.add("CX3");
        mss.add("D36");
        mss.add("EDR");
        System.out.println("Множество создано. Его содержимое "+mss);
        System.out.println("Размер множества "+mss.size());
        System.out.println();

        System.out.println("Пробуем добавить во множество элементы, которые в нем уже есть \"A01\" и \"CX3\"");
        mss.add("A01");
        mss.add("CX3");
        System.out.println("Множество после попытки добавления "+mss);
        System.out.println();

        System.out.println("Добавляем элемерты, которых еще нет во множестве \"RT@\" и \"R#G\"");
        System.out.println(mss.add("RT@")?"Успешно":"Не успешно");
        System.out.println(mss.add("R#G")?"Успешно":"Не успешно");
        System.out.println("Обновленное множество "+mss);
        System.out.println();

        System.out.println("Попытка удалить элемент, которого нет \"F0S\" "+(mss.remove("F0S")?"Успешно":"Не успешно"));
        System.out.println();

        System.out.println("Попытка удалить элемент, который есть \"D36\" "+(mss.remove("D36")?"Успешно":"Не успешно"));
        System.out.println("Обновленное множество "+mss);
        System.out.println();

        System.out.println("Поиск элемента во множестве");
        System.out.println("Элемент \"R#G\" "+(mss.contains("R#G")?"найден":"не найден")+" во множестве");
        System.out.println("Элемент \"UY*\" "+(mss.contains("UY*")?"найден":"не найден")+" во множестве");
        System.out.println();

        System.out.println("Выводим элементы множества по одному:");
        for (String s:mss) System.out.println(s);
        System.out.println();

        System.out.println("Создаем второе множество на основе первого. Первое множество очищаем");
        ManualSet<String> mss2=new ManualSet<>(mss);
        mss.clear();
        System.out.println("Первое множество "+mss+" "+(mss.isEmpty()?"пусто":"не пусто"));
        System.out.println("Второе множество "+mss2+" "+(mss2.isEmpty()?"пусто":"не пусто"));
        System.out.println();

    }

    private static void testMap(){
        System.out.println("----- Тестирование ассоциативного массива -----");
        ManualMap<String, Integer> mmp=new ManualMap<>();
        mmp.put("AAB", 1);
        mmp.put("ABX", 2);
        mmp.put("GTX", 3);
        mmp.put("RVM", 4);
        mmp.put("JVM", 5);
        mmp.put("TF@", 6);
        mmp.put("C++", 7);
        mmp.put("ADA", 8);
        mmp.put("FAX", 9);
        mmp.put("XYZ", 10);
        System.out.println("Создан массив размера "+mmp.size());
        System.out.println("Содержимое массива "+mmp);
        System.out.println();

        System.out.println("Получаем элементы");
        System.out.println("GTX = "+mmp.get("GTX"));
        System.out.println("C++ = "+mmp.get("C++"));
        System.out.println("Попытка получить элемент, которого нет. HDD = "+(mmp.get("HDD")==null?"null":"значение получено успешно"));
        System.out.println();

        System.out.println("Заменяем элементы методом put");
        System.out.println("Старое значение TF@ = "+mmp.put("TF@", 1006));
        System.out.println("Старое знаечние FAX = "+mmp.put("FAX", 1009));
        System.out.println("Обновленный массив "+mmp);
        System.out.println();

        System.out.println("Удаляем значения по ключу");
        System.out.println("Удаляем значение ABX = "+mmp.remove("ABX"));
        System.out.println("Удаляем значение AAB = "+mmp.remove("AAB"));
        System.out.println("Обновленный массив "+mmp);
        System.out.println();

        System.out.println("Удаляем пары значений");
        System.out.println("Удаляем RVM=4: "+(mmp.remove("RVM",4)?"Успешно":"Не успешно"));
        System.out.println("Удаляем ADA=8: "+(mmp.remove("ADA",8)?"Успешно":"Не успешно"));
        System.out.println("Попытка удалить не существующее значение PPP=15 "+(mmp.remove("PPP",15)?"Успешно":"Не успешно"));
        System.out.println("Обновленный массив "+mmp);
        System.out.println();

        System.out.println("Множество ключей "+mmp.keySet());
        System.out.println("Массив значений "+mmp.valsArray());
        System.out.println();

        System.out.println("Массив содержит ключ C++ - "+(mmp.containsKey("C++")?"да":"нет"));
        System.out.println("Массив содержит значение 1009 - "+(mmp.containsValue(1009)?"да":"нет"));
        System.out.println("Массив содержит ключ FFF - "+(mmp.containsKey("FFF")?"да":"нет"));
        System.out.println("Массив содержит значение 24 - "+(mmp.containsValue(24)?"да":"нет"));
        System.out.println();

        System.out.println("Количество пар в массиве "+mmp.size());
        System.out.println();

        System.out.println("Создаем новый массив на основе старого");
        ManualMap<String, Integer> mmp2=new ManualMap<>(mmp);
        System.out.println("Старый массив "+mmp);
        System.out.println("Новый массив "+mmp2);
        System.out.println();

        System.out.println("Очищаем старый массив");
        mmp.clear();
        System.out.println("Старый массив пуст - "+(mmp.isEmpty()?"да":"нет"));
        System.out.println();

    }

    public static void main(String[] args) {
        testArr();
        testList();
        testSet();
        testMap();
    }

}
