package phonebook;

import java.util.HashMap;
import java.util.List;

public class Searcher {

    public int linearSearch(List<Contact> phonebook, List<String> datpeopleToFind) {
        int count = 0;
        for (String name : datpeopleToFind) {
            for (Contact person : phonebook) {
                if (person.getName().equals(name)) {
                    count++;
                }
            }
        }
        return count;
    }


    public int jumpSearchForAllDataToFind(List<Contact> phonebook, List<String> peopleToFind) {
        int count = 0;
        for (String personToFind : peopleToFind) {
            if (isPersonFoundWithJumpSearch(phonebook, personToFind)) {
                count++;
            }
        }
        return count;
    }


    private boolean isPersonFoundWithJumpSearch(List<Contact> phonebook, String personToFind) {
        int jump = (int) Math.sqrt(phonebook.size());
        int blockStartIn = 0;
        int blockEndEx = jump;

        if (personToFind.compareTo(phonebook.getFirst().getName()) < 0) {
            return false;
        }

        while (personToFind.compareTo(phonebook.get(blockEndEx).getName()) >= 0) {
            blockStartIn = blockEndEx;
            blockEndEx += jump;
            if (blockEndEx >= phonebook.size()) {
                return false;
            }
        }

        for (int index = blockStartIn; index < blockEndEx; index++) {
            if (phonebook.get(index).getName().equals(personToFind)) {
                return true;
            }
        }
        return false;
    }


    public int binarySearchForAllDataToFind(List<Contact> phonebook, List<String> peopleToFind) {
        int count = 0;

        for (String personToFind : peopleToFind) {
            if (isPersonFoundWithBinarySearch(phonebook, personToFind, 0, phonebook.size() - 1)) {
                count++;
            }
        }
        return count;
    }


    private boolean isPersonFoundWithBinarySearch(List<Contact> phonebook, String personToFind, int min, int max) {
        if (max >= min && min <= phonebook.size() - 1) {
            int mid = (min + max) / 2;

            if (personToFind.equals(phonebook.get(mid).getName())) {
                return true;
            } else if (personToFind.compareTo(phonebook.get(mid).getName()) > 0) {
                return isPersonFoundWithBinarySearch(phonebook, personToFind, mid, max);
            } else if (personToFind.compareTo(phonebook.get(mid).getName()) < 0) {
                return isPersonFoundWithBinarySearch(phonebook, personToFind, min, mid);
            }
        }
        return false;
    }


    public int hashMapSearch(HashMap<String, String> phonebookHashMap, List<String> peopleToFind) {
        int count = 0;
        for (String personToFind : peopleToFind) {
            if (phonebookHashMap.containsKey(personToFind)) {
                count++;
            }
        }
        return count;
    }
}
