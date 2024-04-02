import java.io.*;
import java.util.Scanner;
public class QuanLyNhanVienn {
	private static final int MAX_NHANVIEN = 100;
    private static NhanVien[] danhSachNhanVien = new NhanVien[MAX_NHANVIEN];
    private static int soLuongNhanVien = 0;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự thừa sau khi đọc số

            switch (choice) {
                case 1:
                    nhapThongTinNhanVien(scanner);
                    break;
                case 2:
                    themNhanVien(scanner);
                    break;
                case 3:
                    timKiemNhanVien(scanner);
                    break;
                case 4:
                    xoaNhanVien(scanner);
                    break;
                case 5:
                    sapXepTheoTen();
                    break;
                case 6:
                    inDanhSachNhanVien();
                    break;
                case 7:
                    thongKeTheoTongLuong();
                    break;
                case 8:
                    docFile();
                    break;
                case 9:
                    luuFile();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void hienThiMenu() {
        System.out.println("\n===========================================");
        System.out.println("==    CHUONG TRINH QUAN LY NHAN VIEN     ==");
        System.out.println("==    1. Nhap thong tin nhan vien        ==");
        System.out.println("==    2. Them nhan vien                  ==");
        System.out.println("==    3. Tim kiem nhan vien (ma NV)      ==");
        System.out.println("==    4. Xoa nhan vien theo ma NV        ==");
        System.out.println("==    5. Sap xep danh sach theo ten      ==");
        System.out.println("==    6. In danh sach nhan vien          ==");
        System.out.println("==    7. Thong ke theo tong luong        ==");
        System.out.println("==    8. Doc du lieu tu file              ==");
        System.out.println("==    9. Luu du lieu vao file             ==");
        System.out.println("==    0. Thoat                           ==");
        System.out.println("============================================\n");
    }

    private static void nhapThongTinNhanVien(Scanner scanner) {
        System.out.print("Nhap ten nhan vien: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        String maNV = scanner.nextLine();
        System.out.print("Nhap tuoi nhan vien: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự thừa sau khi đọc số
        System.out.print("Nhap que quan: ");
        String queQuan = scanner.nextLine();
        System.out.print("Nhap chuc vu: ");
        String chucVu = scanner.nextLine();
        System.out.print("Nhap so ngay lam viec: ");
        int soNgayLamViec = scanner.nextInt();
        System.out.print("Nhap tong luong: ");
        double tongLuong = scanner.nextDouble();
        
        NhanVien nv = new NhanVien(ten, maNV, tuoi, queQuan, chucVu, soNgayLamViec, tongLuong);
        themNhanVienVaoDanhSach(nv);
        System.out.println("Da them nhan vien " + ten + " vao danh sach.");
    }

    private static void themNhanVien(Scanner scanner) {
        // Bạn có thể thêm nội dung vào phương thức này
        // Nếu bạn muốn nhập thông tin một cách tương tác từ bàn phím
        // hoặc gọi phương thức nhapThongTinNhanVien
    }

    private static void timKiemNhanVien(Scanner scanner) {
        System.out.print("Nhap ma nhan vien can tim kiem: ");
        String maNV = scanner.nextLine();
        
        NhanVien nv = timKiemNhanVienTheoMa(maNV);
        if (nv != null) {
            System.out.println("Thong tin nhan vien: ");
            System.out.println(nv);
        } else {
            System.out.println("Khong tim thay nhan vien voi ma " + maNV);
        }
    }

    private static void xoaNhanVien(Scanner scanner) {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String maNV = scanner.nextLine();
        
        boolean daXoa = xoaNhanVienTheoMa(maNV);
        if (daXoa) {
            System.out.println("Da xoa nhan vien voi ma " + maNV);
        } else {
            System.out.println("Khong tim thay nhan vien voi ma " + maNV + " de xoa.");
        }
    }

    private static void sapXepTheoTen() {
        // Sử dụng thuật toán sắp xếp nổi bọt để sắp xếp danh sách theo tên
        for (int i = 0; i < soLuongNhanVien - 1; i++) {
            for (int j = 0; j < soLuongNhanVien - i - 1; j++) {
                if (danhSachNhanVien[j].getTen().compareTo(danhSachNhanVien[j + 1].getTen()) > 0) {
                    NhanVien temp = danhSachNhanVien[j];
                    danhSachNhanVien[j] = danhSachNhanVien[j + 1];
                    danhSachNhanVien[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Da sap xep danh sach theo ten.");
    }

    private static void inDanhSachNhanVien() {
        if (soLuongNhanVien == 0) {
            System.out.println("Danh sach nhan vien rong.");
            return;
        }
        
        System.out.println("Danh sach nhan vien: ");
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println(danhSachNhanVien[i]);
        }
    }

    private static void thongKeTheoTongLuong() {
        double tongLuong = 0;
        for (int i = 0; i < soLuongNhanVien; i++) {
            tongLuong += danhSachNhanVien[i].getTongLuong();
        }
        
        System.out.println("Tong luong cua tat ca nhan vien la: " + tongLuong);
    }

    private static void docFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("nhanvien.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String ten = parts[0];
                String maNV = parts[1];
                int tuoi = Integer.parseInt(parts[2]);
                String queQuan = parts[3];
                String chucVu = parts[4];
                int soNgayLamViec = Integer.parseInt(parts[5]);
                double tongLuong = Double.parseDouble(parts[6]);
                
                NhanVien nv = new NhanVien(ten, maNV, tuoi, queQuan, chucVu, soNgayLamViec, tongLuong);
                themNhanVienVaoDanhSach(nv);
            }
            
            System.out.println("Da doc du lieu tu file.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    private static void luuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nhanvien.txt"))) {
            for (int i = 0; i < soLuongNhanVien; i++) {
                writer.write(danhSachNhanVien[i].toString());
                writer.newLine();
            }
            
            System.out.println("Da luu du lieu vao file.");
        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
        }
    }

    private static void themNhanVienVaoDanhSach(NhanVien nv) {
        if (soLuongNhanVien < MAX_NHANVIEN) {
            danhSachNhanVien[soLuongNhanVien++] = nv;
        } else {
            System.out.println("Danh sach nhan vien da day. Khong the them moi.");
        }
    }

    private static NhanVien timKiemNhanVienTheoMa(String maNV) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].getMaNV().equals(maNV)) {
                return danhSachNhanVien[i];
            }
        }
        return null;
    }

    private static boolean xoaNhanVienTheoMa(String maNV) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].getMaNV().equals(maNV)) {
                for (int j = i; j < soLuongNhanVien - 1; j++) {
                    danhSachNhanVien[j] = danhSachNhanVien[j + 1];
                }
                danhSachNhanVien[--soLuongNhanVien] = null;
                return true;
            }
        }
        return false;
    }

    private static class NhanVien {
        private String ten;
        private String maNV;
        private int tuoi;
        private String queQuan;
        private String chucVu;
        private int soNgayLamViec;
        private double tongLuong;

        public NhanVien(String ten, String maNV, int tuoi, String queQuan, String chucVu, int soNgayLamViec, double tongLuong) {
            this.ten = ten;
            this.maNV = maNV;
            this.tuoi = tuoi;
            this.queQuan = queQuan;
            this.chucVu = chucVu;
            this.soNgayLamViec = soNgayLamViec;
            this.tongLuong = tongLuong;
        }

        public String getTen() {
            return ten;
        }

        public String getMaNV() {
            return maNV;
        }

        public double getTongLuong() {
            return tongLuong;
        }

        @Override
        public String toString() {
            return "NhanVien{" +
                    "ten='" + ten + '\'' +
                    ", maNV='" + maNV + '\'' +
                    ", tuoi=" + tuoi +
                    ", queQuan='" + queQuan + '\'' +
                    ", chucVu='" + chucVu + '\'' +
                    ", soNgayLamViec=" + soNgayLamViec +
                    ", tongLuong=" + tongLuong +
                    '}';
        }
	}

}
