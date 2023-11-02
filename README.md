
## TUGAS PEMROGRAMAN MOBILE
STEPHEN PRATAMA KURNIA

TI.22.A5 312210635

DOSEN PENGAMPUH : Donny Maulana, S.Kom., M.M.S.I.



## File - [MainActivity.java](https://github.com/steprtm/Fibonacci/blob/main/app/src/main/java/com/example/fibonacci/MainActivity.java) [activity_main.xml](https://github.com/steprtm/Fibonacci/blob/main/app/src/main/res/layout/activity_main.xml) 



## MainActivity.java

1. package com.example.fibonacci;
   - Mendefinisikan paket atau namespace aplikasi Anda.

3. import android.os.Bundle;
   import android.view.Gravity;
   import android.view.View;
   import android.widget.Button;
   import android.widget.TextView;
   import android.widget.Toast;
   import androidx.appcompat.app.AppCompatActivity;
   - Mengimpor kelas dan komponen yang diperlukan untuk membuat aplikasi Android, seperti Activity, View, Button, TextView, dan Toast.

5. public class MainActivity extends AppCompatActivity {
   - Mendefinisikan kelas utama aplikasi, `MainActivity`, yang merupakan aktivitas utama dalam aplikasi Android Anda. Ini menggambarkan perilaku dan antarmuka pengguna utama aplikasi.

8. private int currentFibonacci = 0;
   private TextView textView;
   private Button showFibonacciButton;
   private Button resetButton;
   private int previousFibonacci = 1;
   - Mendeklarasikan variabel yang akan digunakan dalam aktivitas, termasuk nilai-nilai Fibonacci saat ini, elemen TextView, dan dua tombol untuk menghitung dan mereset nomor Fibonacci.

12. @Override
   protected void onCreate(Bundle savedInstanceState) {
   - Mendeklarasikan dan mengganti metode `onCreate()`. Metode ini akan dipanggil saat aktivitas dimulai atau dibuat.

14. super.onCreate(savedInstanceState);
   - Memanggil metode `onCreate()` dari kelas induk (`AppCompatActivity`) untuk menjalankan kode inisialisasi dasar aktivitas.

16. setContentView(R.layout.activity_main);
   - Mengatur tampilan atau layout aktivitas dengan menghubungkannya ke file XML `activity_main.xml` yang didefinisikan dalam folder `res/layout`.

18. textView = findViewById(R.id.fibonacciNumberTextView);
   showFibonacciButton = findViewById(R.id.showFibonacciButton);
   resetButton = findViewById(R.id.resetButton);
   - Menghubungkan elemen tampilan (TextView, dua tombol) dalam layout XML dengan elemen Java agar dapat diakses dan dimanipulasi dalam kode.

21. showFibonacciButton.setOnClickListener(new View.OnClickListener() {
   - Mendefinisikan tindakan yang akan terjadi ketika tombol "Show Fibonacci Number" diklik. Ini menggunakan metode `setOnClickListener()` untuk menangani peristiwa klik.

23. int nextFibonacci = currentFibonacci + previousFibonacci;
   - Menghitung nilai nomor Fibonacci selanjutnya dengan menambahkan nomor Fibonacci saat ini dengan nomor Fibonacci sebelumnya.

25. textView.setText(String.valueOf(nextFibonacci));
   - Menampilkan hasil perhitungan Fibonacci di dalam elemen TextView dalam tampilan.

28. String toastMessage = "Hasil : " + nextFibonacci;
   - Membuat pesan yang akan ditampilkan dalam toast.

30. Toast toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
   - Membuat objek Toast untuk menampilkan pesan. Penggunaan `Toast.LENGTH_SHORT` menunjukkan durasi toast yang singkat.

32. toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
   - Mengatur posisi toast ke atas (top) dan di sebelah kiri (start) layar. Nilai 0, 0 adalah offset horizontal dan vertikal (tidak ada offset).

34. toast.show();
   - Menampilkan toast ke layar dengan pesan yang telah dibuat.

37. previousFibonacci = currentFibonacci;
   currentFibonacci = nextFibonacci;
   - Memperbarui nilai nomor Fibonacci sebelumnya dan saat ini untuk perhitungan selanjutnya.

40. resetButton.setOnClickListener(new View.OnClickListener() {
   - Mendefinisikan tindakan yang akan terjadi ketika tombol "Reset" diklik. Ini juga menggunakan `setOnClickListener()` untuk menangani peristiwa klik.

42. currentFibonacci = 0;
   previousFibonacci = 1;
   textView.setText("0");
   - Mereset nilai-nilai Fibonacci dan mengatur teks pada elemen TextView ke "0" saat tombol "Reset" diklik.


## activity_main.xml

1. <?xml version="1.0" encoding="utf-8"?>
   - Deklarasi XML yang menandakan versi XML dan pengkodean karakter.

2. <androidx.constraintlayout.widget.ConstraintLayout
   - Ini adalah tag root dari XML layout. Ini menggunakan `ConstraintLayout` sebagai tata letak utama.

3.   xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:app="http://schemas.android.com/apk/res-auto"
     xmlns:tools="http://schemas.android.com/tools"
   - Definisi namespace yang digunakan dalam file XML.

4.   android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:background="@color/yellow"
   - Atribut-atribut yang mengatur tata letak dan latar belakang layar aplikasi.

5.   tools:context=".MainActivity"
     tools:ignore="ExtraText">
   - Atribut untuk alat pengembangan dan konfigurasi lainnya.

7. <TextView
   - Ini adalah elemen `TextView` yang akan menampilkan nomor Fibonacci.

8.   android:id="@+id/fibonacciNumberTextView"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:layout_marginTop="352dp"
     android:text="0"
     android:textSize="70sp"
     - Atribut-atribut yang mengatur tampilan TextView.

13.   app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintHorizontal_bias="0.494"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent"/>
   - Atribut-atribut yang mengatur tata letak elemen TextView di dalam ConstraintLayout.

15. <LinearLayout
    - Ini adalah elemen `LinearLayout` yang mengelompokkan dua tombol.

16.   android:id="@+id/buttonContainer"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:gravity="center"
     android:orientation="horizontal"
    - Atribut-atribut yang mengatur tampilan dan tata letak LinearLayout.

22.   app:layout_constraintBottom_toBottomOf="parent"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintStart_toStartOf="parent">
   - Atribut-atribut yang mengatur tata letak elemen LinearLayout di dalam ConstraintLayout.

24. <Button
   - Ini adalah elemen `Button` pertama.

25.   android:id="@+id/showFibonacciButton"
     android:layout_width="211dp"
     android:layout_height="70dp"
     android:background="#2196F3"
     android:text="Hitung"
   - Atribut-atribut yang mengatur tampilan tombol pertama.

30. <Button
   - Ini adalah elemen `Button` kedua.

31.   android:id="@+id/resetButton"
     android:layout_width="211dp"
     android:layout_height="70dp"
     android:background="#2196F3"
     android:text="Reset"
   - Atribut-atribut yang mengatur tampilan tombol kedua.

34. </LinearLayout>
   - Penutup untuk elemen `LinearLayout`.

36. </androidx.constraintlayout.widget.ConstraintLayout>
   - Penutup untuk tag root `ConstraintLayout`.
