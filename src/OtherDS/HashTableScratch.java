package OtherDS;

import java.util.LinkedList;

public class HashTableScratch<K, V> {
    public int size;
    public int capacity;
    public float loadFactor;
    private LinkedList<Entry<K, V>>[] buckets;

    public HashTableScratch() {
        this.capacity = 10;
        this.loadFactor = 0.75f;

        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public HashTableScratch(int customCapacity, float customLoad) {
        this.capacity = customCapacity;
        this.loadFactor = customLoad;

        buckets = new LinkedList[customCapacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public V get(K key) {
        int bucketIndex = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index]; // Access existing bucket

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the value if key exists
                return;
            }
        }

        // Key does not exist, add a new entry to the bucket
        bucket.add(new Entry<>(key, value));
        size++;

        // Resize if load factor is exceeded
        if ((double) size / buckets.length > loadFactor) {
            resize();
        }
    }

    public void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value); // Rehash entries
            }
        }
    }

    public void remove(K key) {
        int bucketIndex = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTableScratch<String, Integer> hashTable = new HashTableScratch<>();

        // Add key-value pairs
        hashTable.put("apple", 3);
        hashTable.put("banana", 2);

        // Retrieve values
        System.out.println("apple: " + hashTable.get("apple")); // Output: apple: 3
        System.out.println("banana: " + hashTable.get("banana")); // Output: banana: 2

        // Remove a key
        hashTable.remove("apple");
        System.out.println("apple after removal: " + hashTable.get("apple")); // Output: apple after removal: null
    }
}
