
## TUGAS PEMROGRAMAN MOBILE
STEPHEN PRATAMA KURNIA

TI.22.A5 312210635

DOSEN PENGAMPUH : Donny Maulana, S.Kom., M.M.S.I.



## File - [MainActivity.java](https://github.com/steprtm/Fibonacci/blob/main/app/src/main/java/com/example/fibonacci/MainActivity.java) [activity_main.xml](https://github.com/steprtm/Fibonacci/blob/main/app/src/main/res/layout/activity_main.xml) [colors.xml](https://github.com/steprtm/Fibonacci/blob/main/app/src/main/res/values/colors.xml)



## MainActivity.java

1.      package com.example.fibonacci;
- Mendefinisikan paket atau namespace aplikasi.

2.      import android.content.res.Resources;
        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget TextView;
        import android.widget Toast;

   import androidx.appcompat.app.AppCompatActivity;
- Mengimpor kelas-kelas dan komponen-komponen yang diperlukan dalam pembuatan aplikasi Android.

3.      public class MainActivity extends AppCompatActivity {
- Mendefinisikan kelas `MainActivity` sebagai aktivitas utama dalam aplikasi. Aktivitas utama ini akan menangani interaksi pengguna dan tampilan aplikasi.

4.      private static final int NUM_COLORS = 7; // Update this with the correct number of colors
- Mendeklarasikan konstanta `NUM_COLORS` yang digunakan untuk menentukan jumlah warna yang tersedia dalam daftar warna.

5.      private int currentFibonacci = 0;
        private TextView textView;
        private Button showFibonacciButton;
        private Button resetButton;
        private int previousFibonacci = 1;
- Mendeklarasikan berbagai variabel yang akan digunakan dalam aktivitas, seperti nilai `currentFibonacci` untuk menyimpan nomor Fibonacci saat ini, `textView` untuk mengakses elemen TextView, `showFibonacciButton` dan `resetButton` untuk mengakses tombol, dan `previousFibonacci` untuk menyimpan nomor Fibonacci sebelumnya.

6.      private void changeTextColor() {
- Mendefinisikan metode `changeTextColor()` yang akan digunakan untuk mengubah warna teks pada TextView.

7.      Resources res = getResources();
- Mengambil sumber daya aplikasi dengan menggunakan objek `Resources`.

8.      TypedArray colors = res.obtainTypedArray(R.array.fibonacci_colors);
- Mengambil daftar warna dari sumber daya yang didefinisikan dalam file XML dengan nama `fibonacci_colors`.

9.      int randomIndex = new Random().nextInt(NUM_COLORS);
- Menghasilkan indeks acak untuk memilih warna dari daftar warna.

10.     int randomColor = colors.getColor(randomIndex, 0);
- Mengambil warna dari daftar warna menggunakan indeks acak yang telah dihasilkan.

11.     textView.setTextColor(randomColor);
- Mengatur warna teks pada elemen TextView dengan warna yang telah dipilih secara acak.

12.     @Override
        protected void onCreate(Bundle savedInstanceState) {
- Menggantikan metode `onCreate()` yang akan dipanggil saat aktivitas dibuat atau dimulai.

13. super.onCreate(savedInstanceState);
- Memanggil metode `onCreate()` dari kelas induk `AppCompatActivity` untuk menjalankan inisialisasi dasar aktivitas.

14.     setContentView(R.layout.activity_main);
- Mengatur tampilan aktivitas dengan menghubungkannya ke layout XML yang didefinisikan dalam file `activity_main.xml`.

15.     textView = findViewById(R.id.fibonacciNumberTextView);
        showFibonacciButton = findViewById(R.id.showFibonacciButton);
        resetButton = findViewById(R.id.resetButton);
- Menghubungkan elemen-elemen tampilan dalam layout XML ke elemen Java agar dapat diakses dalam kode.

16.     showFibonacciButton.setOnClickListener(new View.OnClickListener() {
- Mendefinisikan tindakan yang akan terjadi saat tombol "Show Fibonacci Number" diklik dengan menggunakan metode `setOnClickListener()`.

17.     int nextFibonacci = currentFibonacci + previousFibonacci;
- Menghitung nomor Fibonacci selanjutnya dengan menambahkan nomor Fibonacci saat ini dengan nomor Fibonacci sebelumnya.

18.     textView.setText(String.valueOf(nextFibonacci));
- Mengatur teks pada elemen TextView untuk menampilkan nilai nomor Fibonacci yang baru dihitung.

19.     String toastMessage = "Fibonacci Number: " + currentFibonacci;
- Membuat pesan yang akan ditampilkan dalam bentuk toast.

20.     Toast toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
- Membuat objek Toast untuk menampilkan pesan. Durasi toast diatur sebagai `Toast.LENGTH_SHORT`.

21.     toast.setGravity(Gravity.TOP, 0, 16);
- Mengatur posisi toast di bagian atas layar dengan offset vertikal sebesar 16 piksel.

22.     toast.show();
- Menampilkan toast dengan pesan yang telah dibuat.

23.     previousFibonacci = currentFibonacci;
        currentFibonacci = nextFibonacci;
- Memperbarui nilai `previousFibonacci` dan `currentFibonacci` untuk perhitungan selanjutnya.

24.     resetButton.setOnClickListener(new View.OnClickListener() {
- Mendefinisikan tindakan yang akan terjadi saat tombol "Reset" diklik dengan menggunakan metode `setOnClickListener()`.

25.     currentFibonacci = 0;
        previousFibonacci = 1;
        textView.setText("0");
- Mengatur ulang nilai-nilai Fibonacci dan mengatur teks pada elemen TextView menjadi "0" ketika tombol "Reset" diklik.

## activity_main.xml
1.      <?xml version="1.0" encoding="utf-8"?>
- Baris ini mendefinisikan versi XML dan pengkodean karakter yang digunakan.
2.      <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/yellow"
        tools:context=".MainActivity"
        tools:ignore="ExtraText">
- Elemen root dari layout XML dan menggunakan ConstraintLayout, yaitu tata letak konstrain Android. Dalam elemen ini didefinisikan atribut seperti xmlns untuk namespace Android, lebar dan tinggi layout, latar belakang, konteks (activity yang terkait), dan atribut lainnya.
3.      <TextView
        android:id="@+id/fibonacciNumberTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="316dp"
        android:text="0"
        android:textColor="@color/blue"
        android:textSize="120sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
- Elemen TextView yang menampilkan angka Fibonacci. ID, lebar, tinggi, margin atas, teks default, warna teks, ukuran teks, dan batasan tata letak menggunakan ConstraintLayout.
4.      <Button
        android:id="@+id/showToastButton"
        android:layout_width="411dp"
        android:layout_height="70dp"
        android:background="#2196F3"
        android:text="Toast"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
- Elemen Button yang digunakan untuk menampilkan pesan toast. ID, lebar, tinggi, latar belakang, teks tombol, dan batasan tata letak menggunakan ConstraintLayout.
5.      <LinearLayout
        android:id="@+id/buttonContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent">
- Elemen LinearLayout yang berisi dua tombol (Hitung dan Reset). ID, lebar, tinggi, jenis orientasi (horizontal), dan batasan tata letak menggunakan ConstraintLayout.
6.      <Button
        android:id="@+id/showFibonacciButton"
        android:layout_width="211dp"
        android:layout_height="70dp"
        android:background="#2196F3"
        android:text="Hitung" />
- Button pertama dalam LinearLayout, yaitu tombol "Hitung". ID, lebar, tinggi, latar belakang, dan teks tombol.
7.     <Button
        android:id="@+id/resetButton"
        android:layout_width="211dp"
        android:layout_height="70dp"
        android:background="#2196F3"
        android:text="Reset" />
- Button kedua dalam LinearLayout, yaitu tombol "Reset". ID, lebar, tinggi, latar belakang, dan teks tombol.

## Colors.xml
    <array name="fibonacci_colors">
        <item>@color/black</item>
        <item>@color/white</item>
        <item>@color/red</item>
        <item>@color/green</item>
        <item>@color/purple</item>
        <item>@color/orange</item>
     <item>@color/blue</item>
    </array>
- Kode XML di atas mendefinisikan sebuah sumber daya array dengan nama "fibonacci_colors." Array ini berisi daftar referensi ke warna-warna yang didefinisikan dalam file colors.xml. Setiap elemen dalam array ini adalah referensi ke warna, seperti @color/black, @color/white, dan sebagainya.
Dalam kelas MainActivity, terdapat metode changeTextColor(). Metode ini digunakan untuk mengganti warna teks pada TextView dengan warna acak dari array fibonacci_colors.

Menggunakan kode TypedArray colors = res.obtainTypedArray(R.array.fibonacci_colors), kita mengambil referensi ke sumber daya array yang telah didefinisikan di atas. Kemudian, kita menggunakan Random untuk menghasilkan indeks acak dari array tersebut, dan mengambil warna sesuai dengan indeks acak tersebut dengan int randomColor = colors.getColor(randomIndex, 0).

Dengan cara ini, setiap kali tombol "Hitung" diklik, warna teks pada TextView akan diubah menjadi warna acak yang ada dalam array fibonacci_colors, menambahkan elemen visual yang menarik ke aplikasi .