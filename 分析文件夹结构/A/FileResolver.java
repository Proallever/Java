package A;

import java.io.File;

/*
 * 解析路径列表
 */
public class FileResolver {
	
	static int depth = 0;
	public void parseFile(File file){
		if(file.isFile()){
			printFile(file , depth);
			return;
		}else if(file.isDirectory()){
			printFile(file , depth);
			depth++;
			File[] files = file.listFiles();
			if(files == null ){
				return ;
			}
			for(File f : files){
				parseFile(f);
			}
			depth--;
		}else{
			throw new RuntimeException("该文件既不是普通文件也不是路径");
		}
	}
	
	public void printFile(File file , int depth){
		for(int i = 0 ;i < depth ; i++){
			System.out.print("   ");		
			System.out.print("|");
		}
		System.out.println(file.getName());
	}
	
	public static void main(String[] args) {
		File file = new File("D:/phpStudy/WWW/wuliu2/wuliu/public");
		new FileResolver().parseFile(file);
	}
}
