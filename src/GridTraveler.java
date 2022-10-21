import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/21/2022, Friday
 * @project : dynamic-programming-memoization-grid-traveler
 **/
public class GridTraveler {

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static Long gridTraveler(int m, int n, Map<Pair<Integer, Integer>, Long> memo) {
        if (memo.containsKey(new Pair<>(m, n))) {
            return memo.get(new Pair<>(m, n));
        }
        if (m == 1 && n == 1) {
            return 1L;
        }
        if (m == 0 || n == 0) {
            return 0L;
        }
        Long result = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
        memo.put(new Pair<>(m, n), result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1, new HashMap<>()));
        System.out.println(gridTraveler(2, 3, new HashMap<>()));
        System.out.println(gridTraveler(3, 2, new HashMap<>()));
        System.out.println(gridTraveler(3, 3, new HashMap<>()));
        System.out.println(gridTraveler(18, 18, new HashMap<>()));
    }
}
