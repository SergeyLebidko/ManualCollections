package ManualCollections;

import java.util.Iterator;

//Класс реализует связный список
class ManualList<E> implements Iterable<E> {

    private Element<E> first;    //Первый элемент списка
    private Element<E> last;     //Последний элемент списка
    private int size;            //Размер списка

    public ManualList() {
        first = null;
        last = null;
        size = 0;
    }

    public ManualList(ManualList<? extends E> list){
        this();
        for (E e: list)this.addLast(e);
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
        size = 1;
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
        size++;
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
        size++;
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
    public E get(int i){
        if(isEmpty())throw new IndexOutOfBoundsException();
        if((i<0) | (i>size)) throw new IndexOutOfBoundsException();
        int j=-1;
        for (E e:this){
            j++;
            if (j==i)return e;
        }
        return null;
    }

    //Метод возвращает первый элемент из списка, удаляя его
    public E removeFirst() {
        if (isEmpty()) return null;
        E n = first.content;
        if (first == last) {
            first = null;
            last = null;
        } else
            first = first.next;
        if (first != null) first.prev = null;
        size--;
        return n;
    }

    public E removeLast() {
        if (isEmpty()) return null;
        E n = last.content;
        if (last == first) {
            last = null;
            first = null;
        } else
            last = last.prev;
        if (last != null) last.next = null;
        size--;
        return n;
    }

    //Метод возвращает размер списка
    public int getSize() {
        return size;
    }

    //Метод возвращает true, если список пуст
    public boolean isEmpty() {
        return size == 0;
    }

    //Метод очищает список
    public void clear(){
        first=null;
        last=null;
        size=0;
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