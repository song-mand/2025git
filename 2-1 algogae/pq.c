#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define MAX 500000

int array[MAX]={0};
int size=1;

void heapify(int arr[],int index, int arrsize)
{
    int left=2*index;
    int right=2*index+1;
    int max=index;
    if(left<arrsize&&arr[left]>arr[max])
    {
        max=left;
    }
    if(right<arrsize&&arr[right]>arr[max])
    {
        max=right;
    }
    if(max!=index)
    {
        int tmp=arr[index];
        arr[index]=arr[max];
        arr[max]=tmp;
        heapify(arr,max,arrsize);
    }
}

void buildheap(int arr[])
{
    for(int i=size/2;i>=1;i--)
    {
        heapify(arr,i,size);
    }
}
void heapsort(int arr[])
{
    int arrsize=size;
    buildheap(arr);
    for(int i=arrsize-1;i>=1;i--)
    {
        int tmp=arr[1];
        arr[1]=arr[i];
        arr[i]=tmp;
        arrsize--;
        heapify(arr,1, arrsize);
    }
}

void insert(int element) {
    if(size>=MAX) {
        printf("Queue is full\n");
        return;
    }
    array[size] = element;  // Insert the new element at the end of the heap
    size++;  // Increase the size of the heap
    heapsort(array);
}

int delete_min() {
    if (size <= 1) {
        return -1;  // No elements to delete
    } 
    int min = array[1];  // The minimum is at the root
    array[1] = array[size - 1];  // Replace the root with the last element
    size--;  // Reduce the heap size
    heapsort(array);
    return min;
}

int delete_max() {
    if(size<=1) {
        return -1; // No elements to delete
    }
    else{
        int len=sizeof(array) / sizeof(int);
        heapsort(array);
        array[len-1]=0; // Set the last element to 0 after deletion
        size--;
    }
    return 0;// deletion successful
}

int delete_median() {
    int len=sizeof(array) / sizeof(int);
    int median=0;
    if(size<=1) {
        return -1; // No elements to delete
    }
    else if(size==3)
    {
        array[1]=array[2];
        array[2]=0;
        size--;
    }
    else {
        int median_index=len/2;
        for(int i=median_index;i<len;i++)
        {
            array[i]=array[i+1];
        }
        array[len-1]=0;
        size--;
    }
    
    return 0;
}

int find_min() {
    int minimum=0;
    if(size <=1) {
        return -1; // No elements to delete
    }
    else{
        heapsort(array);
        minimum=array[1];// the first element is the minimum value
    }
    return minimum;// return the minimum value
}

int find_max() {
    int maximum=0;
    if(size <= 1) {
        return -1; // No elements to delete
    }
    else if(size<=MAX){
        heapsort(array);
        maximum=array[size-1];// the last element is the maximum value
    }
    return maximum;// return the maximum value
}

int find_median() {
    int median_index=size/2;
    if(size <=1) {
        return -1; // No elements to delete
    }
    else{
        heapsort(array);
        int median=array[median_index];// the middle element is the median value
        return median;
    }
}

int main() {
    clock_t start = clock();
    FILE *in = fopen("pqin.txt", "r");
    FILE *out = fopen("pqout.txt", "w");
    if (!in || !out) {
        fprintf(stderr, "File error\n");
        return 1;
    }

    char oper_repeat[11];
    fgets(oper_repeat, sizeof(oper_repeat), in);
    int repeat=atoi(oper_repeat);
    if (repeat<=0||repeat>500000)
    {
        fprintf(stderr, "Invalid number of operations\n");
        fclose(in);
        fclose(out);
        return 1;
    }
    char oper[255];
    
    for (int i = 0; i < repeat; i++) {
        fgets(oper, sizeof(oper), in);
        if(oper[0]=='I'){
            strcpy(oper,oper+2);
            int input=atoi(oper);
            insert(input);
        }
        else if(oper[0]=='D'){
            if(oper[2]=='M'){
                int min=delete_min();
            }
            else if(oper[2]=='X'){
                int max=delete_max();
            }
            else if(oper[2]=='E'){
                int median=delete_median();
            }
        }
        else if(oper[0]=='F')
        {
            if(oper[2]=='M'){
                int min=find_min();
                if(min==-1){
                    char* null="NULL\n";
                    fputs(null,out);
                }
                else {
                    char minstr[20];
                    sprintf(minstr,"%d\n",min);
                    fputs(minstr,out);
                }


            }
            else if(oper[2]=='X'){
                int max=find_max();
                if(max==-1){
                    char* null="NULL\n";
                    fputs(null,out);
                }
                else{
                    char maxstr[20];
                    sprintf(maxstr,"%d\n",max);
                    fputs(maxstr,out);
                }
                
            }
            else if(oper[2]=='E'){
                int median=find_median();
                if(median==-1){
                    char* null="NULL\n";
                    fputs(null,out);
                   // fputs("find-med fail",out);
                }
                else{
                    
                    char medianstr[20];
                    sprintf(medianstr,"%d\n",median);
                    fputs(medianstr,out);
               // fputs("find-med success",out);
                }
            }
        }
        
    }
    
    fclose(in);
    fclose(out);
    clock_t end = clock();
    printf("Execution time: %lf seconds\n", (double)(end - start) / CLOCKS_PER_SEC);
    return 0;
}