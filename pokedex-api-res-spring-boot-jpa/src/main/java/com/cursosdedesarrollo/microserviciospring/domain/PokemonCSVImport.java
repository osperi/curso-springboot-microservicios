package com.cursosdedesarrollo.microserviciospring.domain;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PokemonCSVImport {

    public List<Pokemon> importCSV(String filePath){
        List<Pokemon> list = new LinkedList<>();
        String csvFile = filePath;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            InputStream is = new ClassPathResource(filePath).getInputStream();
            MappingIterator<Pokemon> readValues =
                    mapper.readerWithSchemaFor(Pokemon.class).with(bootstrapSchema).readValues(is);
            list=readValues.readAll();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PokemonCSVImport pi= new PokemonCSVImport();
        List<Pokemon> list=pi.importCSV("pokemon.csv");
        System.out.println(list);
    }
}
