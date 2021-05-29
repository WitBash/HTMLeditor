package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        return file.isDirectory() || name.toLowerCase(Locale.ROOT).trim().endsWith(".html") || name.toLowerCase(Locale.ROOT).trim().endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
