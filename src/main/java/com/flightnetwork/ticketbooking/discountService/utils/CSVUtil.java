package com.flightnetwork.ticketbooking.discountService.utils;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.InputStream;

public class CSVUtil {

  public static <T> Iterable<T> loadObjectList(Class<T> clazz, InputStream stream) {
    try {
      CsvMapper mapper = new CsvMapper();
      CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);
      ObjectReader reader = mapper.readerFor(clazz).with(schema);
      return reader.<T>readValues(stream).readAll();
    } catch (Exception e) {
      throw new RuntimeException("Error occurred while loading object list from csv file ", e);
    }
  }
}
