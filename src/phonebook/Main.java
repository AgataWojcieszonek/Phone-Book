package phonebook;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.startLinearSearch();
//        phoneBook.startBubbleSortAndJumpSearch();
        phoneBook.startQuickSortAndBinarySearch();
        phoneBook.startHashTable();
    }
}
