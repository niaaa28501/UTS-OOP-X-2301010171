package uts.oop.x.pkg2301010171;

import java.util.Scanner;

class Note {
    String content;

    public Note(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class NoteApp {
    static final int MAX_NOTES = 100;
    static Note[] notes = new Note[MAX_NOTES];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- APLIKASI MAKANAN ---");
            System.out.println("1. Tambah Makanan");
            System.out.println("2. Tampilkan Makanan");
            System.out.println("3. Ubah  Makanan");
            System.out.println("4. Hapus  Makanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (choice) {
                case 1:
                    tambahCatatan(scanner);
                    break;
                case 2:
                    tampilkanCatatan();
                    break;
                case 3:
                    ubahCatatan(scanner);
                    break;
                case 4:
                    hapusCatatan(scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 5);
    }

    static void tambahCatatan(Scanner scanner) {
        if (count >= MAX_NOTES) {
            System.out.println("Penyimpanan penuh!");
            return;
        }
        System.out.print("Masukkan isi catatan: ");
        String isi = scanner.nextLine();
        notes[count] = new Note(isi);
        count++;
        System.out.println("Catatan berhasil ditambahkan.");
    }

    static void tampilkanCatatan() {
        if (count == 0) {
            System.out.println("Belum ada catatan.");
            return;
        }
        System.out.println("\nDaftar Catatan:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + notes[i].getContent());
        }
    }

    static void ubahCatatan(Scanner scanner) {
        tampilkanCatatan();
        if (count == 0) return;

        System.out.print("Pilih nomor catatan yang ingin diubah: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline
        if (index < 1 || index > count) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        System.out.print("Masukkan isi baru: ");
        String isiBaru = scanner.nextLine();
        notes[index - 1].setContent(isiBaru);
        System.out.println("Catatan berhasil diubah.");
    }

    static void hapusCatatan(Scanner scanner) {
        tampilkanCatatan();
        if (count == 0) return;

        System.out.print("Pilih nomor catatan yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline
        if (index < 1 || index > count) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        // Geser elemen setelah index ke kiri
        for (int i = index - 1; i < count - 1; i++) {
            notes[i] = notes[i + 1];
        }
        notes[count - 1] = null;
        count--;
        System.out.println("Catatan berhasil dihapus.");
    }
}
