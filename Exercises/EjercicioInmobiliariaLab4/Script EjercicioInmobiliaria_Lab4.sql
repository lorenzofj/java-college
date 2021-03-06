USE [master]
GO
/****** Object:  Database [Inmobiliaria_Lab4]    Script Date: 07/09/2020 18:07:12 ******/
CREATE DATABASE [Inmobiliaria_Lab4]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Inmobiliaria_Lab4', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Inmobiliaria_Lab4.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Inmobiliaria_Lab4_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\Inmobiliaria_Lab4_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Inmobiliaria_Lab4].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ARITHABORT OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET  MULTI_USER 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET QUERY_STORE = OFF
GO
USE [Inmobiliaria_Lab4]
GO
/****** Object:  Table [dbo].[Inmuebles]    Script Date: 07/09/2020 18:07:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Inmuebles](
	[id_inmueble] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Inmuebles] PRIMARY KEY CLUSTERED 
(
	[id_inmueble] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Operaciones]    Script Date: 07/09/2020 18:07:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Operaciones](
	[id_operacion] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Operaciones] PRIMARY KEY CLUSTERED 
(
	[id_operacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transacciones]    Script Date: 07/09/2020 18:07:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transacciones](
	[id_transaccion] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [varchar](12) NOT NULL,
	[id_vendedor] [int] NOT NULL,
	[tipo_operacion] [int] NOT NULL,
	[tipo_inmueble] [int] NOT NULL,
	[monto] [real] NOT NULL,
 CONSTRAINT [PK_Transacciones] PRIMARY KEY CLUSTERED 
(
	[id_transaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vendedores]    Script Date: 07/09/2020 18:07:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendedores](
	[id_vendedor] [int] IDENTITY(1,1) NOT NULL,
	[nombre_completo] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Vendedores] PRIMARY KEY CLUSTERED 
(
	[id_vendedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Transacciones]  WITH CHECK ADD  CONSTRAINT [FK_Transacciones_Inmuebles] FOREIGN KEY([tipo_inmueble])
REFERENCES [dbo].[Inmuebles] ([id_inmueble])
GO
ALTER TABLE [dbo].[Transacciones] CHECK CONSTRAINT [FK_Transacciones_Inmuebles]
GO
ALTER TABLE [dbo].[Transacciones]  WITH CHECK ADD  CONSTRAINT [FK_Transacciones_Operaciones] FOREIGN KEY([tipo_operacion])
REFERENCES [dbo].[Operaciones] ([id_operacion])
GO
ALTER TABLE [dbo].[Transacciones] CHECK CONSTRAINT [FK_Transacciones_Operaciones]
GO
ALTER TABLE [dbo].[Transacciones]  WITH CHECK ADD  CONSTRAINT [FK_Transacciones_Vendedores] FOREIGN KEY([id_vendedor])
REFERENCES [dbo].[Vendedores] ([id_vendedor])
GO
ALTER TABLE [dbo].[Transacciones] CHECK CONSTRAINT [FK_Transacciones_Vendedores]
GO
USE [master]
GO
ALTER DATABASE [Inmobiliaria_Lab4] SET  READ_WRITE 
GO
