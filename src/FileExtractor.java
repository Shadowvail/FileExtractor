import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class FileExtractor {

	public static void main(String[] args) {
		
		File originDirectory = new File("C:/Users/sean.j.greene/Desktop/TestDirOne");
		File destDirectory = new File("C:/Users/sean.j.greene/Desktop/TestDirTwo");
		String[] extensions = {"txt"};
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
	}
}
