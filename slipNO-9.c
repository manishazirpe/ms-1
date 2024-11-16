#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_NODES 100
typedef struct Node {
    char name[10];           
    struct Node* next;        
} Node;
typedef struct Graph {
    int numNodes;           
    char nodes[MAX_NODES][10]; 
    Node* adjacencyList[MAX_NODES];  
} Graph;
void initializeGraph(Graph* g) {
    g->numNodes = 0;
    for (int i = 0; i < MAX_NODES; i++) {
        g->adjacencyList[i] = NULL;
    }
}
void addNode(Graph* g, char* name) {
    strcpy(g->nodes[g->numNodes], name);
    g->numNodes++;
}
int findNodeIndex(Graph* g, char* name) {
    for (int i = 0; i < g->numNodes; i++) {
        if (strcmp(g->nodes[i], name) == 0) {
            return i;
        }
    }
    return -1;
}
void addEdge(Graph* g, char* from, char* to) {
    int fromIndex = findNodeIndex(g, from);
    int toIndex = findNodeIndex(g, to);
    if (fromIndex == -1 || toIndex == -1) {
        printf("Error: Invalid node name(s)\n");
        return;
    }
    Node* newNode = (Node*)malloc(sizeof(Node));
    strcpy(newNode->name, to);
    newNode->next = g->adjacencyList[fromIndex];
    g->adjacencyList[fromIndex] = newNode;
}
void displayGraph(Graph* g) {
    printf("\nResource Allocation Graph:\n");
    for (int i = 0; i < g->numNodes; i++) {
        printf("%s ->", g->nodes[i]);
        Node* temp = g->adjacencyList[i];
        while (temp != NULL) {
            printf(" %s", temp->name);
            temp = temp->next;
        }
        printf("\n");
    }
}
int main() {
    Graph g;
    initializeGraph(&g);
    addNode(&g, "P1");
    addNode(&g, "P2");
    addNode(&g, "R1");
    addNode(&g, "R2");
    addEdge(&g, "P1", "R1"); 
    addEdge(&g, "R1", "P2"); 
    addEdge(&g, "P2", "R2");
    addEdge(&g, "R2", "P1"); 
    displayGraph(&g);
    return 0;
}
