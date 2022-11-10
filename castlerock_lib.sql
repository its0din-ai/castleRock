-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 10, 2022 at 04:46 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

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
-- Table structure for table `katalog`
--

CREATE TABLE `katalog` (
  `id` int NOT NULL,
  `judul_buku` varchar(255) NOT NULL,
  `nama_pengarang` varchar(128) NOT NULL,
  `tahun_terbit` int NOT NULL,
  `jumlah_buku` int NOT NULL,
  `dipinjam` int NOT NULL,
  `ketersediaan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `katalog`
--

INSERT INTO `katalog` (`id`, `judul_buku`, `nama_pengarang`, `tahun_terbit`, `jumlah_buku`, `dipinjam`, `ketersediaan`) VALUES
(1, 'House of The Dragon', 'George R.R Martin', 2022, 10, 3, 10),
(2, 'Game of Thrones', 'George R.R. Martin', 2012, 5, 2, 5),
(3, 'Learning Java : an Introduction to Real World programming with Java', 'Marc Loy, Patrick Niemeyer, and Daniel Leuck', 2020, 15, 7, 15);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `tanggal_dibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` text NOT NULL,
  `progdi` varchar(64) NOT NULL,
  `role` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `tanggal_dibuat`, `username`, `password`, `nama_lengkap`, `progdi`, `role`) VALUES
(1, '2022-11-10 14:56:13', 'admin', '200ceb26807d6bf99fd6f4f0d1ca54d4', 'Administrator', '', 'admin'),
(2, '2022-11-10 14:57:45', 'staff001', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'Staff Abal-abal', '', 'staff'),
(3, '2022-11-10 14:57:45', 'mahasiswa001', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'Mahasiswa Kupu-kupu', 'Teknik Informatika', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `katalog`
--
ALTER TABLE `katalog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `katalog`
--
ALTER TABLE `katalog`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
