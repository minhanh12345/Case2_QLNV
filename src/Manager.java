import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static Scanner scanner = new Scanner(System.in);
    private String nameFile;

    public Manager(String nameFile) {
        this.nameFile = nameFile;

    }

    public ArrayList<NhanVien> nhanViens = new ArrayList<>();

    public NhanVien create(String loaiNV) {
        System.out.println("Nhap id");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap name");
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap tuoi");
        int age ;
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap gioi tinh");
        String gender ;
        while (true) {
            gender = scanner.nextLine();
            if (gender != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap dia chi");
        String address ;
        while (true) {
            address = scanner.nextLine();
            if (address != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap luong");
        float luong;
        while (true) {
            try {
                luong = Float.parseFloat(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("can't blank");
            }
        }
        System.out.println("Nhap trang thai");
        boolean status ;
        while (true) {
            try {
               status = Boolean.parseBoolean(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("can't blank");
            }
        }
        if (loaiNV.equals("NVFullTime")) {
            return new NhanVienFullTime(id, name, age, gender, address, luong, status);
        } else {
            System.out.println("Nhap gio lam viec");
            int timeWork ;
            while (true) {
                try {
                    timeWork = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("can't blank");
                }
            }
            return new NhanVienPartTime(id, name, age, gender, address, luong, timeWork, status);
        }
    }

    public void add() throws IOException {
        System.out.println("1.Them nhan vien FullTime");
        System.out.println("2.Them nhan vien PartTime");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            nhanViens.add(create("NVFullTime"));
            save();
        } else {
            nhanViens.add(create("NVPartTime"));
            save();
        }
    }

    public void findByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhap ten can tim");
        String name ;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Sai ten");
        } else {
            System.out.println(nhanViens.get(check));
        }
    }

    public void checkStatus() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhap ten can cap nhap");
        String name ;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Sai ten");
        } else {
            System.out.println("nhan vien " + nhanViens.get(check).getName() + " " + nhanViens.get(check).getRealStatus());
        }
    }

    public void remove() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhap ten can cap nhap");
        String name ;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Sai ten");
        } else {
            nhanViens.remove(check);
        }
    }

    public void editByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhap ten can cap nhap");
        String name ;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Sai ten");
        } else {

            System.out.println("Nhap id");
            int id = scanner.nextInt();
            System.out.println("Nhap name");
            String newName = scanner.next();
            System.out.println("Nhap tuoi");
            int age = scanner.nextInt();
            System.out.println("Nhap gioi tinh");
            String gender = scanner.next();
            System.out.println("Nhap dia chi");
            String address = scanner.next();
            System.out.println("Nhap luong");
            float luong = scanner.nextFloat();
            nhanViens.get(check).setId(id);
            nhanViens.get(check).setName(newName);
            nhanViens.get(check).setAge(age);
            nhanViens.get(check).setGender(gender);
            nhanViens.get(check).setAddress(address);
            nhanViens.get(check).setLuong(luong);
            if (nhanViens.get(check) instanceof NhanVienPartTime) {
                System.out.println("Nhap so gio lam viec");
                int timeWork = scanner.nextInt();
                ((NhanVienPartTime) nhanViens.get(check)).setTimeWork(timeWork);
            }

        }
        save();
    }

    public void editStatusByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Nhap ten can cap nhap");
        String name ;
        while (true) {
            name = scanner.nextLine();
            if (name != "") {
                break;
            } else {
                System.out.println("can't blank");
            }
        }
        int check = -1;
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Sai ten");
        } else {
            if (nhanViens.get(check).getStatus() == true) {
                nhanViens.get(check).setStatus(false);
                save();
            } else {
                nhanViens.get(check).setStatus(true);
                save();
            }
        }
    }

    public void showTypeNhanVien() throws IOException, ClassNotFoundException {
        read();
        System.out.println("1.Nhan vien Part time");
        System.out.println("2.Nhan vien Full time");
        int choose = scanner.nextInt();
        if (choose == 1) {
            for (NhanVien nhanVien : nhanViens) {
                if (nhanVien instanceof NhanVienPartTime) {
                    System.out.println(nhanVien);
                }
            }
        } else {
            for (NhanVien nhanVien : nhanViens) {
                if (nhanVien instanceof NhanVienFullTime) {
                    System.out.println(nhanVien);
                }
            }
        }
    }

    public void show() throws IOException, ClassNotFoundException {
        read();
        for (NhanVien nhanVien : nhanViens) {
            System.out.println(nhanVien);
        }
    }

    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(nhanViens);

    }

    public void read() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(nameFile);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        nhanViens = (ArrayList<NhanVien>) ois.readObject();

    }

    public void outputExcel() throws IOException, ClassNotFoundException {
        read();
        File fileExcel = new File(nameFile + ".csv");
        FileWriter fileWriter = new FileWriter(fileExcel);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Nhan Vien" + "," + "ID" + "," + "Name" + "," + "Age" + "," + "Address" + "," + "Luong" + "," + "Status" + "," + "Doanh thu" + "Time Work");
        bufferedWriter.newLine();
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien instanceof NhanVienPartTime) {
                bufferedWriter.write("NV PartTime" + ","
                        + nhanVien.getId() + ","
                        + nhanVien.getName() + ","
                        + nhanVien.getAge() + ","
                        + nhanVien.getAddress() + ","
                        + nhanVien.getLuong() + ","
                        + nhanVien.getRealStatus() + ","
                        + nhanVien.getDoanhThu() + ","
                        + ((NhanVienPartTime) nhanVien).getTimeWork());
                bufferedWriter.newLine();
            }
        }
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien instanceof NhanVienPartTime) {
                bufferedWriter.write("NV FullTime" + ","
                        + nhanVien.getId() + ","
                        + nhanVien.getName() + ","
                        + nhanVien.getAge() + ","
                        + nhanVien.getAddress() + ","
                        + nhanVien.getLuong() + ","
                        + nhanVien.getRealStatus() + ","
                        + nhanVien.getDoanhThu());
                bufferedWriter.newLine();
            }

        }
        bufferedWriter.close();
    }
}
