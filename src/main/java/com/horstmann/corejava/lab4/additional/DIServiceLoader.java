package com.horstmann.corejava.lab4.additional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.ServiceLoader;

public class DIServiceLoader<T> implements Iterable<T>{
    private final Class<T> serviceType;
    private final Map<String, T> beans;

    private DIServiceLoader(Class<T> serviceType) {
        this.serviceType = serviceType;
        this.beans = loadBeans();
    }

    public static <T> DIServiceLoader<T> load(Class<T> serviceType) {
        return new DIServiceLoader<>(serviceType);
    }

    private Map<String, T> loadBeans() {
        Map<String, T> beans = new WeakHashMap<>();

        try {
            String resourceName = "META-INF/services/" + serviceType.getName();
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(resourceName);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                List<String> lines = readLines(resource);

                for (String line : lines) {
                    String[] parts = line.split("#");
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Invalid bean configuration: " + line);
                    }

                    String className = parts[0].trim();
                    String beanName = parts[1].trim();

                    if (beans.containsKey(beanName)) {
                        throw new IllegalArgumentException("Duplicate bean name found: " + beanName);
                    }

                    Class<?> clazz = Class.forName(className);
                    T bean = serviceType.cast(clazz.getDeclaredConstructor().newInstance());
                    beans.put(beanName, bean);
                }
            }
        } catch (IOException | ReflectiveOperationException e) {
            throw new RuntimeException("Failed to load beans for " + serviceType.getName(), e);
        }

        return beans;
    }

    private List<String> readLines(URL resource) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.openStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    public T getBean(String beanName) {
        return beans.get(beanName);
    }

    public T getBean(Class<?> beanClass) {

        ServiceLoader<T> loader = ServiceLoader.load(serviceType);
        for (T bean : loader) {
            if(bean.getClass() == beanClass)
                return bean;
        }

//        for (T bean : beans.values()) {
//            if (bean.getClass() == beanClass) {
//                return bean;
//            }
//        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        ServiceLoader<T> loader = ServiceLoader.load(serviceType);
        return loader.iterator();

        //return beans.values().iterator();
    }
}