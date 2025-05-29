#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_WORD_LEN 100
#define TABLE_SIZE 10000
#define TOP_N 10

typedef struct Bigram {
    char *first;
    char *second;
    int count;
    struct Bigram *next;
} Bigram;

typedef struct {
    char **items;
    int size;
    int capacity;
} WordList;

typedef struct {
    Bigram *items[TOP_N];
    int size;
} TopBigramList;

Bigram *table[TABLE_SIZE];

char *strcpy(char *dest, const char *src) {
    char *start = dest;
    while ((*dest++ = *src++));
    return start;
}

int strcmp(const char *a, const char *b) {
    while (*a && (*a == *b)) {
        a++; b++;
    }
    return (unsigned char)*a - (unsigned char)*b;
}


unsigned long hash_bigram(const char *first, const char *second) {
    unsigned long hash = 1000;
    while(*first){
        hash = (hash<<3)+*first++;
    }
    while(*second){
        hash = (hash<<3)-*second++;
    }
    
    return hash % TABLE_SIZE;
}

char *str_clone(const char *s) {
    size_t len = strlen(s) + 1;
    char *clone = malloc(len);
    if (clone) {
        strcpy(clone, s);
    }
    return clone;
}

void insert_bigram(const char *first, const char *second) {
    unsigned long h = hash_bigram(first, second);
    Bigram *curr = table[h];
    while (curr) {
        if (strcmp(curr->first, first) == 0 && strcmp(curr->second, second) == 0) {
            curr->count++;
            return;
        }
        curr = curr->next;
    }
    Bigram *node = malloc(sizeof(Bigram));
    node->first = str_clone(first);
    node->second = str_clone(second);

    node->count = 1;
    node->next = table[h];
    table[h] = node;
    
}

void lower(char *word) {
    for (int i = 0; word[i]; i++) {
        if(word[i] >= 'A' && word[i] <= 'Z'){
            word[i] = word[i]+('a' - 'A');
        }
    }
}

void make_wordlist(WordList *list) {
    list->capacity = 1024;
    list->size = 0;
    list->items = malloc(sizeof(char *) * list->capacity);
}

void add_word(WordList *list, const char *word) {
    if (list->size >= list->capacity) {
        list->capacity *= 2;
        list->items = realloc(list->items, sizeof(char *) * list->capacity);
    }
    list->items[list->size++] = str_clone(word);
}

void read_words(FILE *fp, WordList *list) {
    char buffer[MAX_WORD_LEN];
    while (fscanf(fp, "%99s", buffer) == 1) {
        lower(buffer);
        add_word(list, buffer);
    }
}

void make_bigrams(const WordList *words) {
     for (int i = 0; i < words->size - 1; i++) {
        insert_bigram(words->items[i], words->items[i + 1]);
    }
}

void merge(Bigram **arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    Bigram **Left = malloc(sizeof(Bigram *) * n1);
    Bigram **Right = malloc(sizeof(Bigram *) * n2);

    for (int i = 0; i < n1; i++) {
        Left[i] = arr[left + i];
    }

    for (int j = 0; j < n2; j++) {
        Right[j] = arr[mid + 1 + j];
    }

    i = 0, j = 0; int k = left;
    while (i < n1 && j < n2) {
        arr[k++]=(Left[i]->count >= Right[j]->count)? Left[i++] : Right[j++];
    }
    
    while (i < n1){
        arr[k++] = Left[i++];
    }
    while (j < n2){
        arr[k++] = Right[j++];
    }

    free(Left);
    free(Right);
}

void mergesort(Bigram **arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergesort(arr, left, mid);
        mergesort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

void sort(Bigram **arr, int n) {
    mergesort(arr, 0, n - 1);
}

void get_top_bigrams(TopBigramList *top, int *total_bigrams) {
    Bigram **all = malloc(sizeof(Bigram *) * 5000000);
    int count = 0;
    for (int i = 0; i < TABLE_SIZE; i++) {
        for (Bigram *curr = table[i]; curr; curr = curr->next) {
            all[count] = curr;
            count++;
        }
    }

    *total_bigrams = count;
    //qsort(all, count, sizeof(Bigram *), compare_bigrams);
    sort(all, count);

    top->size = 0;
    for (int i = 0; i < TOP_N && i < count; i++) {
        top->items[i] = all[i];
        top->size++;
    }
    free(all);
}

void write_output(const char *filename, TopBigramList *top, int total) {
    FILE *fp = fopen(filename, "w");
    if (!fp) return;
    fprintf(fp, "Total bigrams: %d\n", total);
    fprintf(fp, "Top %d bigrams:\n", top->size);
    for (int i = 0; i < top->size; i++) {
        fprintf(fp, "%s %s: %d\n", top->items[i]->first, top->items[i]->second, top->items[i]->count);
    }
    fclose(fp);
}

void free_table() {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Bigram *curr = table[i];
        while (curr) {
            Bigram *next = curr->next;
            free(curr->first);
            free(curr->second);
            free(curr);
            curr = next;
        }
    }
}

void free_words(WordList *list) {
    for (int i = 0; i < list->size; i++) {
        free(list->items[i]);
    }
    free(list->items);
}

int main() {
    FILE *fp = fopen("input.txt", "r");
    if (!fp) {
        perror("Failed to open input file");
        return 1;
    }

    WordList words;
    make_wordlist(&words);
    read_words(fp, &words);
    fclose(fp);

    make_bigrams(&words);

    TopBigramList top;
    int total_bigrams = 0;
    get_top_bigrams(&top, &total_bigrams);

    write_output("output.txt", &top, total_bigrams);

    free_words(&words);
    free_table();
    return 0;
}
