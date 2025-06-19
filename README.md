# Phone-Book

## Description

This is a **console-based Phone Book application** developed in **Java**. 
It allows users to add, remove, search, and edit contacts using a simple text-based interface.
The app supports storing contacts with names, phone numbers, and organizational or personal types.

This project helps reinforce core **Java development skills**, such as:
- Object-oriented programming (OOP)
- Input/output handling
- Working with text files
- Encapsulation and inheritance
- Collections and basic data management

It’s a practical way to learn how to build an application with data handling.

---

## Program Flow

1. **Application Start**:
    - The program starts with a main menu and waits for user input.
2. **User Commands**:
    - `add`: Create a new contact (person or organization)
    - `list`: Show all saved contacts
    - `search`: Search contacts by name, number, or other fields
    - `count`: Show the total number of contacts
    - `edit`: Modify a contact's details
    - `remove`: Delete a contact
    - `exit`: Quit the application
3. **Contact Details**:
    - Personal contact: name, surname, birth date, gender, number
    - Organizational contact: name, address, number
    - All contacts include timestamps for creation and last edit
4. **Persistent Storage**:
    - Contact data is saved to a file so that it's preserved between sessions (if implemented in the advanced stages).
