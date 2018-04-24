package ManualCollections;

import java.util.Iterator;

//Данный класс, реализует множество
public class ManualSet<E> implements Iterable<E>{

    private int setPower;              //Количество элементов в массиве
    private ManualList<E>[] s;          //Массив связных списков
    private int setSize;

    public ManualSet() {
        setPower =4;
        s=new ManualList[setPower];
        for (int i = 0; i< setPower; i++)s[i]=new ManualList<>();
        setSize=0;
    }

    public ManualSet(ManualSet<? extends E> set){
        this();
        for (E e:set)add(e);
    }

    //Возвращает true, если элемент удалось добавить во множество
    public boolean add(E e){
        if(e==null)throw new NullPointerException();
        int pos=e.hashCode()% setPower;
        if (s[pos].isEmpty()){
            s[pos].addLast(e);
            setSize++;
            resize();
            return true;
        }
        if (!s[pos].isEmpty()){
            if (contains(e))return false;
            s[pos].addLast(e);
            setSize++;
            resize();
            return true;
        }
        return false;
    }

    //Возвращает true, если элемент удалось удалить из множества
    public boolean remove(E e){
        if(e==null)throw new NullPointerException();
        int pos=e.hashCode()% setPower;
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
            resize();
            return true;
        }
        return false;
    }

    //Возвращает true, если множество содержит данный элемент
    public boolean contains(E e){
        if (e==null)throw new NullPointerException();
        int pos=e.hashCode()% setPower;
        if (s[pos].isEmpty())return false;
        if (!s[pos].isEmpty()){
            for (E etmp:s[pos])if(etmp.equals(e))return true;
        }
        return false;
    }

    //Очищает множество
    public void clear(){
        setPower =4;
        s=new ManualList[setPower];
        for (int i = 0; i< setPower; i++)s[i]=new ManualList<>();
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

    //Метод производит перехэширование в зависимости от коэффициента заполнения хэш-массива
    private void resize(){
        if (isEmpty())return;
        double k = (double)setSize/(double) setPower;    //Коэффициент заполнения хэш-таблицы
        if ((k>=0.2) & (k<0.75))return;

        //Создаем новый массив и уже имеющиеся элементы переносим в него
        int newSetPower=setSize*2;
        ManualList<E>[] s1=new ManualList[newSetPower];
        for (int i=0;i<newSetPower;i++)s1[i]=new ManualList<>();
        int pos;
        for (E e: this){
            pos=e.hashCode()%newSetPower;
            s1[pos].addLast(e);
        }
        s=s1;
        setPower =newSetPower;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private ManualList<E> tmpList=new ManualList<>();
            private Iterator<E> tmpIterator;
            {
                for (int i = 0; i< setPower; i++){
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
