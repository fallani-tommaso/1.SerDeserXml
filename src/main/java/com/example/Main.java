package com.example;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        Alunno a1 = new Alunno("Claudio", "Benvenuti", new Date(1979,9,22));
        Alunno a2 = new Alunno("Isacco", "Pieri", new Date(2005,4,16));
        Alunno a3 = new Alunno("Davide", "Aiazzi", new Date(2005,5,6));
        Alunno a4 = new Alunno("Gabriele", "Lodde", new Date(2005,6,16));
        ArrayList<Alunno> alunni = new ArrayList<>();
        alunni.add(a1);
        alunni.add(a2);
        alunni.add(a3);
        alunni.add(a4);
        Classe c1 = new Classe(5, "BIA", "12TW", alunni);
        XmlMapper xmlMapper = new XmlMapper();
        
        xmlMapper.writeValue(new File("test.xml"), c1);


        Classe b = xmlMapper.readValue(new File("test.xml"), Classe.class);
        System.out.println(b.numero);
        System.out.println(b.sezione);
        System.out.println(b.aula);

    }
}