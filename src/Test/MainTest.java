package Test;

import Dom.DomUpdateXml;

public class MainTest {

	public static void main(String[] args) {
		update();
	}
    public static void update(){  
    	DomUpdateXml mDomUpdateXml = new DomUpdateXml();  
          
        System.out.println("\n\n尝试修改节点内容中。。。");  
        mDomUpdateXml.update();  
        System.out.println("修改节点内容成功。。。");  
 }  


}
