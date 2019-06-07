package stepdefs;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import dataobjects.*;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.*;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(TradesDfStock.class, new TableEntryTransformer<TradesDfStock>() {
            @Override
            public TradesDfStock transform(Map<String, String> entry) {
                return TradesDfStock.createDfStockTrade(entry);
            }
        }));

        registry.defineDataTableType(new DataTableType(TradesSmStock.class, new TableEntryTransformer<TradesSmStock>() {
            @Override
            public TradesSmStock transform(Map<String, String> entry) {
                return TradesSmStock.createSmStockTrade(entry);
            }
        }));


        //Jackson Table Transformer implementation (can be used in Cucumber instead of
        //TableEntryTransformer and TableCellTransformer

/*      JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
        registry.setDefaultParameterTransformer(jacksonTableTransformer);
        registry.setDefaultDataTableEntryTransformer(jacksonTableTransformer);
        registry.setDefaultDataTableCellTransformer(jacksonTableTransformer);*/

    }


    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }


       //Jackson Table Transformer implementation (can be used in Cucumber instead of
       //TableEntryTransformer and TableCellTransformer


    /*private static final class JacksonTableTransformer implements ParameterByTypeTransformer,
            TableEntryByTypeTransformer, TableCellByTypeTransformer {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Object transform(String s, Type type) {
            return objectMapper.convertValue(s, objectMapper.constructType(type));
        }

        @Override
        public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
            return objectMapper.convertValue(entry, type);
        }

        @Override
        public <T> T transform(String value, Class<T> cellType) {
            return objectMapper.convertValue(value, cellType);
        }
    }*/


}

