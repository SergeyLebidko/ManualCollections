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

        //Метод сравнивает значение переданного ему ключа со значением ключа из текущего объекта
        public boolean equalsKey(K k){
            return key.equals(k);
        }

    }

    private final int START_SIZE=5;     //Начальный размер массива
    private final int STEP_RESIZE=10;   //Шаг изменения размеров массива
    private int fullCount;              //Количество ключей в массиве
    private ManualArray<MapElement<K,V>>[] m;

    public ManualMap() {
        m=new ManualArray[START_SIZE];
        fullCount=0;
    }

    public ManualMap(ManualMap<? extends K,? extends V> map){
        this();
        for (K key: map.keySet())put(key, map.get(key));
    }

    //Метод добавляет элемент к массиву. Возвращает предыдущее значение, связанное с ключом. Если предыдущего значения не было - возвращает null
    public V put(K k, V v){
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%m.length;

        //Если ячейка по хэшу добавляемого ключа пуста - просто дабавляем новую пару "ключ-значение"
        if (m[pos]==null){
            m[pos]=new ManualArray<MapElement<K,V>>();
            m[pos].add(new MapElement<>(k,v));
            return null;
        }

        //Если ячейка по хэшу не пуста...
        if (m[pos]!=null){

        }
        return null;
    }

    //Метод возвращает элемент, связанный с ключом k. Если такого элемента нет - возвращает null
    public V get(Object k){
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k, возвращает значение v
    public V remove(K k){
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k и значению v, возвращает true, если данная операция прошла успешно
    public boolean remove(K k, V v){
        return false;
    }

    //Возвращает множество ключей
    public ManualSet<K> keySet(){
        return null;
    }

    //Возвращает массив значений, связанных с ключами
    public ManualArray<V> valsArray(){
        return null;
    }

    //Равен true, если массив содержит ключ k
    public boolean containsKey(Object k){
        return false;
    }

    //Равен true, если массив содержит значение v
    public boolean containsValue(Object v){
        return false;
    }

    //Возвращает количество элементов в массиве
    public int size(){
        return 0;
    }

    //Очищает массив
    public void clear(){

    }

    //Изменяет размер массива
    private void resize(){

    }

    @Override
    public String toString() {
        return "";
    }

}
