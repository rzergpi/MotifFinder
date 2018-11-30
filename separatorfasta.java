import java.io.*;
import java.util.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
public class separatorfasta{
	String outs;
	String cline;
	FileWriter salen;
	BufferedReader buffR;
	FileReader entra;
	public separatorfasta(String w){
		this.relleno(w);
	}
	public void relleno(String a){
		try{
			this.entra=new FileReader(a);
			this.buffR=new BufferedReader(entra);
			while ((cline=this.buffR.readLine())!=null){
				if(cline.indexOf(">")>=0){
					this.salen=new FileWriter(cline.substring(1).trim()+".fasta");
					this.salen.write(cline);
				}else{
					this.salen.write("\n"+cline);
					this.salen.close();
				}
			}
			if (buffR != null){
				this.buffR.close();
			}
			if (entra != null){
				this.entra.close();
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
			separatorfasta sup=new separatorfasta(args[i]);
		}
	}
}
