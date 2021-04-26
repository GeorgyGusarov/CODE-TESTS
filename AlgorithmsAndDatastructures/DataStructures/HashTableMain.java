package AlgorithmsAndDatastructures.DataStructures;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10); // хэш 25
        hashTable.insert(new HashTable.Item(10)); // 10 легло на 10 место
        hashTable.insert(new HashTable.Item(20)); // 20 на 20 место (20 % 25 = 20)
        hashTable.insert(new HashTable.Item(30)); // 30 на 5 место
        hashTable.insert(new HashTable.Item(75)); // 75 коллизия с 50 (75 % 25 = 0)
        hashTable.insert(new HashTable.Item(40)); // 40 легло на 15 место
        hashTable.insert(new HashTable.Item(50)); // 50 коллизия с 75 и легло следом
        hashTable.insert(new HashTable.Item(60)); // 60 коллизия с 10
        hashTable.insert(new HashTable.Item(70)); // 70 коллизия с 20
        System.out.println(hashTable.toString());

        hashTable.delete(75); // удалили элемент и заменили на -1
        System.out.println(hashTable.toString());
    }
}
