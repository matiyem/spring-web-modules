package com.example.boot.converter;

import com.example.boot.domain.AbstractEntity;
import com.example.boot.domain.Bar;
import com.example.boot.domain.Foo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/*
    Create by Atiye Mousavi 
    Date: 4/16/2022
    Time: 2:43 PM
**/
public class StringToAbstractEntityConverterFactory implements ConverterFactory<String, AbstractEntity> {
    @Override
    public <T extends AbstractEntity> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToAbstractEntityConverter<>(targetType);
    }

    private static class StringToAbstractEntityConverter<T extends AbstractEntity> implements Converter<String, T> {
        private Class<T> targetClass;

        public StringToAbstractEntityConverter(Class<T> targetClass) {
            this.targetClass = targetClass;
        }

        @Override
        public T convert(String source) {
            long id = Long.parseLong(source);
            if (this.targetClass == Foo.class) {
                return (T) new Foo(id);
            } else if (this.targetClass == Bar.class) {
                return (T) new Bar(id);
            } else {
                return null;
            }
        }
    }
}
