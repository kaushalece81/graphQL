package com.example.grapgqljpaexample.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;

import io.micrometer.core.instrument.util.IOUtils;

public class FileReaderUtil {
	public static String read(String location) throws IOException {
		return IOUtils.toString(new ClassPathResource(location)
				.getInputStream(),StandardCharsets.UTF_8
				);
	}
}
