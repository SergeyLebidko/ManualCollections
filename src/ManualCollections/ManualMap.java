package ManualCollections;

//Класс реализующий ассоциативный массив
public class ManualMap<K, V> {

    //Класс, необходимый для хранения элементов ассоциативного массива
    private class MapElement<K, V> {
        K key;
        V val;

        public MapElement(K key, V val) {
            this.key = key;
            this.val = val;
        }

        //Метод сравнивает переданный ему ключ со значением ключа из текущего объекта
        public boolean equalsKey(K k) {
            return key.equals(k);
        }

        //Метод сравнивает переданную ему пару "ключ-значение", с соответствующими полями текущего объекта
        public boolean equalsKeyAndVal(K k, V v){
            return key.equals(k) & val.equals(v);
        }

    }

    private int MAP_POWER = 100;                 //Начальный размер массива
    private int sizeMap;                         //Количество ключей в массиве
    private ManualArray<MapElement<K, V>>[] m;   //Массив связных списков

    public ManualMap() {
        m = new ManualArray[MAP_POWER];
        for (int i=0;i<MAP_POWER;i++)m[i]=new ManualArray<>();
        sizeMap = 0;
    }

    public ManualMap(ManualMap<? extends K, ? extends V> map) {
        this();
        for (K key : map.keySet()) put(key, map.get(key));
    }

    //Метод добавляет элемент к массиву. Возвращает предыдущее значение, связанное с ключом. Если предыдущего значения не было - возвращает null
    public V put(K k, V v) {
        if (k==null) throw new NullPointerException();
        int pos=k.hashCode()%MAP_POWER;
        if (m[pos].isEmpty()){
            m[pos].add(new MapElement<>(k,v));
            return null;
        }
        if (!m[pos].isEmpty()){
            for (int i=0;i<m[pos].size();i++){
                if (m[pos].get(i).equalsKey(k)){
                    V vtmp=m[pos].get(i).val;
                    m[pos].set(new MapElement<>(k,v),i);
                    return vtmp;
                }
            }
            m[pos].add(new MapElement<>(k,v));
        }
        return null;
    }

    //Метод возвращает элемент, связанный с ключом k. Если такого элемента нет - возвращает null
    public V get(Object k) {
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k, возвращает значение v
    public V remove(K k) {
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k и значению v, возвращает true, если данная операция прошла успешно
    public boolean remove(K k, V v) {
        return false;
    }

    //Возвращает множество ключей
    public ManualSet<K> keySet() {
        return null;
    }

    //Возвращает массив значений, связанных с ключами
    public ManualArray<V> valsArray() {
        return null;
    }

    //Равен true, если массив содержит ключ k
    public boolean containsKey(Object k) {
        return false;
    }

    //Равен true, если массив содержит значение v
    public boolean containsValue(Object v) {
        return false;
    }

    //Возвращает количество элементов в массиве
    public int size() {
        return sizeMap;
    }

    //Очищает массив
    public void clear() {

    }

    @Override
    public String toString() {
        String str="[";
        for (int i=0;i<MAP_POWER;i++){
            if (m[i].isEmpty())continue;
            for (int j=0;j<m[i].size();j++){
                str+=" ("+m[i].get(j).key+"="+m[i].get(j).val+")";
            }
        }
        str+=" ]";
        return str;
    }

}
