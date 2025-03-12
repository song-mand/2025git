#include <stdio.h>
#include <stdlib.h> 

#define MAX_SIZE 1000

struct Node {
    int data;
    struct Node* next;
};

struct Node* makenode(int input) {
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = input;
    newnode->next = NULL;
    return newnode;
}

/*int binarySearch(int arr[], int item, int low, int high) {
    if (high <= low)
        return (item > arr[low]) ? (low + 1) : low;

    int mid = (low + high) / 2;

    if (item == arr[mid])
        return mid + 1;

    if (item > arr[mid])
        return binarySearch(arr, item, mid + 1, high);
    return binarySearch(arr, item, low, mid - 1);
}*/

int linearSearch(struct Node* head, int item) {//Find insertion point until the data of node is bigger than selected another data or equal
    struct Node* current = head;
    struct Node* prev = NULL;
    int position = 0;
    while (current != NULL) {
        if (current->data >= item) {
            break;
        }
        prev = current;
        current = current->next;
        position++;
    }
    return position;
}

void inserting(struct Node** listhead, int num, int pos) {//Insert node into insertion point derived by the function 'linearSearch'
    struct Node* newnode = makenode(num);
    if (pos == 0 || *listhead == NULL) {
        newnode->next = *listhead;
        *listhead = newnode;
        return;
    }

    struct Node* current = *listhead;
    for (int i = 0; i < pos - 1 && current->next != NULL; i++) {//Shift current point to insertion point
        current = current->next;
    }
    newnode->next = current->next;
    current->next = newnode;
}

void insertionSort(struct Node** head) {
    struct Node* sortedlist = NULL;  //Temporal space to save sorted list
    struct Node* now = *head;
    while (now != NULL) {
        struct Node* next = now->next;
        int position = linearSearch(sortedlist, now->data);
        inserting(&sortedlist, now->data, position);
        now = next;
    }
    *head = sortedlist;
}

void printlist(struct Node* head) {
    struct Node* current = head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
}

int main() {
    struct Node* head = NULL;
    struct Node* tail = NULL;
    int leng = 0;
    int num;

    while (scanf("%d", &num) == 1 && leng < MAX_SIZE) {//Make linked list
        struct Node* newnode = makenode(num);
        if (head == NULL && tail == NULL) {
            head = newnode;
            tail = newnode;
        } else {
            tail->next = newnode;
            tail = newnode;
        }
        leng++;
    }

    insertionSort(&head);
    printlist(head);

    return 0;
}