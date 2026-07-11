package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Library;


//Created this class becaz of single responsibility principal
// Library -> Bussniess Logic
//Repository -> file handling

public class LibraryRepository {
    
    private static final String FILE_NAME = "library.dat";

    public void saveLibrary(Library library) {

        try (
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            // passed fos in constructor becaz
            // "Whenever ObjectOutputStream produce bytes,
            // send them to this FileOutputStream."
            // i.e it is telling the path
            ObjectOutputStream out = new ObjectOutputStream(fos);
        ) 
        {
            out.writeObject(library);
            // we have done this syntax becaz
            // if this line gives error then try
            // will automatically close the streams

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library loadLibrary(){

        File file = new File(FILE_NAME);

        if(!file.exists()){
            return new Library();
        }
        
        try(
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fis);
        ) 
        {
            Library library = (Library) in.readObject(); // returns object so we need to parse
            return library;

        }catch(IOException | ClassNotFoundException e) // Multi-Catch intead of multiple catch java allow this
        {
            e.printStackTrace();
            return new Library();
            // Pass so that our system does not crash even if it does not able to load previous data
        }
    }
}
