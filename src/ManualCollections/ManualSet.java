package ManualCollections;

import java.util.Iterator;

//Данный класс, реализует множество
public class ManualSet<E> implements Iterable<E>{

    public ManualSet() {

    }

    public ManualSet(ManualSet<? extends E> set){

    }

    //Возвращает true, если элемент удалось добавить во множество
    public boolean add(E e){
        return false;
    }

    //Возвращает true, если элемент удалось удалить из множества
    public boolean remove(E e){
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
