package ManualCollections;

import java.util.Iterator;

//Данный класс, реализует множество
public class ManualSet<E> implements Iterable<E>{

    private final int SET_POWER=100;
    private ManualList<E>[] s;

    public ManualSet() {
        s=new ManualList[SET_POWER];
        for (int i=0;i<SET_POWER;i++)s[i]=new ManualList<>();
    }

    public ManualSet(ManualSet<? extends E> set){
        this();
        for (E e:set)add(e);
    }

    //Возвращает true, если элемент удалось добавить во множество
    public boolean add(E e){

        return false;
    }

    //Возвращает true, если элемент удалось удалить из множества
    public boolean remove(E e){
        return false;
    }

    //Возвращает true, если множество содержит данный элемент
    public boolean contains(E e){
        return false;
    }

    //Очищает множество
    public void clear(){

    }

    //Возвращает true, если множество - пусто
    public boolean isEmpty(){
        return true;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return "";
    }
}
