import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static University university = new University("UMCS");

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose 0 if you are student, 1 teacher, 2 if you want to exit: \n");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 0) {
                studentView();
            } else if (choice == 1) {
                professorView();
            } else if (choice == 2) {
                break;
            }
        }
    }

    private static void studentView() {
        System.out.println("Choose 0 if you want to login, 1 register:");
        int logOrReg = in.nextInt();
        in.nextLine();
        if (logOrReg == 1) {
            registerStudent();
        } else {
            loginStudent();
        }
    }

    private static void registerStudent() {
        System.out.println("Write your full name:");
        String fullName = in.nextLine();
        System.out.println("Write your password:");
        String password = in.nextLine();
        university.reg(false, fullName, password, null);
    }

    private static void loginStudent() {
        System.out.println("Write your index:");
        String index = in.nextLine();
        System.out.println("Write your password:");
        String password = in.nextLine();
        Student user = university.logInStudent(password, index);
        if (user != null) {
            studentOperations(user);
        } else {
            System.out.println("User with such index doesn't exist or password is wrong.");
        }
    }

    private static void professorView() {
        System.out.println("Choose 0 if you want to login, 1 register:");
        int logOrReg = in.nextInt();
        in.nextLine();
        if (logOrReg == 1) {
            registerProfessor();
        } else {
            loginProfessor();
        }
    }

    private static void registerProfessor() {
        System.out.println("Choose your department:");
        for (int i = 0; i < university.departments.size(); ++i) {
            System.out.println(i + " " + university.departments.get(i).name);
        }
        int numberOfDepartment = in.nextInt();
        in.nextLine();
        Department tmp = university.departments.get(numberOfDepartment);
        System.out.println("Write your full name:");
        String fullName = in.nextLine();
        System.out.println("Write your password:");
        String password = in.nextLine();
        university.reg(true, fullName, password, tmp);
    }

    private static void loginProfessor() {
        System.out.println("Write your index:");
        String index = in.nextLine();
        System.out.println("Write your password:");
        String password = in.nextLine();
        Professor user = university.logInProfessor(password, index);
        if (user != null) {
            System.out.println("Logged in successfully \n");
            professorOperations(user);
        } else {
            System.out.println("User with such index doesn't exist or password is wrong.");
        }
    }

    private static void professorOperations(Professor user) {
        while (true) {
            System.out.println("Choose 0 to add course, 1 to add material, 2 to write grade, 3 to log out.");
            int operation = in.nextInt();
            in.nextLine();
            switch (operation) {
                case 0:
                    addCourse(user);
                    break;
                case 1:
                    addMaterial(user);
                    break;
                case 2:
                    //TODO Add functionality for writing grade
                    addGrade(user);
                    break;
                case 3:
                    user = null;
                    return;
            }
        }
    }

    private static void studentOperations(Student user) {
        while (true) {
            System.out.println("Choose 0 to register to course, 1 to view material, 2 to view grade, 3 to log out.");
            int operation = in.nextInt();
            in.nextLine();
            switch (operation) {
                case 0:
                    //TODO Add functionality for registering to course PATRYYYK
                    registerToCourse(user);
                    break;
                case 1:
                    //TODO Add functionality for viewing material
                    break;
                case 2:
                    //TODO Add functionality for viewing grade
                    break;
                case 3:
                    user = null;
                    return;
            }
        }
    }

    private static void addCourse(Professor user) {
        System.out.println("Write the name of course:");
        String nameOfCourse = in.nextLine();
        System.out.println("Write the password for this course:");
        String password = in.nextLine();
        user.addCourse(nameOfCourse, password);
    }

    private static void addMaterial(Professor user) {
        if (user.courses.isEmpty()) {
            System.out.println("You have no added courses!");
            return;
        }
        System.out.println("Choose the course:");
        for (int i = 0; i < user.courses.size(); ++i) {
            System.out.println(i + " " + user.courses.get(i).name);
        }
        int indexOfCourse = in.nextInt();
        in.nextLine();
        System.out.println("Give the way to file:");
        String file = in.nextLine();
        user.addMaterials(file, user.courses.get(indexOfCourse));
    }

    private static void addGrade(Professor user) {
        if (user.courses.isEmpty()) {
            System.out.println("You have no added courses!");
            return;
        }
        boolean areMoreStudents = true;
        while(areMoreStudents) {
            System.out.println("Choose the course:");
            for (int i = 0; i < user.courses.size(); ++i) {
                System.out.println(i + " " + user.courses.get(i).name);
            }
            int indexOfCourse = in.nextInt();
            Course course = user.courses.get(indexOfCourse);
            
            System.out.println("Choose the student:");
            for (int i = 0; i < user.courses.get(indexOfCourse).students.size(); ++i) {
                System.out.println(i + " " + user.courses.get(indexOfCourse).students.get(i).getFullName());
            }
            String indexOfStudent = in.nextLine();

            System.out.println("Write the grade:");
            Grade grade = Grade.valueOf(in.next());

            user.writeGrade(indexOfStudent, grade, course);
            System.out.println("Do you want to add more grades? (yes/no)");
            String answer = in.nextLine();
            if (answer.equals("no")) {
                areMoreStudents = false;
            }
        }
        System.out.println("Choose the course:");
        for (int i = 0; i < user.courses.size(); ++i) {
            System.out.println(i + " " + user.courses.get(i).name);
        }
        int indexOfCourse = in.nextInt();
        Course course = user.courses.get(indexOfCourse);
        
        System.out.println("Choose the student:");
        for (int i = 0; i < user.courses.get(indexOfCourse).students.size(); ++i) {
            System.out.println(i + " " + user.courses.get(indexOfCourse).students.get(i).getFullName());
        }
        String indexOfStudent = in.nextLine();

        System.out.println("Write the grade:");
        Grade grade = Grade.valueOf(in.next());

        user.writeGrade(indexOfStudent, grade, course);
    }

    private static void registerToCourse(Student user) {
        // department => professor => course
        System.out.println("Choose the department:");
        for (int i = 0; i < university.departments.size(); ++i) {
            System.out.println(i + " " + university.departments.get(i).name);
        }
        int indexOfDepartment = in.nextInt();

        System.out.println("Choose the professor:");
        for (int i = 0; i < university.departments.get(indexOfDepartment).profesors.size(); ++i) {
            System.out.println(i + " " + university.departments.get(indexOfDepartment).profesors.get(i).getFullName());
        }
        int indexOfProfessor = in.nextInt();
        Professor professor = university.departments.get(indexOfDepartment).profesors.get(indexOfProfessor);

        int i = 0;
        for (Course course: professor.courses) {
            System.out.println(i + ": " + course.name);
            i++;
        }

        Course course = professor.courses.get(in.nextInt());
        System.out.println("Write the password for this course:");
        String password = in.nextLine();
        user.registerOnCourse(course, password);
    }
}