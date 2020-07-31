package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;




public class Main {
    
    static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
    static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	public static void main(String[] args) {
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.configure() // configures settings from hibernate.cfg.xml
//				.build();
//		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

            Curso curs1 = new Curso("Fundamentos de java");
            Curso curs2 = new Curso("Hibernate para principiantes");
            
            IngresarCurso(curs1);
            IngresarCurso(curs2);
            
            Estudiante estu1 = new Estudiante(0,"Marco Antonio","Solis");
            Estudiante estu2 = new Estudiante(0,"Federica","Bolaños");
            
            IngresarEstudiante(estu1);
            IngresarEstudiante(estu2);
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

}

