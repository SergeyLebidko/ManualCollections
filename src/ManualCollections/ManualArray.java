package ManualCollections;

import java.util.Arrays;
import java.util.Iterator;

//Класс реализует массив изменяющейся длины
public class ManualArray<E> implements Iterable<E>{

    private Object[] a;
    private int startSize;  //Стартовый размер массива
    private int pointer;    //Указатель на последний элемент данных

    private final int STEP_RESIZE=10;    //Массив при необходимости будет уменьшаться или увеличиваться на данное количество элементов


    public ManualArray() {
        startSize = 5;
        pointer = -1;
        a = new Object[startSize];
    }

    public ManualArray(ManualArray<? extends E> array){
        this();
        for (E e: array)add(e);
    }

    //Метод добавляет в массив новый элемент
    public void add(E e) {
        pointer++;
        a[pointer] = e;
        resize();
    }

    //Метод возвращает элмент массива с индексом i
    public E get(int i) {
        if ((i < 0) | (i > pointer)) throw new IndexOutOfBoundsException();
        return (E) a[i];
    }

    //Метод возвращает элмент массива с индексом i, попутно удаляя его
    public E remove(int i){
        if ((i < 0) | (i > pointer)) throw new IndexOutOfBoundsException();
        E e=(E)a[i];
        for (int j=i;j<pointer;j++)a[j]=a[j+1];
        pointer--;
        resize();
        return e;
    }

    //Метод вставляет элемент в массив в позицию i
    public void insert(E e, int i){
        if ((i < 0) | (i > pointer)) throw new IndexOutOfBoundsException();
        pointer++;
        for (int j=pointer;j>i;j--)a[j]=a[j-1];
        a[i]=e;
        resize();
    }

    //Метод изменяет размер массива
    private void resize() {
        //Если массив заполнен - добавляем к нему STEP_RESIZE элементов
        if (pointer==(a.length-1)){
            a=Arrays.copyOf(a, startSize+STEP_RESIZE);
            return;
        }

        //Если в массиве более STEP_RESIZE пустых элементов - уменьшаем его на STEP_RESIZE элементов
        if ((a.length-pointer-1)>STEP_RESIZE){
            a=Arrays.copyOf(a, a.length-STEP_RESIZE);
            return;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int i=0;

            @Override
            public boolean hasNext() {
                return i<=pointer;
            }

            @Override
            public E next() {
                i++;
                return (E) a[i-1];
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
