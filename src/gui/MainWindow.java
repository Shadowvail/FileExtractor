package gui;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;

public class MainWindow extends JPanel{
	
	// construct the window
	public MainWindow(){
		
		//TODO Instantiate the Main GUI Panel
		
		findDriveNames();
	}
	
	private static void findDriveNames(){
		
		File originDirectory = new File("C:/Users/sean.j.greene/Desktop/TestDirOne");
		File destDirectory = new File("C:/Users/sean.j.greene/Desktop/TestDirTwo");
		String[] extensions = {"jpg"};
		Collection<File> directoryContents = FileUtils.listFiles(originDirectory, extensions, true);
		
		Iterator<File> iterator= directoryContents.iterator();
		while(iterator.hasNext()) {
			try {
				FileUtils.copyFileToDirectory(iterator.next(), destDirectory);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		System.exit(0);
		
		
		
		List<File> files = Arrays.asList(File.listRoots());
		
		for(File f : files) {
			System.out.println("The drive name is "+FileSystemView.getFileSystemView().getSystemDisplayName(f));
			System.out.println("The drive description is "+FileSystemView.getFileSystemView().getSystemTypeDescription(f));
		}
	}
}
