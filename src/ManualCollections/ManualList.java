package ManualCollections;

import java.util.Iterator;

//Класс реализует связный список
class ManualList<E> implements Iterable<E> {

    private Element<E> first;    //Первый элемент списка
    private Element<E> last;     //Последний элемент списка
    private int sizeList;        //Размер списка

    public ManualList() {
        first = null;
        last = null;
        sizeList = 0;
    }

    public ManualList(ManualList<? extends E> list) {
        this();
        for (E e : list) this.addLast(e);
    }

    //Вспомогательный внутренний класс для хранения данных
    private class Element<E> {
        E content;               //Хранимые данные
        Element<E> next;         //Указатель на следующий элемент списка
        Element<E> prev;         //Указатель на предыдущие элемент списка

        //Конструктор создает первый эелемент пустого списка
        public Element(E content) {
            this.content = content;
            next = null;
            prev = null;
        }

    }

    //Метод добавляет элемент в пустой список
    private void addInEmptyList(E e) {
        first = new Element<>(e);
        last = first;
        sizeList = 1;
    }

    //Метод добавляет элемент в начало списка
    public void addFirst(E e) {
        if (isEmpty()) {
            addInEmptyList(e);
            return;
        }
        Element<E> n = new Element<>(e);
        n.next = first;
        first.prev = n;
        first = n;
        sizeList++;
    }

    //Метод добавляет элемент в конец списка
    public void addLast(E e) {
        if (isEmpty()) {
            addInEmptyList(e);
            return;
        }
        Element<E> n = new Element<>(e);
        last.next = n;
        n.prev = last;
        last = n;
        sizeList++;
    }

    //Метод возвращает первый элемент списка
    public E getFirst() {
        if (isEmpty()) return null;
        return first.content;
    }

    //Метод возвращает последний элемент списка
    public E getLast() {
        if (isEmpty()) return null;
        return last.content;
    }

    //Метод возвращает произвольный элемент списка
    public E get(int i) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        if ((i < 0) | (i >= sizeList)) throw new IndexOutOfBoundsException();
        int j = -1;
        for (E e : this) {
            j++;
            if (j == i) return e;
        }
        return null;
    }

    //Метод устанавливает новое значение произвольному элементу списка
    public void set(E e, int i) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        if ((i < 0) | (i >= sizeList)) throw new IndexOutOfBoundsException();
        Element<E> current = first;
        int j = 0;
        while (current!=null){
            if (j==i){
                current.content=e;
                return;
            }
            j++;
            current=current.next;
        }
    }

    //Метод возвращает произвольный элемент из списка, удаляя его. Если список пуст - возвращается null
    public E remove(int i) {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        if ((i < 0) | (i > (size() - 1))) throw new IndexOutOfBoundsException();
        if (i == 0) {
            return removeFirst();
        }
        if (i == (size() - 1)) {
            return removeLast();
        }

        Element<E> current = first;
        int j = 0;
        while (j != i) {
            j++;
            current = current.next;
        }
        Element<E> n = current.next;
        Element<E> p = current.prev;
        p.next = n;
        n.prev = p;
        sizeList--;
        return current.content;
    }

    //Метод возвращает первый элемент из списка, удаляя его. Если список пуст - возвращается null
    public E removeFirst() {
        if (isEmpty()) return null;
        E n = first.content;
        if (first == last) {
            first = null;
            last = null;
        } else
            first = first.next;
        if (first != null) first.prev = null;
        sizeList--;
        return n;
    }

    //Метод возвращает последний элемент из списка, удаляя его. Если список пуст - возвращается null
    public E removeLast() {
        if (isEmpty()) return null;
        E n = last.content;
        if (last == first) {
            last = null;
            first = null;
        } else
            last = last.prev;
        if (last != null) last.next = null;
        sizeList--;
        return n;
    }

    //Метод возвращает размер списка
    public int size() {
        return sizeList;
    }

    //Метод возвращает true, если список пуст
    public boolean isEmpty() {
        return sizeList == 0;
    }

    //Метод очищает список
    public void clear() {
        first = null;
        last = null;
        sizeList = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Element<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E n = current.content;
                current = current.next;
                return n;
            }
        };
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (E e : this) s += e.toString() + " ";
        s += "]";
        return s;
    }
}