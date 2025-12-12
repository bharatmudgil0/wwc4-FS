
import java.util.*;



class Student {
    private String id , name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public String getrole(){
        return "Undergraduate";
    }
    @Override
    public String toString(){
        return id + " - " + name + " (" + marks + ")" + " " + getrole();
    }
}

class GraduateStudent extends Student {
    private String area;
    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }
    public String getRole(){
        return "Graduate in " + area;
    }
}
class Repository<T>{
    private Map<String, T> data = new HashMap<>();
    public void save(String id, T obj){
        data.put(id, obj);

    }
    public T find(String id){
        return data.get(id);
    }
    public void delete(String id){
        data.remove(id);
    }
}
class HonorStudent extends Student {
    public HonorStudent(String id, String name, int marks) {
        super(id, name, marks);
    }

    public int bonusmarks(){
        return getMarks() + 10;
    }
}
public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "Bharat", 85));
        list.add(new GraduateStudent("G1", "Amit", 90, "Computer Science"));


        Repository<Student> repo = new Repository<>();
        for(Student s : list){
            repo.save(s.getId(), s);
        }
        System.out.println("All Students:");
        for(Student s : list){
            System.out.println(s);
        }
        System.out.println("\nFinding Student with ID S001:");
        Student s = repo.find("1");
        System.out.println(s);

        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getMarks() < 60){
                iterator.remove();
                repo.delete(student.getId());
                System.out.println("\nRemoved Student with ID: " + student.getId());
            }
        }
        System.out.println("\nRemaining Students:");
        for(Student student : list){
            System.out.println(student);
        }
        HonorStudent honorStudent = new HonorStudent("H1", "Charlie", 95);
        System.out.println("\nHonor Student Details:");
        System.out.println(honorStudent);
        System.out.println("Bonus Marks: " + honorStudent.bonusmarks());

        Student topper = null;
        int mx = -1;

        for (Student st : list) {
            if (st.getMarks() > mx) {
                mx = st.getMarks();topper = st;
            }
        }

        System.out.println("\nTopper:"+topper);
    }
}
