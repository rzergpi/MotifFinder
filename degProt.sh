asdf1=$2
echo $asdf1
fasgrep -is $asdf1 $1>${1}.seq.fasta
javac ~/mine2/java/linemaker.java
java -classpath ~/mine2/java/ linemaker ${1}.seq.fasta
sed "s/$asdf1/#\L&#/g" ${1}.seq.fasta.out>${1}.seq.loc.fasta
java -classpath ~/mine2/java/ linemaker ${1}.seq.loc.fasta
awk -F"#" '/[a-z]+/||/^>/ {
  if(/^>/){print $0}
  else{
    sum=sum+1
    for (i=1;i<=NF;i+=2){$i=""}
    print $0
  }
}END{print sum}' ${1}.seq.loc.fasta.out>${1}.res.txt #elimina lo que no es parte del motif, lo pone debajo del nombre de cada sequencia
javac ~/mine/java/indexfinder.java
java -classpath ~/mine/java/ indexfinder ${1}.seq.loc.fasta
asdf=`echo $2 | tr '[:upper:]' '[:lower:]'`
grep -o "$asdf" ${1}.res.txt | awk '{a[$1]+=1} END {for (b in a) {print b, a[b]}; for(c in a) {sup+=a[c]; sup2+=1}; {print "total:", sup, sup2} }'>${1}.motifHist.txt
grep -o ">" ${1}.res.txt | wc -l >> ${1}.motifHist.txt
grep -o ">" ${1} | wc -l >> ${1}.motifHist.txt
