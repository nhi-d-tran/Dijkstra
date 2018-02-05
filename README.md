# Dijkstra

Dijkstra’s algorithm for the Single-Source-Shortest Paths problem. We are going to program n times, where n if the number of node in the

Problem Statement: Given a directed graph, G = <N, E>, and the source node, S, in G, the task is find the shortest paths from S to every nodes in G, using the Dijkstra’s algorithm

I. Input:
	a)  argv[]: a directed graph, represented by a list of edges with costs, {<ni, nj, c>}
		
The format of the input file is as follows:

The first text line is the number of nodes, N, follows by a list of triplets, <ni, nj, cost>
 
	For example:
	5	        // there are 5 nodes in the graph
   	2         // source node ID is 2  
	1  5 10   // an edge <1, 5, 10>
    2  3  5   // an edge <2, 3, 5>
    1  2  20  // an edge <1, 2, 20>
	3  5  2   // an edge <3, 5, 2>


II. Outputs: (There are two output files, OutFile1 and OutFile2) 

(a) OutFile1 (use argv[]) :  The OutFile1 will have  single-source-shortest shortest paths.

For example, if there are 7 nodes in the graph G, and source node ID is 1
then your OutFile1 will be as follows:

Source node  = 1 
The shortest paths  from the source node 1 are: (Note: doing back-tracing)

The path from 1 to 1 :  1  1 : cost = 0 
The path from 1 to 2 :  2  …  1: cost = ...
The path from 1 to 3 :  3  …  1: cost = ...
:
:
The path from 1 to 7 :  7  …  1: cost = whatever

(b) OutFile2 (use argv[]): Write all debugging outputs in OutFile2. 
