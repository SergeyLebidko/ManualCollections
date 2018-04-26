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

    }

    private int mapPower;                        //Начальный размер массива
    private int mapSize;                         //Количество ключей в массиве
    private ManualArray<MapElement<K, V>>[] m;   //Массив для хранения пар "ключ-значение"

    public ManualMap() {
        mapPower = 4;
        m = new ManualArray[mapPower];
        for (int i = 0; i < mapPower; i++) m[i] = new ManualArray<>();
        mapSize = 0;
    }

    public ManualMap(ManualMap<? extends K, ? extends V> map) {
        this();
        for (K key : map.keySet()) put(key, map.get(key));
    }

    //Метод добавляет элемент к массиву. Возвращает предыдущее значение, связанное с ключом. Если предыдущего значения не было - возвращает null
    public V put(K k, V v) {
        if (k == null) throw new NullPointerException();
        int pos = k.hashCode() % mapPower;
        if (m[pos].isEmpty()) {
            m[pos].add(new MapElement<>(k, v));
            mapSize++;
            resize();
            return null;
        }
        if (!m[pos].isEmpty()) {
            for (int i = 0; i < m[pos].size(); i++) {
                if (m[pos].get(i).key.equals(k)) {
                    V vtmp = m[pos].get(i).val;
                    m[pos].set(new MapElement<>(k, v), i);
                    return vtmp;
                }
            }
            m[pos].add(new MapElement<>(k, v));
            mapSize++;
            resize();
        }
        return null;
    }

    //Метод возвращает элемент, связанный с ключом k. Если такого элемента нет - возвращает null
    public V get(Object k) {
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%mapPower;
        if (m[pos].isEmpty())return null;
        for (int i=0;i<m[pos].size();i++){
            if (m[pos].get(i).key.equals(k)){
                return m[pos].get(i).val;
            }
        }
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k, возвращает значение v
    public V remove(K k) {
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%mapPower;
        if (m[pos].isEmpty())return null;
        for (int i=0;i<m[pos].size();i++){
            if (m[pos].get(i).key.equals(k)){
                V vtmp=m[pos].get(i).val;
                m[pos].remove(i);
                return vtmp;
            }
        }
        return null;
    }

    //Удаляет пару ключ-значение соответствующую ключу k и значению v, возвращает true, если данная операция прошла успешно
    public boolean remove(K k, V v) {
        if (k==null)throw new NullPointerException();
        int pos=k.hashCode()%mapPower;
        if (m[pos].isEmpty())return false;
        for (int i=0;i<m[pos].size();i++){
            if (m[pos].get(i).key.equals(k) & m[pos].get(i).val.equals(v)){
                m[pos].remove(i);
                return true;
            }
        }
        return false;
    }

    //Возвращает множество ключей
    public ManualSet<K> keySet() {
        ManualSet<K> set=new ManualSet<>();
        for (int i=0;i<mapPower;i++){
            if (m[i].isEmpty())continue;
            for (int j=0;j<m[i].size();j++){
                set.add(m[i].get(j).key);
            }
        }
        return set;
    }

    //Возвращает массив значений, связанных с ключами
    public ManualArray<V> valsArray() {
        ManualArray<V> array=new ManualArray<>();
        for (int i=0;i<mapPower;i++){
            if (m[i].isEmpty())continue;
            for (int j=0;j<m[i].size();j++){
                array.add(m[i].get(j).val);
            }
        }
        return array;
    }

    //Равен true, если массив содержит ключ k
    public boolean containsKey(Object k) {
        if (k==null)throw new NullPointerException();
        for (int i=0;i<mapPower;i++){
            if (m[i].isEmpty())continue;
            for (int j=0;j<m[i].size();j++){
                if (m[i].get(j).key.equals(k))return true;
            }
        }
        return false;
    }

    //Равен true, если массив содержит значение v
    public boolean containsValue(Object v) {
        if (v==null)throw new NullPointerException();
        for (int i=0;i<mapPower;i++){
            if (m[i].isEmpty())continue;
            for (int j=0;j<m[i].size();j++){
                if (m[i].get(j).val.equals(v))return true;
            }
        }
        return false;
    }

    //Возвращает количество элементов в массиве
    public int size() {
        return mapSize;
    }

    //Возвращает true, если массив пуст
    public boolean isEmpty() {
        return (mapSize == 0);
    }

    //Очищает массив
    public void clear() {
        mapPower = 4;
        m = new ManualArray[mapPower];
        for (int i = 0; i < mapPower; i++) m[i] = new ManualArray<>();
        mapSize = 0;
    }

    //Метод производит перехэширование в зависимости от коэффициента заполнения хэш-массива
    private void resize() {
        if (isEmpty()) return;
        double k = (double) mapSize / (double) mapPower;
        if ((k>=0.2) & (k<0.75))return;

        //Создаем новый массив и уже имеющиеся во элементы переносим в него
        int newMapPower= mapSize*2;
        ManualArray<MapElement<K,V>>[] m1=new ManualArray[newMapPower];
        int pos;
        for (int i=0;i<newMapPower;i++)m1[i]=new ManualArray<>();
        for (int i=0;i<mapPower;i++){
            for (int j=0;j<m[i].size();j++){
                pos=m[i].get(j).key.hashCode()%newMapPower;
                m1[pos].add(m[i].get(j));
            }
        }
        m=m1;
        mapPower=newMapPower;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < mapPower; i++) {
            if (m[i].isEmpty()) continue;
            for (int j = 0; j < m[i].size(); j++) {
                str += " (" + m[i].get(j).key + "=" + m[i].get(j).val + ")";
            }
        }
        str += " ]";
        return str;
    }

}
