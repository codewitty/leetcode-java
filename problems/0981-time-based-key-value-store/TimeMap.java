import java.util.*;

class TimeMap {
    private final Map<String, TreeMap<Integer, String>> store = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> versions = store.get(key);
        if (versions == null) return "";
        Map.Entry<Integer, String> e = versions.floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));
        System.out.println(tm.get("foo", 3));
        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));
        System.out.println(tm.get("foo", 5));
    }
}
