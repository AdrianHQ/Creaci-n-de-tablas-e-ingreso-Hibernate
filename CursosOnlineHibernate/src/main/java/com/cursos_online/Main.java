package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;
import java.util.List;
import javax.management.Query;




public class Main {
    
    static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
    static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	public static void main(String[] args) {


            Curso curs1 = new Curso("Fundamentos de java");
            Curso curs2 = new Curso("Hibernate para principiantes");
            
            IngresarCurso(curs1);
            IngresarCurso(curs2);
            
            Estudiante estu1 = new Estudiante(0,"Marco Antonio","Solis");
            Estudiante estu2 = new Estudiante(0,"Federica","Bolaños");
            
            IngresarEstudiante(estu1);
            IngresarEstudiante(estu2);
            
            List<Curso> cursos = getCurso();
            
            for(Curso temp:cursos){
                System.out.println("temp");
            }
            
            List<Estudiante> estudiante = getEstudiante();
            
            for(Estudiante temp:estudiante){
                System.out.println("temp");
            }
            
            List<Estudiante> estudiantes = getEstudiantePorNombre("Rosa");
             for(Estudiante temp:estudiante){
                System.out.println("temp");
            }
}
        
        static List<Estudiante>getEstudiantePorNombre(String nombre){
            Session session = sessionFactory.openSession();
            Query query = session
                  .createQuery(" from estudiante where nombre:nombre");
            query.setParameter("nombre", nombre);
            
            List<Estudiante> estudiante = (List<Estudiante>)query.getResultList();
            return estudiante;
 
}
        static List<Curso> getCurso(){
            Session session = sessionFactory.openSession(); 
            List<Curso> cursos = session.createQuery("from Curso", Curso.class).list();
            return cursos;
        }

        static List<Estudiante> getEstudiante(){
            Session session = sessionFactory.openSession();
            List<Estudiante> estudiantes  = session.createQuery("from Estudiante", Estudiante.class).list();
            return estudiantes;
        }

        

    static void IngresarCurso(Curso curso) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Curso curso = new Curso("Nuevo Curso");
        session.save(curso);
		
        session.getTransaction().commit();
        session.close();
}

    static void IngresarEstudiante (Estudiante estudiante){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Curso curso = new Curso("Nuevo Curso");
        session.save(estudiante);
		
        session.getTransaction().commit();
        session.close();
        
    }
    
     static void ModificarEstudiante(Estudiante estudiante){
        
//        Estudiante est = getEstudianteId(estudiante);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(estudiante);
        session.getTransaction().commit();
            
        }

     static void EliminarEstudiante (int id){
         
//         Estudiante est = getEstudiantePorId(id);
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.delete(id);
         session.getTransaction().commit();
     }
     
        static void ModificarCurso(Curso Curso){
        
//        Curso cur = getCursoId(curso);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(Curso);
        session.getTransaction().commit();
            
        }
        static void EliminarCurso(int id){
        
//        Curso cur = getCursoId(curso);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
            
        }

 
    

}




