import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        University university = new University("UMCS");
        User user = null;
        Scanner in = new Scanner(System.in);

        while(true){
            
            System.out.println("Choose 0 to log as student, 1 to log as teacher, 2 to exit: \n");
            int choice = Integer.parseInt(in.nextLine());

            System.out.println("Do you want to log in or register? 0 for log in, 1 for register: \n");
            int logOrReg = Integer.parseInt(in.nextLine());

            if (logOrReg == 0){

                System.out.println("Enter your index: \n");
                String index = in.nextLine();
                System.out.println("Enter your password: \n");
                String password = in.nextLine();
                
                if (choice == 0){
                    user = university.logIn(false, password, index, null);
                }
                else if (choice == 1){
                    user = university.logIn(true, password, index, null);
                }
            }
            else{
                System.out.println("Enter your full name: \n");
                String fullName = in.nextLine();
                System.out.println("Enter your password: \n");
                String password = in.nextLine();
                
                if (choice == 0){
                    university.reg(false, fullName, password, null);
                }
                else if (choice == 1){
                    System.out.println("Choose your department: \n");
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