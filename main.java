import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{	
		try
		{
			Scanner inFile = new Scanner(new FileReader(args[0]));	
			BufferedWriter outFile1, outFile2;
			outFile1 = new BufferedWriter(new FileWriter(new File(args[1])));
			outFile2 = new BufferedWriter(new FileWriter(new File(args[2])));
			
			/*check if the file exist*/
		    if(args.length < 1) 
		    {
		        System.out.println("Error");
		        System.exit(1);
		    }
		    
		    //read numNodes and sourceNode from file
		    int numNodes = inFile.nextInt();
		    int sourceNode =inFile.nextInt();
		
			DijktraSSS dij = new DijktraSSS(numNodes);
		    int n_i, n_j, c;
		    dij.sourceNode = sourceNode;
		    
		    //read the data in the file until end
		    while(inFile.hasNext())		
		    {     		    
		    	n_i = inFile.nextInt();
		    	n_j = inFile.nextInt();
		    	c = inFile.nextInt();
		    	dij.loadCostMatrix(n_i, n_j, c);
		    }
		    dij.setBestCostAry(sourceNode);
		    dij.setFatherAry(sourceNode);
		    dij.setToDoAry(sourceNode);

		
		    // repeat until all nodes in toDoAry are 0
		    while(dij.isAllZero())
		    {
			    dij.minNode = dij.findMinNode();

			    dij.markMinNode(dij.minNode);
    
			    dij.debugPrint(outFile2);
			    
			    dij.currentNode = 1; 
			   
			    while(dij.currentNode <= dij.numNodes)
			    {	
		    		if(dij.toDoAry[dij.currentNode] == 1)
		    		{ 
		    			dij.newCost = dij.computeCost(dij.minNode, dij.currentNode);
		    			
		    			if(dij.newCost < dij.bestCostAry[dij.currentNode])
		    			{
		    				dij.changeCost(dij.currentNode, dij.newCost);
		    				dij.changeFather(dij.currentNode, dij.minNode);
		    				dij.debugPrint(outFile2);
		    			}	
		    		}
		    	dij.currentNode++;
			    }
		    }
		    
		    int currentNode = 1;
		    
		    while(currentNode <= dij.numNodes)
		    {
			    dij.printShortestPaths(dij.sourceNode, currentNode, outFile1);
				currentNode++;
		    }

		    //close all file
		    inFile.close();
		    outFile1.close();
		    outFile2.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	

	}

}
