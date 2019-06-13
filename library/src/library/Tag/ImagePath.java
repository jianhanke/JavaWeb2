package library.Tag;

public class ImagePath {
	
	
	public static String doPath(String path) {
		String Alter_path=path.substring(path.lastIndexOf("/")+1);
		Alter_path="images/"+Alter_path;
		return Alter_path;
	}
}
