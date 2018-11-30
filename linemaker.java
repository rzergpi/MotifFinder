import java.io.*;
import java.util.*;
//import javax.swing.*;

//este programa toma el output del archivo seq2loc.fasta que contiene los motifs en minuscula separados por #. Indica la localizacion en la proteina y el motif.
//ademas del genbank number
public class linemaker{
	String outs;
	String cline;
	int index1;
	String [] s;
	public linemaker(String w){
		this.nojump(w);
	}
	public void nojump(String a){
		try{
			FileReader entra=new FileReader(a);
			BufferedReader buffR=new BufferedReader(entra);
			FileWriter sale=new FileWriter(a+".out");
			this.cline=buffR.readLine();
			sale.write((this.cline.indexOf(">")>=0? this.cline+"\n":this.cline));
			while ((this.cline=buffR.readLine())!=null){
				sale.write((this.cline.indexOf(">")>=0? "\n"+this.cline+"\n":this.cline));//
			}
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
//		System.out.println("Please state the file:");
//		Scanner ska=new Scanner(System.in);
//		String filo= ska.next();//new File(); File[] listOfFiles = folder.listFiles();
if(args.length==0){
	System.out.println("No argument defined! The Program will close.");
	System.exit(0);
}
		for(int i=0;i<args.length;i++){
			linemaker sup=new linemaker(args[i]);
		}
	}
}
