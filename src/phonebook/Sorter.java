package phonebook;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Sorter {
    private final Timer timer = new Timer();

    public boolean sortPhonebookByName(List<Contact> phonebook) {
        phonebook.sort(Comparator.comparing(Contact::getName));
        return true;
    }


    private static void swap(List<Contact> phonebook, int i, int j) {
        Contact temp = phonebook.get(i);
        phonebook.set(i, phonebook.get(j));
        phonebook.set(j, temp);
    }


    public boolean bubbleSort(List<Contact> phonebook, long start) {
        int n = phonebook.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (phonebook.get(j).getName().compareTo(phonebook.get(j + 1).getName()) > 0) {
                    swap(phonebook, j, j+1);
                    swapped = true;
                }
            }

            if (!swapped)
                break;

            long timeInFor = System.nanoTime();
            LocalTime time = timer.findTime(start, timeInFor);

            if (time.getMinute() > 1) {
                return false;
            }
        }
        return true;
    }

    private static int generateRandomPivot(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    public void quickSort(List<Contact> phonebook,  int min, int max) {
        if (min < max) {
            int pivotIndex = generateRandomPivot(min, max);
            Contact pivotContact = phonebook.get(pivotIndex);
            swap(phonebook, pivotIndex, max);

            int i = min - 1;

            for (int j = min; j < max; j++) {
                if (phonebook.get(j).getName().compareTo(pivotContact.getName())<0) {
                    i++;
                    if (i != j) {
                        swap(phonebook, i, j);
                    }
                }
            }
            swap(phonebook, i + 1, max);

            quickSort(phonebook, min, i);
            quickSort(phonebook, i + 2, max);
        }
    }

}
