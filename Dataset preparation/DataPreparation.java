package dataset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.yspsys.tools.jdbc.DaoUtils;


public class DataPreparation {
	
	
	
public static int getRandomInt(int max){
	Random rand = new Random();
	return rand.nextInt(max) ;

}	

public static void generateDataset() throws Exception{
	String tableName = "bio_hmdd3" ;
	String saveDir="D:/bio_hmdd3/" ;
	List<Map<String,Object>> mirnasList = DaoUtils.queryMapList("select DISTINCT mirna from "+tableName) ;
	
	
	
	
	List<Map<String,Object>> diseasesList = DaoUtils.queryMapList("select DISTINCT disease from "+tableName) ;
	
	
	
	List<Map<String,Object>> relationsList = DaoUtils.queryMapList("select * from "+tableName) ;
	int total = relationsList.size() ;
	
	
	int trainCount = (int) (total*0.7) ;
	int validCount = (int) (total*0.2) ;
	int testCount = (int) (total*0.1) ;
	
	
	System.out.println("train Dataset Size: "+trainCount);
	System.out.println("test Dataset Size: "+testCount);
	System.out.println("valid Dataset Size: "+validCount);
	
	
	
	List<Map<String,Object>> trainList= new LinkedList<>() ;
	List<Map<String,Object>> testList= new LinkedList<>() ;
	List<Map<String,Object>> validList= new LinkedList<>() ;
	
	while(testList.size()<testCount){
		int random = getRandomInt(relationsList.size());
		Map<String,Object> relationMap = relationsList.remove(random) ;
		testList.add(relationMap);
	}
	
	while(validList.size()<validCount){
		int random = getRandomInt(relationsList.size());
		Map<String,Object> relationMap = relationsList.remove(random) ;
		validList.add(relationMap);
	}
	
	
	trainList=relationsList ;
	
	
	System.out.println("trainList:"+trainList.size());
	System.out.println("testList:"+testList.size());
	System.out.println("validList:"+validList.size());
	


	

	BufferedWriter writer = new BufferedWriter(new FileWriter( saveDir+"/entities.dict",false)) ;
	
	for(int i = 0 ;i < mirnasList.size() ;i++){
		Map<String,Object> map = mirnasList.get(i) ;
		String mirna = map.get("mirna")+"" ;
		String rowStr = (i)+"\t"+mirna ;
		writer.write(rowStr);
		writer.newLine();
	}
	
	for(int i = 0 ;i < diseasesList.size() ;i++){
		Map<String,Object> map = diseasesList.get(i) ;
		String disease = map.get("disease")+"" ;
		String rowStr = (mirnasList.size()+ i)+"\t"+disease.replaceAll(" ",""); ;
		writer.write(rowStr);
		writer.newLine();
	}
	
	writer.close();
	
	
	
	writer =  new BufferedWriter(new FileWriter( saveDir+"/train.txt",false)) ;
	for(int i = 0 ;i < trainList.size() ;i++){
		Map<String,Object> map = trainList.get(i) ;
		String mirna = map.get("mirna")+"" ;
		String disease = map.get("disease")+"" ;
		String rowStr = mirna+"\t"+map.get("kgtype")+"\t"+disease.replaceAll(" ","") ;
		writer.write(rowStr);
		writer.newLine();
	}
	writer.close();
	
	
	writer =  new BufferedWriter(new FileWriter( saveDir+"/valid.txt",false)) ;
	for(int i = 0 ;i < validList.size() ;i++){
		Map<String,Object> map = validList.get(i) ;
		String mirna = map.get("mirna")+"" ;
		String disease = map.get("disease")+"" ;
		String rowStr = mirna+"\t"+map.get("kgtype")+"\t"+disease.replaceAll(" ","") ;
		writer.write(rowStr);
		writer.newLine();
	}
	writer.close();
	
	
	
	writer =  new BufferedWriter(new FileWriter( saveDir+"/test.txt",false)) ;
	for(int i = 0 ;i < testList.size() ;i++){
		Map<String,Object> map = testList.get(i) ;
		String mirna = map.get("mirna")+"" ;
		String disease = map.get("disease")+"" ;
		String rowStr = mirna+"\t"+map.get("kgtype")+"\t"+disease.replaceAll(" ","") ;
		writer.write(rowStr);
		writer.newLine();
	}
	writer.close();
	
}



public static void generatePredictTriplets() throws Exception{
	String tableName = "bio_hmdd3" ;
	String saveDir="D:/bio_hmdd3/" ;
	List<Map<String,Object>> mirnasList = DaoUtils.queryMapList("select DISTINCT mirna from "+tableName) ;
	
	
	
	
	List<Map<String,Object>> diseasesList = DaoUtils.queryMapList("select DISTINCT disease from "+tableName+" group by kgtype ") ;
	
	
	
	List<Map<String,Object>> relationsList = DaoUtils.queryMapList("select kgtype from "+tableName) ;
	BufferedWriter writer =  new BufferedWriter(new FileWriter( saveDir+"/prediction_triplets.txt",false)) ;
	for(int i = 0 ;i < mirnasList.size() ;i++){
		for(int j = 0 ; j < relationsList.size() ;j++){
			for(int k = 0 ; k < diseasesList.size() ;k++){
				Map<String,Object> mMap = mirnasList.get(i) ;
				Map<String,Object> rMap = relationsList.get(j) ;
				Map<String,Object> dMap = diseasesList.get(k) ;
				
				
				String mirna = mMap.get("mirna")+"" ;
				String disease = dMap.get("disease")+"" ;
				String rowStr = mirna+"\t"+rMap.get("kgtype")+"\t"+disease.replaceAll(" ","") ;
				
				
				System.out.println("(i,j,k)"+"("+i+","+j+","+k+")");
				System.out.println(rowStr);
				writer.write(rowStr);
				writer.newLine();
			}
		}
		
	}
	writer.close();
	
}

	public static void main(String[] args) throws Exception{
		//generateDataset();// generate dataset
		generatePredictTriplets(); //generate prediction triplets
		
		
		
	}
}
