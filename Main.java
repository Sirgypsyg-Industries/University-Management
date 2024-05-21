import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        University university = new University("UMCS");
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("Choose 0 if you are student, 1 teacher, 2 if you want to exit: \n");
            int choice = in.nextInt();
            in.nextLine();
            boolean logOrReg;
            if(choice == 0){
                System.out.println("Choose 0 if you want to login, 1 register:");
                logOrReg = in.nextBoolean();
                in.nextLine();
                if(logOrReg){
                    String password, fullName;
                    System.out.println("Write your full name:");
                    fullName = in.nextLine();
                    System.out.println("Write your password:");
                    password = in.nextLine();
                    university.reg(false, fullName, password, null);
                }else{
                    String password, index;
                    System.out.println("Write your index:");
                    index = in.nextLine();
                    System.out.println("Write your password:");
                    password = in.nextLine();
                    Student user;
                    user = (Student)university.logIn(false, password, index, null);
                    if(user != null){

                        
                    }else{
                        System.out.println("User with such index doesn't exist or password is wrong.");
                    }
                }
            }else if(choice == 1){
                System.out.println("Choose 0 if you want to login, 1 register:");
                logOrReg = in.nextBoolean();
                in.nextLine();
                if(logOrReg){
                    System.out.println("Choose your department:");
                    for(int i = 0; i < university.departments.size(); ++i){
                        System.out.println(i + " " + university.departments.get(i).name);
                    }
                    int numberOfDepartment = in.nextInt();
                    in.nextLine();
                    Department tmp = university.departments.get(numberOfDepartment);
                    String password, fullName;
                    System.out.println("Write your full name:");
                    fullName = in.nextLine();
                    System.out.println("Write your password:");
                    password = in.nextLine();
                    university.reg(true, fullName, password, tmp);
                }else{
                    System.out.println("Choose your department:");
                    for(int i = 0; i < university.departments.size(); ++i){
                        System.out.println(i + " " + university.departments.get(i).name);
                    }
                    int numberOfDepartment = in.nextInt();
                    in.nextLine();
                    Department tmp = university.departments.get(numberOfDepartment);
                    String password, index;
                    System.out.println("Write your index:");
                    index = in.nextLine();
                    System.out.println("Write your password:");
                    password = in.nextLine();
                    Professor user;
                    user = (Professor)university.logIn(true, password, index, tmp);
                    if(user != null){
                        while(true){
                            int operation;
                            System.out.println("Choose 0 to add course, 1 to add material, 2 to write grade, 3 to log out.");
                            operation = in.nextInt();
                            in.nextLine();
                            switch(operation){
                                case 0:
                                    System.out.println("Write the name of course:");
                                    String nameOfCouse = in.nextLine();
                                    System.out.println("Write the password for this course:");
                                    password = in.nextLine();
                                    user.addCourse(nameOfCouse, password);
                                    continue;
                                case 1:
                                    if(user.courses.isEmpty()){
                                        System.out.println("You have no added courses!");
                                        continue;
                                    }
                                    System.out.println("Choose the course:");
                                    for(int i = 0; i < user.courses.size(); ++i){
                                        System.out.println(i + " " + user.courses.get(i).name);
                                    }
                                    int indexOfCourse = in.nextInt();
                                    in.nextLine();
                                    System.out.println("Give the way to file:");
                                    String file = in.nextLine();
                                    user.addMaterials(file, user.courses.get(indexOfCourse));
                                    continue;
                                case 2:
                        
                                    continue;
                                case 3:
                                    user = null;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("User with such index doesn't exist or password is wrong.");
                    }
                }
            }else if(choice == 2){
                break;
            }
        }
    }
}