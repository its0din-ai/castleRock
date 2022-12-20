-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: t0rSQL
-- Generation Time: Dec 20, 2022 at 03:28 AM
-- Server version: 8.0.12
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `castlerock_lib`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id_inventory` int(11) NOT NULL,
  `tanggal_pinjam` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_user` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id_inventory`, `tanggal_pinjam`, `id_user`, `id_buku`) VALUES
(5, '2022-12-19 23:53:31', 0, 17),
(7, '2022-12-19 23:57:54', 0, 18);

-- --------------------------------------------------------

--
-- Table structure for table `katalog`
--

CREATE TABLE `katalog` (
  `id` tinyint(4) NOT NULL,
  `kategori` varchar(255) NOT NULL,
  `judul_buku` varchar(255) NOT NULL,
  `bahasa` varchar(128) NOT NULL,
  `nama_pengarang` varchar(128) NOT NULL,
  `tahun_terbit` int(11) NOT NULL,
  `max_buku` int(11) NOT NULL,
  `dipinjam` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `katalog`
--

INSERT INTO `katalog` (`id`, `kategori`, `judul_buku`, `bahasa`, `nama_pengarang`, `tahun_terbit`, `max_buku`, `dipinjam`) VALUES
(17, 'Non Fiksi', 'Learning Java : an Introduction to Real World programming with Java', 'Inggris', 'Marc Loy, Patrick Niemeyer, and Daniel Leuck', 2020, 15, 0),
(18, 'Non Fiksi', 'Ruby on Rails', 'Inggris', 'Matsumoto', 2012, 5, 0),
(21, 'Komik', 'Black Clover 20', 'Indonesia', 'Yuki Tabata', 2022, 13, 0),
(22, 'Novel', 'Home Sweet Loan', 'Indonesia', 'Almira Bastari', 2022, 15, 0),
(23, 'Self Improvement', 'Rich Dad\'s - Increase Your Financial IQ', 'Indonesia', 'Robert T. Kiyosaki', 2016, 20, 0),
(24, 'Self Improvement', 'Atomic Habits: Perubahan Kecil yang Memberikan Hasil Luar Biasa', 'Indonesia', 'James Clear', 2019, 22, 0),
(25, 'Self Improvement', 'You Do You: Discovering Life through Experiments & Self-Awareness', 'Indonesia', 'Fellexandro Ruby', 2020, 25, 0),
(26, 'Komik', 'Moriarty the Patriot 13', 'Indonesia', 'Miyoshi Hikaru', 2022, 26, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` tinyint(4) NOT NULL,
  `tanggal_dibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` varchar(34) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `progdi` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `tanggal_dibuat`, `username`, `password`, `nama_lengkap`, `progdi`, `role`) VALUES
(0, '2022-11-10 14:56:13', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrator', '', 'admin'),
(34, '2022-12-20 01:34:51', 'staff', '1253208465b1efa876f982d8a9e73eef', 'Staff 002', '', 'staff'),
(35, '2022-12-20 01:35:12', 'user', 'ee11cbb19052e40b07aac0ca060c23ee', 'User 001', 'Teknik Informatika', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id_inventory`),
  ADD KEY `id_inventory` (`id_inventory`);

--
-- Indexes for table `katalog`
--
ALTER TABLE `katalog`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id_inventory` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `katalog`
--
ALTER TABLE `katalog`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
