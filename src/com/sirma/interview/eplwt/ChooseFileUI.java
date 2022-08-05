package com.sirma.interview.eplwt;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class ChooseFileUI {
    private static final String DEFAULT_PATH = "./resources/employees.csv";
    private static final String DIALOG_TITLE = "Choose a csv file to load data: ";
    private static final String CSV_FILE = "csv";
    private static final String CSV_FILE_TITLE = "CSV files";

    private static final String APPROVE_BUTTON_NAME = "Choose";

    /**
     * Returns a filepath String, chosen from the user, if no choice has made, the default filepath is returned.
     *
     * @return filepath
     **/
    public static String chooseFile () {
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        chooser.setDialogTitle(DIALOG_TITLE);

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        FileFilter csvFilter = new FileNameExtensionFilter(CSV_FILE_TITLE, CSV_FILE);
        chooser.setFileFilter(csvFilter);

        chooser.setMultiSelectionEnabled(false);

        if (chooser.showDialog(null,APPROVE_BUTTON_NAME) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        else {
            return DEFAULT_PATH;
        }
    }
}
