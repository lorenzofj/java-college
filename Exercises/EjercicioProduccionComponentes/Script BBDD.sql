USE [master]
GO
/****** Object:  Database [Producciones_Lab4]    Script Date: 09/09/2020 18:11:26 ******/
CREATE DATABASE [Producciones_Lab4]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Producciones_Lab4', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Producciones_Lab4.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Producciones_Lab4_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Producciones_Lab4_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Producciones_Lab4] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Producciones_Lab4].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Producciones_Lab4] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET ARITHABORT OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Producciones_Lab4] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Producciones_Lab4] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Producciones_Lab4] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Producciones_Lab4] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Producciones_Lab4] SET  MULTI_USER 
GO
ALTER DATABASE [Producciones_Lab4] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Producciones_Lab4] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Producciones_Lab4] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Producciones_Lab4] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Producciones_Lab4] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Producciones_Lab4] SET QUERY_STORE = OFF
GO
USE [Producciones_Lab4]
GO
/****** Object:  Table [dbo].[Componente]    Script Date: 09/09/2020 18:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Componente](
	[id_componente] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Componente] PRIMARY KEY CLUSTERED 
(
	[id_componente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Produccion]    Script Date: 09/09/2020 18:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Produccion](
	[id_produccion] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [nvarchar](12) NOT NULL,
	[cantidad_produccion] [int] NOT NULL,
	[id_responsable] [int] NOT NULL,
	[id_componente] [int] NOT NULL,
 CONSTRAINT [PK_Produccion] PRIMARY KEY CLUSTERED 
(
	[id_produccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Responsable]    Script Date: 09/09/2020 18:11:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Responsable](
	[id_responsable] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Responsable] PRIMARY KEY CLUSTERED 
(
	[id_responsable] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Produccion]  WITH CHECK ADD  CONSTRAINT [FK_Produccion_Componente] FOREIGN KEY([id_componente])
REFERENCES [dbo].[Componente] ([id_componente])
GO
ALTER TABLE [dbo].[Produccion] CHECK CONSTRAINT [FK_Produccion_Componente]
GO
ALTER TABLE [dbo].[Produccion]  WITH CHECK ADD  CONSTRAINT [FK_Produccion_Responsable] FOREIGN KEY([id_responsable])
REFERENCES [dbo].[Responsable] ([id_responsable])
GO
ALTER TABLE [dbo].[Produccion] CHECK CONSTRAINT [FK_Produccion_Responsable]
GO
USE [master]
GO
ALTER DATABASE [Producciones_Lab4] SET  READ_WRITE 
GO
