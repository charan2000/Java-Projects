package serialization;

import java.io.*;

class SaveClass implements Serializable {
    public int sal;
}

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SaveClass objSave = new SaveClass();
        objSave.sal = 1211203925;

//      To Save the Object in a file for later use
        FileOutputStream fos = new FileOutputStream(new File("src/savingOBJ.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(objSave);

//      To retrive a saved object and use it
        FileInputStream fis = new FileInputStream(new File("src/savingOBJ.txt"));
        ObjectInputStream ois = new ObjectInputStream(fis);

        SaveClass newObj = (SaveClass) ois.readObject();

    }

}
