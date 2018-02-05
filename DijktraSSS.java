import java.io.*;

public class DijktraSSS 
{
	int numNodes;		// number of nodes in G
	int sourceNode;		
	int minNode;
	int currentNode;
	int newCost;
	int[][] costMatrix;
	int[] fatherAry;
	int[] toDoAry;
	int[] bestCostAry;
	
	public DijktraSSS(int N)
	{
		costMatrix = new int[N+1][N+1];
		fatherAry = new int[N+1];
		toDoAry = new int[N+1];	
		bestCostAry = new int[N+1];
		currentNode = 0;
		newCost = 0;
		numNodes = N;
		
		for(int i = 1; i < N+1; i++)
		{
			for(int k = 1; k < N+1; k++)
			{
				costMatrix[i][k] = 99999;
			}
		}
		
		for(int j = 1; j < N+1; j++)
		{
			costMatrix[j][j] = 0;
			fatherAry[j] = j;
			toDoAry[j] = 1;
			bestCostAry[j] = 99999;
		}
	}
	
	public void loadCostMatrix(int i, int j, int data)
	{
		costMatrix[i][j] = data;
	}
	
	public void setBestCostAry(int sourcenode)
	{
		for(int i = 1; i < bestCostAry.length; i++)
		{
			bestCostAry[i] = costMatrix[sourcenode][i];
		}
	}
	
	public void setFatherAry(int sourcenode)
	{	
		for(int i = 1; i < fatherAry.length; i++)
		{
			fatherAry[i] = sourcenode;
		}
	}
	
	public void setToDoAry(int sourcenode)
	{
		toDoAry[sourcenode] = 0;
	}
	
	public int findMinNode()
	{
		int temp = 99999;
		for(int i = 1; i < toDoAry.length; i++)
		{
			if(toDoAry[i] == 1 && bestCostAry[i] < temp)
			{
				temp = bestCostAry[i];
				minNode = i;
			}
		}
		return minNode;
	}
	
	public int computeCost(int minNode, int currentNode)
	{
		return bestCostAry[minNode] + costMatrix[minNode][currentNode];
	}
	
	public void markMinNode(int minNode)
	{
		toDoAry[minNode] = 0;
	}
	
	public void changeFather(int node, int newCost)
	{
		fatherAry[node] = newCost;
	}
	
	public void changeCost(int node, int newCost)
	{
		bestCostAry[node] = newCost;
	}
	
	public void debugPrint(BufferedWriter outFile)
	{
		try 
		{
			outFile.write("Source Node - " + sourceNode +"\n");
			
			for(int i = 1; i < fatherAry.length; i++)
			{
				outFile.write("FatherAry - " + fatherAry[i]+"\n");
			}
			
			for(int j = 1; j < bestCostAry.length; j++)
			{
				outFile.write("BestCostAry - " + bestCostAry[j]+"\n");
			}
			
			for(int k = 1; k < toDoAry.length; k++)
			{
				outFile.write("toDoAry - " + toDoAry[k]+"\n");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	public void printShortestPaths(int sourceNode, int currentNode, BufferedWriter outFile)
	{
		try 
		{
			String result = "";
			outFile.write("From path " + sourceNode + " to " + currentNode + "\n");
			int sampleCurrentNode = currentNode;
			result += currentNode + " <-- ";
			
			while(fatherAry[currentNode] != sourceNode)
			{
				result += fatherAry[currentNode] + " <-- " ;
				currentNode = fatherAry[currentNode];
			}
			result += String.valueOf(sourceNode);
			outFile.write(result + ". Cost: " + bestCostAry[sampleCurrentNode]);
			outFile.write("\n");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isAllZero()
	{
		for(int i = 1; i < toDoAry.length; i++)
		{
			if(toDoAry[i] == 1)
			{
				return true;
			}
		}
		return false;		
	}

}
