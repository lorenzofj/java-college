USE [master]
GO
/****** Object:  Database [BibliotecaWeb]    Script Date: 03/12/2020 18:46:15 ******/
CREATE DATABASE [BibliotecaWeb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BibliotecaWeb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.FJLORENZO\MSSQL\DATA\BibliotecaWeb.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BibliotecaWeb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.FJLORENZO\MSSQL\DATA\BibliotecaWeb_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BibliotecaWeb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BibliotecaWeb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BibliotecaWeb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET ARITHABORT OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BibliotecaWeb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BibliotecaWeb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BibliotecaWeb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BibliotecaWeb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BibliotecaWeb] SET  MULTI_USER 
GO
ALTER DATABASE [BibliotecaWeb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BibliotecaWeb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BibliotecaWeb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BibliotecaWeb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [BibliotecaWeb] SET DELAYED_DURABILITY = DISABLED 
GO
USE [BibliotecaWeb]
GO
/****** Object:  Table [dbo].[Alumnos]    Script Date: 03/12/2020 18:46:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alumnos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombreCompleto] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Alumnos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Prestamos]    Script Date: 03/12/2020 18:46:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Prestamos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fechaPrestamo] [nvarchar](12) NOT NULL,
	[legajoAlumno] [int] NOT NULL,
	[tituloLibro] [varchar](50) NOT NULL,
	[tematicaLibro] [int] NOT NULL,
	[tipoLibro] [int] NOT NULL,
 CONSTRAINT [PK_Prestamos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Alumnos] ON 

INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (1, N'Francisco Lorenzo')
INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (2, N'Candelaria Ricchini')
INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (3, N'Matias Lorenzo')
INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (4, N'Lionel Messi')
INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (5, N'Kun Aguero')
INSERT [dbo].[Alumnos] ([id], [nombreCompleto]) VALUES (6, N'Bad Bunny')
SET IDENTITY_INSERT [dbo].[Alumnos] OFF
SET IDENTITY_INSERT [dbo].[Prestamos] ON 

INSERT [dbo].[Prestamos] ([id], [fechaPrestamo], [legajoAlumno], [tituloLibro], [tematicaLibro], [tipoLibro]) VALUES (1, N'03-12-2020', 1, N'Paradigmas de programacion', 2, 2)
SET IDENTITY_INSERT [dbo].[Prestamos] OFF
ALTER TABLE [dbo].[Prestamos]  WITH CHECK ADD  CONSTRAINT [FK_Prestamos_Alumnos] FOREIGN KEY([legajoAlumno])
REFERENCES [dbo].[Alumnos] ([id])
GO
ALTER TABLE [dbo].[Prestamos] CHECK CONSTRAINT [FK_Prestamos_Alumnos]
GO
USE [master]
GO
ALTER DATABASE [BibliotecaWeb] SET  READ_WRITE 
GO
