import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    int id;
    String name;
    int age;
    double grade;

    Student(int id, String name, int age, double grade)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void display()
    {
        System.out.println("ID: " +id);
        System.out.println("Name: " +name);
        System.out.println("Age: " +age);
        System.out.println("Grade: " +grade);
        System.out.println("-------------------------");
    }

}
public class StudentManagementSystem 
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while(true)
        {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sobj.nextInt();

            if(choice == 1)
            {
                System.out.println("Enter ID: ");
                int id = sobj.nextInt();
                sobj.nextLine();

                System.out.println("Enter Name: ");
                String name = sobj.nextLine();

                System.out.print("Enter Age: ");
                int age = sobj.nextInt();

                System.out.print("Enter Grade: ");
                double grade = sobj.nextDouble();

                students.add(new Student(id, name, age, grade));
                System.out.println("\nStudent added successfully!");
            }
            else if(choice == 2)
            {
                if(students.isEmpty())
                {
                    System.out.println("No students found.");
                }

                for(Student s : students)
                {
                    s.display();
                }
            }
            else if(choice == 3)
            {
                System.out.println("Enter student ID: ");
                int id = sobj.nextInt();
                boolean found = false;

                for(Student s : students)
                {
                    if(s.id == id)
                    {
                        s.display();
                        found = true;
                        break;
                    }
                }
                if(!found)
                {
                    System.out.println("Student not found.");
                }
            }
            else if(choice == 4)
            {
                if(students.isEmpty())
                {
                    System.out.println("No student grades available.");
                }
                else
                {
                    double total = 0;

                    for( Student s : students)
                    {
                    total += s.grade;
                    }

                    System.out.println("Average Grade: " + total / students.size());
                }
                
            }
            else if (choice == 5)
            {
                System.out.println("\n----Program closed----");
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
        sobj.close();
    }
}
