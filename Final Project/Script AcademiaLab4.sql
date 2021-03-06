USE [master]
GO
/****** Object:  Database [AcademiaLab4]    Script Date: 06/11/2020 16:41:59 ******/
CREATE DATABASE [AcademiaLab4]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AcademiaLab4', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.FJLORENZO\MSSQL\DATA\AcademiaLab4.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'AcademiaLab4_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.FJLORENZO\MSSQL\DATA\AcademiaLab4_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [AcademiaLab4] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AcademiaLab4].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AcademiaLab4] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AcademiaLab4] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AcademiaLab4] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AcademiaLab4] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AcademiaLab4] SET ARITHABORT OFF 
GO
ALTER DATABASE [AcademiaLab4] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AcademiaLab4] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AcademiaLab4] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AcademiaLab4] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AcademiaLab4] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AcademiaLab4] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AcademiaLab4] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AcademiaLab4] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AcademiaLab4] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AcademiaLab4] SET  DISABLE_BROKER 
GO
ALTER DATABASE [AcademiaLab4] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AcademiaLab4] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AcademiaLab4] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AcademiaLab4] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AcademiaLab4] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AcademiaLab4] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AcademiaLab4] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AcademiaLab4] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AcademiaLab4] SET  MULTI_USER 
GO
ALTER DATABASE [AcademiaLab4] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AcademiaLab4] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AcademiaLab4] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AcademiaLab4] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [AcademiaLab4] SET DELAYED_DURABILITY = DISABLED 
GO
USE [AcademiaLab4]
GO
/****** Object:  Table [dbo].[Alumno]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alumno](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[apellido] [nvarchar](50) NOT NULL,
	[direccion] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Alumno] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Aula]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aula](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Aula] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Curso]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Curso](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[aula] [int] NOT NULL,
	[descuento] [int] NOT NULL,
	[precio] [money] NOT NULL,
 CONSTRAINT [PK_Curso] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CursoAlumnos]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CursoAlumnos](
	[idCursoAlumno] [int] IDENTITY(1,1) NOT NULL,
	[alumno] [int] NULL,
	[curso] [int] NULL,
 CONSTRAINT [PK_CursoAlumnos] PRIMARY KEY CLUSTERED 
(
	[idCursoAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Descuento]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Descuento](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[porcentaje] [int] NOT NULL,
 CONSTRAINT [PK_Descuento] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Programa]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Programa](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[tamaño] [nvarchar](10) NOT NULL,
	[version] [nvarchar](15) NOT NULL,
	[descargas] [int] NULL,
	[habilitado] [bit] NOT NULL,
	[alumno] [int] NOT NULL,
	[ruta_descarga] [nvarchar](300) NULL,
 CONSTRAINT [PK_Programa] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 06/11/2020 16:41:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[nombre] [nvarchar](50) NOT NULL,
	[contraseña] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Alumno] ON 

INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (30, N'Juan', N'Perez', N'Av. Colon 1234')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (31, N'Francisco', N'Lorenzo', N'Esteban Piacenza 6789')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (32, N'Lionel', N'Messi', N'Recta Martinoli 4769')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (33, N'Bill', N'Gates', N'Saint Avenue 1334')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (34, N'Candelaria', N'Gonzalez', N'Santa Fe 4708')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (35, N'Matias', N'Alday', N'Guillermo Furlong 145')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (36, N'Sergio', N'Aguero', N'Roberto Cayol 567')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (37, N'Roberto', N'Lopez', N'Gay Lussac 7865')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (38, N'Ornella', N'Berta', N'Tristan Malbran 5925')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (39, N'Ramiro', N'Alvarez', N'Florencia Noche 576')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (40, N'Jorge', N'Rodriguez', N'Av. Siempre viva 123')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (41, N'Ines', N'Lopez', N'Av. Spilimbergo 345')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (42, N'Franco', N'Aberturas', N'Manuel Cardeñosa 4876')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (43, N'Jose', N'Roque Funes', N'Menendez Pidal 4825')
INSERT [dbo].[Alumno] ([id], [nombre], [apellido], [direccion]) VALUES (44, N'Gregorio', N'Carreras', N'La Cordillera 456')
SET IDENTITY_INSERT [dbo].[Alumno] OFF
SET IDENTITY_INSERT [dbo].[Aula] ON 

INSERT [dbo].[Aula] ([id], [nombre]) VALUES (1, N'1A')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (2, N'1B')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (3, N'1C')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (4, N'2A')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (5, N'2B')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (6, N'2C')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (7, N'2D')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (8, N'3A')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (9, N'3B')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (10, N'3C')
INSERT [dbo].[Aula] ([id], [nombre]) VALUES (11, N'3D')
SET IDENTITY_INSERT [dbo].[Aula] OFF
SET IDENTITY_INSERT [dbo].[Curso] ON 

INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (7, N'FrontEnd HTML-CSS-JS', 1, 3, 4500.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (8, N'BackEnd ASP.NET', 2, 6, 5800.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (9, N'React Native', 3, 1, 3000.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (10, N'BackEnd Django', 4, 3, 7300.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (11, N'DevOps Amazon ', 5, 1, 2700.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (12, N'SQL Server', 6, 4, 9200.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (13, N'Data Science', 7, 2, 5700.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (14, N'Google Cloud Platform', 8, 4, 12000.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (15, N'Android', 9, 3, 5899.0000)
INSERT [dbo].[Curso] ([id], [nombre], [aula], [descuento], [precio]) VALUES (16, N'Unity', 10, 1, 2000.0000)
SET IDENTITY_INSERT [dbo].[Curso] OFF
SET IDENTITY_INSERT [dbo].[CursoAlumnos] ON 

INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (19, 30, 7)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (20, 31, 8)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (21, 32, 9)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (22, 33, 10)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (23, 34, 11)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (24, 35, 12)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (25, 36, 13)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (26, 37, 16)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (27, 37, 14)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (28, 39, 8)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (29, 40, 13)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (30, 41, 9)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (31, 42, 16)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (32, 43, 10)
INSERT [dbo].[CursoAlumnos] ([idCursoAlumno], [alumno], [curso]) VALUES (33, 44, 12)
SET IDENTITY_INSERT [dbo].[CursoAlumnos] OFF
SET IDENTITY_INSERT [dbo].[Descuento] ON 

INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (1, 0)
INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (2, 10)
INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (3, 15)
INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (4, 20)
INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (5, 25)
INSERT [dbo].[Descuento] ([id], [porcentaje]) VALUES (6, 35)
SET IDENTITY_INSERT [dbo].[Descuento] OFF
SET IDENTITY_INSERT [dbo].[Programa] ON 

INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (9, N'Netflix', N'3GB', N'2.3', 8, 1, 31, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (10, N'Instagram', N'562MB', N'3.1.4', 6, 1, 30, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (11, N'Microsoft', N'10GB', N'10.5', 1, 0, 33, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (12, N'Facebook', N'253MB', N'7.2.54', 1, 0, 32, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (13, N'Twitter', N'354MB', N'1.2', 1, 0, 34, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (14, N'Among Us', N'3KB', N'1.4', 1, 0, 35, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (15, N'Spotify', N'1.2GB', N'5.8.67', 1, 0, 36, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (16, N'Discord', N'2.54GB', N'4.54', 1, 0, 37, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (17, N'SQL Server', N'15.65GB', N'5.6.4.3', 1, 0, 38, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (18, N'Google Chrome', N'2.67GB', N'4.3', 1, 0, 39, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (19, N'NetBeans', N'54GB', N'19.2', 1, 0, 40, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (20, N'WhatsApp', N'765MB', N'3.4.6', 4, 1, 44, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (21, N'Discord', N'5MB', N'1.2', 7, 1, 41, N'\AcademiaProgramacion\web\ProgramasDeAlumnos')
INSERT [dbo].[Programa] ([id], [nombre], [tamaño], [version], [descargas], [habilitado], [alumno], [ruta_descarga]) VALUES (26, N'Mozilla Firefox', N'40MB', N'2.1', 2, 1, 30, NULL)
SET IDENTITY_INSERT [dbo].[Programa] OFF
INSERT [dbo].[Usuario] ([nombre], [contraseña]) VALUES (N'a', N'a')
INSERT [dbo].[Usuario] ([nombre], [contraseña]) VALUES (N'admin', N'admin')
INSERT [dbo].[Usuario] ([nombre], [contraseña]) VALUES (N'profesor', N'123456')
INSERT [dbo].[Usuario] ([nombre], [contraseña]) VALUES (N'francisco', N'fran1997')
INSERT [dbo].[Usuario] ([nombre], [contraseña]) VALUES (N'messi', N'messi')
ALTER TABLE [dbo].[Curso]  WITH CHECK ADD  CONSTRAINT [FK_Curso_Aula] FOREIGN KEY([aula])
REFERENCES [dbo].[Aula] ([id])
GO
ALTER TABLE [dbo].[Curso] CHECK CONSTRAINT [FK_Curso_Aula]
GO
ALTER TABLE [dbo].[Curso]  WITH CHECK ADD  CONSTRAINT [FK_Curso_Descuento] FOREIGN KEY([descuento])
REFERENCES [dbo].[Descuento] ([id])
GO
ALTER TABLE [dbo].[Curso] CHECK CONSTRAINT [FK_Curso_Descuento]
GO
ALTER TABLE [dbo].[CursoAlumnos]  WITH CHECK ADD  CONSTRAINT [FK_CursoAlumnos_Alumno] FOREIGN KEY([alumno])
REFERENCES [dbo].[Alumno] ([id])
GO
ALTER TABLE [dbo].[CursoAlumnos] CHECK CONSTRAINT [FK_CursoAlumnos_Alumno]
GO
ALTER TABLE [dbo].[CursoAlumnos]  WITH CHECK ADD  CONSTRAINT [FK_CursoAlumnos_Curso] FOREIGN KEY([curso])
REFERENCES [dbo].[Curso] ([id])
GO
ALTER TABLE [dbo].[CursoAlumnos] CHECK CONSTRAINT [FK_CursoAlumnos_Curso]
GO
ALTER TABLE [dbo].[Programa]  WITH CHECK ADD  CONSTRAINT [FK_Programa_Alumno] FOREIGN KEY([alumno])
REFERENCES [dbo].[Alumno] ([id])
GO
ALTER TABLE [dbo].[Programa] CHECK CONSTRAINT [FK_Programa_Alumno]
GO
USE [master]
GO
ALTER DATABASE [AcademiaLab4] SET  READ_WRITE 
GO
