
import java.io.*;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class SaveResults {
    private ArrayList<ObiektCrawlera> wyniki;
    SaveResults(ArrayList<ObiektCrawlera> obiekty){
        this.wyniki=obiekty;
    }
    
    public void saveToFile()
    {
        try {
        // Get a file channel for the file
        File file = new File("wyniki.dat");
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

        // Use the file channel to create a lock on the file.
        // This method blocks until it can retrieve the lock.
        FileLock lock = channel.lock();

        /*
           use channel.lock OR channel.tryLock();
        */

        // Try acquiring the lock without blocking. This method returns
        // null or throws an exception if the file is already locked.
        try {
            lock = channel.tryLock();
            
             ArrayList<ObiektCrawlera> obiektyCrawlera = new ArrayList();
        ObjectInputStream content=null ;
        ObjectOutputStream save = null;
        try{
            content = new ObjectInputStream(new FileInputStream("wyniki.dat"));
        } catch(FileNotFoundException e){
        } catch (IOException ex) {
            
        }
        try{
        obiektyCrawlera = (ArrayList<ObiektCrawlera>) content.readObject();
        }catch (NullPointerException e){
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(SaveResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        obiektyCrawlera.addAll(wyniki);
        
        try {
            save = new ObjectOutputStream(new FileOutputStream("wyniki.dat"));
        } catch (IOException ex) {
            Logger.getLogger(SaveResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            save.writeObject(obiektyCrawlera);
        } catch (IOException ex) {
            Logger.getLogger(SaveResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (OverlappingFileLockException e) {
          Logger.getLogger(SaveResults.class.getName()).log(Level.SEVERE, null, e);
        }

        // Release the lock - if it is not null!
        if( lock != null ) {
            lock.release();
            System.out.println("lock sie zwolnil");
        }

        // Close the file
        channel.close();
    } catch (Exception e) {
    }
}

    public ArrayList<ObiektCrawlera> getWyniki() {
        return wyniki;
    }

    public void setWyniki(ArrayList<ObiektCrawlera> wyniki) {
        this.wyniki = wyniki;
    }
    
}
