package it.fabrick.bip.wwsbipbackend.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

public class ConversionServiceHelper {

	private static ConversionService conversionService;

	public static <T> T convert(Object source, Class<T> targetType) {
		return conversionService.convert(source, targetType);
	}

	public static <T> T convert(Optional<?> source, Class<T> targetType) {
		return conversionService.convert(source.orElseThrow(NoSuchElementException::new), targetType);
	}

	public static <T> List<T> convert(List<?> sourceList, Class<T> targetClass) {
		List<T> targetList = new ArrayList<>();
		for (Object o : sourceList) {
			targetList.add(conversionService.convert(o, targetClass));
		}
		return targetList;
	}

	public static <T> Set<T> convert(Set<?> sourceList, Class<T> targetClass) {
		Set<T> targetList = new HashSet<>();
		for (Object o : sourceList) {
			targetList.add(conversionService.convert(o, targetClass));
		}
		return targetList;
	}

	@Autowired
	private void setConversionService(ConversionService conversionService) {
		ConversionServiceHelper.conversionService = conversionService;
	}

}
