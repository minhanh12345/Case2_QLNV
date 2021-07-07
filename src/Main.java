import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String nameFile1;
    static String passWord1;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        returnMain();
    }

    public static void returnMain() throws IOException, ClassNotFoundException {
        start();
        Manager manager = new Manager(nameFile1);
        while (true) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("             ******* [" + nameFile1 + "] ******                  o online");
            System.out.println("___________________________________________________________________");
            System.out.println("1.Add                                       | 11.Tro lai dang nhap|");
            System.out.println("2.Edit                                      | 12.Exit             |");
            System.out.println("3.EditForStatus                             | 13.Xuat ra Excel    |");
            System.out.println("4.Find by Name                              ----------------------|");
            System.out.println("5.Check for status                                                |");
            System.out.println("6.Remove nhan vien                                   ACCOUNT      |");
            System.out.println("7.Show nhan vien theo tung loai              |=>9.Remove account  |");
            System.out.println("8.Show thong tin nhan vien                   |=>10.Show info acc  |");
            System.out.println("__________________________________________________________________|");
            int choose = Integer.parseInt(scanner.nextLine());
            File fileManager = new File(nameFile1);
            switch (choose) {
                case 1:
                    manager.add();
                    break;
                case 2:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.editByName();
                        break;
                    }
                case 3:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.editStatusByName();
                        break;
                    }
                case 4:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.findByName();
                        break;
                    }
                case 5:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.checkStatus();
                        break;
                    }
                case 6:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.remove();
                        break;
                    }
                case 7:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.showTypeNhanVien();
                        break;
                    }

                case 8:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        manager.show();
                        break;
                    }
                case 9:
                    System.out.println("Da xoa tai khoan "+nameFile1);
                    ManagerUser.removeUser(nameFile1);
                    returnMain();
                    break;
                case 10:
                    System.out.println("UserName: " + nameFile1);
                    System.out.println("PassWord: " + passWord1);
                    break;
                case 11:
                    returnMain();
                case 12:
                    System.exit(0);
                case 13:
                    if (!fileManager.exists()) {
                        System.out.println("List is empty");
                        break;
                    } else {
                        System.out.println("Da luu vao file: " + nameFile1 + ".csv");
                        manager.outputExcel();
                        break;
                    }
            }
        }
    }


    public static void start() throws IOException, ClassNotFoundException {
        File file = new File("user.txt");

        if (!file.exists()) {
            ManagerUser.listUser.add(new UserPerson("new", "new"));
            ManagerUser.writeFileUser();
        }


        ManagerUser.readFileUser();
        System.out.println("--------------");
        System.out.println("1.Dang Nhap  |");
        System.out.println("2 Dang ky    |");
        System.out.println("--------------");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 2) {
            while (true) {
                System.out.println("Nhap username");
                String userName = scanner.nextLine();
                int check = -1;

                for (int i = 0; i < ManagerUser.listUser.size(); i++) {
                    if (ManagerUser.listUser.get(i).getUserName().equals(userName)) {
                        check = i;
                    }
                }
                if (check > 0) {
                    System.out.println("da co ");
                } else {
                    System.out.println("Nhap password");
                    String password = scanner.nextLine();
                    UserPerson userPerson = new UserPerson(userName, password);
                    ManagerUser.listUser.add(userPerson);
                    ManagerUser.writeFileUser();
                    nameFile1 = userName;
                    System.out.println("WELCOME " + userName);
                    passWord1 = password;
                    break;
                }
            }
        } else {
            int check1 = -1;
            while (true) {
                System.out.println("Nhap username");
                String userName = scanner.nextLine();
                for (int i = 0; i < ManagerUser.listUser.size(); i++) {
                    if (ManagerUser.listUser.get(i).getUserName().equals(userName)) {
                        while (true) {
                            System.out.println("Nhap Password");
                            String password = scanner.nextLine();
                            if (ManagerUser.listUser.get(i).getPassword().equals(password)) {
                                nameFile1 = userName;
                                System.out.println("WELCOME " + userName);
                                check1 = 1;
                                passWord1 = password;
                                break;
                            }
                            System.out.println("sai pass");
                        }
                    }
                }
                if (check1 > 0) {
                    break;
                }
                System.out.println("sai user");
            }
        }
    }


}
