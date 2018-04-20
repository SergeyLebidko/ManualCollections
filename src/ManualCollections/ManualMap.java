package ManualCollections;

//Класс реализующий ассоциативный массив
public class ManualMap<K, V>{

    //Класс, необходимый для хранения элементов ассоциативного массива
    private class MapElement<K, V>{
        K key;
        V val;

        public MapElement(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

    private final int START_SIZE=10;    //Начальный размер массива
    private final int STEP_RESIZE=20;   //Шаг изменения размеров массива
    private int fullCount;              //Количество заполненных элементов массива (оно же - количество ключей в массиве)
    private MapElement<K, V>[] m;

    public ManualMap() {
        m=new MapElement[START_SIZE];
        fullCount=0;
    }

    public ManualMap(ManualMap<K,V> map){
        this();
        for (K key: map.keySet())put(key, map.get(key));
    }

    //Метод добавляет элемент к массиву. Возвращает предыдущее значение, связанное с ключом. Если предыдущего значения не было - возвращает null
    public V put(K k, V v){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;
        if (m[pos]==null){
            m[pos]=new MapElement<>(k,v);
            fullCount++;
            resize();
            return null;
        }
        if (m[pos]!=null){
            V oldv=m[pos].val;
            m[pos].val=v;
            return oldv;
        }
        return null;
    }

    //Метод возвращает элемент, связанный с ключом k. Если такого элемента нет - возвращает null
    public V get(K k){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;
        if(m[pos]!=null)return m[pos].val;
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k, возвращает значение v
    public V remove(K k){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;
        V oldv=m[pos].val;
        m[pos]=null;
        fullCount--;
        resize();
        return oldv;
    }

    //Удаляет пару ключ-значение соответствующую ключу k и значению v, возвращает true, если данная операция прошла успешно
    public boolean remove(K k, V v){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;
        if (m[pos]==null)return false;
        if((m[pos].val.equals(v))){
            m[pos]=null;
            fullCount--;
            resize();
            return true;
        }
        return false;
    }

    //Возвращает множество ключей
    public ManualSet<K> keySet(){
        ManualSet<K> keys=new ManualSet<>();
        for (int i=0;i<m.length;i++)if (m[i]!=null)keys.add(m[i].key);
        return keys;
    }

    //Возвращает массив значений, связанных с ключами
    public ManualArray<V> valsArray(){
        ManualArray<V> vals=new ManualArray<>();
        for (int i=0;i<m.length;i++)if (m[i]!=null)vals.add(m[i].val);
        return vals;
    }

    //Равен true, если массив содержит ключ k
    public boolean containsKey(K k){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;
        if(m[pos]!=null)return true;
        return false;
    }

    //Равен true, если массив содержит значение v
    public boolean containsValue(V v){
        for (int i=0;i<m.length;i++){
            if (m[i]!=null){
                if (m[i].val.equals(v))return true;
            }
        }
        return false;
    }

    //Возвращает количество элементов в массиве
    public int size(){
        return fullCount;
    }

    //Очищает массив
    public void clear(){
        m=new MapElement[START_SIZE];
        fullCount=0;
    }

    //Изменяет размер массива
    private void resize(){
        if (fullCount==m.length){
            MapElement<K, V>[] m1=new MapElement[m.length+STEP_RESIZE];
            int pos;
            for (int i=0;i<m.length;i++){
                pos=m[i].key.hashCode()%m1.length;
                m1[pos]=m[i];
            }
            m=m1;
            return;
        }
        if ((m.length-fullCount)>STEP_RESIZE){
            MapElement<K, V>[] m1=new MapElement[m.length-STEP_RESIZE];
            int pos;
            for (int i=0;i<m.length;i++){
                if (m[i]==null)continue;
                pos=m[i].key.hashCode()%m1.length;
                m1[pos]=m[i];
            }
            m=m1;
            return;
        }
    }

    @Override
    public String toString() {
        String str="[ ";
        for (int i=0;i<m.length;i++){
            if (m[i]!=null){
                str+="(";
                str+=m[i].key;
                str+="=";
                str+=(m[i].val==null?"null":m[i].val);
                str+=" ";
            }
        }
        str+="]";
        return str;
    }

}
