package it.fabrick.bip.wwsbipbackend.converter;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;

public class ConvertionServiceAutoConfiguration {

    @Bean(name = "conversionService")
    public ConversionService getConversionService(ObjectProvider<Set<? extends Converter>> converters) {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        if (converters.getIfAvailable() != null) {
            bean.setConverters(converters.getIfAvailable());
        }
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean
    private ConversionServiceHelper convertionServiceHelper(ConversionService conversionService) {
        return new ConversionServiceHelper();
    }
}


