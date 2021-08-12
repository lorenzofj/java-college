select * from Curso
select * from Descuento
select * from Alumno
select * from Programa
select * from Aula
select * from CursoAlumnos
select c.nombre 'Curso', a.nombre + ' ' + a.apellido 'Alumno'
from Curso c join CursoAlumnos ca on ca.curso = c.id
     join Alumno a on a.id = ca.alumno

--Consulta de verificacion. Listado de alumnos con sus descuentos (se repiten)
select c.nombre 'Curso', a.nombre + ' ' + a.apellido 'Alumno', porcentaje
from Alumno a join CursoAlumnos ca on a.id = ca.alumno
     join Curso c on c.id = ca.curso
	 join Descuento d on d.id = c.descuento

--Total facturado por cada curso
select c.nombre 'Curso', porcentaje, c.precio, count(ca.alumno)
from Curso c join CursoAlumnos ca on c.id = ca.curso
	join Descuento d on d.id = c.descuento
group by c.nombre, porcentaje, c.precio

--Sumatoria total de los descuentos realizados, a mitad con Java
select sum((d.porcentaje * c.precio)/100) 'Sumatoria total de los descuentos realizados'
from Curso c join Descuento d on d.id = c.descuento
where porcentaje <> 0

/*Listado de todos los alumnos que accedieron a algún descuento. Si un alumno tiene descuentos en más de un curso, 
sólo debe aparecer una única vez en el listado.*/
select distinct a.nombre + ' ' + a.apellido 'Alumno'
from Alumno a join CursoAlumnos ca on a.id = ca.alumno
     join Curso c on c.id = ca.curso
where descuento <> 1

--Listado de los 5 programas más descargados.
select top 5 p.nombre, a.nombre
from Programa p join Alumno a on a.id = p.alumno
where habilitado = 1
order by descargas desc

--Listado de todos los cursos con descuento
select ca.alumno, d.porcentaje, precio
from Curso c join Descuento d on c.descuento = d.id
     join CursoAlumnos ca on ca.curso = c.id
where c.descuento <> 1

--Listado de todos los programas habilitados
select p.nombre, tamaño, version, a.nombre, descargas
from Programa p join Alumno a on a.id = p.alumno
where habilitado = 1

--Listado de todos los programas deshabilitados
select p.nombre, tamaño, version, a.nombre
from Programa p join Alumno a on a.id = p.alumno
where habilitado = 0

-- Alumnos inscriptos en un curso seleccionado
select a.nombre, a.apellido
from CursoAlumnos ca join Alumno a on a.id = ca.alumno
where ca.curso=13
