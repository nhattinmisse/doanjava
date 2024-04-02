
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class QuanLyNhanVien {
	 public static class NhanVien {
	        private String maNV;
	        private String ten;
	        private int tuoi;
	        private String chucVu;
	        private int luong;
	        private String ngayThangNamSinh;
	        private int soNgayCong;

	        public NhanVien(String maNV, String ten, int tuoi, String chucVu, String ngayThangNamSinh, int soNgayCong) {
	            this.maNV = maNV;
	            this.ten = ten;
	            this.tuoi = tuoi;
	            this.chucVu = chucVu;
	            this.ngayThangNamSinh = ngayThangNamSinh;
	            this.soNgayCong = soNgayCong;
	            this.luong = soNgayCong * 300000; 
	        }

	        @Override
	        public String toString() {
	            return String.format(
	                    "Ma NV: %-11s | Ho ten: %-19s | Tuoi: %1d | Chuc vu: %-11s | Luong: %-13d | Ngay sinh: %-11s | So ngay cong: %-10d",
	                    maNV, ten, tuoi, chucVu, luong, ngayThangNamSinh, soNgayCong
	            );
	        }
	    }

	    private static final int MAX_NHANVIEN = 100; 
	    private static NhanVien[] danhSachNhanVien = new NhanVien[MAX_NHANVIEN];
	    private static int soLuongNhanVien = 0;
	    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            System.out.println();

            switch (luaChon) {
                case 1:
                    nhapThongTinNhanVien();
                    System.out.println("Ban da nhap thong tin nhan vien!\n");
                    break;

                case 2:
                    themNhanVien();
                    System.out.println("Nhan vien da duoc them vao danh sach!\n");
                    break;

                case 3:
                    timKiemNhanVienTheoMa();
                    break;

                case 4:
                    xoaNhanVienTheoMa();
                    break;
                    
                case 5:
                    inDanhSachNhanVien();
                    break;
                case 6:
                	sapXepDanhSachTheoTuoi();
                	break;
                    
                case 7:
                	sapXepDanhSachTheoLuongGiamDan();
                	break;
                case 8:
                    xuatDuLieuRaFile();
                    break;

                case 9:
                    nhapDuLieuTuFile();
                    break;

                case 0:
                    System.out.println("Ban da thoat chuong trinh!");
                    System.exit(0);

                default:
                	System.out.println("Khong co chuc nang nay!\n");
            }
        }
    }

    private static void hienThiMenu() {
        System.out.println("\n===========================================");
        System.out.println("==    CHUONG TRINH QUAN LY NHAN VIEN     ==");
        System.out.println("==    1. Nhap thong tin nhan vien        ==");
        System.out.println("==    2. Them nhan vien                  ==");
        System.out.println("==    3. Tim kiem nhan vien (ma NV)      ==");
        System.out.println("==    4. Xoa nhan vien theo ma NV        ==");
        System.out.println("==    5. In danh sach nhan vien          ==");
        System.out.println("==    6. Sap xep danh sach theo Tuoi     ==");
        System.out.println("==    7. Thong ke danh sach theo luong   ==");
        System.out.println("==    8. Xuat du lieu ra file            ==");
        System.out.println("==    9. Nhap du lieu tu file            ==");
        System.out.println("==    0. Thoat                           ==");
        System.out.println("============================================\n");
    }

    private static void nhapThongTinNhanVien() {
        System.out.print("Nhap so luong nhan vien: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < soLuong; i++) {
            System.out.printf("\n--- Nhan vien thu %d ---\n", (i + 1));

            System.out.print("Nhap Ma nhan vien: ");
            String maNV = scanner.nextLine();

            System.out.print("Nhap Ho ten nhan vien: ");
            String ten = scanner.nextLine();

            System.out.print("Nhap Tuoi nhan vien: ");
            int tuoi = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Nhap Chuc vu nhan vien: ");
            String chucVu = scanner.nextLine();

            System.out.print("Nhap So ngay lam viec trong thang: ");
            int soNgayCong = scanner.nextInt();
            scanner.nextLine(); 

            String ngayThangNamSinh = "";
            System.out.print("Nhap Ngay thang nam sinh (dd/mm/yyyy): ");
            ngayThangNamSinh = scanner.nextLine();

            danhSachNhanVien[soLuongNhanVien++] = new NhanVien(maNV, ten, tuoi, chucVu, ngayThangNamSinh, soNgayCong);
        }
    }

    private static void themNhanVien() {
    	 if (soLuongNhanVien < MAX_NHANVIEN) {
    	        System.out.println("\n======= THEM NHAN VIEN =======");
    	        scanner.nextLine(); 
    	        System.out.print("Nhap Ma nhan vien: ");
    	        String maNV = scanner.nextLine();

    	        System.out.print("Nhap Ho ten nhan vien: ");
    	        String ten = scanner.nextLine();

    	        System.out.print("Nhap Tuoi nhan vien: ");
    	        int tuoi = scanner.nextInt();
    	        scanner.nextLine(); 
    	        System.out.print("Nhap Chuc vu nhan vien: ");
    	        String chucVu = scanner.nextLine();

    	        System.out.print("Nhap So ngay lam viec trong thang: ");
    	        int soNgayCong = scanner.nextInt();
    	        scanner.nextLine();

    	        System.out.print("Nhap Ngay thang nam sinh (dd/mm/yyyy): ");
    	        String ngayThangNamSinh = scanner.nextLine();

    	        danhSachNhanVien[soLuongNhanVien++] = new NhanVien(maNV, ten, tuoi, chucVu, ngayThangNamSinh, soNgayCong);
    	        System.out.println("Nhan vien da duoc them vao danh sach!\n");
    	    } else {
    	        System.out.println("Danh sach nhan vien da day, khong the them nhan vien moi!");
    	    }
    }

    private static void timKiemNhanVienTheoMa() {
        System.out.println("Tim kiem nhan vien theo Ma nhan vien");
        System.out.print("Nhap Ma nhan vien can tim: ");
        String maNV = scanner.next();

        boolean timThay = false;
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].maNV.equals(maNV)) {
                timThay = true;
                System.out.println("\n=====================================================================================================================================================");
                System.out.println("===========================================================       NHAN VIEN TIM THAY      ===========================================================");
                System.out.println(danhSachNhanVien[i]);
                System.out.println("=====================================================================================================================================================\n");
                break;
            }
        }

        if (!timThay) {
            System.out.printf("Khong tim thay nhan vien voi Ma nhan vien: %s\n", maNV);
        }
    }

    private static void xoaNhanVienTheoMa() {
        System.out.println("Xoa nhan vien theo Ma nhan vien");
        System.out.print("Nhap Ma nhan vien can xoa: ");
        String maNV = scanner.next();

        boolean timThay = false;
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].maNV.equals(maNV)) {
                timThay = true;
                for (int j = i; j < soLuongNhanVien - 1; j++) {
                    danhSachNhanVien[j] = danhSachNhanVien[j + 1];
                }
                danhSachNhanVien[--soLuongNhanVien] = null;
                System.out.printf("Da xoa nhan vien co Ma nhan vien: %s\n", maNV);
                break;
            }
        }

        if (!timThay) {
            System.out.printf("Khong tim thay nhan vien voi Ma nhan vien: %s\n", maNV);
        }
    }

    private static void sapXepDanhSachTheoTuoi() {
        for (int i = 0; i < soLuongNhanVien - 1; i++) {
            for (int j = i + 1; j < soLuongNhanVien; j++) {
                if (danhSachNhanVien[i].tuoi > danhSachNhanVien[j].tuoi) {
                    NhanVien temp = danhSachNhanVien[i];
                    danhSachNhanVien[i] = danhSachNhanVien[j];
                    danhSachNhanVien[j] = temp;
                }
            }
        }

        System.out.println("\n=========================================================================================================================================================");
        System.out.println("============================================================= DANH SACH NHAN VIEN (THEO TUOI TANG DAN) ==================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==      Ma NV      |      Ho ten nhan vien       |   Tuoi   |       Chuc vu        |        Luong         |        Ngay sinh       |   So ngay cong   ===");

        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println(danhSachNhanVien[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }
    private static void inDanhSachNhanVien() {
        System.out.println("\n=========================================================================================================================================================");
        System.out.println("=================================================================== DANH SACH NHAN VIEN =================================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==    Ma NV        |     Ho ten nhan vien        |   Tuoi   |       Chuc vu        |     Luong            |        Ngay sinh       | So ngay cong      ==");

        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println(danhSachNhanVien[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }
    
    private static void sapXepDanhSachTheoLuongGiamDan() {
        for (int i = 0; i < soLuongNhanVien - 1; i++) {
            for (int j = i + 1; j < soLuongNhanVien; j++) {
                if (danhSachNhanVien[i].luong < danhSachNhanVien[j].luong) {
                    NhanVien temp = danhSachNhanVien[i];
                    danhSachNhanVien[i] = danhSachNhanVien[j];
                    danhSachNhanVien[j] = temp;
                }
            }
        }

        System.out.println("\n=========================================================================================================================================================");
        System.out.println("============================================================== DANH SACH NHAN VIEN (THEO LUONG GIAM DAN) ================================================");
        System.out.println("=========================================================================================================================================================");
        System.out.println("==      Ma NV      |      Ho ten nhan vien       |   Tuoi   |       Chuc vu        |        Luong         |        Ngay sinh       |   So ngay cong   ===");

        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println(danhSachNhanVien[i]);
        }

        System.out.println("=========================================================================================================================================================");
    }
    
    private static void xuatDuLieuRaFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nhanvien.txt"))) {
            for (int i = 0; i < soLuongNhanVien; i++) {
                writer.write(String.format("%s,%s,%d,%s,%s,%d,%d\n",
                        danhSachNhanVien[i].maNV,
                        danhSachNhanVien[i].ten,
                        danhSachNhanVien[i].tuoi,
                        danhSachNhanVien[i].chucVu,
                        danhSachNhanVien[i].ngayThangNamSinh,
                        danhSachNhanVien[i].soNgayCong,
                        danhSachNhanVien[i].luong));
            }
            System.out.println("Luu du lieu vao file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi luu file: " + e.getMessage());
        }
    }

    private static void nhapDuLieuTuFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("nhanvien.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maNV = parts[0];
                String ten = parts[1];
                int tuoi = Integer.parseInt(parts[2]);
                String chucVu = parts[3];
                String ngayThangNamSinh = parts[4];
                int soNgayCong = Integer.parseInt(parts[5]);
                int luong = (int)Float.parseFloat(parts[6]);

                NhanVien nv = new NhanVien(maNV, ten, tuoi, chucVu, ngayThangNamSinh, soNgayCong);
                themNhanVienVaoDanhSach(nv);
            }
            System.out.println("Doc du lieu tu file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    private static void themNhanVienVaoDanhSach(NhanVien nv) {
        if (soLuongNhanVien < MAX_NHANVIEN) {
            danhSachNhanVien[soLuongNhanVien++] = nv;
        } else {
            System.out.println("Danh sach nhan vien da day, khong the them nhan vien moi!");
        }

	}

}