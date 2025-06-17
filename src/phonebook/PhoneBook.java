package phonebook;

import phonebook.reader.FileReader;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {

    private final static String DIRECTORY_PATH = "C:\\Users\\Agata\\Desktop\\Workspace\\Phone Book with Java\\files\\directory.txt";
    private final static String FIND_PATH = "C:\\Users\\Agata\\Desktop\\Workspace\\Phone Book with Java\\files\\find.txt";

    private final FileReader fileReader = new FileReader();
    private final Sorter sorter = new Sorter();
    private final Searcher searcher = new Searcher();
    private final Timer timer = new Timer();


    public void startLinearSearch() {

        long start = System.nanoTime();
        System.out.println("Start searching (linear search)...");

        List <Contact> phonebook = createPhonebook();
        List<String> peopleToFind = fileReader.readDataFromFile(FIND_PATH);

        int count = searcher.linearSearch(phonebook, peopleToFind);

        long end = System.nanoTime();

        System.out.printf("Found %d/%d entries. ", count, peopleToFind.size());
        LocalTime time = timer.findTime(start, end);
        System.out.printf("Time taken: %d min. %d sec. %dms.\n\n", time.getMinute(), time.getSecond(), time.getNano());
    }


    public void startBubbleSortAndJumpSearch() {

        long start = System.nanoTime();
        System.out.println("Start searching (bubble sort + jump search)...");

        List <Contact> phonebook = createPhonebook();
        List<String> peopleToFind = fileReader.readDataFromFile(FIND_PATH);

        boolean isPhonebookSorted = sorter.bubbleSort(phonebook, start);
//        boolean isPhonebookSorted = sorter.sortPhonebookByName(phonebook);

        long sortEnd = System.nanoTime();
        LocalTime sortTime = timer.findTime(start, sortEnd);

        int count;
        if(isPhonebookSorted){
            count = searcher.jumpSearchForAllDataToFind(phonebook, peopleToFind);
        } else {
            count = searcher.linearSearch(phonebook, peopleToFind);
        }

        long end = System.nanoTime();
        LocalTime searchTime = timer.findTime(sortEnd, end);
        LocalTime time = timer.findTime(start, end);

        System.out.printf("Found %d/%d entries. ", count, peopleToFind.size());
        System.out.printf("Time taken: %d min. %d sec. %dms.\n", time.getMinute(), time.getSecond(), time.getNano());
        if(isPhonebookSorted){
            System.out.printf("Sorting time: %d min. %d sec. %dms.\n", sortTime.getMinute(), sortTime.getSecond(), sortTime.getNano());
        } else {
            System.out.printf("Sorting time: %d min. %d sec. %dms. - STOPPED, moved to linear search\n", sortTime.getMinute(), sortTime.getSecond(), sortTime.getNano());
        }
        System.out.printf("Searching time: %d min. %d sec. %dms.\n\n", searchTime.getMinute(), searchTime.getSecond(), searchTime.getNano());
    }


    public void startQuickSortAndBinarySearch() {

        long start = System.nanoTime();
        System.out.println("Start searching (quick sort + binary search)...");

        List <Contact> phonebook = createPhonebook();
        List<String> peopleToFind = fileReader.readDataFromFile(FIND_PATH);

        sorter.quickSort(phonebook,0, phonebook.size()-1);

        long sortEnd = System.nanoTime();
        LocalTime sortTime = timer.findTime(start, sortEnd);

        int count = searcher.binarySearchForAllDataToFind(phonebook, peopleToFind);

        long end = System.nanoTime();
        LocalTime searchTime = timer.findTime(sortEnd, end);
        LocalTime time = timer.findTime(start, end);

        System.out.printf("Found %d/%d entries. ", count, peopleToFind.size());
        System.out.printf("Time taken: %d min. %d sec. %dms.\n", time.getMinute(), time.getSecond(), time.getNano());
        System.out.printf("Sorting time: %d min. %d sec. %dms.\n", sortTime.getMinute(), sortTime.getSecond(), sortTime.getNano());
        System.out.printf("Searching time: %d min. %d sec. %dms.\n\n", searchTime.getMinute(), searchTime.getSecond(), searchTime.getNano());
    }


    public void startHashTable() {

        long start = System.nanoTime();
        System.out.println("Start searching (hash table)...");

        List <Contact> phonebook = createPhonebook();
        HashMap<String, String> phonebookHashMap = createPhonebookHashMap(phonebook);
        List<String> peopleToFind = fileReader.readDataFromFile(FIND_PATH);

        long createEnd = System.nanoTime();
        LocalTime createTime = timer.findTime(start, createEnd);

        int count = searcher.hashMapSearch(phonebookHashMap, peopleToFind);


        long end = System.nanoTime();
        LocalTime searchTime = timer.findTime(createEnd, end);
        LocalTime time = timer.findTime(start, end);

        System.out.printf("Found %d/%d entries. ", count, peopleToFind.size());
        System.out.printf("Time taken: %d min. %d sec. %dms.\n", time.getMinute(), time.getSecond(), time.getNano());
        System.out.printf("Creating time: %d min. %d sec. %dms.\n", createTime.getMinute(), createTime.getSecond(), createTime.getNano());
        System.out.printf("Searching time: %d min. %d sec. %dms.\n\n", searchTime.getMinute(), searchTime.getSecond(), searchTime.getNano());
    }


    private List<Contact> createPhonebook() {

        List<String> allData = fileReader.readDataFromFile(DIRECTORY_PATH);
        List<Contact> phonebook = new ArrayList<>();
        for(String person : allData){
            String[] personData = person.split(" ", 2);
            phonebook.add(new Contact(personData[1], personData[0]));
        }
        return phonebook;
    }


    private HashMap<String, String> createPhonebookHashMap(List <Contact> phonebook){

        HashMap<String, String> phonebookHashMap = new HashMap<>();
        phonebook.forEach((person) -> phonebookHashMap.putIfAbsent(person.getName(), person.getNumber()));
        return phonebookHashMap;
    }
}


