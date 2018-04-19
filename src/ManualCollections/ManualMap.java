package ManualCollections;

import java.util.Iterator;

//Класс реализующий ассоциативный массив
public class ManualMap<E> implements Iterable<E>{

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

}
