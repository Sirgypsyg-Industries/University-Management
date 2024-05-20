import java.util.Scanner;






public class Main{
    public static void main(String[] args){
        University university = new University("UMCS");
        User user = null;
        while(true){
            Scanner in = new Scanner(System.in);
            System.out.println("Choose 0 if you are a student, 1 a teacher");
            int choice = in.nextInt();
            in.nextLine();
            if(choice != 0 && choice != 1){
                continue;
            }
            System.out.println("Do you want to log in or register? 0 for log in, 1 for register, anything else for choosing the user:");
            int logOrReg = in.nextInt();
            in.nextLine();
            if (logOrReg == 0){

                System.out.println("Enter your index:");
                String index = in.nextLine();
                System.out.println("Enter your password:");
                String password = in.nextLine();
                
                if (choice == 0){
                    user = university.logIn(false, password, index, null);
                    System.out.println(user.get);
                }
                else if (choice == 1){
                    System.out.println("Choose the department you are in.");
                    for(int i = 0; i < university.departments.size(); ++i){
                        System.out.println(i + " " + university.departments.get(i).name);
                    }
                    String departmentName = university.departments.get(in.nextInt()).name;
                    in.nextLine();
                    user = university.logIn(true, password, index, departmentName);
                }
            }
            else if(logOrReg == 1){
                System.out.println("Enter your full name:");
                String fullName = in.nextLine();
                System.out.println("Enter your password:");
                String password = in.nextLine();
                
                if (choice == 0){
                    university.reg(false, fullName, password, null);
                }
                else if (choice == 1){
                    System.out.println("Choose your department:");
                    for (int index = 0; index < university.departments.size(); index++) {
                        System.out.println(index + " " + university.departments.get(index).name);
                    }
                    int departmentIndex = in.nextInt();
                    university.reg(true, fullName, password, university.departments.get(departmentIndex));
                }
            }
        }
    }
}