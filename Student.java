public class Student {

    private int rollNo;
    private String name;
    private String dept;
    private int year;

    public Student(int rollNo, String name, String dept, int year) {
        this.rollNo = rollNo;
        this.name = name;
        this.dept = dept;
        this.year = year;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", year=" + year +
                '}';
    }
}
