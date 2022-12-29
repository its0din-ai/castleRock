## CASTLEROCK LIBRARY
### Final Project of Object Oriented Programming Course
##### Library Information Management System written in Java with JDBC and MySQL Database.

![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)

[English Documentation](#english) <br>
[Indonesian Documentation](#indonesia) <br>
[Version History](#version-history)

### ENGLISH
#### How To Build
1. Clone / download this repository
2. Use Visual Studio Code to open the project for optimized experience
3. Make sure you already installed [Java Projects extension](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
4. You need a MySQL database, and export the ```castlerock_lib.sql``` file to your database
5. Create a directory ```config``` with ```config.xml``` inside
   ```xml
   config.xml ::
   <config>
      <url>jdbc:mysql://[SQL_HOST]/castlerock_lib?useSSL=false</url>
      <username>[SQL_USERNAME]</username>
      <password>[SQL_PASSWORD]</password>
   </config>
   ```
6. Click on the "Export jar.." button
7. After jar is created, update the jarfile to include the configuration database
   ```bash
    $ jar uf castleRock.jar ./config/config.xml
   ```
8. Done, you can execute jarfile using these command
   ```bash
     $ java -jar castleRock.jar
   ```

### INDONESIA
#### Cara Mem-build Project
1. Clone / Download repository ini
2. Gunakan Visual Studio Code agar lebih optimal
3. Pastikan sudah memasang [Java Projects extension](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
4. Anda membutuhkan database MySQL, dan ekspor file ```castlerock_lib.sql``` ke database anda
5. Buat direktori ```config``` dengan file ```config.xml``` di dalamnya
   ```xml
   config.xml ::
   <config>
      <url>jdbc:mysql://[ALAMAT_DB_SQL]/castlerock_lib?useSSL=false</url>
      <username>[SQL_USERNAME]</username>
      <password>[SQL_PASSWORD]</password>
   </config>
   ```
6. Klik tombol "Export jar.." di Visual Studio Code pada bagian bawah
7. Setelah jar selesai di export, update jarfile untuk menambahkan konfigurasi database
   ```bash
    $ jar uf castleRock.jar ./config/config.xml
   ```
8. Selesai, anda bisa menjalankan jarfile dengan menggunakan perintah ini
   ```bash
     $ java -jar castleRock.jar
   ```

### VERSION HISTORY
- v0.1-dev      -  Authentication, Read users data.    ✅
- v0.2-dev      -  Add new user, Delete user, Update user. (Finish the CRUD Models)    ✅
  - v0.2.1-dev    -  DB INSERT Done
  - v0.2.2-dev    -  DB DELETE Done
  - v0.2.3-dev    -  DB UPDATE Done  
- v0.3-dev      -  Get Userlist by parameter(Prodi, Role)    ✅
- v0.4-dev      -  User can Update password with last password for Verification    ✅
- v0.5-dev      -  Add duplicate username validation on AddUser function    ✅
- v0.6-dev      -  Create, and Read Book Data    ✅
- v0.7-dev      -  Update, and Delete Book Data  ✅
- v0.8-dev      -  CREATE AND READ INVENTORY  ✅
- v0.9-dev-rc   -  UPDATE AND DELETE INVENTORY  ✅

- v1.0-beta-rc  -  Add all menus and done the basic app, just improving!!!  ✅
- v1.1-beta     -  Fix Bugs and Add documentation & Code Comments  ✅

- v1.3-final    -  Done adding the Documentation  ✅

*this project will stall because there's no Maintainer,
<br>&nbsp;&nbsp;or maybe this project will be maintained idk :v


Any question? Feel free to contact the Project Manager ::: [encrypt0r](mailto:encrypt0r-x@protonmail.com)