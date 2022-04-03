import java.io.Serializable;

// Implementations of Resolver implement a strategy for allocating rooms to students fairly.
public interface Resolver {
    // Allocate rooms given student requests and available room data.
    public void roomAllocation();
    public void studentRequests();
    public void availableRooms();
    // See sample .csv files.
    CSVFile resolve(CSVFile housingData, CSVFile studentChoices);
}

class Solve implements Resolver
{
    int id;
    int spaceAvailable;
    String name;
    Housing housing;

    List <User> students;

    public int getId()
    {
        return id;
    }

    public List<Student> getListOfStudents()
    {
        return listOfStudents();

    }

    public void setListOfStudents(List<Student> listOfStudents)
    {
        this.listOfStudents = listOfStudents;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Housing getHousing()
    {
        return housing;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }



    public void roomAllocation()
    {

    }
}

public class Housing extends User implements Serializable
{
    String name;
    String housing;
    String group;


}
