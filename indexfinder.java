import java.io.*;
import java.util.*;
//import javax.swing.*;

//este programa toma el output del archivo seq2loc.fasta que contiene los motifs en minuscula separados por #. Indica la localizacion en la proteina y el motif.
//ademas del genbank number
public class indexfinder{
	String outs;
	String cline;
	int index1;
	String [] s;
	public indexfinder(String w){
		this.gitit(w);
	}
	public void gitit(String a){
		try{
			FileReader entra=new FileReader(a);
			BufferedReader buffR=new BufferedReader(entra);
			FileWriter sale=new FileWriter(a+".out");
			while ((this.cline=buffR.readLine())!=null){
				if(this.cline.indexOf(">")>=0){
					sale.write("\n"+this.cline+"\n");//
				}else{
					if((this.cline.indexOf("#")<0)&&(this.cline.length()>0)){
						sale.write("motif not found:"+this.cline);
					}else{
						this.s=this.cline.split("#"); //assuming the # is not in the beggining
						this.cline=null;
						int [] len=new int [this.s.length];
						for(int i=0; i<this.s.length; i++){
							len[i]=this.s[i].length();
						}
						for (int j=1; j<this.s.length; j+=2){
							this.index1=1;//no hay posicion 0
							for(int p=0; p<j; p++){
								index1+=len[p];
							}
							sale.write("Index= "+index1+"\nMotif:"+this.s[j]+"\n");
						}
					}
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
			indexfinder sup=new indexfinder(args[i]);
		}
	}
}
