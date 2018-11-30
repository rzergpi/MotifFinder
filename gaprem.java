import java.io.*;
import java.util.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
public class gaprem{
	String outs;
	String cline;
	public gaprem(String w){
		this.removin(w);
	}
	public double countgaps(String secu){
		return((secu.length() - secu.replace(".", "").length())/secu.length());
	}
	public void removin(String a){
		String pivv="";
		try{
			FileReader entra=new FileReader(a);
			BufferedReader buffR=new BufferedReader(entra);
			FileWriter sale=new FileWriter(a+".out");
			while ((cline=buffR.readLine())!=null){
				if (cline.indexOf(">")==1){
					pivv=cline;
				}else{
					if((this.countgaps(cline)<0.3)&&(pivv!="")){
						sale.write(pivv+"\n"+cline);
						pivv="";
					}
				}
				//System.out.println(cline+"hello ql");
			}
			if (buffR != null){
				buffR.close();
			}
			if (entra != null){
				entra.close();
			}
			if (sale!=null){
				sale.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		if(args.length==0){
			System.out.println("No argument defined! The Program will close.");
			System.exit(0);
		}
		for(int i=0;i<args.length;i++){
			gaprem sup=new gaprem(args[i]);
		}
	}
}
