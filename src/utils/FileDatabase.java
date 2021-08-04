package utils;

import authenticate.Account;
import data.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileDatabase {
    public static void writeDatabaseInfo(String path, LinkedList<Document> list) throws FileNotFoundException, IOException {
        File file = new File(path);

        try ( ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file))) {
            objOutput.writeObject(list);
            objOutput.close();
        }
    }

    public static LinkedList<Document> readDatabaseInfo(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        LinkedList<Document> data;

        File fileToRead;
        fileToRead = new File(path);

        try ( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead))) {
            data = (LinkedList<Document>) objectInputStream.readObject();
        }

        return data;
    }

    public static void exportToFile(String path, LinkedList<Document> list) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            for (Document doc : list) {
                fw.write(doc.toExportedFileFormat() + System.lineSeparator());
            }

            fw.close();
        } catch (IOException ex) {
            System.out.println(Language.MSG_FILE_SAVE_FAILED);
        }
    }

    public static void writeAuthInfo(String path, ArrayList<Account> list) throws FileNotFoundException, IOException {
        File file = new File(path);

        try ( ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file))) {
            objOutput.writeObject(list);
            objOutput.close();
        }
    }

    public static ArrayList<Account> readAuthInfo(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Account> data;

        File fileToRead;
        fileToRead = new File(path);

        try ( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead))) {
            data = (ArrayList<Account>) objectInputStream.readObject();
        }

        return data;
    }
}
