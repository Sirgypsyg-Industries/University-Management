import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static University university = new University("UMCS", 1234);

    public static void main(String[] args) {
        university.addDepartment("Mathematics");
        university.addDepartment("Computer Science");
        university.addDepartment("Physics");
        university.addDepartment("Neurobiology");
        university.addDepartment("Cosmology");

        while (true) {
            try {
                System.out.println("Choose 0 if you are student, 1 teacher, anything else if you want to exit:");
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 0) {
                    studentView();
                } else if (choice == 1) {
                    professorView();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine(); 
            }
        }
    }

    private static void studentView() {
        try {
            System.out.println("Choose 0 if you want to login, 1 register, anything else to exit:");
            int logOrReg = in.nextInt();
            in.nextLine();
            if (logOrReg == 1) {
                registerStudent();
            } else if (logOrReg == 0) {
                loginStudent();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine(); 
        }
    }

    private static void registerStudent() {
        System.out.println("Write your full name:");
        String fullName = in.nextLine();
        System.out.println("Write your password:");
        String password = in.nextLine();
        System.out.println(university.regStudent(fullName, password));
    }

    private static void loginStudent() {
        try {
            System.out.println("Write your index:");
            int index = in.nextInt();
            in.nextLine();
            System.out.println("Write your password:");
            String password = in.nextLine();
            Student user = university.logInStudent(index, password);
            if (user != null) {
                System.out.println("Logged in successfully");
                studentOperations(user);
            } else {
                System.out.println("User with such index doesn't exist or password is wrong.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine(); 
        }
    }

    private static void professorView() {
        try {
            System.out.println("Choose 0 if you want to login, 1 register, anything else to exit:");
            int logOrReg = in.nextInt();
            in.nextLine();
            if (logOrReg == 1) {
                registerProfessor();
            } else if (logOrReg == 0) {
                loginProfessor();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine();
        }
    }

    private static void registerProfessor() {
        try {
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
            System.out.println(university.regProfessor(fullName, password, tmp));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid department number. Please try again.");
        }
    }

    private static void loginProfessor() {
        try {
            System.out.println("Write your index:");
            int index = in.nextInt();
            in.nextLine();
            System.out.println("Write your password:");
            String password = in.nextLine();
            Professor user = university.logInProfessor(index, password);
            if (user != null) {
                System.out.println("Logged in successfully");
                professorOperations(user);
            } else {
                System.out.println("User with such index doesn't exist or password is wrong.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine(); 
        }
    }

    private static void professorOperations(Professor user) {
        while (true) {
            try {
                System.out.println("Choose 0 to add course, 1 to add material, 2 to write grade, anything else to log out.");
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
                        addGrade(user);
                        break;
                    default:
                        user = null;
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine();
            }
        }
    }

    private static void studentOperations(Student user) {
        while (true) {
            try {
                System.out.println("Choose 0 to register to course, 1 to view material, 2 to view grade, anything else to log out.");
                int operation = in.nextInt();
                in.nextLine();
                switch (operation) {
                    case 0:
                        registerToCourse(user);
                        break;
                    case 1:
                        viewMaterial(user);
                        break;
                    case 2:
                        System.out.println(user.viewGrades());
                        break;
                    default:
                        user = null;
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine();
            }
        }
    }

    private static void addCourse(Professor user) {
        System.out.println("Write the name of course:");
        String nameOfCourse = in.nextLine();
        System.out.println("Write the password for this course:");
        String password = in.nextLine();
        System.out.println(user.addCourse(nameOfCourse, password));
    }

    private static void addMaterial(Professor user) {
        if (user.courses.isEmpty()) {
            System.out.println("You have no added courses!");
            return;
        }
        try {
            System.out.println("Choose the course:");
            for (int i = 0; i < user.courses.size(); ++i) {
                System.out.println(i + " " + user.courses.get(i).name);
            }
            int indexOfCourse = in.nextInt();
            in.nextLine();
            System.out.println("Give the way to file:");
            String file = in.nextLine();
            System.out.println(user.addMaterials(file, user.courses.get(indexOfCourse)));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine(); 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid course number. Please try again.");
        }
    }

    private static void addGrade(Professor user) {
        if (user.courses.isEmpty()) {
            System.out.println("You have no added courses!");
            return;
        }
        boolean areMoreStudents = true;
        while (areMoreStudents) {
            try {
                System.out.println("Choose the course:");
                for (int i = 0; i < user.courses.size(); ++i) {
                    System.out.println(i + " " + user.courses.get(i).name);
                }
                int indexOfCourse = in.nextInt();
                Course course = user.courses.get(indexOfCourse);
                if (course.students.isEmpty()) {
                    System.out.println("There are no students registered on this course!");
                    return;
                }
                System.out.println("Choose the student:");
                for (int i = 0; i < user.courses.get(indexOfCourse).students.size(); ++i) {
                    System.out.println(i + " " + user.courses.get(indexOfCourse).students.get(i).getFullName());
                }
                int indexOfStudent = in.nextInt();
                in.nextLine();
                System.out.println("Write the grade:");
                Grade grade;
                while (true) {
                    try {
                        grade = Grade.valueOf(in.next());
                        in.nextLine();
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid grade entered. Please enter one of the following: Two, Three, Four, Five.");
                        in.nextLine();
                    }
                }
                System.out.println(user.writeGrade(user.courses.get(indexOfCourse).students.get(indexOfStudent).getIndex(), grade, course));
                System.out.println("Do you want to add more grades? (yes/no)");
                String answer = in.nextLine();
                areMoreStudents = answer.equalsIgnoreCase("yes");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine(); 
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid course or student number. Please try again.");
            }
        }
    }

    private static void registerToCourse(Student user) {
        try {
            System.out.println("Choose the department:");
            for (int i = 0; i < university.departments.size(); ++i) {
                System.out.println(i + " " + university.departments.get(i).name);
            }
            int indexOfDepartment = in.nextInt();
            in.nextLine();
            System.out.println("Choose the professor:");
            for (int i = 0; i < university.departments.get(indexOfDepartment).professors.size(); ++i) {
                System.out.println(i + " " + university.departments.get(indexOfDepartment).professors.get(i).getFullName());
            }
            int indexOfProfessor = in.nextInt();
            in.nextLine();
            Professor professor = university.departments.get(indexOfDepartment).professors.get(indexOfProfessor);

            int i = 0;
            for (Course course : professor.courses) {
                System.out.println(i + " " + course.name);
                i++;
            }

            Course course = professor.courses.get(in.nextInt());
            in.nextLine();
            System.out.println("Write the password for this course:");
            String password = in.next();
            System.out.println(user.registerOnCourse(course, password));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine(); 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid department or professor number. Please try again.");
        }
    }

    private static void viewMaterial(Student user) {
        if (user.courses.isEmpty()) {
            System.out.println("You are not registered in any courses!");
            return;
        }

        try {
            System.out.println("Choose the course to view materials:");
            for (int i = 0; i < user.courses.size(); ++i) {
                System.out.println(i + " " + user.courses.get(i).name);
            }
            int indexOfCourse = in.nextInt();
            in.nextLine();

            Course course = user.courses.get(indexOfCourse);
            if (course.materials.isEmpty()) {
                System.out.println("There are no materials for this course.");
                return;
            }
            System.out.println("Choose material you want to see:");
            for (int i = 0; i < course.materials.size(); ++i) {
                System.out.println(i + " " + course.materials.get(i));
            }
            int indexOfMaterial = in.nextInt();
            in.nextLine();
            user.viewMaterial(course, course.materials.get(indexOfMaterial));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid course or material number. Please try again.");
        }
    }
}
