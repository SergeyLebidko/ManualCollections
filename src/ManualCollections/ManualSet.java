package ManualCollections;

import java.util.Iterator;

//Данный класс, реализует множество
public class ManualSet<E> implements Iterable<E>{

    private int SET_POWER=100;          //Количество элементов в массиве
    private ManualList<E>[] s;          //Массив связных списков
    private int setSize;

    public ManualSet() {
        s=new ManualList[SET_POWER];
        for (int i=0;i<SET_POWER;i++)s[i]=new ManualList<>();
        setSize=0;
    }

    public ManualSet(ManualSet<? extends E> set){
        this();
        for (E e:set)add(e);
    }

    //Возвращает true, если элемент удалось добавить во множество
    public boolean add(E e){
        if(e==null)throw new NullPointerException();
        int pos=e.hashCode()%SET_POWER;
        if (s[pos].isEmpty()){
            s[pos].addLast(e);
            setSize++;
            return true;
        }
        if (!s[pos].isEmpty()){
            if (contains(e))return false;
            s[pos].addLast(e);
            setSize++;
            return true;
        }
        return false;
    }

    //Возвращает true, если элемент удалось удалить из множества
    public boolean remove(E e){
        if(e==null)throw new NullPointerException();
        int pos=e.hashCode()%SET_POWER;
        if (s[pos].isEmpty())return false;
        if (!s[pos].isEmpty()){
            int j=-1;
            for (E etmp: s[pos]){
                j++;
                if (etmp.equals(e))break;
            }
            if (j==-1)return false;
            s[pos].remove(j);
            setSize--;
            return true;
        }
        return false;
    }

    //Возвращает true, если множество содержит данный элемент
    public boolean contains(E e){
        if (e==null)throw new NullPointerException();
        int pos=e.hashCode()%SET_POWER;
        if (s[pos].isEmpty())return false;
        if (!s[pos].isEmpty()){
            for (E etmp:s[pos])if(etmp.equals(e))return true;
        }
        return false;
    }

    //Очищает множество
    public void clear(){
        s=new ManualList[SET_POWER];
        for (int i=0;i<SET_POWER;i++)s[i]=new ManualList<>();
        setSize=0;
    }

    //Возвращает количество элементов в множестве
    public int size(){
        return setSize;
    }

    //Возвращает true, если множество - пусто
    public boolean isEmpty(){
        return setSize==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private ManualList<E> tmpList=new ManualList<>();
            private Iterator<E> tmpIterator;
            {
                for (int i=0;i<SET_POWER;i++){
                    if (!s[i].isEmpty()){
                        for (E e:s[i]) tmpList.addLast(e);
                    }
                }
                tmpIterator=tmpList.iterator();
            }

            @Override
            public boolean hasNext() {
                return tmpIterator.hasNext();
            }

            @Override
            public E next() {
                return tmpIterator.next();
            }
        };
    }

    @Override
    public String toString() {
        String str="[ ";
        for (E e:this)str+=" "+e;
        str+=" ]";
        return str;
    }
}
