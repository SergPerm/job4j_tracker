package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {
    private static final Logger LOG = LoggerFactory.getLogger(DirFileCache.class.getName());
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
        downloadToCache();
    }

    @Override
    protected String load(String key) {
        String rsl = null;
        try (BufferedReader read = new BufferedReader(new FileReader(key))) {
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            read.lines().forEach(stringJoiner::add);
            rsl = stringJoiner.toString();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }

    private void downloadToCache() {
        if (Path.of(cachingDir).toFile().isDirectory()) {
            try {
                Files.walkFileTree(Paths.get(cachingDir), new MyVisitor());
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        } else {
            DirFileCache.super.put(cachingDir, load(cachingDir));
        }
    }

    private class MyVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String fileName = file.toAbsolutePath().toString();
            if (fileName.endsWith(".txt")) {
                DirFileCache.super.put(fileName, load(fileName));
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
